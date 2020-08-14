package com.jyr.iot.platform.controller;

import com.jyr.iot.platform.entity.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegLoginController {
    @RequestMapping("/login_p")
    @ResponseBody
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }

}
