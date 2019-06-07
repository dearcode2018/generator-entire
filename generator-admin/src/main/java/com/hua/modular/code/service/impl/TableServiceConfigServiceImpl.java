package com.hua.modular.code.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TableServiceConfigDao;
import com.hua.modular.code.model.TableServiceConfigModel;
import com.hua.modular.code.service.ITableServiceConfigService;

/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:21
 */
@Service
public class TableServiceConfigServiceImpl implements ITableServiceConfigService {

    @Autowired
    private TableServiceConfigDao tableServiceConfigDao;

    @Override
    public Integer insert(TableServiceConfigModel entity) {
        return tableServiceConfigDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        // 删除旧数据
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("table_id", id);
        return tableServiceConfigDao.deleteByMap(temp);
    }

    @Override
    public Integer updateById(TableServiceConfigModel entity) {
        return tableServiceConfigDao.updateById(entity);
    }

    @Override
    public TableServiceConfigModel selectById(Integer id) {
        return tableServiceConfigDao.selectById(id);
    }

    @Override
    public TableServiceConfigModel selectOne(TableServiceConfigModel entity) {
    	Wrapper<TableServiceConfigModel> query = new QueryWrapper<>(entity);	
    	
        return tableServiceConfigDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TableServiceConfigModel model) {
        return tableServiceConfigDao.selectCount(model);
    }

    @Override
    public List<TableServiceConfigModel> selectList(TableServiceConfigModel model) {
        return tableServiceConfigDao.selectList(model);
    }

    @Override
    public List<TableServiceConfigModel> selectPage(Page<TableServiceConfigModel> pagination, TableServiceConfigModel model, Wrapper<TableServiceConfigModel> wrapper) {
        return tableServiceConfigDao.selectPage(pagination, model, wrapper);
    }

    @Override
    public void batchSaveOrUpdateServiceConfig(List<TableServiceConfigModel> serviceConfig) {
        deleteById(serviceConfig.get(0).getTableId());
        //插入新数据
        tableServiceConfigDao.batchInsert(serviceConfig);
    }

    @Override
    public List<TableServiceConfigModel> selectByTableId(int tableId) {
        TableServiceConfigModel entity = new TableServiceConfigModel();
        entity.setTableId(tableId);
        return selectList(entity);
    }

}
