package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	MySQL分页方言
 *
 * @author  mandy.hu
 */
public class MySQLPageDialect extends AbstractDBPageDialect implements
        DBPageDialect {

    /**
     * LIMIT 0 quickly returns an empty set. This can be useful for checking the
     * validity of a query.
     * <p/>
     * [FROM pos ] [LIMIT [ offset ,] row_count ]
     */
    @Override
    public String getPageQuerySql(String querySelect, long offset, long pageSize) {
        StringBuilder sb = new StringBuilder(querySelect.length() + 20);

        sb.append(querySelect);

        if (offset > 0) {
            sb.append(" limit ").append(offset).append(",").append(pageSize);
        } else {
            sb.append(" limit ").append(pageSize);
        }
        return sb.toString();

    }

    @Override
    public boolean supportPage() {
        return true;
    }

}