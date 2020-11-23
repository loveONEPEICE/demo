package com.lhl.demo.entity.response;

public class BaseResponse<T> {
    private String msg;
    private int code;
    private T data;

    public BaseResponse(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public BaseResponse(String msg) {
        this.msg = msg;
    }
}
