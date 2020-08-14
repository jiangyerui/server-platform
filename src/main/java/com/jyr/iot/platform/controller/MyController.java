package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.appservice.AppAlarmLogService;
import com.jyr.iot.platform.pojo.AlarmLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/pathother")
public class MyController {
    @Autowired
    private AppAlarmLogService appAlarmLogService;

    @RequestMapping("/getalarmlog")
    @ResponseBody
//    public List<AlarmLog> getalarmlog(){
    public String getalarmlog(){
//        return appAlarmLogService.getAlarmLogByProjectId(1);
        return "qwqwqwqgetalarmlog";
    }

    @RequestMapping("/")
    public String index (){
//        log.info("用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//        log.info("用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName());
        return "wel";
    }

    @RequestMapping("platform/get")
    @ResponseBody
    public static String currentUser(HttpSession session) {
        log.info("用户角色为:"+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        log.info("用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName());
        return "用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities()+
                "---用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping("/platform/jiang")
    @ResponseBody
//    @PreAuthorize("hasAuthority('JIANG')")
    public String jiang() {
        log.info("用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        log.info("用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName());
        return "用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities()+
        "---用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping("/platform/ye")
    @ResponseBody
//    @PreAuthorize("hasAuthority('YE')")
    public String ye() {
        log.info("用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        log.info("用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName());
        return "用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities()+
                "---用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName();
    }




    @GetMapping("/platform/haha")
    @ResponseBody
//    @PreAuthorize("hasAuthority('vip')")
    public String haha (){
        log.info("用户角色为:"+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        log.info("用户名为:"+ SecurityContextHolder.getContext().getAuthentication().getName());
        return "haha";
    }
}
