package com.tcl.mybatis.utils;

import com.tcl.mybatis.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {

    public static Connection getConnection(Configuration configuration){
        try{
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
