package com.john.springbootstarterredis.annotation;

import com.john.springbootstarterredis.proccess.BamuImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version 1.0
 * @Description 自定义注解使用
 * @date 2020/6/12 15:29
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BamuImportBeanDefinitionRegistrar.class})
public @interface EnableEcho {

    //传入包名
    String[] packages() default "";
}
