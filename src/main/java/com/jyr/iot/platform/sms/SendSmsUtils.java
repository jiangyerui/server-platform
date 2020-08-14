package com.jyr.iot.platform.sms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
@Slf4j
@Component
public class SendSmsUtils {

    @Autowired
    private Environment env;

    public void sendSmsCode(String PhoneNumbers,String SignName,String TemplateCode, String TemplateParam) {
        String accessKeyId = env.getProperty("accessKeyId");
        String accessSecret = env.getProperty("accessSecret");

        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode",TemplateCode);
        request.putQueryParameter("TemplateParam", TemplateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }


    }


    public void sendSmsAlarmLog(String PhoneNumbers,String device,String project,String time,String warn) {
        String accessKeyId = env.getProperty("accessKeyId");
        String accessSecret = env.getProperty("accessSecret");

        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", "北京联创广汇");
        request.putQueryParameter("TemplateCode", "SMS_165060555");
        String str = "{\"device\":\""+device+"\",\"project\":\""+project+"\",\"time\":\""+time+"\",\"warn\":\""+warn+"\"}";
        log.info("PhoneNumbers -- "+PhoneNumbers);
        log.info("str -- "+str);
        request.putQueryParameter("TemplateParam", "{\"device\":\""+device+"\",\"project\":\""+project+"\",\"time\":\""+time+"\",\"warn\":\""+warn+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}

