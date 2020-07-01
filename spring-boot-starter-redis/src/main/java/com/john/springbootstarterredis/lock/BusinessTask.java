package com.john.springbootstarterredis.lock;

import com.john.springbootstarterredis.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/28 9:49
 */
@Component
@Slf4j
public class BusinessTask {

    private final static String LOCK_ID = "happyJava";

    @Resource
    DistributedLock distributedLock;

    @Resource
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void doSomething() {
        boolean lock = distributedLock.getLock(LOCK_ID, 10 * 1000);
        if (lock) {
            log.info("执行任务");
            distributedLock.releaseLock(LOCK_ID);
        } else {
            log.info("没有抢到锁 ");
        }
    }

    @Scheduled(fixedRate = 3000)
    public void sendMessage() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lwx" + i);
            user.setUserId("hhh" + i);
            redisTemplate.convertAndSend("index",user);
        }
    }

}
