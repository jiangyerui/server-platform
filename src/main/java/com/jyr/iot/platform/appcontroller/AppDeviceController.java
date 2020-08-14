package com.jyr.iot.platform.appcontroller;

import com.jyr.iot.platform.appservice.AppDeviceService;
import com.jyr.iot.platform.entity.Result;
import com.jyr.iot.platform.pojogroup.DeviceCompany;
import com.jyr.iot.platform.pojogroup.DeviceGroup;
import com.jyr.iot.platform.pojogroup.DeviceProject;
import com.jyr.iot.platform.pojogroup.LcAcs;
import com.jyr.iot.platform.service.LcAcsService;
import com.jyr.iot.platform.service.ZhydService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "AppDeviceController|应用设备管理控制器")
@RequestMapping("/platform/app/device/")
@CrossOrigin
@Slf4j
public class AppDeviceController {
    @Autowired
    private LcAcsService lcAcsService;
    @Autowired
    private ZhydService zhydService;
    @Autowired
    private AppDeviceService appDeviceService;
    //得到单个设备的实时数据
    @GetMapping("selectDeviceDataByMac/{mac}")
    @ApiOperation(value = "查询设备",notes = "根据设备MAC查询设备数据")
    @ApiImplicitParam(paramType = "path",name = "mac",value = "设备mac",required = true,dataType = "String")
//    public LcAcs selectDeviceById(@PathVariable("mac") String mac){
//        return lcAcsService.selectDeviceDataByMac(mac);
//    }
    public Object selectDeviceById(@PathVariable("mac") String mac){
        if (mac.length()>12)
            return lcAcsService.selectDeviceDataByMac(mac);
        else
            return zhydService.selectDeviceDataByMac(mac);
    }


    @GetMapping("selectDeviceProjectsByCurrentUser")
    @ApiOperation(value = "查询设备",notes = "根据当前登陆用户查首页信息树")
    public List<DeviceProject> selectDeviceProjectsByCurrentUser(){
        return appDeviceService.selectDeviceProjectsByCurrentUser();
    }

}
