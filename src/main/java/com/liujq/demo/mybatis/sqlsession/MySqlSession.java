package com.liujq.demo.mybatis.sqlsession;

import java.lang.reflect.Proxy;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
public class MySqlSession {
    private Executor executor = new MyExecutor();
    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(myConfiguration, this));
    }
}
