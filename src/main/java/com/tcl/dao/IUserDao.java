package com.tcl.dao;

import com.tcl.mybatis.annotation.Select;
import com.tcl.domain.User;

import java.util.List;

public interface IUserDao {
    // 使用xml配置
//    List<User> findAll();

    // 使用注解
    @Select("select * from user")
    List<User> findAll();
}
