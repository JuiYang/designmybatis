package com.tcl.mybatis.configuration;

import lombok.Data;

/**
 *
 * 用于封装sql语句和结果类型的全限定类名
 */


@Data
public class Mapper {

    private String queryString;
    private String resultType;
}
