package com.liujq.demo.mybatis.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
@Getter
@Setter
public class Function {

    /**
     * sql类型 select/update/insert/delete
     */
    private String sqlType;

    /**
     * 方法名
     */
    private String funcName;

    /**
     * sql语句
     */
    private String sql;

    /**
     * 结果类型
     */
    private Object resultType;

    /**
     * 入参类型
     */
    private String parameterType;
}
