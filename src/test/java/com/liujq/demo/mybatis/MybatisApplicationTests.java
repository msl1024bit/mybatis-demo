package com.liujq.demo.mybatis;

import com.liujq.demo.mybatis.bean.User;
import com.liujq.demo.mybatis.mapper.UserMapper;
import com.liujq.demo.mybatis.sqlsession.MySqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void testMybatis() {
        MySqlSession mySqlSession = new MySqlSession();
        UserMapper mapper = mySqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1L);
        System.out.println(user);
    }

}
