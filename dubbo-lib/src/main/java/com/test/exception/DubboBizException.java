package com.test.exception;

/**
 * @author earthchen
 * @date 2021/8/10
 **/
public class DubboBizException extends RuntimeException{

    private Integer code;

    public DubboBizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
