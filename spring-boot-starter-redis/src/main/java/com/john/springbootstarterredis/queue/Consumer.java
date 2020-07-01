package com.john.springbootstarterredis.queue;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 18:12
 */
@Component
@Slf4j
public class Consumer {

    @Resource
    private RedisTemplate redisTemplate;

    private ListOperations<String,String> listOperations;

    @PostConstruct
    private void init(){
        listOperations = redisTemplate.opsForList();
    }

    public void receive(){
        while (true){
            String message = listOperations.rightPop("message");
            if(StringUtils.isBlank(message)){
                log.info("消息队列为空");
                break;
            }
            log.info("message: " + message);
        }
    }
}
