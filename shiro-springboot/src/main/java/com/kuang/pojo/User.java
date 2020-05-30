package com.kuang.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author hujiawei
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String usercode;
    /** 权限*/
    private String perms;

    private static final long serialVersionUID = 1L;
}