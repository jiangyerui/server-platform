package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.PageResult;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.mapper.DeviceMapper;
import com.jyr.iot.platform.pojo.Device;

import com.jyr.iot.platform.pojogroup.DeviceCompany;
import com.jyr.iot.platform.pojogroup.DeviceGroup;
import com.jyr.iot.platform.service.DeviceService;
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
@Api(value = "DeviceController|设备管理控制器")
@RequestMapping("/platform/device/")
//@CrossOrigin(origins = "http://localhost:8082",maxAge = 3600)
@CrossOrigin
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("addDevice")
    @ApiOperation(value = "增加设备",notes = "增加一个设备")
    @ApiImplicitParam(paramType = "body",name = "device",value = "设备信息",required = true,dataType = "DeviceGroup")
    public Result addDevice(@RequestBody DeviceGroup deviceGroup){
        try {
            deviceService.addDevice(deviceGroup);
            return new Result(true,"增加设备成功了");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加设备失败");
        }
    }

    @DeleteMapping("deleteDeviceById/{id}")
    @ApiOperation(value = "删除设备",notes = "根据设备ID删除一个设备")
    @ApiImplicitParam(paramType = "path",name = "id",value = "设备ID",required = true,dataType = "Integer")
    public Result deleteDeviceById(@PathVariable("id") Integer id){
        try {
            deviceService.deleteDeviceById(id);
            return new Result(true,"删除设备成功");
        }catch (Exception e){
            return new Result(false,"删除设备失败");
        }
    }

    @PutMapping("updateDevice")
    @ApiOperation(value = "更新设备",notes = "更新一个设备")
    @ApiImplicitParam(paramType = "body",name = "device",value = "设备信息",required = true,dataType = "DeviceGroup")
    public Result updateDevice(@RequestBody DeviceGroup deviceGroup){
        try {
            deviceService.updateDevice(deviceGroup);
            return new Result(true,"更新设备成功");
        }catch (Exception e){
            return new Result(false,"更新设备失败");
        }
    }

    @GetMapping("selectDeviceById/{id}")
    @ApiOperation(value = "查询设备",notes = "根据设备ID查询设备")
    @ApiImplicitParam(paramType = "path",name = "id",value = "设备ID",required = true,dataType = "Integer")
    public DeviceGroup selectDeviceById(@PathVariable("id") Integer id){
        return deviceService.selectDeviceById(id);
    }

    @GetMapping("selectAllDevice")
    @ApiOperation(value = "查询设备",notes = "查询所有设备")
    public List<DeviceGroup> selectAllDevice(){
        return deviceService.selectAllDevice();
    }

    @GetMapping("selectDeviceByPage")
    @ApiOperation(value = "查询设备",notes = "分页查询设备")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页记录数",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "deviceName",value = "查询条件deviceName",required = false,dataType = "String")
    })
    public PageResult selectDeviceByPage(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("deviceName") String deviceName){
        return deviceService.selectDeviceByPage(pageNum,pageSize,deviceName);
    }


    @GetMapping("selectDeviceTreeByCurrentUser")
    @ApiOperation(value = "查询设备",notes = "根据当前登陆用户查设备树")
    public List<DeviceCompany> selectDeviceTreeByCurrentUser(){
        return deviceService.selectDeviceTreeByCurrentUser();
    }


    //
}
