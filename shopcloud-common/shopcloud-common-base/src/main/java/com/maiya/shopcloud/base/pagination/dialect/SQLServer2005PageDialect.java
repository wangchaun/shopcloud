package com.maiya.shopcloud.base.pagination.dialect;

/**
 * 功能描述：	Microsoft SQL 2005分页方言，支持物理分页
 *
 * @author mandy.hu
 */
public class SQLServer2005PageDialect extends SQLServerPageDialect {
    private static final String SELECT = "select";
    private static final String FROM = "from";
    private static final String DISTINCT = "distinct";

    @Override
    public boolean supportPage() {
        return true;
    }

    @Override
    public boolean supportPageOffset() {
        return true;
    }

    @Override
    public String getPageQuerySql(String query, long offset, long pageSize) {
        // We transform the query to one with an offset and limit if we have an
        // offset and limit to bind
        if (offset >= 1 || pageSize >= 1)
            return getLimitString(query, offset, pageSize);
        return query;
    }

    /**
     * Add a LIMIT clause to the given SQL SELECT (HHH-2655: ROW_NUMBER for
     * Paging)
     * <p/>
     * The LIMIT SQL will look like:
     * <p/>
     * <pre>
     * WITH query AS (
     *   SELECT ROW_NUMBER() OVER (ORDER BY orderby) as __hibernate_row_nr__,
     *   original_query_without_orderby
     * )
     * SELECT * FROM query WHERE __hibernate_row_nr__ BEETWIN offset AND offset + last
     * </pre>
     *
     * @param querySqlString The SQL statement to base the limit query off of.
     * @param offset         Offset of the first row to be returned by the query
     *                       (zero-based)
     * @param limit          Maximum number of rows to be returned by the query
     * @return A new SQL statement with the LIMIT clause applied.
     */
    protected String getLimitString(String querySqlString, long offset,
                                    long limit) {
        StringBuilder sb = new StringBuilder(querySqlString.trim()
                .toLowerCase());

        int orderByIndex = sb.indexOf("order by");
        CharSequence orderby = orderByIndex > 0 ? sb.subSequence(orderByIndex,
                sb.length()) : "ORDER BY CURRENT_TIMESTAMP";

        // Delete the order by clause at the end of the query
        if (orderByIndex > 0) {
            sb.delete(orderByIndex, orderByIndex + orderby.length());
        }

        // HHH-5715 bug fix
        replaceDistinctWithGroupBy(sb);

        insertRowNumberFunction(sb, orderby);

        // Wrap the query within a with statement:
        sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");

        // 开始和结束Index
        // Our dialect paginated results aren't zero based. The first row should
        // get the number 1 and so on
        long startIndex = offset + 1;
        long endIndex = offset + limit;

        sb.append("WHERE __hibernate_row_nr__ BETWEEN " + startIndex + " AND "
                + endIndex);

        return sb.toString();
    }

    /**
     * This utility method searches the given sql query for the fields of the
     * select statement and returns them without the aliases.
     *
     * @param sql sql query
     * @return the fields of the select statement without their alias
     */
    protected static CharSequence getSelectFieldsWithoutAliases(
            StringBuilder sql) {
        String select = sql.substring(sql.indexOf(SELECT) + SELECT.length(),
                sql.indexOf(FROM));

        // Strip the as clauses
        return stripAliases(select);
    }

    /**
     * Utility method that strips the aliases.
     *
     * @param str string to replace the as statements
     * @return a string without the as statements
     */
    protected static String stripAliases(String str) {
        return str.replaceAll("\\sas[^,]+(,?)", "$1");
    }

    /**
     * Utility method that checks if the given sql query is a select distinct
     * one and if so replaces the distinct select with an equivalent simple
     * select with a group by clause.
     *
     * @param sql an sql query
     */
    protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
        int distinctIndex = sql.indexOf(DISTINCT);
        if (distinctIndex > 0) {
            sql.delete(distinctIndex, distinctIndex + DISTINCT.length() + 1);
            sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
        }
    }

    /**
     * Right after the select statement of a given query we must place the
     * row_number function
     *
     * @param sql     the initial sql query without the order by clause
     * @param orderby the order by clause of the query
     */
    protected static void insertRowNumberFunction(StringBuilder sql,
                                                  CharSequence orderby) {
        // Find the end of the select statement
        int selectEndIndex = sql.indexOf(SELECT) + SELECT.length();

        // Insert after the select statement the row_number() function:
        sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby
                + ") as __hibernate_row_nr__,");
    }

}
