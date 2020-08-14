package com.jyr.iot.platform.appcontroller;

import com.jyr.iot.platform.appservice.AppAlarmLogService;
import com.jyr.iot.platform.pojo.AlarmLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "AppAlarmLogController|应用报警管理控制器")
@RequestMapping("/platform/app/alarmlog/")
@CrossOrigin
@Slf4j
public class AppAlarmLogController {
    @Autowired
    private AppAlarmLogService appAlarmLogService;
    @GetMapping("selectAlarmLogByCurrentUser")
    @ApiOperation(value = "查询报警",notes = "根据当前登陆用户查报警")
    public List<AlarmLog> selectAlarmLogByCurrentUser(){
        return appAlarmLogService.selectAlarmLogByCurrentUser();
    }

}
