package com.supermario.mixsuper.exception;

import com.supermario.mixsuper.enums.ExceptionEnum;

public class BaseException extends Exception {
    private static final long serialVersionUID = 6712796083037062062L;

    private Long code;
    private String msg;

    public BaseException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public BaseException(Long code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
