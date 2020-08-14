package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.pojo.Project;

import com.jyr.iot.platform.pojogroup.ProjectGroup;
import com.jyr.iot.platform.service.ProjectService;
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
@Api(value = "ProjectController|项目管理控制器")
@RequestMapping("/platform/project/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("addProject")
    @ApiOperation(value = "增加项目",notes = "增加一个项目")
    @ApiImplicitParam(paramType = "body",name = "project",value = "项目信息",required = true,dataType = "Project")
    public Result addProject(@RequestBody Project project){
        try {
            projectService.addProject(project);
            return new Result(true,"增加项目成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加项目失败");
        }
    }

    @DeleteMapping("deleteProjectById/{id}")
    @ApiOperation(value = "删除项目",notes = "根据项目ID删除一个项目")
    @ApiImplicitParam(paramType = "path",name = "id",value = "项目ID",required = true,dataType = "Integer")
    public Result deleteProjectById(@PathVariable("id") Integer id){
        try {
            projectService.deleteProjectById(id);
            return new Result(true,"删除项目成功");
        }catch (Exception e){
            return new Result(false,"删除项目失败");
        }
    }

    @PutMapping("updateProject")
    @ApiOperation(value = "更新项目",notes = "更新一个项目")
    @ApiImplicitParam(paramType = "body",name = "project",value = "项目信息",required = true,dataType = "Project")
    public Result updateProject(@RequestBody Project project){
        try {
            projectService.updateProject(project);
            return new Result(true,"更新项目成功");
        }catch (Exception e){
            return new Result(false,"更新项目失败");
        }
    }

    @GetMapping("selectProjectById/{id}")
    @ApiOperation(value = "查询项目",notes = "根据项目ID查询项目")
    @ApiImplicitParam(paramType = "path",name = "id",value = "项目ID",required = true,dataType = "Integer")
    public Project selectProjectById(@PathVariable("id") Integer id){
        return projectService.selectProjectById(id);
    }

    @GetMapping("selectAllProject")
    @ApiOperation(value = "查询项目",notes = "查询所有项目")
    public List<Project> selectAllProject(){
        return projectService.selectAllProject();
    }

    @GetMapping("selectProjectByPage")
    @ApiOperation(value = "查询项目",notes = "分页查询项目")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "projectName",value = "查询条件projectName",required = false,dataType = "String")
    })
    public PageResult selectProjectByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("projectName") String projectName){
        return projectService.selectProjectByPage(pageNum,pageSize,projectName);
    }

    @GetMapping("selectAllProjectByCurrentUser")
    @ApiOperation(value = "查询项目",notes = "由当前登陆用户，查所有项目")
    public List<ProjectGroup> selectAllProjectByCurrentUser(){
        return projectService.selectAllProjectByCurrentUser();
    }

}
