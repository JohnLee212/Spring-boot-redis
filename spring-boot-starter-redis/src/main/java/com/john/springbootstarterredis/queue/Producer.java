package com.john.springbootstarterredis.queue;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 18:05
 */
@Component
public class Producer {

    @Resource
    private RedisTemplate redisTemplate;

    private ListOperations<String,String> listRedis;

    @PostConstruct
    private void init(){
        listRedis = redisTemplate.opsForList();
    }

    public void publishMessage(String message){
        listRedis.leftPush("message",message);
    }
}
