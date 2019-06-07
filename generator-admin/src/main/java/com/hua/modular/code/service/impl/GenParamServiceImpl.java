package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.GenParamDao;
import com.hua.modular.code.model.GenParamModel;
import com.hua.modular.code.service.IGenParamService;
/**
 * 生成参数Service
 *
 * @author JueYue
 * @Date 2017-09-13 09:14
 */
@Service
public class GenParamServiceImpl implements IGenParamService {

    @Autowired
    private GenParamDao genParamDao;

    @Override
    public Integer insert(GenParamModel entity) {
        return genParamDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return genParamDao.deleteById(id);
    }

    @Override
    public Integer updateById(GenParamModel entity) {
        return genParamDao.updateById(entity);
    }

    @Override
    public GenParamModel selectById(Integer id) {
        return genParamDao.selectById(id);
    }

    @Override
    public GenParamModel selectOne(GenParamModel entity) {
    	Wrapper<GenParamModel> query = new QueryWrapper<>(entity);	
    	
        return genParamDao.selectOne(query);
    }

    @Override
    public Integer selectCount(GenParamModel model) {
        return genParamDao.selectCount(model);
    }

    @Override
    public List<GenParamModel> selectList(GenParamModel model) {
        return genParamDao.selectList(model);
    }

    @Override
    public List<GenParamModel> selectPage(Page<GenParamModel> pagination, GenParamModel model, Wrapper<GenParamModel> wrapper) {
        return genParamDao.selectPage(pagination,model,wrapper);
    }

}
