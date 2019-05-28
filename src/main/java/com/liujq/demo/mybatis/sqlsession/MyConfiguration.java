package com.liujq.demo.mybatis.sqlsession;

import com.liujq.demo.mybatis.SpringContextHolder;
import com.liujq.demo.mybatis.config.Function;
import com.liujq.demo.mybatis.config.MapperBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Jiqiang.Liu
 * @date 2019-05-27
 */
public class MyConfiguration {

    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    public Connection getConnection() {
        Object dataSource = SpringContextHolder.getBean("dataSource");
        Connection connection = null;
        try {
            if (Objects.nonNull(dataSource)) {
                connection =  ((DataSource)dataSource).getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public MapperBean readMapper(String path) {
        MapperBean mapper = new MapperBean();
        try {
            InputStream stream = loader.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();

            mapper.setInterfaceName(root.attributeValue("namespace").trim());
            List<Function> list = new ArrayList<>();

            for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
                Function function = new Function();
                Element element = (Element) iterator.next();
                String sqlType = element.getName().trim();
                String funcName = element.attributeValue("id").trim();
                String sql = element.getText().trim();
                String resultType = element.attributeValue("resultType").trim();
                function.setFuncName(funcName);
                function.setSqlType(sqlType);
                function.setSql(sql);

                Object instance = null;
                try {
                    instance = Class.forName(resultType).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                function.setResultType(instance);
                list.add(function);
            }

            mapper.setList(list);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return mapper;
    }
}
