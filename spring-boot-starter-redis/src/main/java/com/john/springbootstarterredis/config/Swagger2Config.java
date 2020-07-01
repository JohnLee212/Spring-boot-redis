package com.john.springbootstarterredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 14:42
 */
// 标记配置类
@Configuration
// 开启在线接口文档
@EnableSwagger2
public class Swagger2Config {

    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 配置到项目的controller包
                .apis(RequestHandlerSelectors.basePackage("com.xxx.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * @Description: 构建api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxx项目文档标题")
                .description("xxx项目文档描述")
                .contact(new Contact("xxx开发者称呼", "xxx.com网站", "xxx@qq.com邮箱"))
                // 定义版本号
                .version("版本号:xx.x").build();
    }
}
