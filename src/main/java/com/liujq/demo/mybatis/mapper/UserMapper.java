package com.liujq.demo.mybatis.mapper;

import com.liujq.demo.mybatis.bean.User;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id 主键id
     * @return 用户信息
     */
    User getUserById(Long id);
}
