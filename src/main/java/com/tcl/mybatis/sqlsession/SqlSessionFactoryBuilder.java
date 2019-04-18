package com.tcl.mybatis.sqlsession;

import com.tcl.mybatis.configuration.Configuration;
import com.tcl.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 *
 * 用于创建sessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory builder(InputStream inputStream){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
