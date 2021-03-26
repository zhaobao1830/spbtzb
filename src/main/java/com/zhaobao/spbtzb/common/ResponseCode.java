package com.zhaobao.spbtzb.common;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/26 8:52
 */
public enum ResponseCode {
    // 成功
    SUCCESS(0,"SUCCESS"),
    // 失败
    ERROR(1,"ERROR"),
    // 需要登录
    NEED_LOGIN(10,"用户未登录,请登录"),
    // 非法参数
    ILLEGAL_ARGUMENT(2,"非法参数");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
