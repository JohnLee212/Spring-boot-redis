package com.john.springbootstarterredis.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 14:29
 */
@Service
public class RedisDistributedLocker implements DistributedLocker   {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    @Override
    public RLock lock(String lockKey, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout,TimeUnit.SECONDS);
        return lock;
    }

    @Override
    public RLock lock(String lockKey, TimeUnit timeUnit, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout,timeUnit);
        return lock;
    }

    @Override
    public boolean tryLock(String lockKey, TimeUnit timeUnit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime,leaseTime,timeUnit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override
    public void unLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    @Override
    public void unLock(RLock lock) {
        lock.unlock();
    }
}
