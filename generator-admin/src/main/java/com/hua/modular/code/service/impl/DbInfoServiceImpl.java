package com.hua.modular.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hua.modular.code.dao.DbInfoDao;
import com.hua.modular.code.model.DbInfoModel;
import com.hua.modular.code.service.IDbInfoService;

/**
 * 数据库管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:15
 */
@Service
public class DbInfoServiceImpl extends ServiceImpl<DbInfoDao, DbInfoModel> implements IDbInfoService {

    @Autowired
    private DbInfoDao dbInfoDao;

    @Override
    public DbInfoModel selectOne(DbInfoModel model) {
    	Wrapper<DbInfoModel> query = new QueryWrapper<>(model);
    	
        return dbInfoDao.selectOne(query);
    }

    @Override
    public List<DbInfoModel> selectList(DbInfoModel model) {
        return dbInfoDao.selectList(model, new QueryWrapper<DbInfoModel>(model));
    }

    @Override
    public List<DbInfoModel> selectList(DbInfoModel model, Wrapper<DbInfoModel> wrapper) {
        return dbInfoDao.selectList(model, wrapper);
    }

    @Override
    public List<DbInfoModel> selectPage(Page<DbInfoModel> pagination, DbInfoModel model, Wrapper<DbInfoModel> wrapper) {
        return dbInfoDao.selectPage(pagination, model, wrapper);
    }

}
