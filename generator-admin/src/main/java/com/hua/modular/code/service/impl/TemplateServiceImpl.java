package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.dao.TemplateDao;
import com.hua.modular.code.dao.TemplateFileDao;
import com.hua.modular.code.dao.TemplateGroupDao;
import com.hua.modular.code.model.TemplateFileModel;
import com.hua.modular.code.model.TemplateGroupModel;
import com.hua.modular.code.model.TemplateModel;
import com.hua.modular.code.service.ITemplateService;

/**
 * 模板管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private TemplateDao templateDao;
    @Autowired
    private TemplateFileDao templateFileDao;
    @Autowired
    private TemplateGroupDao templateGroupDao;

    @Override
    @Transactional
    public Integer insert(TemplateModel entity, TemplateFileModel fileModel) {
        templateDao.insert(entity);
        fileModel.setTemplateId(entity.getId());
        return templateFileDao.insert(fileModel);
    }

    @Override
    @Transactional
    public Integer deleteById(Integer id) {
        templateFileDao.deleteByTemplateId(id);
        return templateDao.deleteById(id);
    }

    @Override
    @Transactional
    public Integer updateById(TemplateModel entity, TemplateFileModel fileModel) {
        //保存历史版本
        TemplateModel temp = templateDao.selectById(entity.getId());
        temp.setId(null);
        temp.setVersion(2);
        temp.setOriginalId(entity.getId());
        TemplateFileModel tempFileModel = new TemplateFileModel();
        tempFileModel.setTemplateId(entity.getId());
        Wrapper<TemplateFileModel> query = new QueryWrapper<>(tempFileModel);	
        tempFileModel = templateFileDao.selectOne(query);
        if(tempFileModel != null){
            tempFileModel.setId(null);
            insert(temp, tempFileModel);
        }else{
            templateDao.insert(temp);
        }
        //修改当前版本
        fileModel.setTemplateId(entity.getId());
        int nums = templateFileDao.updateTemplateId(fileModel);
        if (nums == 0) {
            templateFileDao.insert(fileModel);
        }
        return templateDao.updateById(entity);
    }

    @Override
    public TemplateModel selectById(Integer id) {
        return templateDao.selectById(id);
    }

    @Override
    public TemplateModel selectOne(TemplateModel entity) {
    	Wrapper<TemplateModel> query = new QueryWrapper<>(entity);	
    	
        return templateDao.selectOne(query);
    }

    @Override
    public Integer selectCount(TemplateModel model) {
        return templateDao.selectCount(model);
    }

    @Override
    public List<TemplateModel> selectList(TemplateModel model) {
        return templateDao.selectList(model);
    }

    @Override
    public List<TemplateModel> selectPage(Page<TemplateModel> pagination, TemplateModel model, Wrapper<TemplateModel> wrapper) {
        return templateDao.selectPage(pagination, model, wrapper);
    }

    @Override
    public List<TemplateModel> getTemplateByIds(String[] templates) {
        return templateDao.getTemplateByIds(templates);
    }

    @Override
    public List<TemplateModel> getAllTemplateByGroupId(String groupId) {
        List<TemplateModel> list = templateDao.getAllTemplateByGroupId(groupId);
        for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
            TemplateFileModel fileModel = new TemplateFileModel();
            fileModel.setTemplateId(list.get(i).getId());
            Wrapper<TemplateFileModel> query = new QueryWrapper<>(fileModel);	
            list.get(i).setFileModel(templateFileDao.selectOne(query));
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cloneGroup(String groupId, Integer userId) {
        TemplateGroupModel groupModel = templateGroupDao.selectById(groupId);
        TemplateGroupModel tempGroupModel = new TemplateGroupModel();
        BeanUtils.copyProperties(groupModel, tempGroupModel);
        tempGroupModel.setId(null);
        tempGroupModel.setUserId(userId);
        templateGroupDao.insert(tempGroupModel);
        List<TemplateModel> list = templateDao.getAllTemplateByGroupId(groupId);
        for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
            TemplateModel templateModel = new TemplateModel();
            BeanUtils.copyProperties(list.get(i), templateModel);
            templateModel.setId(null);
            templateModel.setUserId(userId);
            templateModel.setGroupId(tempGroupModel.getId() + "");

            TemplateFileModel fileModel = new TemplateFileModel();
            fileModel.setTemplateId(list.get(i).getId());
            Wrapper<TemplateFileModel> query = new QueryWrapper<>(fileModel);	
            list.get(i).setFileModel(templateFileDao.selectOne(query));
            fileModel.setTemplateId(list.get(i).getId());
            fileModel.setFile(list.get(i).getFileModel().getFile());
            fileModel.setFileType(list.get(i).getFileModel().getFileType());
            templateModel.setVersion(1);
            insert(templateModel, fileModel);
        }
    }

}
