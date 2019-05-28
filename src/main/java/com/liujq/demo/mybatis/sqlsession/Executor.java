package com.liujq.demo.mybatis.sqlsession;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
public interface Executor {

    <T> T query(String statement, Object parameter);
}
