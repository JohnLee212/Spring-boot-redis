package com.john.springbootstarterredis.controller;

import com.john.springbootstarterredis.queue.Consumer;
import com.john.springbootstarterredis.queue.Producer;
import com.john.springbootstarterredis.queue.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description 测试Redis生产者或者消费者
 * @date 2020/6/30 18:18
 */
@RestController
@RequestMapping("/produce")
public class ProducerAndConsumerController {

    @Resource
    private Producer producer;

    @Resource
    private Consumer consumer;

    @Resource
    private SendService sendService;

    @RequestMapping(value = "/send/{message}")
    public void send(@PathVariable String message){
        sendService.sendMessage(message);
    }

    @RequestMapping(value = "/receive")
    public void receive(){
        consumer.receive();
    }
}
