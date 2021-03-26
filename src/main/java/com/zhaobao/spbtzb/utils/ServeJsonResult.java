package com.zhaobao.spbtzb.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/25 17:35
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 */
public class ServeJsonResult {

    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 返回的json数据中不包含该属性
     */
    @JsonIgnore
    private String ok;

    public static ServeJsonResult build(Integer status, String msg, Object data) {
        return new ServeJsonResult(status, msg, data);
    }

    public static ServeJsonResult build(Integer status, String msg, Object data, String ok) {
        return new ServeJsonResult(status, msg, data, ok);
    }

    public static ServeJsonResult ok(Object data) {
        return new ServeJsonResult(data);
    }

    public static ServeJsonResult ok() {
        return new ServeJsonResult(null);
    }

    public static ServeJsonResult errorMsg(String msg) {
        return new ServeJsonResult(500, msg, null);
    }

    public static ServeJsonResult errorMap(Object data) {
        return new ServeJsonResult(501, "error", data);
    }

    public static ServeJsonResult errorTokenMsg(String msg) {
        return new ServeJsonResult(502, msg, null);
    }

    public static ServeJsonResult errorException(String msg) {
        return new ServeJsonResult(555, msg, null);
    }

    public static ServeJsonResult errorUserQQ(String msg) {
        return new ServeJsonResult(556, msg, null);
    }

    public ServeJsonResult() {

    }

    public ServeJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServeJsonResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public ServeJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
