package com.john.springbootstarterredis.utils;

import com.john.springbootstarterredis.lock.DistributedLocker;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description redis分布式锁帮助类
 * @date 2020/6/28 10:08
 */
@Component
public class RedisLockUtil {

    @Resource
    private DistributedLocker locker;

    @PostConstruct
    private void init() {
        distributedLocker = locker;
    }

    private static DistributedLocker distributedLocker;

    public static RLock lock(String lockKey){
        return distributedLocker.lock(lockKey);
    }

    public static   void unLock(String lockKey){
         distributedLocker.unLock(lockKey);
    }

    public static   RLock lock(String lockKey,int timeout){
        return distributedLocker.lock(lockKey,timeout);
    }

    public static RLock lock(String lockKey, int timeout, TimeUnit unit){
        return distributedLocker.lock(lockKey,unit,timeout);
    }

    public static boolean tryLock(String lockKey,TimeUnit unit,int waitTime,int leaseTime){
        return distributedLocker.tryLock(lockKey,unit,waitTime,leaseTime);
    }


}
