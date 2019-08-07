package com.example.postgresdemo.config;

import com.example.postgresdemo.messages.Channels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

/**
 * User: ankoks
 * Date: 23/07/2019
 */
@Configuration
public class ChannelConfig {

    @Bean(name = Channels.PROCESSING_CHANNEL)
    public MessageChannel processingSaleInChannel() {
        return new QueueChannel();
    }

    @Bean(name = Channels.SUCCESSES_CHANNEL)
    public QueueChannel successesChannel() {
        return new QueueChannel();
    }

    @Bean(name = Channels.ERROR_CHANNEL)
    public QueueChannel errorChannel() {
        return new QueueChannel();
    }

    @Bean(name = "msgExecutor")
    public AsyncTaskExecutor exec() {
        System.out.println("Creating Async Queue Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadGroupName("MSG");
        executor.setThreadNamePrefix("msg-exec-");
        executor.initialize();
        return new DelegatingSecurityContextAsyncTaskExecutor(executor);
    }
}
