package com.john.springbootstarterredis.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/30 19:20
 */
@Data
public class User implements Serializable {

    private String name;
    private String userId;
}
