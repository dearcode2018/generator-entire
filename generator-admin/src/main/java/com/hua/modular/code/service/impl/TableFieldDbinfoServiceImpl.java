package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TableFieldDbinfoDao;
import com.hua.modular.code.model.TableFieldDbinfoModel;
import com.hua.modular.code.service.ITableFieldDbinfoService;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-27 20:46
 */
@Service
public class TableFieldDbinfoServiceImpl implements ITableFieldDbinfoService {

    @Autowired
    private TableFieldDbinfoDao tableFieldDbinfoDao;

    @Override
    public Integer insert(TableFieldDbinfoModel entity) {
        return tableFieldDbinfoDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableFieldDbinfoDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableFieldDbinfoModel entity) {
        return tableFieldDbinfoDao.updateById(entity);
    }

    @Override
    public TableFieldDbinfoModel selectById(Integer id) {
        return tableFieldDbinfoDao.selectById(id);
    }

    @Override
    public TableFieldDbinfoModel selectOne(TableFieldDbinfoModel entity) {
    	Wrapper<TableFieldDbinfoModel> query = new QueryWrapper<>(entity);	   	
    	
        return tableFieldDbinfoDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TableFieldDbinfoModel model) {
        return tableFieldDbinfoDao.selectCount(model);
    }

    @Override
    public List<TableFieldDbinfoModel> selectList(TableFieldDbinfoModel model) {
        return tableFieldDbinfoDao.selectList(model);
    }

    @Override
    public List<TableFieldDbinfoModel> selectPage(Page<TableFieldDbinfoModel> pagination, TableFieldDbinfoModel model, Wrapper<TableFieldDbinfoModel> wrapper) {
        return tableFieldDbinfoDao.selectPage(pagination,model,wrapper);
    }
    @Override
    public Integer deleteByFieldIds(List<Integer> fieldIds) {
        return tableFieldDbinfoDao.deleteByFieldIds(fieldIds);
    }

    @Override
    public Integer batchInsert(List<TableFieldDbinfoModel> dbInfoModelList) {
        return tableFieldDbinfoDao.batchInsert(dbInfoModelList);
    }
}
