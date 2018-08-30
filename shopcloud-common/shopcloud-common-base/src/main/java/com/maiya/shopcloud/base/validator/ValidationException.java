package com.maiya.shopcloud.base.validator;

import com.maiya.shopcloud.base.exceptions.BusinessException;

/**
 * 功能描述: 验证失败异常类
 *
 * @auther:  mandy.hu
 */
public class ValidationException extends BusinessException {
    public ValidationException() {
    }

    public ValidationException(String code, String message) {
        super(code, message);
    }

    public ValidationException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
