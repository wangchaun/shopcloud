package com.maiya.shopcloud.base.pagination.dialect;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @auther:  mandy.hu
 */
public class DBPageDialectFactory {

    private Map<DBPageDialectType, DBPageDialect> dialectMap = new HashMap<DBPageDialectType, DBPageDialect>();
    public static DBPageDialectFactory factory = new DBPageDialectFactory();

    private DBPageDialectFactory(){}

    public static DBPageDialectFactory getInstance() {
        return factory;
    }

    public DBPageDialect getDBPageDialect(DBPageDialectType dialectType) {
        DBPageDialect dbPageDialect = dialectMap.get(dialectType);

        if (dbPageDialect == null) {
            dbPageDialect = createDBPageDialect(dialectType);
            dialectMap.put(dialectType, dbPageDialect);
        }

        return dbPageDialect;
    }

    private DBPageDialect createDBPageDialect(DBPageDialectType dialectType) {
        DBPageDialect dbPageDialect = null;

        switch (dialectType) {
            case MYSQL:
                dbPageDialect = new MySQLPageDialect();
                break;
            case HSQL:
                dbPageDialect = new HSQLPageDialect();
                break;
            case ORACLE:
                dbPageDialect = new OraclePageDialect();
                break;
            case SQLServer:
                dbPageDialect = new SQLServerPageDialect();
                break;
            case SQLServer2005:
                dbPageDialect = new SQLServer2005PageDialect();
                break;
            case SQLServer2008:
                dbPageDialect = new SQLServer2008PageDialect();
                break;
            default:
                break;
        }
        return dbPageDialect;
    }
}
