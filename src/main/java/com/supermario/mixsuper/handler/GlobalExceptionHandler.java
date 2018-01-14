package com.supermario.mixsuper.handler;

import com.supermario.mixsuper.exception.BusinessException;
import com.supermario.mixsuper.wrapper.ResponseWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Global exception handler
 */
@ControllerAdvice //RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * If it returns map, no need to return as a json, otherwise, RestControllerAdvice or
     * ResponseBody is required
     * @param businessException
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseWrapper businessExceptionHandler(BusinessException businessException) {
        return new ResponseWrapper(400, 400L,
                businessException.getMsg(), null);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseWrapper otherExceptionHandler(Exception exception) {
        return new ResponseWrapper(500, 11000L, exception.getMessage(), null);
    }
}
