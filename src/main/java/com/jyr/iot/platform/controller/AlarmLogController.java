package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;

import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.service.AlarmLogService;
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
@Api(value = "AlarmLogController|报警管理控制器")
@RequestMapping("/platform/alarmLog/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class AlarmLogController {
    @Autowired
    private AlarmLogService alarmlogService;

    @PostMapping("addAlarmLog")
    @ApiOperation(value = "增加报警",notes = "增加一个报警")
    @ApiImplicitParam(paramType = "body",name = "alarmlog",value = "报警信息",required = true,dataType = "AlarmLog")
    public Result addAlarmLog(@RequestBody AlarmLog alarmlog){
        try {
            alarmlogService.addAlarmLog(alarmlog);
            return new Result(true,"增加报警成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加报警失败");
        }
    }

    @DeleteMapping("deleteAlarmLogById/{id}")
    @ApiOperation(value = "删除报警",notes = "根据报警ID删除一个报警")
    @ApiImplicitParam(paramType = "path",name = "id",value = "报警ID",required = true,dataType = "Integer")
    public Result deleteAlarmLogById(@PathVariable("id") Integer id){
        try {
            alarmlogService.deleteAlarmLogById(id);
            return new Result(true,"删除报警成功");
        }catch (Exception e){
            return new Result(false,"删除报警失败");
        }
    }

    @PutMapping("updateAlarmLog")
    @ApiOperation(value = "更新报警",notes = "更新一个报警")
    @ApiImplicitParam(paramType = "body",name = "alarmlog",value = "报警信息",required = true,dataType = "AlarmLog")
    public Result updateAlarmLog(@RequestBody AlarmLog alarmlog){
        try {
            alarmlogService.updateAlarmLog(alarmlog);
            return new Result(true,"更新报警成功");
        }catch (Exception e){
            return new Result(false,"更新报警失败");
        }
    }

    @GetMapping("sloveAlarmLogById/{id}")
    @ApiOperation(value = "查询报警",notes = "根据报警ID查询报警")
    @ApiImplicitParam(paramType = "path",name = "id",value = "报警ID",required = true,dataType = "Integer")
    public void sloveAlarmLogById(@PathVariable("id") Integer id){
        alarmlogService.sloveAlarmLogById(id);
    }

    @GetMapping("selectAlarmLogById/{id}")
    @ApiOperation(value = "处理报警",notes = "处理一条报警")
    @ApiImplicitParam(paramType = "path",name = "id",value = "报警ID",required = true,dataType = "Integer")
    public AlarmLog selectAlarmLogById(@PathVariable("id") Integer id){
        return alarmlogService.selectAlarmLogById(id);
    }

    @GetMapping("selectAllAlarmLog")
    @ApiOperation(value = "查询报警",notes = "查询所有报警")
    public List<AlarmLog> selectAllAlarmLog(){
        return alarmlogService.selectAllAlarmLog();
    }

    @GetMapping("selectAlarmLogByPage")
    @ApiOperation(value = "查询报警",notes = "分页查询报警")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "alarmlogName",value = "查询条件alarmlogName",required = false,dataType = "String")
    })
    public PageResult selectAlarmLogByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("alarmlogName") String alarmlogName){
        return alarmlogService.selectAlarmLogByPage(pageNum,pageSize,alarmlogName);
    }

}
