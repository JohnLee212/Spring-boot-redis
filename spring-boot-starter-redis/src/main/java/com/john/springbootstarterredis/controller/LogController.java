package com.john.springbootstarterredis.controller;

import com.john.springbootstarterredis.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 9:57
 */
@RestController
public class LogController {

    @Autowired
    private SimpleService simpleService;

    @RequestMapping(path = "/log",method = RequestMethod.GET)
    public String getLogInfo(){
        simpleService.core(8);
        return "success";
    }
}
