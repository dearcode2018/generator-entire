package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TableFieldVerifyDao;
import com.hua.modular.code.model.TableFieldVerifyModel;
import com.hua.modular.code.service.ITableFieldVerifyService;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:24
 */
@Service
public class TableFieldVerifyServiceImpl implements ITableFieldVerifyService {

    @Autowired
    private TableFieldVerifyDao tableFieldVerifyDao;

    @Override
    public Integer insert(TableFieldVerifyModel entity) {
        return tableFieldVerifyDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableFieldVerifyDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableFieldVerifyModel entity) {
        return tableFieldVerifyDao.updateById(entity);
    }

    @Override
    public TableFieldVerifyModel selectById(Integer id) {
        return tableFieldVerifyDao.selectById(id);
    }

    @Override
    public TableFieldVerifyModel selectOne(TableFieldVerifyModel entity) {
    	Wrapper<TableFieldVerifyModel> query = new QueryWrapper<>(entity);	
    	
        return tableFieldVerifyDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TableFieldVerifyModel model) {
        return tableFieldVerifyDao.selectCount(model);
    }

    @Override
    public List<TableFieldVerifyModel> selectList(TableFieldVerifyModel model) {
        return tableFieldVerifyDao.selectList(model);
    }

    @Override
    public List<TableFieldVerifyModel> selectPage(Page<TableFieldVerifyModel> pagination, TableFieldVerifyModel model, Wrapper<TableFieldVerifyModel> wrapper) {
        return tableFieldVerifyDao.selectPage(pagination,model,wrapper);
    }

    @Override
    public Integer deleteByFieldIds(List<Integer> fieldIds) {
        return tableFieldVerifyDao.deleteByFieldIds(fieldIds);
    }

    @Override
    public Integer batchInsert(List<TableFieldVerifyModel> verifyModelList) {
        return tableFieldVerifyDao.batchInsert(verifyModelList);
    }

}
