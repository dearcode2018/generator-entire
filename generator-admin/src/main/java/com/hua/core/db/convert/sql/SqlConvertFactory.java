package com.hua.core.db.convert.sql;

import com.hua.core.db.convert.sql.impl.SqlConvertOfDB2;
import com.hua.core.db.convert.sql.impl.SqlConvertOfMysql;
import com.hua.core.db.convert.sql.impl.SqlConvertOfOracle;
import com.hua.core.db.exception.GenerationRunTimeException;
import com.hua.core.db.read.impl.ReadTableForMysqlImpl;

import static com.hua.core.GenCoreConstant.*;

/**
 * @author JueYue on 2017/10/25.
 */
public class SqlConvertFactory {

    public static ISqlConvert getReadTable(String dbType) {
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfMysql();
        }
        if (DB2.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfDB2();
        }
        if (ORACLE.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfOracle();
        }
        throw new GenerationRunTimeException("数据库不支持");
    }
}
