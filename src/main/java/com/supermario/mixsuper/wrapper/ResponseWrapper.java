package com.supermario.mixsuper.wrapper;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = -2929231384808137705L;

    private int httpStatusCode;
    private Long statusCode;
    private String statusMsg;
    private T data;

    public ResponseWrapper() {}

    public ResponseWrapper(int httpStatusCode, Long statusCode, String statusMsg, T data) {
        this.httpStatusCode = httpStatusCode;
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.data = data;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "httpStatusCode=" + httpStatusCode +
                ", statusCode=" + statusCode +
                ", statusMsg='" + statusMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
