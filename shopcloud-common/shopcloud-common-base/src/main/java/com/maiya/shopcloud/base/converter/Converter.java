package com.maiya.shopcloud.base.converter;

/**
 * 功能描述:实体对象与领域对象转换接口
 *
 * @auther:  mandy.hu
 */
public interface Converter<EO, DO> {
    /**
     * 将领域对象转换为实体对象
     *
     * @param param 领域对象
     * @return 实体对象
     */
    EO convert(DO param);

    /**
     * 将实体对象转换为领域对象
     *
     * @param param 实体对象
     * @return 领域对象
     */
    DO reconvert(EO param);
}
