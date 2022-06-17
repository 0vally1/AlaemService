package com.dh.alarmservice.common;


public class ResponseData<T> {

    private static final long serialVersionUID = 1L;

    //状态码
    private String code;
    //提示信息
    private String msg;
    //数据
    private T data;


    public ResponseData() {
    }

    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", msg:'" + msg + '\'' +
                ", data:'" + data +'\'' +
                '}';
    }
}
