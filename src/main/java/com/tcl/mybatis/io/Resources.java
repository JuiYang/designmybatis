package com.tcl.mybatis.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
