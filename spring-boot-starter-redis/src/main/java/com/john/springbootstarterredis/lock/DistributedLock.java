package com.john.springbootstarterredis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/28 9:46
 */
@Component
public class DistributedLock {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获得锁
     */
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    /**
     * 释放锁
     * @param lockId
     */
    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }
}
