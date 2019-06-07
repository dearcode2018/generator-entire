package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TemplateGroupDao;
import com.hua.modular.code.model.TemplateGroupModel;
import com.hua.modular.code.service.ITemplateGroupService;

/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-12 13:42
 */
@Service
public class TemplateGroupServiceImpl implements ITemplateGroupService {

    @Autowired
    private TemplateGroupDao templateGroupDao;

    @Override
    public Integer insert(TemplateGroupModel entity) {
        return templateGroupDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return templateGroupDao.deleteById(id);
    }

    @Override
    public Integer updateById(TemplateGroupModel entity) {
        return templateGroupDao.updateById(entity);
    }

    @Override
    public TemplateGroupModel selectById(Integer id) {
        return templateGroupDao.selectById(id);
    }

    @Override
    public TemplateGroupModel selectOne(TemplateGroupModel entity) {
    	Wrapper<TemplateGroupModel> query = new QueryWrapper<>(entity);	
    	
        return templateGroupDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TemplateGroupModel model) {
        return templateGroupDao.selectCount(model);
    }

    @Override
    public List<TemplateGroupModel> selectList(TemplateGroupModel model) {
        return templateGroupDao.selectList(model);
    }

    @Override
    public List<TemplateGroupModel> selectPage(Page<TemplateGroupModel> pagination, TemplateGroupModel model, Wrapper<TemplateGroupModel> wrapper) {
        return templateGroupDao.selectPage(pagination, model, wrapper);
    }

    @Override
    public void share(Integer id) {
        templateGroupDao.share(id);
    }

}
