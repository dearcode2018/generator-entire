package com.hua.core.db.convert.sql;

import com.hua.core.model.GenBeanEntity;
import com.hua.core.model.enmus.DBType;

/**
 * @author JueYue on 2017/10/25.
 */
public interface ISqlConvert {

    /**
     * 解析SQL
     */
    public GenBeanEntity parseSql(String sql);

    public DBType getDbType();

}
