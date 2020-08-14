package com.jyr.iot.platform.netty;

import com.jyr.iot.platform.config.UdpConfig;
import com.jyr.iot.platform.rabbitmq.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 *spring容器监听类，监听spring容器启动完成后，可在onApplicationEvent函数中做一些操作
 * 注：netty服务器需等到spring容器启动完成后再启动
 */
@Service
@Slf4j
public class StartupEvent implements ApplicationListener<ContextRefreshedEvent> {
    private static ApplicationContext context;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            context = contextRefreshedEvent.getApplicationContext();

//            初始化rabbitmq
            RabbitmqService rabbitmqService = (RabbitmqService) StartupEvent.getBean(RabbitmqService.class);
            rabbitmqService.init();

//            启动UPD服务器，并将接收到的数据存到redis中
            UdpConfig udpConfig = (UdpConfig) StartupEvent.getBean(UdpConfig.class);
            NettyServer nettyServer = (NettyServer) StartupEvent.getBean(NettyServer.class);
            nettyServer.run(udpConfig.getUdpReceivePort());

//            这里可以开启多个线程去执行不同的任务
//            此处为工作的内容，不便公开！

        } catch (Exception e) {
            log.error("StartupEvent Exception", e);
        }
    }

    public static Object getBean(Class beanName) {
        return context != null ? context.getBean(beanName) : null;
    }
}

