package com.john.springbootstarterredis.points;

import com.john.springbootstarterredis.annotation.Log;
import com.john.springbootstarterredis.interceptor.LogMethodInterceptor;
import com.john.springbootstarterredis.logs.LogProperties;
import lombok.extern.log4j.Log4j2;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 测试
 * @date 2020/6/12 16:28
 */
@Log4j2
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration extends AbstractPointcutAdvisor {

    private Pointcut pointcut;

    private Advice advice;

    @Resource
    private LogProperties logProperties;

    @PostConstruct
    public void init() {
        log.info("init LogAutoConfiguration start");
        this.advice = new LogMethodInterceptor(logProperties.getExcludeArr());
        this.pointcut = new AnnotationMatchingPointcut(null, Log.class);
        log.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
