package com.maiya.shopcloud.base.validator;

/**
 * 功能描述: 验证器接口
 *
 * @auther: mandy.hu
 */
public interface Validator<T> {
    /**
     * 参数的有效性验证
     * @param param
     * @throws ValidationException
     */
    void validate(T param) throws ValidationException;
}
