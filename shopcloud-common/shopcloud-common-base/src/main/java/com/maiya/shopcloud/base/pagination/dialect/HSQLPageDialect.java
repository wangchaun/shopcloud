package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	HSQLDB (Hypersonic SQL)分页方言
 *
 * @author  mandy.hu
 */
public class HSQLPageDialect extends AbstractDBPageDialect {

    @Override
    public String getPageQuerySql(String querySelect, long offset, long pageSize) {
        StringBuilder sb = new StringBuilder(querySelect.length() + 20);
        sb.append(querySelect.trim());
        if (offset > 0) {
            sb.insert(6, " limit " + offset + " " + pageSize);
        } else {
            sb.insert(6, " top " + pageSize);
        }
        return sb.toString();

    }

    @Override
    public boolean supportPage() {
        return true;
    }
}
