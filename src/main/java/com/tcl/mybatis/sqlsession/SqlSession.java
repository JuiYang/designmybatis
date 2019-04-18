package com.tcl.mybatis.sqlsession;

/**
 *
 * mybatis和数据库交互的核心类， 它里面创建dao接口的实例对象
 */
public interface SqlSession {
    // 根据参数创建一个代理对象
    <T> T getMapper(Class<T> daoInterfaceClass);

    // 关闭资源
    void close();
}
