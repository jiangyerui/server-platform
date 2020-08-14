package com.jyr.iot.platform.service;

import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.*;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.pojogroup.DeviceCompany;
import com.jyr.iot.platform.pojogroup.DeviceGroup;
import com.jyr.iot.platform.pojogroup.DeviceProject;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CameraMapper cameraMapper;

    /**
     * 增
     */
    public void addDevice(DeviceGroup deviceGroup){
        try {
            deviceMapper.insert(deviceGroup.getDevice());
        }catch (Exception e){
            e.printStackTrace();
            log.info("DeviceService/addDevice/增加设备/错误");
        }
    }

    /**
     * 删
     */
    public void deleteDeviceById(Integer id){
        try {
            deviceMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.info("DeviceService/deleteDeviceById/删除设备/错误");
        }
    }

    /**
     * 改
     */
    public void updateDevice(DeviceGroup deviceGroup){
        try {
            deviceMapper.updateByPrimaryKey(deviceGroup.getDevice());
        }catch (Exception e){
            e.printStackTrace();
            log.info("DeviceService/updateDevice/更新设备/错误");
        }
    }

    /**
     * 查
     */
    //查DeviceGroup
    public DeviceGroup selectDeviceById(Integer id){
        try {
            Device device = deviceMapper.selectByPrimaryKey(id);
            Company company = companyMapper.selectByPrimaryKey(device.getDeviceCompanyId());
            Project project = projectMapper.selectByPrimaryKey(device.getDeviceProjectId());
            Camera camera = cameraMapper.selectByPrimaryKey(device.getDeviceCameraId());
            return new DeviceGroup(device,company,project,camera);
        }catch (Exception e){
            e.printStackTrace();
            log.info("DeviceService/selectDeviceById/查DeviceGroup/错误");
        }
        return null;
    }
    //根据设备编号查设备
    public Device selectDeviceByMac(String mac){
        try {
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceNoEqualTo(mac);
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            if (devices.size()>0)
                return devices.get(0);
            else return null;
        }catch (Exception e){
            e.printStackTrace();
            log.info("DeviceService/selectDeviceById/查DeviceGroup/错误");
        }
        return null;
    }
    //查所有DeviceGroup
    public List<DeviceGroup> selectAllDevice(){
        try {
            List<Device> devices = deviceMapper.selectByExample(null);
            List<DeviceGroup> list = selectDeviceGroupByDevicesList(devices);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("DeviceService/selectAllDevice/查所有DeviceGroup/错误");
        }
        return null;

    }
    //根据设备列表查DeviceGroup
    public List<DeviceGroup> selectDeviceGroupByDevicesList(List<Device> devicesArgs){
        try {
            List<Device> devices = devicesArgs;
            List<DeviceGroup> list = new ArrayList<DeviceGroup>();
            for (Device device: devices){
                Company company = companyMapper.selectByPrimaryKey(device.getDeviceCompanyId());
                Project project = projectMapper.selectByPrimaryKey(device.getDeviceProjectId());
                Camera camera = cameraMapper.selectByPrimaryKey(device.getDeviceCameraId());
                list.add(new DeviceGroup(device,company,project,camera));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("DeviceService/selectDeviceGroupByDevicesList/根据设备列表查DeviceGroup/错误");
        }
        return null;
    }

    //查分页，根据当前登陆用户查分页DeviceGroup
    public PageResult selectDeviceByPage(int pageNum, int pageSize, String deviceName) {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    Integer superSize = superSelectDeviceGroupSize(deviceName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<DeviceGroup> superList = superSelectDeviceGroup(deviceName);
                    return new PageResult(superSize, superList);
                case 2:
                    Integer companySize = companySelectDeviceGroupSize(deviceName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<DeviceGroup> companyList = companySelectDeviceGroup(deviceName);
                    return new PageResult(companySize, companyList);
                case 3:
                    Integer projectSize = projectSelectDeviceGroupSize(deviceName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<DeviceGroup> projectList = projectSelectDeviceGroup(deviceName);
                    return new PageResult(projectSize, projectList);
                case 4:
                    Integer commonSize = commonSelectDeviceGroupSize(deviceName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<DeviceGroup> commonList = commonSelectDeviceGroup(deviceName);
                    return new PageResult(commonSize, commonList);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("DeviceService/selectDeviceByPage/查分页，根据当前登陆用户查分页DeviceGroup/错误");
        }
        return null;
    }
    //子方法，超级用户查设备DeviceGroup
    private List<DeviceGroup> superSelectDeviceGroup(String deviceName){
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        if(deviceName!=null&&deviceName!=""){
            criteria.andDeviceNameLike("%"+deviceName+"%");
        } else {
            example = null;
        }
        List<Device> devices = deviceMapper.selectByExample(example);
        List<DeviceGroup> list = selectDeviceGroupByDevicesList(devices);
        return list;
    }
    //子方法，集团用户查设备DeviceGroup
    private List<DeviceGroup> companySelectDeviceGroup(String deviceName){
        User currentUser = UserUtils.getCurrentUser();
        List<DeviceGroup> list = new ArrayList<DeviceGroup>();
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        for (User projectUser: projectUsers){
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectIdEqualTo(projectUser.getUserId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            List<DeviceGroup> listTemp = selectDeviceGroupListByProjectsList(projects, deviceName);
            list.addAll(listTemp);
        }
        return list;
    }
    //子方法，项目用户查设备DeviceGroup
    private List<DeviceGroup> projectSelectDeviceGroup(String deviceName){
        User currentUser = UserUtils.getCurrentUser();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<DeviceGroup> list = selectDeviceGroupListByProjectsList(projects, deviceName);
        return list;
    }
    //子方法，普通用户查设备DeviceGroup
    private List<DeviceGroup> commonSelectDeviceGroup(String deviceName){
        User currentUser = UserUtils.getCurrentUser();
        User projectUser = userMapper.selectByPrimaryKey(currentUser.getUserParentId());
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<DeviceGroup> list = selectDeviceGroupListByProjectsList(projects, deviceName);
        return list;
    }
    //孙方法，由项目列表查List<DeviceGroup>
    private List<DeviceGroup> selectDeviceGroupListByProjectsList(List<Project> projectsArgs,String deviceName){
        List<Project> projects = projectsArgs;
        List<DeviceGroup> list = new ArrayList<DeviceGroup>();
        for (Project project:projects){
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
            if(deviceName!=null&&deviceName!=""){
                deviceExampleCriteria.andDeviceNameLike("%"+deviceName+"%");
            }
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            List<DeviceGroup> listTemp = selectDeviceGroupByDevicesList(devices);
            list.addAll(listTemp);
        }
        return list;
    }

    //外子方法，超级用户查设备数
    private Integer superSelectDeviceGroupSize(String deviceName){
        List<DeviceGroup> list = superSelectDeviceGroup(deviceName);
        return list.size();
    }
    //外子方法，集团用户查设备数
    private Integer companySelectDeviceGroupSize(String deviceName){
        List<DeviceGroup> list = companySelectDeviceGroup(deviceName);
        return list.size();
    }
    //外子方法，项目用户查设备数
    private Integer projectSelectDeviceGroupSize(String deviceName){
        List<DeviceGroup> list = projectSelectDeviceGroup(deviceName);
        return list.size();
    }
    //外子方法，普通用户查设备数
    private Integer commonSelectDeviceGroupSize(String deviceName){
        List<DeviceGroup> list = commonSelectDeviceGroup(deviceName);
        return list.size();
    }

    //根据当前登陆用户，查设备树
    public List<DeviceCompany> selectDeviceTreeByCurrentUser(){
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    return superSelectDeviceTree();
                case 2:
                    return companySelectDeviceTree();
                case 3:
                    return projectSelectDeviceTree();
                case 4:
                    return commonSelectDeviceTree();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("DeviceService/selectDeviceTreeByCurrentUser/根据当前登陆用户，查设备树/错误");
        }
        return null;
    }
    //子方法，超级管理员查设备树
    private List<DeviceCompany> superSelectDeviceTree(){
        UserExample companyUserExample = new UserExample();
        UserExample.Criteria companyUserExampleCriteria = companyUserExample.createCriteria();
        companyUserExampleCriteria.andUserRoleEqualTo(2);
        List<User> companyUsers = userMapper.selectByExample(companyUserExample);
        List<DeviceCompany> deviceCompanies = new ArrayList<DeviceCompany>();
        for (User companyUser: companyUsers){
            //根据集团管理员查集团
            CompanyExample companyExample = new CompanyExample();
            CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
            companyExampleCriteria.andCompanyUserIdEqualTo(companyUser.getUserId());
            List<Company> companies = companyMapper.selectByExample(companyExample);
            //根据集团管理员查项目管理员
            UserExample projectUserExample = new UserExample();
            UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
            projectUserExampleCriteria.andUserParentIdEqualTo(companyUser.getUserId());
            List<User> projectUsers = userMapper.selectByExample(projectUserExample);
            for (User projectUser: projectUsers){
                ProjectExample projectExample = new ProjectExample();
                ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
                List<Project> projects = projectMapper.selectByExample(projectExample);
                //根据项目查设备
                List<DeviceCompany> deviceCompaniesTemp = selectDeviceProjectByProjectList(projects);
                deviceCompanies.addAll(deviceCompaniesTemp);
            }
        }
        return deviceCompanies;
    }
    //子方法，集团管理员查设备树
    private List<DeviceCompany> companySelectDeviceTree(){
        User currentUser = UserUtils.getCurrentUser();
        List<DeviceCompany> deviceCompanies = new ArrayList<DeviceCompany>();
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(currentUser.getUserId());
        List<Company> companies = companyMapper.selectByExample(companyExample);
        for (Company company: companies){
            //根据集团管理员查项目管理员
            UserExample projectUserExample = new UserExample();
            UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
            projectUserExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
            List<User> projectUsers = userMapper.selectByExample(projectUserExample);
            for (User projectUser: projectUsers){
                ProjectExample projectExample = new ProjectExample();
                ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
                List<Project> projects = projectMapper.selectByExample(projectExample);
                //根据项目查设备
                List<DeviceCompany> deviceCompaniesTemp = selectDeviceProjectByProjectList(projects);
                deviceCompanies.addAll(deviceCompaniesTemp);
            }
        }
        return deviceCompanies;
    }
    //子方法，项目管理员查设备树
    private List<DeviceCompany> projectSelectDeviceTree(){
        User currentUser = UserUtils.getCurrentUser();
        //由项目管理员查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<DeviceCompany> deviceCompanies = selectDeviceProjectByProjectList(projects);
        return deviceCompanies;
    }
    //子方法，普通管理员查设备树
    private List<DeviceCompany> commonSelectDeviceTree(){
        User currentUser = UserUtils.getCurrentUser();
        User projectUser = userMapper.selectByPrimaryKey(currentUser.getUserParentId());
        //由项目管理员查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<DeviceCompany> deviceCompanies = selectDeviceProjectByProjectList(projects);
        return deviceCompanies;
    }

    //孙方法，由项目列表查DeviceProject
    private List<DeviceCompany> selectDeviceProjectByProjectList(List<Project> projectsArgs){
        List<Project> projects = projectsArgs;
        List<DeviceCompany> deviceCompanies = new ArrayList<DeviceCompany>();
        List<DeviceProject> deviceProjects = new ArrayList<DeviceProject>();
        Company company = null;
        for (Project project: projects){
            //由项目查相机
            CameraExample cameraExample = new CameraExample();
            CameraExample.Criteria cameraExampleCriteria = cameraExample.createCriteria();
            cameraExampleCriteria.andCameraProjectIdEqualTo(project.getProjectId());
            List<Camera> cameraList = cameraMapper.selectByExample(cameraExample);
            //由项目查设备
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            //根据单个设备查DeviceGroup
            List<DeviceGroup> deviceGroups = new ArrayList<DeviceGroup>();
            for (Device device: devices){
                //由设备查集团
                if (company == null)
                    company = companyMapper.selectByPrimaryKey(device.getDeviceCompanyId());
                //根据设备查相机
                Camera camera = cameraMapper.selectByPrimaryKey(device.getDeviceCameraId());
                deviceGroups.add(new DeviceGroup(device,company,project,camera));
            }
            deviceProjects.add(new DeviceProject(project,deviceGroups,cameraList));
        }
        deviceCompanies.add(new DeviceCompany(company,deviceProjects));
        return deviceCompanies;
    }

}
