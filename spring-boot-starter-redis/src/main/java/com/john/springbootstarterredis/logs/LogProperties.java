package com.john.springbootstarterredis.logs;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 日志
 * @date 2020/6/12 16:27
 */
@Configuration
@ConfigurationProperties(prefix = "mylog")
@Setter
@Getter
public class LogProperties {

    private String exclude;

    private String[] excludeArr;

    @PostConstruct
    public void init() {
        if(StringUtils.isNotBlank((exclude))){
            this.excludeArr = StringUtils.split(exclude, ",");
        }
    }
}
