package com.maiya.shopcloud.base.exceptions;

/**
 * 功能描述:业务类异常
 *
 * @auther: mandy.hu
 */
public class BusinessException extends Exception {
    private String code;
    private String message;

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
