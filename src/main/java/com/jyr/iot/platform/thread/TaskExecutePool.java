package com.jyr.iot.platform.thread;

import com.jyr.iot.platform.config.UdpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 任务管理，管理netty-udp线程
 */
@Configuration
@EnableAsync
public class TaskExecutePool {

    @Autowired
    private UdpConfig udpConfig;

    @Bean
    public Executor myTaskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(udpConfig.getCorePoolSize());
        executor.setMaxPoolSize(udpConfig.getMaxPoolSize());
        executor.setQueueCapacity(udpConfig.getQueueCapacity());
        executor.setKeepAliveSeconds(udpConfig.getKeepAliveSeconds());
        executor.setThreadNamePrefix("MyExecutor-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}