package com.hua.core.db.read;

import java.util.List;

import com.hua.core.model.GenBeanEntity;

/**
 * 读取数据库表,获取数据库表的属性
 *
 * @author JueYue
 * @date 2014年12月21日
 */
public interface IReadTable {
    /**
     * 读取数据库表格属性
     */
    public GenBeanEntity read(String dbName, String tableName);

    /**
     * 查询所有的库
     */
    public List<String> getAllDB();

    /**
     * 查询所有的表
     */
    public List<GenBeanEntity> getAllTable(String dbName);

}
