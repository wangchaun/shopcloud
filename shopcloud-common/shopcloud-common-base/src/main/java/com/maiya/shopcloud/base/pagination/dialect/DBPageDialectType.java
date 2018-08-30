package com.maiya.shopcloud.base.pagination.dialect;


import com.maiya.shopcloud.base.enums.BaseEnum;

/**
 * 功能描述:
 *
 * @auther:  mandy.hu
 */
public enum DBPageDialectType implements BaseEnum {
    MYSQL("mysql"),
    SQLServer("sqlserver"),
    SQLServer2005("sqlserver2005"),
    SQLServer2008("sqlserver2008"),
    HSQL("hsql"),
    ORACLE("oracle");

    private String code;

    DBPageDialectType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name();
    }

    public static DBPageDialectType fromCode(String dialect) {
        if (dialect == null || "".equals(dialect))
            return null;

        for (DBPageDialectType dialectType : DBPageDialectType.values()) {
            if (dialect.equals(dialectType.getCode())) {
                return dialectType;
            }
        }

        return null;
    }
}
