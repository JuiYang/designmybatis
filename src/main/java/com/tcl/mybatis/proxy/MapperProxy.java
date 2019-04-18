package com.tcl.mybatis.proxy;

import com.tcl.mybatis.configuration.Mapper;
import com.tcl.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    // key:全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    // 用于方法增强，我们实现selectList方法
    public Object invoke(Object o, Method method, Object[] objects) {
        // 获取方法名
        String methodName = method.getName();
        // 获取方法所在的类名
        String className = method.getDeclaringClass().getName();
        // 组合key
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入参数有误");
        }
        return new Executor().selectList(mapper, connection);
    }
}
