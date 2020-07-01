package com.john.springbootstarterredis.lock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 14:23
 */
public interface DistributedLocker {

    RLock lock(String lockKey);

    RLock lock(String lockKey,int timeout);

    RLock lock(String lockKey, TimeUnit timeUnit,int timeout);

    boolean tryLock(String lockKey,TimeUnit timeUnit,int waitTime,int leaseTime);

    void unLock(String lockKey);

    void unLock(RLock lock);

}
