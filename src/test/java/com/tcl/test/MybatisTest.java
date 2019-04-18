package com.tcl.test;


import com.tcl.dao.IUserDao;
import com.tcl.domain.User;
import com.tcl.mybatis.io.Resources;
import com.tcl.mybatis.sqlsession.SqlSession;
import com.tcl.mybatis.sqlsession.SqlSessionFactory;
import com.tcl.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {

    public static void main(String[] args) throws Exception {
        // 1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 创建SqlSessionFactor工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.builder(inputStream);

        // 3. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        // 4. 使用SqlSession对象创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 5. 使用代理对象实现方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user.toString());
        }

        // 6. 释放资源
        session.close();
        inputStream.close();
    }
}
