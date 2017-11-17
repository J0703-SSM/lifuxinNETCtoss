package com.lanou.response;



/**
 * Created by dllo on 17/11/8.
 */
public class AjaxResult<T> {

    private int errorCode; // 响应码
    private String message; //当返回错误时,给出错误信息
    private T data; // 用户对象

    public AjaxResult() {
    }

    public AjaxResult(int errorCode, String message, T data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(int errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public AjaxResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public AjaxResult(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
