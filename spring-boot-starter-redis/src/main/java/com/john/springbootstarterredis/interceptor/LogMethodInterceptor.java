package com.john.springbootstarterredis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 16:32
 */
@Slf4j
public class LogMethodInterceptor implements MethodInterceptor {

    private List<String> exclude = new ArrayList<>();

    public LogMethodInterceptor(String... exclude) {
        List<String> excludes = null ;
        if(exclude != null){
           excludes = Arrays.asList(exclude);
        }
        if(!CollectionUtils.isEmpty(excludes)){
            this.exclude = excludes;
        }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        if (exclude != null && exclude.contains(methodName)) {
            return invocation.proceed();
        }
        long start = System.currentTimeMillis();
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        log.info("====method({}), cost({}) ", methodName, (end - start));
        return result;
    }
}
