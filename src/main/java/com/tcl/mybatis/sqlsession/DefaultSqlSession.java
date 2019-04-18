package com.tcl.mybatis.sqlsession;

import com.tcl.mybatis.configuration.Configuration;
import com.tcl.mybatis.proxy.MapperProxy;
import com.tcl.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * mybatis和数据库交互的核心类， 它里面创建dao接口的实例对象
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }


    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(configuration.getMappers(),connection));
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
