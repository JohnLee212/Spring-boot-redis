package com.john.springbootstarterredis;

import com.john.springbootstarterredis.annotation.EnableEcho;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
public class SpringBootStarterRedisApplication {

    @Resource
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterRedisApplication.class, args);
    }

}
