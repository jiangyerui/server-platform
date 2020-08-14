package com.jyr.iot.platform.service;

import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.AlarmLogMapper;
import com.jyr.iot.platform.mapper.CompanyMapper;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.mapper.UserMapper;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.pojogroup.ProjectGroup;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProjectService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AlarmLogMapper alarmLogMapper;

    /**
     * 增
     */
    public void addProject(Project project){
        try {
            projectMapper.insert(project);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/addProject/增加项目/错误");
        }

    }

    /**
     * 删
     */
    public void deleteProjectById(Integer id){
        try {
            projectMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/deleteProjectById/删除项目/错误");
        }
    }

    /**
     * 改
     */
    public void updateProject(Project project){
        try {
            projectMapper.updateByPrimaryKey(project);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/updateProject/更新项目/错误");
        }
    }

    //重新计算一个项目的报警状态
    public void calculProjectStatusByProjectId(Integer projectId){
        try {
            AlarmLogExample alarmLogExample = new AlarmLogExample();
            AlarmLogExample.Criteria alarmLogExampleCriteria = alarmLogExample.createCriteria();
            alarmLogExampleCriteria.andAlarmProjectIdEqualTo(projectId);
            List<AlarmLog> alarmLogs = alarmLogMapper.selectByExample(alarmLogExample);
            Project project = projectMapper.selectByPrimaryKey(projectId);
            project.setProjectDeviceStatus(1);
            for (AlarmLog alarmLog:alarmLogs){
                if (alarmLog.getAlarmStatus()==1){
                    project.setProjectDeviceStatus(2);
                }
            }
            projectMapper.updateByPrimaryKey(project);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/calculProjectStatusByProjectId/重新计算一个项目的报警状态/错误");
        }
    }

    /**
     * 查
     *
     */
    public Project selectProjectById(Integer id){
        try {
            return projectMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/selectProjectById/查询项目/错误");
        }
        return null;
    }

    public List<Project> selectAllProject(){
        try {
            return projectMapper.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/selectAllProject/查询所有项目/错误");
        }
        return null;
    }

    public PageResult selectProjectByPage(int pageNum, int pageSize, String projectName) {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    List<Project> projects = selectAllProject();
                    PageHelper.startPage(pageNum, pageSize);
                    List<ProjectGroup> superList = selectProjectGroupBySuperUser(projectName);
                    return new PageResult(projects.size(),superList);
                case 2:
                    Integer companySize = selectProjectGrouSizepByCompanyUser(projectName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<ProjectGroup> companyList = selectProjectGroupByCompanyUser(projectName);
                    return new PageResult(companySize,companyList);
                case 3:
                    Integer projectSize = selectProjectGroupSizeByPorjectUser(projectName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<ProjectGroup> projectList = selectProjectGroupByPorjectUser(projectName);
                    return new PageResult(projectSize,projectList);
                case 4:
                    Integer commonSize = selectProjectGroupSizeByCommonUser(projectName);
                    PageHelper.startPage(pageNum, pageSize);
                    List<ProjectGroup> commonList = selectProjectGroupByCommonUser(projectName);
                    return new PageResult(commonSize,commonList);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/selectProjectByPage/分页查项目/错误");
        }
        return null;
    }
    //子方法，超级用户查询项目信息
    private List<ProjectGroup> selectProjectGroupBySuperUser(String projectName){
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        if(projectName!=null&&projectName!=""){
            projectExampleCriteria.andProjectNameLike("%"+projectName+"%");
        } else {
            projectExample = null;
        }
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //子方法，集团用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByCompanyUser(String projectName) {
        List<ProjectGroup> list = new ArrayList<ProjectGroup>();
        User currentUser = UserUtils.getCurrentUser();
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
        List<User> projectUsers = userMapper.selectByExample(userExample);
        for (User user: projectUsers){
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectUserIdEqualTo(user.getUserId());
            if(projectName!=null&&projectName!=""){
                projectExampleCriteria.andProjectNameLike("%"+projectName+"%");
            }
            List<Project> projects = projectMapper.selectByExample(projectExample);
            List<ProjectGroup> listTemp = seletProjectGroupByProjectsList(projects);
            list.addAll(listTemp);
        }
        return list;
    }
    //子方法，项目用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByPorjectUser(String projectName) {
        User currentUser = UserUtils.getCurrentUser();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        if(projectName!=null&&projectName!=""){
            projectExampleCriteria.andProjectNameLike("%"+projectName+"%");
        }
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //子方法，普通用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByCommonUser(String projectName) {
        User currentUser = UserUtils.getCurrentUser();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
        if(projectName!=null&&projectName!=""){
            projectExampleCriteria.andProjectNameLike("%"+projectName+"%");
        }
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //子方法，集团用户查大小
    private Integer selectProjectGrouSizepByCompanyUser(String projectName) {
        List<ProjectGroup> list = selectProjectGroupByCompanyUser(projectName);
        return list.size();
    }
    //子方法，项目用户查大小
    private Integer selectProjectGroupSizeByPorjectUser(String projectName) {
        List<ProjectGroup> list = selectProjectGroupByPorjectUser(projectName);
        return list.size();
    }
    //子方法，普通用户查大小
    private Integer selectProjectGroupSizeByCommonUser(String projectName) {
        List<ProjectGroup> list = selectProjectGroupByCommonUser(projectName);
        return list.size();
    }


    //根据当前登陆用户查所有项目
    public List<ProjectGroup> selectAllProjectByCurrentUser(){
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    return selectProjectGroupBySuperUser();
                case 2:
                    return selectProjectGroupByCompanyUser();
                case 3:
                    return selectProjectGroupByPorjectUser();
                case 4:
                    return selectProjectGroupByCommonUser();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("ProjectService/selectAllProjectByCurrentUser/根据当前登陆用户查所有项目ProjectGroup/错误");
        }
        return null;
    }
    //子方法，超级用户查询项目信息
    private List<ProjectGroup> selectProjectGroupBySuperUser(){
        List<Project> projects = projectMapper.selectByExample(null);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //子方法，集团用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByCompanyUser() {
        List<ProjectGroup> list = new ArrayList<ProjectGroup>();
        User currentUser = UserUtils.getCurrentUser();
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUserParentIdEqualTo(currentUser.getUserId());
        List<User> projectUsers = userMapper.selectByExample(userExample);
        for (User user: projectUsers){
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectUserIdEqualTo(user.getUserId());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            List<ProjectGroup> listTemp = seletProjectGroupByProjectsList(projects);
            list.addAll(listTemp);
        }
        return list;
    }
    //子方法，项目用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByPorjectUser() {
        User currentUser = UserUtils.getCurrentUser();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //子方法，项目用户查询项目信息
    private List<ProjectGroup> selectProjectGroupByCommonUser() {
        User currentUser = UserUtils.getCurrentUser();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(currentUser.getUserParentId());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        List<ProjectGroup> list = seletProjectGroupByProjectsList(projects);
        return list;
    }
    //孙方法，根据项目列表查ProjectGroup
    private List<ProjectGroup> seletProjectGroupByProjectsList(List<Project> projectsArgs){
        List<Project> projects = projectsArgs;
        List<ProjectGroup> list = new ArrayList<ProjectGroup>();
        for (Project project:projects){
            User user = userMapper.selectByPrimaryKey(project.getProjectUserId());
            Company company = companyMapper.selectByPrimaryKey(project.getProjectCompanyId());
            list.add(new ProjectGroup(project,user,company));
        }
        return list;
    }

}
