package com.jyr.iot.platform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyr.iot.platform.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class PlatformApplicationTests {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
    @Test
    void sendToRabbitMQ() {
//        User user = new User();
//        user.setUserName("jiang");
//        user.setUserPassword("pw");
//
//        User user1 = new User();
//        user1.setUserName("ye");
//        user1.setUserPassword("ye");
//        //单播，存到队列
//        rabbitTemplate.convertAndSend("ex-point",null,user);
//        rabbitTemplate.convertAndSend("ex-point",null,user1);
    }

    @Test
    void receiveFromRabbitMQ() {
//        User user = (User)rabbitTemplate.receiveAndConvert("queue1");
//        log.error("queue1 = "+user.getUserName());
    }

}
