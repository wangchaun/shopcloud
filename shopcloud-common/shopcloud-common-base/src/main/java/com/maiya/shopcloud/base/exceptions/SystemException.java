package com.maiya.shopcloud.base.exceptions;

/**
 * 系统异常(使用者无法自行处理,需要开发人员干预的问题)
 *
 * @author mandy.hu
 */
public class SystemException extends RuntimeException {
    private static final long serialVersionUID = -1055987646767600935L;
    private String code;
    private String message;

    public SystemException() {
        super();
    }

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
