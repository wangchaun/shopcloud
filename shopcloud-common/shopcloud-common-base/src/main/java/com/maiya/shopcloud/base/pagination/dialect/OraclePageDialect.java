package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	Oracle分页方言
 *
 * @author  mandy.hu
 */
public class OraclePageDialect extends AbstractDBPageDialect implements
        DBPageDialect {

    @Override
    public String getPageQuerySql(String querySelect, long offset, long pageSize) {
        StringBuilder pagingSelect = new StringBuilder(querySelect.length() + 100);

        if (offset > 0) {
            long startIndex = offset;
            long endIndex = offset + pageSize;
            pagingSelect.append("select * from (select row_.*, rownum rownum_ from (");
            pagingSelect.append(querySelect);
            pagingSelect.append(" ) row_ where rownum <= ").append(endIndex);
            pagingSelect.append(") where rownum_ > ").append(startIndex);
        } else {
            pagingSelect.append("select * from ( ");
            pagingSelect.append(querySelect);
            pagingSelect.append(" ) where rownum <= ").append(pageSize);
        }

        return pagingSelect.toString();
    }

    @Override
    public boolean supportPage() {
        return true;
    }

}