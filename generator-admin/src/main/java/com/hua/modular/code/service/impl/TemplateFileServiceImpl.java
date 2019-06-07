package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TemplateFileDao;
import com.hua.modular.code.model.TemplateFileModel;
import com.hua.modular.code.service.ITemplateFileService;
/**
 * 模板内容Service
 *
 * @author JueYue
 * @Date 2017-09-13 11:26
 */
@Service
public class TemplateFileServiceImpl implements ITemplateFileService {

    @Autowired
    private TemplateFileDao templateFileDao;

    @Override
    public Integer insert(TemplateFileModel entity) {
        return templateFileDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return templateFileDao.deleteById(id);
    }

    @Override
    public Integer updateById(TemplateFileModel entity) {
        return templateFileDao.updateById(entity);
    }

    @Override
    public TemplateFileModel selectById(Integer id) {
        return templateFileDao.selectById(id);
    }

    @Override
    public TemplateFileModel selectOne(TemplateFileModel entity) {
    	Wrapper<TemplateFileModel> query = new QueryWrapper<>(entity);	
    	
        return templateFileDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TemplateFileModel model) {
        return templateFileDao.selectCount(model);
    }

    @Override
    public List<TemplateFileModel> selectList(TemplateFileModel model) {
        return templateFileDao.selectList(model);
    }

    @Override
    public List<TemplateFileModel> selectPage(Page<TemplateFileModel> pagination, TemplateFileModel model, Wrapper<TemplateFileModel> wrapper) {
        return templateFileDao.selectPage(pagination,model,wrapper);
    }

}
