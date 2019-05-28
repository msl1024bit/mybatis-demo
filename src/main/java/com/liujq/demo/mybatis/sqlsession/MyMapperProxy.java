package com.liujq.demo.mybatis.sqlsession;

import com.liujq.demo.mybatis.config.Function;
import com.liujq.demo.mybatis.config.MapperBean;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * Mapper代理对象
 *
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
public class MyMapperProxy implements InvocationHandler {

    private MyConfiguration myConfiguration;

    private MySqlSession mySqlSession;

    public MyMapperProxy(MyConfiguration myConfiguration, MySqlSession mySqlSession) {
        this.myConfiguration = myConfiguration;
        this.mySqlSession = mySqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        MapperBean mapperBean =  myConfiguration.readMapper("UserMapper.xml");

        if (!Objects.equals(mapperBean.getInterfaceName(), method.getDeclaringClass().getName())) {
            return null;
        }
        List<Function> list = mapperBean.getList();
        if (!CollectionUtils.isEmpty(list)) {
            for (Function function : list) {
                if (Objects.equals(method.getName(), function.getFuncName())) {
                    return mySqlSession.selectOne(function.getSql(), args[0]);
                }
            }
        }
        return null;
    }
}
