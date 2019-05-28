package com.liujq.demo.mybatis.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
@Getter
@Setter
@ToString
public class User {

    private Long id;

    private String username;

    private String password;
}
