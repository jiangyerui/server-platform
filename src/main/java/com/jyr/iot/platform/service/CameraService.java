package com.jyr.iot.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.CameraMapper;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.mapper.UserMapper;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.pojogroup.CameraGroup;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CameraService {

    @Autowired
    private CameraMapper cameraMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 增
     */
    public void addCamera(CameraGroup cameraGroup){
        try {
            cameraMapper.insert(cameraGroup.getCamera());
        }catch (Exception e){
            e.printStackTrace();
            log.error("CameraService/addCamera/增加相机/错误");
        }

    }

    /**
     * 删
     */
    public void deleteCameraById(Integer id){
        try {
            cameraMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CameraService/addCamera/删除相机/错误");
        }
    }

    /**
     * 改
     */
    public void updateCamera(CameraGroup cameraGroup){
        try {
            cameraMapper.updateByPrimaryKey(cameraGroup.getCamera());
        }catch (Exception e){
            e.printStackTrace();
            log.error("CameraService/addCamera/更新相机/错误");
        }
    }

    /**
     * 查
     */
    public CameraGroup selectCameraById(Integer id){
        try {
            Camera camera = cameraMapper.selectByPrimaryKey(id);
            Project project = projectMapper.selectByPrimaryKey(camera.getCameraProjectId());
            return new CameraGroup(camera,project);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CameraService/selectCameraById/根据相机ID查CameraGroup/错误");
        }
        return null;
    }

    public List<Camera> selectAllCamera(){
        try {
            return cameraMapper.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
            log.error("CameraService/selectAllCamera/查所有相机/错误");
        }
        return null;
    }

    //TODO 此方法存在问题，待后期解决，2019年12月24日记录
    public PageResult selectCameraByPage(int pageNum, int pageSize, String cameraName) {
        Integer size = selectCameraByCurrentUsers(cameraName);
        PageHelper.startPage(pageNum, pageSize);
        List<CameraGroup> cameraGroups = selectCameraByCurrentUser(cameraName);
        return new PageResult(size, cameraGroups);
    }

    //子方法，由当前登陆用户，查相机
    public List<CameraGroup> selectCameraByCurrentUser(String cameraName){
        User currentUser = UserUtils.getCurrentUser();
        switch (currentUser.getUserRole()){
            case 1:
                CameraExample superExample = new CameraExample();
                CameraExample.Criteria superCriteria = superExample.createCriteria();
                if(cameraName!=null&&cameraName!=""){
                    superCriteria.andCameraNameLike("%"+cameraName+"%");
                } else {
                    superExample = null;
                }
                List<Camera> cameras = cameraMapper.selectByExample(superExample);
                return selectCameraGroupByCameras(cameras);
            case 2:
                //由集团用户，查项目用户
                UserExample companyUserExample = new UserExample();
                UserExample.Criteria companyUserExampleCriteria = companyUserExample.createCriteria();
                companyUserExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
                List<User> projectUsers = userMapper.selectByExample(companyUserExample);
                //由项目用户，查项目
                List<Project> projects = new ArrayList<Project>();
                for (User projectUser: projectUsers){
                    ProjectExample projectExample = new ProjectExample();
                    ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                    projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
                    List<Project> projectList = projectMapper.selectByExample(projectExample);
                    projects.addAll(projectList);
                }
                //由项目，查相机
                List<Camera> list = new ArrayList<Camera>();
                for (Project project:projects){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> cameraList = cameraMapper.selectByExample(companyExample);
                    list.addAll(cameraList);
                }
                return selectCameraGroupByCameras(list);
            case 3:
                //由当前项目用户，查项目
                ProjectExample projectExample = new ProjectExample();
                ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
                List<Project> projectList = projectMapper.selectByExample(projectExample);
                //由项目，查相机
                List<Camera> cameraListByProjects = new ArrayList<Camera>();
                for (Project project:projectList){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> cameraListByProject = cameraMapper.selectByExample(companyExample);
                    cameraListByProjects.addAll(cameraListByProject);
                }
                return selectCameraGroupByCameras(cameraListByProjects);
            case 4:
                //由当前项目用户，查项目
                ProjectExample commonExample = new ProjectExample();
                ProjectExample.Criteria commonExampleCriteria = commonExample.createCriteria();
                commonExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
                List<Project> commonList = projectMapper.selectByExample(commonExample);
                //由项目，查相机
                List<Camera> commonListByProjects = new ArrayList<Camera>();
                for (Project project:commonList){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> commonListByProject = cameraMapper.selectByExample(companyExample);
                    commonListByProjects.addAll(commonListByProject);
                }
                return selectCameraGroupByCameras(commonListByProjects);
        }
        return null;
    }

    //子方法，由当前登陆用户，查相机数量
    public Integer selectCameraByCurrentUsers(String cameraName){
        User currentUser = UserUtils.getCurrentUser();
        switch (currentUser.getUserRole()){
            case 1:
                CameraExample superExample = new CameraExample();
                CameraExample.Criteria superCriteria = superExample.createCriteria();
                if(cameraName!=null&&cameraName!=""){
                    superCriteria.andCameraNameLike("%"+cameraName+"%");
                } else {
                    superExample = null;
                }
                List<Camera> cameras = cameraMapper.selectByExample(superExample);
                return selectCameraGroupByCameras(cameras).size();
            case 2:
                //由集团用户，查项目用户
                UserExample companyUserExample = new UserExample();
                UserExample.Criteria companyUserExampleCriteria = companyUserExample.createCriteria();
                companyUserExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
                List<User> projectUsers = userMapper.selectByExample(companyUserExample);
                //由项目用户，查项目
                List<Project> projects = new ArrayList<Project>();
                for (User projectUser: projectUsers){
                    ProjectExample projectExample = new ProjectExample();
                    ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                    projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
                    List<Project> projectList = projectMapper.selectByExample(projectExample);
                    projects.addAll(projectList);
                }
                //由项目，查相机
                List<Camera> list = new ArrayList<Camera>();
                for (Project project:projects){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> cameraList = cameraMapper.selectByExample(companyExample);
                    list.addAll(cameraList);
                }
                return selectCameraGroupByCameras(list).size();
            case 3:
                //由当前项目用户，查项目
                ProjectExample projectExample = new ProjectExample();
                ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
                List<Project> projectList = projectMapper.selectByExample(projectExample);
                //由项目，查相机
                List<Camera> cameraListByProjects = new ArrayList<Camera>();
                for (Project project:projectList){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> cameraListByProject = cameraMapper.selectByExample(companyExample);
                    cameraListByProjects.addAll(cameraListByProject);
                }
                return selectCameraGroupByCameras(cameraListByProjects).size();
            case 4:
                //由当前项目用户，查项目
                ProjectExample commonExample = new ProjectExample();
                ProjectExample.Criteria commonExampleCriteria = commonExample.createCriteria();
                commonExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
                List<Project> commonList = projectMapper.selectByExample(commonExample);
                //由项目，查相机
                List<Camera> commonListByProjects = new ArrayList<Camera>();
                for (Project project:commonList){
                    CameraExample companyExample = new CameraExample();
                    CameraExample.Criteria companyCriteria = companyExample.createCriteria();
                    companyCriteria.andCameraProjectIdEqualTo(project.getProjectId());
                    if(cameraName!=null&&cameraName!=""){
                        companyCriteria.andCameraNameLike("%"+cameraName+"%");
                    }
                    List<Camera> commonListByProject = cameraMapper.selectByExample(companyExample);
                    commonListByProjects.addAll(commonListByProject);
                }
                return selectCameraGroupByCameras(commonListByProjects).size();
        }
        return null;
    }

    //孙方法，由Cameras得CameraGroups
    public List<CameraGroup> selectCameraGroupByCameras(List<Camera> cameras){
        List<CameraGroup> cameraGroups = new ArrayList<CameraGroup>();
        for (Camera camera: cameras){
            Project project = projectMapper.selectByPrimaryKey(camera.getCameraProjectId());
            cameraGroups.add(new CameraGroup(camera,project));
        }
        return cameraGroups;
    }
}
