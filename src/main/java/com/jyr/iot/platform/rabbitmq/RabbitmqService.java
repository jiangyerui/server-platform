package com.jyr.iot.platform.rabbitmq;

import com.jyr.iot.platform.netty.StartupEvent;
import com.jyr.iot.platform.pojogroup.LcAcs;
import com.jyr.iot.platform.pojogroup.ZhydData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class RabbitmqService {


    @Autowired
    AmqpAdmin amqpAdmin;

//    String RABBITMQ_EXCHANGE_LCACS = "rabbitmq_exchange_lcacs";
//    String RABBITMQ_QUEUE_LCACS = "rabbitmq_queue_lcacs";
//    String RABBITMQ_ZHYD = "rabbitmq_zhyd";


    public RabbitmqService() {
//        init();
    }

    public void init(){
        //创建电气火灾交换器
        amqpAdmin.declareExchange(new DirectExchange("rabbitmq_exchange_lcacs"));
        //创建电气火灾队列
        amqpAdmin.declareQueue(new Queue("rabbitmq_queue_lcacs"));
        //创建电气火灾绑定
        Map<String,Object> map = new HashMap<String,Object>();
        amqpAdmin.declareBinding(new Binding("rabbitmq_queue_lcacs",Binding.DestinationType.QUEUE,
                "rabbitmq_exchange_lcacs","rabbitmq_routingKey_lcacs",map));

        //创建电气火灾交换器
        amqpAdmin.declareExchange(new DirectExchange("rabbitmq_exchange_zhyd"));
        //创建电气火灾队列
        amqpAdmin.declareQueue(new Queue("rabbitmq_queue_zhyd"));
        //创建电气火灾绑定
        Map<String,Object> map1 = new HashMap<String,Object>();
        amqpAdmin.declareBinding(new Binding("rabbitmq_queue_zhyd",Binding.DestinationType.QUEUE,
                "rabbitmq_exchange_zhyd","rabbitmq_routingKey_zhyd",map1));
        log.info("init rabbitmp success !!");
    }

    //向电气火灾队列中存一个对象
    public void setLcAcs(LcAcs lcAcs){
        RabbitTemplate rabbitTemplate = (RabbitTemplate) StartupEvent.getBean(RabbitTemplate.class);
        rabbitTemplate.convertAndSend("rabbitmq_exchange_lcacs","rabbitmq_routingKey_lcacs",lcAcs);

    }

    //从队列中获取一个电气火灾对象
    public LcAcs getLcAcs(){
        RabbitTemplate rabbitTemplate = (RabbitTemplate) StartupEvent.getBean(RabbitTemplate.class);
        return (LcAcs)rabbitTemplate.receiveAndConvert("rabbitmq_queue_lcacs");
    }


    //存zhyd
    public void setZhyd(ZhydData zhydData){
        RabbitTemplate rabbitTemplate = (RabbitTemplate) StartupEvent.getBean(RabbitTemplate.class);
        rabbitTemplate.convertAndSend("rabbitmq_exchange_zhyd","rabbitmq_routingKey_zhyd",zhydData);
    }
    //取zhyd
    public ZhydData getZhyd(){
        RabbitTemplate rabbitTemplate = (RabbitTemplate) StartupEvent.getBean(RabbitTemplate.class);
        return (ZhydData)rabbitTemplate.receiveAndConvert("rabbitmq_queue_zhyd");
    }

}
