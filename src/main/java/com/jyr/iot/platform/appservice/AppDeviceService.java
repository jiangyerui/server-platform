package com.jyr.iot.platform.appservice;

import com.jyr.iot.platform.mapper.*;
import com.jyr.iot.platform.pojo.*;
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
public class AppDeviceService {
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

    //根据当前登陆用户查首页信息树
    public List<DeviceProject> selectDeviceProjectsByCurrentUser(){
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    return superSelectDeviceProjects();
                case 2:
                    return companySelectDeviceProjects();
                case 3:
                    return projectSelectDeviceProjects();
                case 4:
                    return commonSelectDeviceProjects();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("AppDeviceService/selectDeviceProjectsByCurrentUser根据当前登陆用户查首页信息树");
        }
        return null;
    }
    //子方法，超级管理员查设备树
    private List<DeviceProject> superSelectDeviceProjects(){
        //查项目管理员
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserRoleEqualTo(3);
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        List<DeviceProject> list = selectDeviceProjectByProjectUsers(projectUsers);
        return list;
    }
    //子方法，集团管理员查设备树
    private List<DeviceProject> companySelectDeviceProjects(){
        //查项目管理员
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserParentIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        List<DeviceProject> list = new ArrayList<DeviceProject>();
        return list;
    }
    //子方法，项目管理员查设备树
    private List<DeviceProject> projectSelectDeviceProjects() {
        //查项目管理员
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        List<DeviceProject> list = selectDeviceProjectByProjectUsers(projectUsers);
        return list;
    }
    //子方法，普通管理员查设备树
    private List<DeviceProject> commonSelectDeviceProjects(){
        //查项目管理员
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserIdEqualTo(UserUtils.getCurrentUser().getUserParentId());
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        List<DeviceProject> list = selectDeviceProjectByProjectUsers(projectUsers);
        return list;
    }
    //孙方法，根据项目管理员查设备树
    private List<DeviceProject> selectDeviceProjectByProjectUsers(List<User> projectUsersArgs){
        List<User> projectUsers = projectUsersArgs;
        List<DeviceProject> list = new ArrayList<DeviceProject>();
        for (User projectUser: projectUsers){
            //查项目
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            //根据项目查设备
            for (Project project: projects){
                //由项目查相机
                CameraExample cameraExample = new CameraExample();
                CameraExample.Criteria cameraExampleCriteria = cameraExample.createCriteria();
                cameraExampleCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                List<Camera> cameraList = cameraMapper.selectByExample(cameraExample);
                // 由项目查设备
                DeviceExample deviceExample = new DeviceExample();
                DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
                deviceExampleCriteria.andDeviceProjectIdEqualTo(project.getProjectId());
                List<Device> devices = deviceMapper.selectByExample(deviceExample);
                //根据单个设备查DeviceGroup
                List<DeviceGroup> deviceGroups = new ArrayList<DeviceGroup>();
                for (Device device: devices){
                    //根据设备查相机
                    Camera camera = cameraMapper.selectByPrimaryKey(device.getDeviceCameraId());
                    deviceGroups.add(new DeviceGroup(device,null,project,camera));
                }
                list.add(new DeviceProject(project,deviceGroups,cameraList));
            }
        }
        return list;
    }

}
