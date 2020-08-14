package com.jyr.iot.platform.sms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SmsService {
    @Autowired
    private SendSmsUtils sendSmsUtils;

    @JmsListener(destination="smsalarm")
    public void sendSms(Map<String,String> map){
        try {
            sendSmsUtils.sendSmsAlarmLog(
                    map.get("PhoneNumbers"),
                    map.get("device"),
                    map.get("project"),
                    map.get("time"),
                    map.get("warn")
            );
            log.info("短信发送成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("SmsService/sendSms/发送短信/失败");
        }
    }
}


