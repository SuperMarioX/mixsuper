package com.supermario.mixsuper.enums;


public enum ExceptionEnum {

    MIXSUPER_SERVER_OK(10000L, "OK"),
    MIXSUPER_CLIENT_ERROR_BAD_PARAMS(10001L, "Bad params"),
    MIXSUPER_SERVER_ERROR_DB_INTERNAL(10002L, "db exceptions");


    private Long code;
    private String msg;

    ExceptionEnum(Long code, String msg) {
        this.code = code;
        this.msg = msg;
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
