package com.jyr.iot.platform.config;

import com.jyr.iot.platform.pojo.AlarmLog;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojogroup.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.List;

/**
 * 配置redis序列json化存储
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, LcAcsB128> lcAcsB128RedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, LcAcsB128> template = new RedisTemplate<Object, LcAcsB128>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<LcAcsB128> jre = new Jackson2JsonRedisSerializer<LcAcsB128>(LcAcsB128.class);
        template.setDefaultSerializer(jre);
        return template;
    }

    @Bean
    public RedisTemplate<Object, LcAcs> lcAcsRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, LcAcs> template = new RedisTemplate<Object, LcAcs>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<LcAcs> jre = new Jackson2JsonRedisSerializer<LcAcs>(LcAcs.class);
        template.setDefaultSerializer(jre);
        return template;
    }

    @Bean
    public RedisTemplate<Object, ZhydData> zhydDataRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, ZhydData> template = new RedisTemplate<Object, ZhydData>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<ZhydData> jre = new Jackson2JsonRedisSerializer<ZhydData>(ZhydData.class);
        template.setDefaultSerializer(jre);
        return template;
    }

    @Bean
    public RedisTemplate<Object, AlarmLog> alarmLogRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, AlarmLog> template = new RedisTemplate<Object, AlarmLog>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<AlarmLog> jre = new Jackson2JsonRedisSerializer<AlarmLog>(AlarmLog.class);
        template.setDefaultSerializer(jre);
        return template;
    }

    @Bean
    public RedisTemplate<Object, ProjectThing> deviceRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, ProjectThing> template = new RedisTemplate<Object,ProjectThing>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<ProjectThing> jre = new Jackson2JsonRedisSerializer<ProjectThing>(ProjectThing.class);
        template.setDefaultSerializer(jre);
        return template;
    }
}
