package com.john.springbootstarterredis.redis;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

/**
 * @author John Lee
 * @Version 1.0
 * @Description Redis配置自动读取
 * @date 2020/6/12 14:43
 */
@SpringBootConfiguration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(Jedis.class)
    public Jedis jedis(RedisProperties redisProperties) {
        //spring会自动将RedisProperties这个bean注入进来，读者也可以手动注入
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}
