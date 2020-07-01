package com.john.springbootstarterredis.service;

import com.john.springbootstarterredis.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 16:57
 */
@Component
@Slf4j
public class SimpleService {

    @Log
    public void test(int num) {
        log.info("----test---- {}" + num);
    }

    @Log
    public void core(int num) {
        log.info("----core---- {}" + num);
    }

    public void work(int num) {
        System.out.println("----work---- " + num);
    }

}
