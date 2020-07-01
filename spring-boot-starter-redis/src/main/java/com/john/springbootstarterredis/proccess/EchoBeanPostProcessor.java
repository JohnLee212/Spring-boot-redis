package com.john.springbootstarterredis.proccess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author John Lee
 * @Version 1.0 实现BeanPostProcessor接口的类，放入spring容器中后，容器启动和关闭时会执行以下两个重写的方法
 * @Description 自定义注解
 * @date 2020/6/12 15:17
 */
public class EchoBeanPostProcessor implements BeanPostProcessor {


    /**
     * getter、setter省略，读者在试验的时候要加上
     */
    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    /**
     * 该方法在spring容器初始化前执行
     * @param bean
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        if(!CollectionUtils.isEmpty(packages)){
            packages.forEach(str ->{
                System.out.println("echo bean " + bean.getClass().getName());
            });
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
