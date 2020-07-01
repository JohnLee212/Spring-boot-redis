package com.john.springbootstarterredis.queue;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.john.springbootstarterredis.dto.User;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description 接收者
 * @date 2020/6/30 19:02
 */
@Component
public class Receiver {

    public void receiveMessage(String message){
        System.out.println("Receive:" + message);
    }

    public void receiveMessage2(String message) {
        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(User.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        seria.setObjectMapper(objectMapper);
        User user = (User)seria.deserialize(message.getBytes());
        System.out.println("消息来了："+user);
    }


}
