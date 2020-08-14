package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.mapper.OperationLogMapper;
import com.jyr.iot.platform.pojo.OperationLog;

import com.jyr.iot.platform.service.OperationLogService;
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
@Api(value = "OperationLogController|操作管理控制器")
@RequestMapping("/platform/operationLog/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class OperationLogController {
    @Autowired
    private OperationLogService operlogService;

    @PostMapping("addOperationLog")
    @ApiOperation(value = "增加操作",notes = "增加一个操作")
    @ApiImplicitParam(paramType = "body",name = "operlog",value = "操作信息",required = true,dataType = "OperationLog")
    public Result addOperationLog(@RequestBody OperationLog operlog){
        try {
            operlogService.addOperationLog(operlog);
            return new Result(true,"增加操作成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加操作失败");
        }
    }

    @DeleteMapping("deleteOperationLogById/{id}")
    @ApiOperation(value = "删除操作",notes = "根据操作ID删除一个操作")
    @ApiImplicitParam(paramType = "path",name = "id",value = "操作ID",required = true,dataType = "Integer")
    public Result deleteOperationLogById(@PathVariable("id") Integer id){
        try {
            operlogService.deleteOperationLogById(id);
            return new Result(true,"删除操作成功");
        }catch (Exception e){
            return new Result(false,"删除操作失败");
        }
    }

    @PutMapping("updateOperationLog")
    @ApiOperation(value = "更新操作",notes = "更新一个操作")
    @ApiImplicitParam(paramType = "body",name = "operlog",value = "操作信息",required = true,dataType = "OperationLog")
    public Result updateOperationLog(@RequestBody OperationLog operlog){
        try {
            operlogService.updateOperationLog(operlog);
            return new Result(true,"更新操作成功");
        }catch (Exception e){
            return new Result(false,"更新操作失败");
        }
    }

    @GetMapping("selectOperationLogById/{id}")
    @ApiOperation(value = "查询操作",notes = "根据操作ID查询操作")
    @ApiImplicitParam(paramType = "path",name = "id",value = "操作ID",required = true,dataType = "Integer")
    public OperationLog selectOperationLogById(@PathVariable("id") Integer id){
        return operlogService.selectOperationLogById(id);
    }

    @GetMapping("selectAllOperationLog")
    @ApiOperation(value = "查询操作",notes = "查询所有操作")
    public List<OperationLog> selectAllOperationLog(){
        return operlogService.selectAllOperationLog();
    }

    @GetMapping("selectOperationLogByPage")
    @ApiOperation(value = "查询操作",notes = "分页查询操作")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
//            @ApiImplicitParam(paramType = "query",name = "operlogName",value = "查询条件operlogName",required = false,dataType = "String")
    })
    public PageResult selectOperationLogByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize){
//            @RequestParam("operlogName") String operlogName){
        return operlogService.selectOperationLogByPage(pageNum,pageSize);
    }

}
