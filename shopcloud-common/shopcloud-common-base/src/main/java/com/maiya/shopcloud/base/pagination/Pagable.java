package com.maiya.shopcloud.base.pagination;

/**
 * 功能描述：	支持物理分页接口
 *
 * @author  mandy.hu
 */
public interface Pagable {

    boolean isEnablePage();

    void setEnablePage(boolean enablePage);
}