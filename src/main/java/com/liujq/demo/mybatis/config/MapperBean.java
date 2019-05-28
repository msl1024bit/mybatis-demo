package com.liujq.demo.mybatis.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
@Getter
@Setter
public class MapperBean {

    /**
     * 接口名
     */
    private String interfaceName;

    /**
     * 接口下所有方法
     */
    private List<Function> list;
}
