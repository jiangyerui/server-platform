package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.pojo.User;

import com.jyr.iot.platform.pojogroup.UserCompany;
import com.jyr.iot.platform.pojogroup.UserGroup;
import com.jyr.iot.platform.service.UserService;
import com.jyr.iot.platform.util.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * paramType：参数放在哪个地方
 * header-->请求参数的获取：@RequestHeader
 * query-->请求参数的获取：@RequestParam
 * path（用于restful接口）-->请求参数的获取：@PathVariable
 * body（不常用）
 * form（不常用）
 */
@RestController
@Api(value = "UserController|用户管理控制器")
@RequestMapping("/platform/user/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    @ApiOperation(value = "增加用户",notes = "增加一个用户")
    @ApiImplicitParam(paramType = "body",name = "userGroup",value = "用户信息",required = true,dataType = "UserGroup")
    public Result addUserGroup(@RequestBody UserGroup userGroup){
        try {
            log.info(userGroup.toString());
            userService.addUserGroup(userGroup);
            return new Result(true,"增加用户成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加用户失败");
        }
    }

    @DeleteMapping("deleteUserById/{id}")
    @ApiOperation(value = "删除用户",notes = "根据用户ID删除一个用户")
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户ID",required = true,dataType = "Integer")
    public Result deleteUserGroupById(@PathVariable("id") Integer id){
        try {
            userService.deleteUserGroupById(id);
            return new Result(true,"删除用户成功");
        }catch (Exception e){
            return new Result(false,"删除用户失败");
        }
    }

    @PutMapping("updateUser")
    @ApiOperation(value = "更新用户",notes = "更新一个用户")
    @ApiImplicitParam(paramType = "body",name = "user",value = "用户信息",required = true,dataType = "UserGroup")
    public Result updateUserGroup(@RequestBody UserGroup userGroup){
        try {
            userService.updateUserGroup(userGroup);
            return new Result(true,"更新用户成功");
        }catch (Exception e){
            return new Result(false,"更新用户失败");
        }
    }

    @GetMapping("selectUserById/{id}")
    @ApiOperation(value = "查询用户",notes = "根据用户ID查询用户")
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户ID",required = true,dataType = "Integer")
    public UserGroup selectUserGroupById(@PathVariable("id") Integer id){
        return userService.selectUserGroupById(id);
    }

    @GetMapping("selectCurrentUser")
    @ApiOperation(value = "查询用户",notes = "查询当前登陆用户")
    public User selectCurrentUser(){
        return UserUtils.getCurrentUser();
    }

    @GetMapping("selectAllUser")
    @ApiOperation(value = "查询用户",notes = "查询所有用户")
    public List<UserGroup> selectAllUserGroup(){
        return userService.selectAllUserGroup();
    }

    @GetMapping("selectUserByPage")
    @ApiOperation(value = "查询用户",notes = "分页查询用户")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "userPhone",value = "查询条件userPhone",required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "userName",value = "查询条件userName",required = false,dataType = "String")
    })
    public PageResult selectUserByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userName") String userName){

        return userService.selectUserGroupByPage(pageNum,pageSize,userPhone,userName);
    }



    /*****************************************************集团业务******************************************************/

    @GetMapping("selectUsersTree")
    @ApiOperation(value = "查询UserCompany",notes = "根据当前登陆用户，查用户组合类树，查询用户组，即集团们，每个集团下的项目，每个项目下的普通")
    public List<UserCompany> selectUsersTree() {
        return userService.selectUsersTree();
    }


    @GetMapping("selectProjectUsers")
    @ApiOperation(value = "查询List<User>",notes = "根据当前登陆用户，查询所有项目管理员")
    public List<User> selectProjectUsers() {
        return userService.selectProjectUsers();
    }

    @GetMapping("selectUserProjectByProjectId/{id}")
    @ApiOperation(value = "查询UserProject",notes = "根据项目ID，查一个项目组合类树枝")
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户ID",required = true,dataType = "Integer")
    public UserCompany selectUserProjectByProjectId(@PathVariable("id") Integer id){
        return userService.selectUserProjectByProjectId(id);
    }
}
