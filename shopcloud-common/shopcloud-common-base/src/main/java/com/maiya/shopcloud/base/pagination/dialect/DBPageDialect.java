package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	数据库物理分页方言接口
 *
 * @author  mandy.hu
 */
public interface DBPageDialect {
    long DEFAULT_PAGE_SIZE = 20;

    boolean supportPage();

    boolean supportPageOffset();

    String getPageQuerySql(String querySelect, long offset, long pageSize);

    String getTotalCountQuerySql(String querySelect);
}