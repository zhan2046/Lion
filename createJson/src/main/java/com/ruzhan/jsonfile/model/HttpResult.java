package com.ruzhan.jsonfile.model;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public class HttpResult<T> {

    public int code;
    public String message;
    public T data;

    public HttpResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
