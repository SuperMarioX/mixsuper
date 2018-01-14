package com.supermario.mixsuper.exception;

import com.supermario.mixsuper.enums.ExceptionEnum;

public class BusinessException extends BaseException {
    public BusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public BusinessException(Long code, String msg) {
        super(code, msg);
    }
}
