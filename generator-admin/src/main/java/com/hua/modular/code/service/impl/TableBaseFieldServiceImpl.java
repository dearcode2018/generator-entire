package com.hua.modular.code.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hua.modular.code.dao.TableBaseFieldDao;
import com.hua.modular.code.model.TableBaseFieldModel;
import com.hua.modular.code.model.TableFieldModel;
import com.hua.modular.code.model.TableFieldVerifyModel;
import com.hua.modular.code.service.ITableBaseFieldService;
import com.hua.modular.code.service.ITableFieldService;
import com.hua.modular.code.service.ITableFieldVerifyService;

/**
 * Service
 * 基础字段
 *
 * @author
 * @Date
 */
@Service
public class TableBaseFieldServiceImpl extends ServiceImpl<TableBaseFieldDao, TableBaseFieldModel> implements ITableBaseFieldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableBaseFieldServiceImpl.class);

    @Autowired
    private TableBaseFieldDao tableBaseFieldDao;
    @Autowired
    private ITableFieldService tableFieldService;
    @Autowired
    private ITableFieldVerifyService tableFieldVerifyService;


    @Override
    public TableBaseFieldModel selectOne(TableBaseFieldModel entity) {
    	Wrapper<TableBaseFieldModel> query = new QueryWrapper<>(entity);	
    	
        return tableBaseFieldDao.selectOne(query);
    }

    @Override
    public List<TableBaseFieldModel> selectList(TableBaseFieldModel model) {
        return tableBaseFieldDao.selectList(model, new QueryWrapper<TableBaseFieldModel>());
    }

    @Override
    public List<TableBaseFieldModel> selectList(TableBaseFieldModel model, Wrapper<TableBaseFieldModel> wrapper) {
        return tableBaseFieldDao.selectList(model, wrapper);
    }

    @Override
    public List<TableBaseFieldModel> selectPage(Page<TableBaseFieldModel> pagination, TableBaseFieldModel model, Wrapper<TableBaseFieldModel> wrapper) {
        return tableBaseFieldDao.selectPage(pagination, model, wrapper);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insert(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel) {
        tableFieldService.insert(fieldModel);

        verifyModel.setFieldId(fieldModel.getId());
        tableFieldVerifyService.insert(verifyModel);

        model.setFieldId(fieldModel.getId());
        model.setFieldNameCheck(fieldModel.getFieldName());
        tableBaseFieldDao.insert(model);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean deleteById(Integer id) {
        TableBaseFieldModel old = tableBaseFieldDao.selectById(id);
        // 删除旧数据
        tableFieldService.deleteById(old.getFieldId());
        tableFieldVerifyService.deleteByFieldIds(Arrays.asList(new Integer[]{old.getFieldId()}));
        return tableBaseFieldDao.deleteById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateById(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel) {
        TableBaseFieldModel old = tableBaseFieldDao.selectById(model.getId());
        old.setAlias(model.getAlias());
        old.setFieldNameCheck(fieldModel.getFieldName());
        // 删除旧数据
        tableFieldService.deleteById(old.getFieldId());
        tableFieldVerifyService.deleteByFieldIds(Arrays.asList(new Integer[]{old.getFieldId()}));
        // 插入新数据
        tableFieldService.insert(fieldModel);
        verifyModel.setFieldId(fieldModel.getId());
        tableFieldVerifyService.insert(verifyModel);
        old.setFieldId(fieldModel.getId());
        tableBaseFieldDao.updateById(old);
    }

    @Override
    public TableBaseFieldModel queryBaseField(String fieldName, int userId) {
        TableBaseFieldModel fieldModel = new TableBaseFieldModel();
        fieldModel.setUserId(userId);
        fieldModel.setFieldNameCheck(fieldName);
        
        Wrapper<TableBaseFieldModel> query = new QueryWrapper<>(fieldModel);	
        fieldModel = tableBaseFieldDao.selectOne(query);
        if (fieldModel != null) {
            fieldModel.setFieldModel(tableFieldService.selectById(fieldModel.getFieldId()));
            fieldModel.setVerifyModel(tableFieldVerifyService.selectOne(new TableFieldVerifyModel(fieldModel.getFieldId())));
        }
        return fieldModel;
    }

}
