package com.john.springbootstarterredis.queue;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description 消息队列测试
 * @date 2020/6/30 18:59
 */

@Service
public class SendService {

    @Resource
    private RedisTemplate redisTemplate;

    public void sendMessage(String message){
        redisTemplate.convertAndSend("myChannel",message);
    }
}
