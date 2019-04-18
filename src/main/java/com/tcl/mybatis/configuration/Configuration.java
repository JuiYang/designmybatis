package com.tcl.mybatis.configuration;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Configuration {

    private String username;
    private String password;
    private String url;
    private String driver;
    private Map<String,Mapper> mappers = new HashMap<String, Mapper>();

    public void setMappers(Map<String, Mapper> mappers){
        // 这里需要采用追加的方式
        this.mappers.putAll(mappers);
    }
}
