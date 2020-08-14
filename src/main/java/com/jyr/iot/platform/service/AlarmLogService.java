package com.jyr.iot.platform.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.*;
import com.jyr.iot.platform.mqtt.MqttUtil;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.pojogroup.*;
import com.jyr.iot.platform.redis.RedisService;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;


import javax.jms.*;
import javax.jms.Queue;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class AlarmLogService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AlarmLogMapper alarmlogMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private LcAcsService lcAcsService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private RedisService redisService;

    //activemq发送queue类型消息
    public void sendQueueMsg(AlarmLog alarmlog,String phone){
        Date date = new Date();
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        Map map = new HashMap<>();
        map.put("PhoneNumbers",phone);
        map.put("device",alarmlog.getAlarmDeviceId()+"");
        map.put("project",alarmlog.getAlarmProjectId()+"");
        map.put("time",sdf.format(date)+"");
        map.put("warn",alarmlog.getAlarmName());
       jmsTemplate.convertAndSend("smsalarm", map);
    }

    //activemq发送topic类型消息
    public void sendTopicMsg(String msg){
        jmsTemplate.convertAndSend(topic, msg);
    }

    /**
     * 增
     */
    public void addAlarmLog(AlarmLog alarmlog){
        log.info("监听到报警");
        try {
            alarmlog.setAlarmStatus(1);
            alarmlogMapper.insert(alarmlog);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/addAlarmLog/持久化报警信息异常");
        }
        try {
            MqttUtil.publish("currentalarmlog", JSON.toJSONString(alarmlog));
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/addAlarmLog/给前台发报警信息异常");
        }
        try {
            Device device = deviceMapper.selectByPrimaryKey(alarmlog.getAlarmDeviceId());
            device.setDeviceUseStatus(2);
            deviceMapper.updateByPrimaryKey(device);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/addAlarmLog/持久化设备报警信息异常");
        }
        try {
            updateProjectThingToRedis(alarmlog.getAlarmProjectId());
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/addAlarmLog/更新redis中的DeviceProject，用于3D显示/异常");
        }
        try {
            //持久化项目报警信息,用于百度地图
            Project project = projectMapper.selectByPrimaryKey(alarmlog.getAlarmProjectId());
            project.setProjectDeviceStatus(2);
            projectMapper.updateByPrimaryKey(project);
            //给项目管理员发送报警短信
            User user = userMapper.selectByPrimaryKey(project.getProjectUserId());
            sendQueueMsg(alarmlog,user.getUserPhone());
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/addAlarmLog/持久化项目报警信息异常");
        }

    }

    /**
     * 删
     */
    public void deleteAlarmLogById(Integer id){
        try {
            alarmlogMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/deleteAlarmLogById/删除报警异常");
        }
    }

    /**
     * 改
     */
    public void updateAlarmLog(AlarmLog alarmlog){
        try {
            alarmlogMapper.updateByPrimaryKey(alarmlog);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/updateAlarmLog/修改报警异常");
        }
    }

    //处理一条报警
    public void sloveAlarmLogById(Integer id){
        try {
            AlarmLog alarmLog = alarmlogMapper.selectByPrimaryKey(id);
            alarmLog.setAlarmStatus(3);
            Device device = deviceMapper.selectByPrimaryKey(alarmLog.getAlarmDeviceId());
            //更新缓存中的设备信息(含智慧用电)
            lcAcsService.sloveDevcieChannelAlarmlog(device.getDeviceNo(),alarmLog.getAlarmL());
            //重新计算设备整体状态，并持久化
            resetCulDeviceStatus(device);
            //更新缓存中的DeviceProject，用于3D显示
            updateProjectThingToRedis(alarmLog.getAlarmProjectId());
            //持久化报警的处理状态
            alarmlogMapper.updateByPrimaryKey(alarmLog);
            //更新项目报警信息，并持久化
            projectService.calculProjectStatusByProjectId(alarmLog.getAlarmProjectId());
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/sloveAlarmLogById/处理一条报警错误");
        }

    }

    //重新计算设备状态
    private void resetCulDeviceStatus(Device deviceArgs){
        try {
            Device device = deviceArgs;
            if (device.getDeviceNo().length()>12){
                LcAcs lcAcs = redisService.getLcAcs(device.getDeviceNo());
                if (lcAcs.getL1Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL2Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL3Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL4Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL5Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL6Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL7Status()==2)device.setDeviceUseStatus(2);
                else if (lcAcs.getL8Status()==2)device.setDeviceUseStatus(2);
                else device.setDeviceUseStatus(1);
            }else {
                ZhydData zhydData = redisService.getZhyd(device.getDeviceNo());
                if (zhydData.getL1Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL2Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL3Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL4Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL5Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL6Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL7Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getL8Status()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getDlStatus()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getYgStatus()==2)device.setDeviceUseStatus(2);
                else if (zhydData.getJydzStatus()==2)device.setDeviceUseStatus(2);
                else device.setDeviceUseStatus(1);
            }
            deviceMapper.updateByPrimaryKey(device);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/selectAlarmLogById/重新计算设备状态/错误");
        }

    }

    /**
     * 查
     */
    public AlarmLog selectAlarmLogById(Integer id){
        try {
            return alarmlogMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error("AlarmLogService/selectAlarmLogById/查一个报警错误");
        }
        return null;
    }

    public List<AlarmLog> selectAllAlarmLog(){
        try {
            return alarmlogMapper.selectByExample(null);
        }catch (Exception e){
            log.error("AlarmLogService/selectAlarmLogById/查所有报警错误");
        }
        return null;
    }

    public PageResult selectAlarmLogByPage(int pageNum, int pageSize, String alarmlogName) {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    Integer superSize = superSelectAlarmLogSize(alarmlogName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<AlarmLog> superList = superSelectAlarmLog(alarmlogName);
                    return new PageResult(superSize, superList);
                case 2:
                    Integer companySize = companySelectAlarmLogSize(alarmlogName,currentUser);
                    PageHelper.startPage(pageNum, pageSize);
                    List<AlarmLog> companyList = companySelectAlarmLog(alarmlogName,currentUser);
                    return new PageResult(companySize, companyList);
                case 3:
                    Integer projectSize = projectSelectAlarmLogSize(alarmlogName,currentUser);
                    PageHelper.startPage(pageNum, pageSize);
                    List<AlarmLog> projectList = projectSelectAlarmLog(alarmlogName,currentUser);
                    return new PageResult(projectSize, projectList);
                case 4:
                    Integer commonSize = commonSelectAlarmLogSize(alarmlogName,currentUser);
                    PageHelper.startPage(pageNum, pageSize);
                    List<AlarmLog> commonList = commonSelectAlarmLog(alarmlogName,currentUser);
                    return new PageResult(commonSize, commonList);
            }
        }catch (Exception e){
            log.error("AlarmLogService/selectAlarmLogByPage/分页查报警/错误");
        }
        return null;

    }
    //子方法：超级用户查报警
    private List<AlarmLog> superSelectAlarmLog(String alarmlogName){
        AlarmLogExample alarmLogExample = new AlarmLogExample();
        AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
        if(alarmlogName!=null&&alarmlogName!=""){
            alarmLogExampleCriteria.andAlarmNameLike("%"+alarmlogName+"%");
        } else {
            alarmLogExample = null;
        }
        return alarmlogMapper.selectByExample(alarmLogExample);
    }
    //子方法：集团用户查报警
    private List<AlarmLog> companySelectAlarmLog(String alarmlogName,User currentUser){
        List<AlarmLog> list = new ArrayList<AlarmLog>();
        //由集团用户查集团
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(currentUser.getUserId());
        List<Company> companies = companyMapper.selectByExample(companyExample);
        if (companies.size()<=0)return null;
        for (Company company: companies){
            //由集团查项目
            ProjectExample  projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectCompanyIdEqualTo(company.getCompanyId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            if (projects.size()<=0)continue;
            //由项目查设备
            List<AlarmLog> listTemp = selectAlarmLogByProjectList(projects, alarmlogName);
            list.addAll(listTemp);
        }
        return list;
    }
    //子方法：项目用户查报警
    private List<AlarmLog> projectSelectAlarmLog(String alarmlogName,User currentUser){
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        if (projects.size()<=0)return null;
        List<AlarmLog> list = selectAlarmLogByProjectList(projects, alarmlogName);
        return list;
    }
    //子方法：普通用户查报警
    private List<AlarmLog> commonSelectAlarmLog(String alarmlogName,User currentUser){
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        if (projects.size()<=0)return null;
        List<AlarmLog> list = selectAlarmLogByProjectList(projects, alarmlogName);
        return list;
    }

    //子方法：超级用户查报警大小
    private Integer superSelectAlarmLogSize(String alarmlogName){
        AlarmLogExample alarmLogExample = new AlarmLogExample();
        AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
        if(alarmlogName!=null&&alarmlogName!=""){
            alarmLogExampleCriteria.andAlarmNameLike("%"+alarmlogName+"%");
        } else {
            alarmLogExample = null;
        }
        List<AlarmLog> list = alarmlogMapper.selectByExample(alarmLogExample);
        return list.size();
    }
    //子方法：集团用户查报警大小
    private Integer companySelectAlarmLogSize(String alarmlogName,User currentUser){
        List<AlarmLog> list = new ArrayList<AlarmLog>();
        //由集团用户查集团
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(currentUser.getUserId());
        List<Company> companies = companyMapper.selectByExample(companyExample);
        for (Company company: companies){
            //由集团查项目
            ProjectExample  projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectCompanyIdEqualTo(company.getCompanyId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            //由项目查设备
            for (Project project:projects){
                DeviceExample deviceExample = new DeviceExample();
                DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
                deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
                List<Device> devices = deviceMapper.selectByExample(deviceExample);
                for (Device device: devices){
                    //由设备查报警
                    AlarmLogExample alarmLogExample = new AlarmLogExample();
                    AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
                    alarmLogExampleCriteria.andAlarmDeviceIdEqualTo(device.getDeviceId());
                    if(alarmlogName!=null&&alarmlogName!=""&&alarmlogName!="undefined"){
                        alarmLogExampleCriteria.andAlarmNameLike("%"+alarmlogName+"%");
                    }
                    List<AlarmLog> alarmLogs = alarmlogMapper.selectByExample(alarmLogExample);
                    list.addAll(alarmLogs);
                }
            }
        }
        return list.size();
    }
    //子广场：项目用户查报警大小
    private Integer projectSelectAlarmLogSize(String alarmlogName,User currentUser){
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<AlarmLog> list = selectAlarmLogByProjectList(projects, alarmlogName);
        return list.size();
    }
    //子方法：普通用户查报警大小
    private Integer commonSelectAlarmLogSize(String alarmlogName,User currentUser){
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<AlarmLog> list = selectAlarmLogByProjectList(projects, alarmlogName);
        return list.size();
    }

    //孙方法：由项目列表查报警列表(上面两组父方法)
    private List<AlarmLog> selectAlarmLogByProjectList(List<Project> projectsArgs,String alarmlogName){
        List<Project> projects = projectsArgs;
        List<AlarmLog> list = new ArrayList<AlarmLog>();
        for (Project project:projects){
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            for (Device device: devices){
                //由设备查报警
                AlarmLogExample alarmLogExample = new AlarmLogExample();
                AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
                alarmLogExampleCriteria.andAlarmDeviceIdEqualTo(device.getDeviceId());
                if(alarmlogName!=null&&alarmlogName!=""){
                    alarmLogExampleCriteria.andAlarmNameLike("%"+alarmlogName+"%");
                }
                List<AlarmLog> alarmLogs = alarmlogMapper.selectByExample(alarmLogExample);
                list.addAll(alarmLogs);
            }
        }
        return list;
    }

    //更新redis中的DeviceProject，用于3D显示
    private void updateProjectThingToRedis(Integer projectId){
        try {
            Project project = projectMapper.selectByPrimaryKey(projectId);
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(projectId);
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            List<ZhydData> list = new ArrayList<>();
            for (Device device:devices){
                list.add(redisService.getZhyd(device.getDeviceNo()));
            }
            redisService.setProjectThing(new ProjectThing(project,devices,list));
        }catch (Exception e){
            e.printStackTrace();
            log.error("AlarmLogService/updateProjectThingToRedis/更新redis中的DeviceProject，用于3D显示/错误");
        }
    }

}
