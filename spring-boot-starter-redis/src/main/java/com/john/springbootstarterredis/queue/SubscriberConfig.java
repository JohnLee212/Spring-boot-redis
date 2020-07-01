package com.john.springbootstarterredis.queue;

import org.redisson.api.listener.MessageListener;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.regex.Pattern;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description 订阅关系绑定
 * @date 2020/6/30 19:02
 */
@Configuration
@AutoConfigureAfter({Receiver.class})
public class SubscriberConfig {

    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver, "receiveMessage2");
    }



    @Bean
    @ConditionalOnBean(MessageListenerAdapter.class)
    public RedisMessageListenerContainer getMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,new PatternTopic("index"));
        return redisMessageListenerContainer;
    }
}
