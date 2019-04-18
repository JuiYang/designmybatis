package com.tcl.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
