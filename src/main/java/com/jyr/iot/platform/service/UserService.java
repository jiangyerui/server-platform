package com.jyr.iot.platform.service;

import com.github.pagehelper.PageHelper;
import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.mapper.CompanyMapper;
import com.jyr.iot.platform.mapper.PermissionMapper;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.mapper.UserMapper;
import com.jyr.iot.platform.pojo.*;
import com.jyr.iot.platform.pojogroup.UserCompany;
import com.jyr.iot.platform.pojogroup.UserGroup;
import com.jyr.iot.platform.pojogroup.UserProject;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 根据当前登陆用户增加一个用户组合类
     * @param userGroup
     */
    public void addUserGroup(UserGroup userGroup){
        try {
            //设父ID
            User currentUser = UserUtils.getCurrentUser();
            userGroup.getUser().setUserParentId(currentUser.getUserId());
            //设密码
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String userPassword = userGroup.getUser().getUserPassword();
            userGroup.getUser().setUserPassword(encoder.encode(userPassword));
            //设权限
            Permission permission = userGroup.getPermission();
            permissionMapper.insert(permission);
            userGroup.getUser().setUserPermissionId(permission.getPermissionId());
            userMapper.insert(userGroup.getUser());
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/addUserGroup/增加用户/错误");
        }
    }

    /**
     * 根据用户ID，删除一个用户组合类
     * @param id
     */
    public void deleteUserGroupById(Integer id){
        try {
            User user = userMapper.selectByPrimaryKey(id);
            permissionMapper.deleteByPrimaryKey(user.getUserPermissionId());
            userMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/deleteUserGroupById/删除用户/错误");
        }
    }

    /**
     * 更新一个用户组合类
     * @param userGroup
     */
    public void updateUserGroup(UserGroup userGroup){
        try {
            userMapper.updateByPrimaryKey(userGroup.getUser());
            permissionMapper.updateByPrimaryKey(userGroup.getPermission());
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/updateUserGroup/更新用户/错误");
        }

    }

    /**
     * 根据用户ID，查询一个用户组合类
     * @param id
     * @return
     */
    public UserGroup selectUserGroupById(Integer id){
        try {
            User user =  userMapper.selectByPrimaryKey(id);
            Permission permission = permissionMapper.selectByPrimaryKey(user.getUserPermissionId());
            switch (user.getUserRole())
            {
                case 1:
                    return new UserGroup(user,permission,null,null);
                case 2:
                    CompanyExample companyExample = new CompanyExample();
                    CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
                    companyExampleCriteria.andCompanyUserIdEqualTo(user.getUserId());
                    List<Company> companies = companyMapper.selectByExample(companyExample);
                    if (companies.size()<0)
                    return new UserGroup(user,permission,null,null);
                    else
                    return new UserGroup(user,permission,companies.get(0),null);
                case 3:
                    //查项目
                    ProjectExample projectExample = new ProjectExample();
                    ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                    projectExampleCriteria.andProjectUserIdEqualTo(user.getUserId());
                    List<Project> projects = projectMapper.selectByExample(projectExample);
                    //查集团
                    CompanyExample companyProjectExample = new CompanyExample();
                    CompanyExample.Criteria companyProjectExampleCriteria = companyProjectExample.createCriteria();
                    companyProjectExampleCriteria.andCompanyUserIdEqualTo(user.getUserParentId());
                    List<Company> companiesProject = companyMapper.selectByExample(companyProjectExample);
                    if (projects.size()<0||companiesProject.size()<0)
                        return new UserGroup(user,permission,null,null);
                    else
                        return new UserGroup(user,permission,companiesProject.get(0),projects.get(0));
                case 4:
                    //查项目
                    ProjectExample ocmmonExample = new ProjectExample();
                    ProjectExample.Criteria commonExampleCriteria = ocmmonExample.createCriteria();
                    commonExampleCriteria.andProjectUserIdEqualTo(user.getUserParentId());
                    List<Project> projectsCommon = projectMapper.selectByExample(ocmmonExample);
                    //查项目管理员
                    User projectUser = userMapper.selectByPrimaryKey(user.getUserParentId());
                    //查集团
                    CompanyExample commonProjectExample = new CompanyExample();
                    CompanyExample.Criteria commonProjectExampleCriteria = commonProjectExample.createCriteria();
                    commonProjectExampleCriteria.andCompanyUserIdEqualTo(projectUser.getUserParentId());
                    List<Company> companiesCommon = companyMapper.selectByExample(commonProjectExample);
                    if (projectsCommon.size()<0||companiesCommon.size()<0)
                        return new UserGroup(user,permission,null,null);
                    else
                        return new UserGroup(user,permission,companiesCommon.get(0),projectsCommon.get(0));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/selectUserGroupById/查询用户/错误");
        }
        return null;
    }

    /**
     * 查询所有用户组合类
     * @return
     */
    public List<UserGroup> selectAllUserGroup(){
        List<User> users = userMapper.selectByExample(null);
        List<UserGroup> list = new ArrayList<UserGroup>();
        for (User user: users){
            Permission permission = permissionMapper.selectByPrimaryKey(user.getUserParentId());
            switch (user.getUserRole())
            {
                case 1:
                    list.add(new UserGroup(user,permission,null,null));
                    break;
                case 2:
                    CompanyExample companyExample = new CompanyExample();
                    CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
                    companyExampleCriteria.andCompanyUserIdEqualTo(user.getUserId());
                    List<Company> companies = companyMapper.selectByExample(companyExample);
                    if (companies.size()<0)
                        list.add(new UserGroup(user,permission,null,null));
                    else
                        list.add(new UserGroup(user,permission,companies.get(0),null));
                    break;
                case 3:
                    //查项目
                    ProjectExample projectExample = new ProjectExample();
                    ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                    projectExampleCriteria.andProjectUserIdEqualTo(user.getUserId());
                    List<Project> projects = projectMapper.selectByExample(projectExample);
                    //查集团
                    CompanyExample companyProjectExample = new CompanyExample();
                    CompanyExample.Criteria companyProjectExampleCriteria = companyProjectExample.createCriteria();
                    companyProjectExampleCriteria.andCompanyUserIdEqualTo(user.getUserParentId());
                    List<Company> companiesProject = companyMapper.selectByExample(companyProjectExample);
                    if (projects.size()<0||companiesProject.size()<0)
                        list.add(new UserGroup(user,permission,null,null));
                    else
                        list.add(new UserGroup(user,permission,companiesProject.get(0),projects.get(0)));
                        break;
                case 4:
                    //查项目
                    ProjectExample ocmmonExample = new ProjectExample();
                    ProjectExample.Criteria commonExampleCriteria = ocmmonExample.createCriteria();
                    commonExampleCriteria.andProjectUserIdEqualTo(user.getUserParentId());
                    List<Project> projectsCommon = projectMapper.selectByExample(ocmmonExample);
                    //查项目管理员
                    User projectUser = userMapper.selectByPrimaryKey(user.getUserParentId());
                    //查集团
                    CompanyExample commonProjectExample = new CompanyExample();
                    CompanyExample.Criteria commonProjectExampleCriteria = commonProjectExample.createCriteria();
                    commonProjectExampleCriteria.andCompanyUserIdEqualTo(projectUser.getUserParentId());
                    List<Company> companiesCommon = companyMapper.selectByExample(commonProjectExample);
                    if (projectsCommon.size()<0||companiesCommon.size()<0)
                    list.add(new UserGroup(user,permission,null,null));
                    else
                    list.add(new UserGroup(user,permission,companiesCommon.get(0),projectsCommon.get(0)));
                    break;
            }
        }
        return list;
    }

    /**
     * 根据当前登陆用户，分页查询用户组合类
     * @param pageNum
     * @param pageSize
     * @param userPhone
     * @param userName
     * @return
     */
    public PageResult selectUserGroupByPage(int pageNum, int pageSize,String userPhone, String userName) {
        try {
            User currentUser = UserUtils.getCurrentUser();
            //查子用户
            switch (currentUser.getUserRole()){
                case 1:// 如果是超级用户，查所有
                    List<Integer> superIds = new ArrayList<Integer>();
                    superIds.add(currentUser.getUserId());//加入当前集团用户ID
                    List<Integer> superCompanyIds = getChildrenIdByUserId(currentUser.getUserId());// 查儿子
                    superIds.addAll(superCompanyIds);
                    for (Integer id: superCompanyIds){
                        List<Integer> superProjectIds = getChildrenIdByUserId(id);// 查孙子
                        superIds.addAll(superProjectIds);
                        for (Integer i: superProjectIds){
                            List<Integer> superCommonIds = getChildrenIdByUserId(i);// 查曾孙
                            superIds.addAll(superCommonIds);
                        }
                    }
                    PageHelper.startPage(pageNum, pageSize);
                    List<UserGroup> superUserGroups = getUserGroupByUsers(superIds, userName, userPhone);
                    return new PageResult(superIds.size(),superUserGroups);
                case 2:// 如果是集团用户，查自己、查项目用户、普通用户
                    List<Integer> companyIds = new ArrayList<Integer>();
                    companyIds.add(currentUser.getUserId());//加入当前集团用户ID
                    List<Integer> companyProjectIds = getChildrenIdByUserId(currentUser.getUserId());// 查项目用户ID
                    companyIds.addAll(companyProjectIds);
                    for ( Integer id: companyProjectIds){
                        List<Integer> companyCommonIds = getChildrenIdByUserId(id);// 查普通用户ID
                        companyIds.addAll(companyCommonIds);
                    }
                    PageHelper.startPage(pageNum, pageSize);
                    List<UserGroup> companyUserGroups = getUserGroupByUsers(companyIds, userName, userPhone);
                    return new PageResult(companyIds.size(),companyUserGroups);
                case 3:// 如果是项目用户，查自己、查普通用户
                    List<Integer> projectIds = new ArrayList<Integer>();
                    projectIds.add(currentUser.getUserId());
                    List<Integer> projecgtCommonIds = getChildrenIdByUserId(currentUser.getUserId());
                    projectIds.addAll(projecgtCommonIds);
                    PageHelper.startPage(pageNum, pageSize);
                    List<UserGroup> projectUserGroups = getUserGroupByUsers(projectIds, userName, userPhone);
                    return new PageResult(projectIds.size(),projectUserGroups);
                case 4:// 如果是普通用户，无可查，只查自己
                    List<Integer> commonIds = new ArrayList<Integer>();
                    commonIds.add(currentUser.getUserId());
                    PageHelper.startPage(pageNum, pageSize);
                    List<UserGroup> commonUserGroups = getUserGroupByUsers(commonIds, userName, userPhone);
                    return new PageResult(commonIds.size(),commonUserGroups);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/selectUserGroupByPage/分页查询用户/错误");
        }
        return null;
    }
    //子方法1，根据用户Id得子用户ID集合，父方法selectUserGroupByPage
    private  List<Integer> getChildrenIdByUserId(Integer id){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserParentIdEqualTo(id);
        List<User> list =  userMapper.selectByExample(example);
        List<Integer> listIds = new ArrayList<Integer>();
        for (User u: list){
            listIds.add(u.getUserId());
        }
        return listIds;
    }
    //子方法2，根据用户ID集合返回UserGroup集合，父方法selectUserGroupByPage
    private List<UserGroup> getUserGroupByUsers(List<Integer> userIds,String userName,String userPhone){
        List<UserGroup> list = new ArrayList<UserGroup>();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(userIds);
        if(userName!=null&&userName!=""){
            criteria.andUserNameLike("%"+userName+"%");
        } else if (userPhone!=null&&userPhone!="") {
            criteria.andUserPhoneEqualTo(userPhone);
        }
        List<User> users = userMapper.selectByExample(example);
        for (User user: users){
                Permission permission = permissionMapper.selectByPrimaryKey(user.getUserPermissionId());
                list.add(new UserGroup(user,permission,null,null));
            }
            return list;
    }

    /**
     * 根据当前登陆用户，查询用户组合类树
     * @return
     */
    public List<UserCompany> selectUsersTree() {
        try {
            User currentUser = UserUtils.getCurrentUser();
            switch (currentUser.getUserRole()){
                case 1:
                    return superSelectUsers();
                case 2:
                    return companySelectUsers();
                case 3:
                    return projectSelectUsers();
                case 4:
                    return commonSelectUsers();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserService/selectUsersTree/查用户树/错误");
        }
        return null;
    }
    //1、子方法，超级用户，查集团用户，集团用户下的项目用户，项目用户下的普通用户，父方法selectUsersTree
    private List<UserCompany> superSelectUsers(){
        List<UserCompany> userCompanies = new ArrayList<UserCompany>();
        //查厂家下所有集团经理
        UserExample superExample = new UserExample();
        UserExample.Criteria superCriteria = superExample.createCriteria();
        superCriteria.andUserRoleEqualTo(2);
        List<User> companyUsers = userMapper.selectByExample(superExample);
        for (User companyUser: companyUsers){
            //由集团经理查集团
            CompanyExample companyExample = new CompanyExample();
            CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
            companyExampleCriteria.andCompanyUserIdEqualTo(companyUser.getUserId());
            List<Company> companies = companyMapper.selectByExample(companyExample);
            //查一个集团经理下的所有项目经理
            UserExample companUseryExample = new UserExample();
            UserExample.Criteria companyCriteria = companUseryExample.createCriteria();
            companyCriteria.andUserParentIdEqualTo(companyUser.getUserId());
            List<User> projectUsers = userMapper.selectByExample(companUseryExample);

            List<UserProject> userProjects = new ArrayList<UserProject>();
            for (User projectUser: projectUsers){
                //由项目经理查项目
                ProjectExample projectExample = new ProjectExample();
                ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
                projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
                List<Project> projects = projectMapper.selectByExample(projectExample);

                //查一个项目经理下的所有安全经理
                UserExample projectUserExample = new UserExample();
                UserExample.Criteria projectCriteria = projectUserExample.createCriteria();
                projectCriteria.andUserParentIdEqualTo(projectUser.getUserId());
                List<User> commonUsers = userMapper.selectByExample(projectUserExample);
                List<UserGroup> userCommons = new ArrayList<UserGroup>();
                for (User commonUser: commonUsers){
                    //封装一个    private List<UserGroup> userCommons;
                    Company commonCompany = companyMapper.selectByPrimaryKey(commonUser.getUserCompanyId());
                    Project commonProject = projectMapper.selectByPrimaryKey(commonUser.getUserProjectId());
                    Permission commonPermission = permissionMapper.selectByPrimaryKey(commonUser.getUserPermissionId());
                    userCommons.add(new UserGroup(commonUser,commonPermission,commonCompany,commonProject));
                }
                //封装一个项目经理树
                if(projects.size()>0)
                userProjects.add(new UserProject(projectUser,projects.get(0),userCommons));
            }
            //封装一个集团经理树
            if (companies.size()>0)
            userCompanies.add(new UserCompany(companyUser,companies.get(0),userProjects));
        }
        return userCompanies;
    }
    //2、子方法，集团用户，查本集团，本集团下的项目用户，每个项目用户下的普通用户，父方法selectUsersTree
    private List<UserCompany> companySelectUsers(){
        List<UserCompany> userCompanies = new ArrayList<UserCompany>();
        //根据当前登陆的集团用户查集团
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<Company> companies = companyMapper.selectByExample(companyExample);

        //查一个集团经理下的所有项目经理
        UserExample companUseryExample = new UserExample();
        UserExample.Criteria companyCriteria = companUseryExample.createCriteria();
        companyCriteria.andUserParentIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<User> projectUsers = userMapper.selectByExample(companUseryExample);

        List<UserProject> userProjects = new ArrayList<UserProject>();
        for (User projectUser: projectUsers){
            //由项目经理查项目
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectUserIdEqualTo(projectUser.getUserId());
            List<Project> projects = projectMapper.selectByExample(projectExample);

            //查一个项目经理下的所有安全经理
            UserExample projectUserExample = new UserExample();
            UserExample.Criteria projectCriteria = projectUserExample.createCriteria();
            projectCriteria.andUserParentIdEqualTo(projectUser.getUserId());
            List<User> commonUsers = userMapper.selectByExample(projectUserExample);
            List<UserGroup> userCommons = new ArrayList<UserGroup>();
            for (User commonUser: commonUsers){
                //封装一个    private List<UserGroup> userCommons;
                Company commonCompany = companyMapper.selectByPrimaryKey(commonUser.getUserCompanyId());
                Project commonProject = projectMapper.selectByPrimaryKey(commonUser.getUserProjectId());
                Permission commonPermission = permissionMapper.selectByPrimaryKey(commonUser.getUserPermissionId());
                userCommons.add(new UserGroup(commonUser,commonPermission,commonCompany,commonProject));
            }
            //封装一个项目经理树
            if(projects.size()>0)
                userProjects.add(new UserProject(projectUser,projects.get(0),userCommons));
        }
        //封装一个集团经理树
        if (companies.size()>0)
            userCompanies.add(new UserCompany(UserUtils.getCurrentUser(),companies.get(0),userProjects));
        return userCompanies;
    }
    //3、子方法，项目用户，查所在集团用户，查本项目用户，查项目用户下的普通用户，父方法selectUsersTree
    private List<UserCompany> projectSelectUsers(){
        List<UserCompany> userCompanies = new ArrayList<UserCompany>();
        //根据当前登陆的项目经理查集团
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(UserUtils.getCurrentUser().getUserParentId());
        List<Company> companies = companyMapper.selectByExample(companyExample);

        List<UserProject> userProjects = new ArrayList<UserProject>();
        //由项目经理查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);

        //查一个项目经理下的所有安全经理
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectCriteria = projectUserExample.createCriteria();
        projectCriteria.andUserParentIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<User> commonUsers = userMapper.selectByExample(projectUserExample);
        List<UserGroup> userCommons = new ArrayList<UserGroup>();
        for (User commonUser: commonUsers){
            //封装一个    private List<UserGroup> userCommons;
            Company commonCompany = companyMapper.selectByPrimaryKey(commonUser.getUserCompanyId());
            Project commonProject = projectMapper.selectByPrimaryKey(commonUser.getUserProjectId());
            Permission commonPermission = permissionMapper.selectByPrimaryKey(commonUser.getUserPermissionId());
            userCommons.add(new UserGroup(commonUser,commonPermission,commonCompany,commonProject));
        }
        //封装一个项目经理树
        if(projects!=null)
            userProjects.add(new UserProject(UserUtils.getCurrentUser(),projects.get(0),userCommons));
        //封装一个集团经理树
        if (companies!=null)
            userCompanies.add(new UserCompany(UserUtils.getCurrentUser(),companies.get(0),userProjects));
        return userCompanies;
    }
    //4、子方法，普通用户，查所在集团用户，所在项目用户，查本普通用户，父方法selectUsersTree
    private List<UserCompany> commonSelectUsers(){
        List<UserCompany> userCompanies = new ArrayList<UserCompany>();
        //由当前登陆安全经理，查项目经理
        User projectUser = userMapper.selectByPrimaryKey(UserUtils.getCurrentUser().getUserParentId());
        //根据项目经理查集团
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andCompanyUserIdEqualTo(projectUser.getUserParentId());
        List<Company> companies = companyMapper.selectByExample(companyExample);

        List<UserProject> userProjects = new ArrayList<UserProject>();
        //由项目经理查项目
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
        projectExampleCriteria.andProjectUserIdEqualTo(UserUtils.getCurrentUser().getUserId());
        List<Project> projects = projectMapper.selectByExample(projectExample);

        List<UserGroup> userCommons = new ArrayList<UserGroup>();
        //封装一个    private List<UserGroup> userCommons;
        Company commonCompany = companyMapper.selectByPrimaryKey(UserUtils.getCurrentUser().getUserCompanyId());
        Project commonProject = projectMapper.selectByPrimaryKey(UserUtils.getCurrentUser().getUserProjectId());
        Permission commonPermission = permissionMapper.selectByPrimaryKey(UserUtils.getCurrentUser().getUserPermissionId());
        userCommons.add(new UserGroup(UserUtils.getCurrentUser(),commonPermission,commonCompany,commonProject));

        //封装一个项目经理树
        if(projects!=null)
            userProjects.add(new UserProject(UserUtils.getCurrentUser(),projects.get(0),userCommons));
        //封装一个集团经理树
        if (companies!=null)
            userCompanies.add(new UserCompany(UserUtils.getCurrentUser(),companies.get(0),userProjects));
        return userCompanies;
    }

    /**
     * 根据项目ID，查询一个项目用户的树枝
     * @param projectId
     * @return
     */
    public UserCompany selectUserProjectByProjectId(Integer projectId){
        //查所在集团
        Project project = projectMapper.selectByPrimaryKey(projectId);
        Company company = companyMapper.selectByPrimaryKey(project.getProjectCompanyId());
        User projectUser = userMapper.selectByPrimaryKey(project.getProjectUserId());
        User companyUser = userMapper.selectByPrimaryKey(projectUser.getUserParentId());
        UserExample projectUserExample = new UserExample();
        UserExample.Criteria projectUserExampleCriteria = projectUserExample.createCriteria();
        projectUserExampleCriteria.andUserParentIdEqualTo(companyUser.getUserId());
        List<User> projectUsers = userMapper.selectByExample(projectUserExample);
        List<UserProject> userProjects = new ArrayList<UserProject>();
        for (User user: projectUsers){
            //由项目经理查项目
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria projectExampleCriteria = projectExample.createCriteria();
            projectExampleCriteria.andProjectUserIdEqualTo(user.getUserId());
            List<Project> projects = projectMapper.selectByExample(projectExample);

            //由项目经理，查安全经理
            UserExample commonExample = new UserExample();
            UserExample.Criteria commonExampleCriteria = commonExample.createCriteria();
            commonExampleCriteria.andUserParentIdEqualTo(user.getUserId());
            List<User> commonUsers = userMapper.selectByExample(commonExample);
            List<UserGroup> userCommons = new ArrayList<UserGroup>();
            for (User commonUser: commonUsers){
                //封装一个    private List<UserGroup> userCommons;
                Company commonCompany = companyMapper.selectByPrimaryKey(commonUser.getUserCompanyId());
                Project commonProject = projectMapper.selectByPrimaryKey(commonUser.getUserProjectId());
                Permission commonPermission = permissionMapper.selectByPrimaryKey(commonUser.getUserPermissionId());
                userCommons.add(new UserGroup(commonUser,commonPermission,commonCompany,commonProject));
            }
            if (projects!=null)
            userProjects.add(new UserProject(user,projects.get(0),userCommons));
        }
        return new UserCompany(companyUser,company,userProjects);
    }

    /**
     * 根据当前登陆用户，查询所有集团用户，及下属项目用户
     * @return
     */
    public List<User> selectProjectUsers() {
        User currentUser = UserUtils.getCurrentUser();
        if (currentUser.getUserRole()==1){// 超级用户查项目管理员
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserRoleEqualTo(3);
            return userMapper.selectByExample(example);
        }else if (currentUser.getUserRole()==2){//集团用户查项目管理员
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserParentIdEqualTo(currentUser.getUserId());
            return userMapper.selectByExample(example);
        }else if (currentUser.getUserRole()==3){//项目用户查项目管理员
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(currentUser.getUserId());
            return userMapper.selectByExample(example);
        }else if (currentUser.getUserRole()==4){//普通用户查项目管理员
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(currentUser.getUserParentId());
            return userMapper.selectByExample(example);
        }
        return null;
    }

}
