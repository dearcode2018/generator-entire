package com.hua.test.sql;

import org.junit.Test;

import com.hua.core.db.convert.sql.impl.SqlConvertOfOracle;
import com.hua.core.model.GenBeanEntity;

public class SqlConvertOfOracleTest {

    private String sql = "CREATE TABLE \"HR\".\"test\" (\n" +
            "\"id\" NUMBER(10) NOT NULL ,\n" +
            "\"name\" VARCHAR2(15) NULL ,\n" +
            "\"sex\" NUMBER(2) NULL \n" +
            ");\n" +
            "COMMENT ON TABLE \"HR\".\"test\" IS '测试';\n" +
            "COMMENT ON COLUMN \"HR\".\"test\".\"name\" IS '名字';\n" +
            "COMMENT ON COLUMN \"HR\".\"test\".\"sex\" IS '性别';";

    @Test
    public void parseSql() throws Exception {
        GenBeanEntity beanEntity = new SqlConvertOfOracle().parseSql(sql);
    }

}