package com.jyr.iot.platform.appservice;

import com.jyr.iot.platform.mapper.AlarmLogMapper;
import com.jyr.iot.platform.mapper.CompanyMapper;
import com.jyr.iot.platform.mapper.DeviceMapper;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class AppAlarmLogService {
    @Autowired
    private AlarmLogMapper alarmlogMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    //根据当前登陆用户查未处理的报警
    public List<AlarmLog> selectAlarmLogByCurrentUser() {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    return superSelectAlarmLog();
                case 2:
                    return companySelectAlarmLog();
                case 3:
                    return projectSelectAlarmLog();
                case 4:
                    return commonSelectAlarmLog();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("AppAlarmLogService/selectAlarmLogByCurrentUser根据当前登陆用户查未处理的报警错误");
        }
        return null;
    }
    //子方法：超级用户查报警
    private List<AlarmLog> superSelectAlarmLog(){
        AlarmLogExample alarmLogExample = new AlarmLogExample();
        AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
        alarmLogExampleCriteria.andAlarmStatusEqualTo(1);
        return alarmlogMapper.selectByExample(alarmLogExample);
    }
    //子方法：集团用户查报警
    private List<AlarmLog> companySelectAlarmLog(){
        User currentUser = UserUtils.getCurrentUser();
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
            list = selectAlarmLogByProjectList(projects);
        }
        return list;
    }
    //子广场：项目用户查报警
    private List<AlarmLog> projectSelectAlarmLog(){
        User currentUser = UserUtils.getCurrentUser();
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        if (projects.size()<=0)return null;
        List<AlarmLog> list = selectAlarmLogByProjectList(projects);
        return list;
    }
    //子方法：普通用户查报警
    private List<AlarmLog> commonSelectAlarmLog(){
        User currentUser = UserUtils.getCurrentUser();
        // 由当前用户查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        if (projects.size()<=0)return null;
        List<AlarmLog> list = selectAlarmLogByProjectList(projects);
        return list;
    }
    //孙方法，根据项目列表查未处理的报警
    private List<AlarmLog> selectAlarmLogByProjectList(List<Project> projectsArgs){
        if (projectsArgs.size()<=0)return null;
        List<Project> projects = projectsArgs;
        List<AlarmLog> list = new ArrayList<AlarmLog>();
        for (Project project:projects){
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            if (devices.size()<=0)return null;
            for (Device device: devices){
                //由设备查报警
                AlarmLogExample alarmLogExample = new AlarmLogExample();
                AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
                alarmLogExampleCriteria.andAlarmDeviceIdEqualTo(device.getDeviceId());
                alarmLogExampleCriteria.andAlarmStatusEqualTo(1);
                List<AlarmLog> alarmLogs = alarmlogMapper.selectByExample(alarmLogExample);
                if (alarmLogs.size()<=0)continue;
                list.addAll(alarmLogs);
            }
        }
        return list;
    }


}
