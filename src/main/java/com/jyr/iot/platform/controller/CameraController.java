package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.pojo.Camera;

import com.jyr.iot.platform.pojogroup.CameraGroup;
import com.jyr.iot.platform.service.CameraService;
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
@Api(value = "CameraController|相机管理控制器")
@RequestMapping("/platform/camera/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class CameraController {
    @Autowired
    private CameraService cameraService;

    @PostMapping("addCamera")
    @ApiOperation(value = "增加相机",notes = "增加一个相机")
    @ApiImplicitParam(paramType = "body",name = "camera",value = "相机信息",required = true,dataType = "Camera")
    public Result addCamera(@RequestBody CameraGroup cameraGroup){
        try {
            cameraService.addCamera(cameraGroup);
            return new Result(true,"增加相机成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加相机失败");
        }
    }

    @DeleteMapping("deleteCameraById/{id}")
    @ApiOperation(value = "删除相机",notes = "根据相机ID删除一个相机")
    @ApiImplicitParam(paramType = "path",name = "id",value = "相机ID",required = true,dataType = "Integer")
    public Result deleteCameraById(@PathVariable("id") Integer id){
        try {
            cameraService.deleteCameraById(id);
            return new Result(true,"删除相机成功");
        }catch (Exception e){
            return new Result(false,"删除相机失败");
        }
    }

    @PutMapping("updateCamera")
    @ApiOperation(value = "更新相机",notes = "更新一个相机")
    @ApiImplicitParam(paramType = "body",name = "camera",value = "相机信息",required = true,dataType = "Camera")
    public Result updateCamera(@RequestBody CameraGroup cameraGroup){
        try {
            cameraService.updateCamera(cameraGroup);
            return new Result(true,"更新相机成功");
        }catch (Exception e){
            return new Result(false,"更新相机失败");
        }
    }

    @GetMapping("selectCameraById/{id}")
    @ApiOperation(value = "查询相机",notes = "根据相机ID查询相机")
    @ApiImplicitParam(paramType = "path",name = "id",value = "相机ID",required = true,dataType = "Integer")
    public CameraGroup selectCameraById(@PathVariable("id") Integer id){
        return cameraService.selectCameraById(id);
    }

    @GetMapping("selectAllCamera")
    @ApiOperation(value = "查询相机",notes = "查询所有相机")
    public List<Camera> selectAllCamera(){
        return cameraService.selectAllCamera();
    }

    @GetMapping("selectCameraByPage")
    @ApiOperation(value = "查询相机",notes = "分页查询相机")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "cameraName",value = "查询条件cameraName",required = false,dataType = "String")
    })
    public PageResult selectCameraByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("cameraName") String cameraName){
        return cameraService.selectCameraByPage(pageNum,pageSize,cameraName);
    }

}
