package com.john.springbootstarterredis.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 自定义redis配置信息
 * @date 2020/6/12 14:38
 */
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private final static String HOST = "127.0.0.1";
    private final static Integer PORT = 6379;

    private String host = HOST;
    private Integer port = PORT;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
