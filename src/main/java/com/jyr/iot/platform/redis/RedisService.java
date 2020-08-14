package com.jyr.iot.platform.redis;

import com.alibaba.fastjson.JSON;
import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.User;
import com.jyr.iot.platform.pojogroup.*;
import com.jyr.iot.platform.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * redis工具
 */
@Service
@Slf4j
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<Object, LcAcsB128> lcAcsB128RedisTemplate;
    @Autowired
    private RedisTemplate<Object, LcAcs> lcAcsRedisTemplate;

    @Autowired
    private RedisTemplate<Object, ZhydData> zhydDataRedisTemplate;
    @Autowired
    private RedisTemplate<Object, ZhydData> alarmLogRedisTemplate;
    @Autowired
    private RedisTemplate<Object, ProjectThing> projectThingRedisTemplate;

//    存储当前用户当前选择的设备mac
    public void setCurrentDeviceMac(String currentDevKey,String mac){
        redisTemplate.opsForValue().set(currentDevKey,mac);
    }
//    获取当前选择的设备mac
    public String getCurrentDeviceMac(String currentDevKey){
        return (String) redisTemplate.opsForValue().get(currentDevKey);
    }

//    根据MAC存一组电气火灾数据
    public void setLcAcs(LcAcs lcAcs){
        lcAcsRedisTemplate.opsForValue().set(lcAcs.getMac(),lcAcs);
    }
//    根据MAC取一组电气火灾数据
    public LcAcs getLcAcs(String mac){
        return lcAcsRedisTemplate.opsForValue().get(mac);
    }

//    根据MAC存一组智慧用电数据
    public void setZhyd(ZhydData zhydData){
        zhydDataRedisTemplate.opsForValue().set(zhydData.getMac(),zhydData);
    }
//    根据MAC取一组智慧用电数据
    public ZhydData getZhyd(String mac){
        return zhydDataRedisTemplate.opsForValue().get(mac);
    }

//    存DeviceProject，用于3D显示
    public void setProjectThing(ProjectThing projectThing){
        projectThingRedisTemplate.opsForValue().set("projectthing/"+projectThing.getProject().getProjectId(),projectThing);
    }
//    取项目中的设备状态，用于3D显示
    public ProjectThing getProjectThing(Integer projectId){
        String projectKey = "projectthing/"+projectId;
        return projectThingRedisTemplate.opsForValue().get(projectKey);
    }
}
