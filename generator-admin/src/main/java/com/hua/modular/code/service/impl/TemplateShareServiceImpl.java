package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TemplateShareDao;
import com.hua.modular.code.model.TemplateShareModel;
import com.hua.modular.code.service.ITemplateShareService;

/**
 * 模板分享管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:26
 */
@Service
public class TemplateShareServiceImpl implements ITemplateShareService {

    @Autowired
    private TemplateShareDao templateShareDao;

    @Override
    public Integer insert(TemplateShareModel entity) {
        return templateShareDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return templateShareDao.deleteById(id);
    }

    @Override
    public Integer updateById(TemplateShareModel entity) {
        return templateShareDao.updateById(entity);
    }

    @Override
    public TemplateShareModel selectById(Integer id) {
        return templateShareDao.selectById(id);
    }

    @Override
    public TemplateShareModel selectOne(TemplateShareModel entity) {
    	Wrapper<TemplateShareModel> query = new QueryWrapper<>(entity);	
    	
        return templateShareDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TemplateShareModel model) {
        return templateShareDao.selectCount(model);
    }

    @Override
    public List<TemplateShareModel> selectList(TemplateShareModel model) {
        return templateShareDao.selectList(model);
    }

    @Override
    public List<TemplateShareModel> selectPage(Page<TemplateShareModel> pagination, TemplateShareModel model, Wrapper<TemplateShareModel> wrapper) {
        return templateShareDao.selectPage(pagination, model, wrapper);
    }

}
