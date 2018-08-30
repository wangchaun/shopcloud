package com.maiya.shopcloud.base.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 所有自定义类型的基础类
 *
 * @author  mandy.hu
 */
public class BaseObject implements Serializable {

    /**
     * 默认当前类版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 输出实例信息
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}