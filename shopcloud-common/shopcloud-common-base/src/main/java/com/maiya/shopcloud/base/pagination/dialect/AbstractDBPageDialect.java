package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	数据库物理分页方言接口
 *
 * @author  mandy.hu
 */
public abstract class AbstractDBPageDialect implements DBPageDialect {

    public boolean supportPage() {
        return false;
    }

    public boolean supportPageOffset() {
        return supportPage();
    }

    public String getPageQuerySql(String querySelect, long offset, long pageSize) {
        throw new UnsupportedOperationException("paged queries not supported");
    }

    public String getTotalCountQuerySql(String querySelect) {
        return "SELECT COUNT(1) AS _c_ FROM (" + querySelect + ") AS _tc_";
    }

}