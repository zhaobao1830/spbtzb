package com.zhaobao.spbtzb.common;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/26 8:48
 * 默认配置
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }
}
