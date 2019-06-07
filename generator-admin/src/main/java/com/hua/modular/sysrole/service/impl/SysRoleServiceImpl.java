package com.hua.modular.sysrole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.sysrole.dao.SysRoleDao;
import com.hua.modular.sysrole.model.SysRoleModel;
import com.hua.modular.sysrole.service.ISysRoleService;
/**
 * 角色222Service
 *
 * @author qianye.zheng
 * @Date 2019-06-05 19:54:53
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public Integer insert(SysRoleModel entity) {
        return sysRoleDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
    	
    	System.out.println("SysRoleServiceImpl.deleteById()");
    	
        return sysRoleDao.deleteById(id);
    }

    @Override
    public Integer updateById(SysRoleModel entity) {
        return sysRoleDao.updateById(entity);
    }

    @Override
    public SysRoleModel selectById(Integer id) {
        return sysRoleDao.selectById(id);
    }

    @Override
    public SysRoleModel selectOne(SysRoleModel entity) {
     	QueryWrapper<SysRoleModel> query = new QueryWrapper<>(entity);
     	
        return sysRoleDao.selectOne(query);
    }

    @Override
    public Integer selectCount(SysRoleModel model) {
        return sysRoleDao.selectCount(model);
    }

    @Override
    public List<SysRoleModel> selectList(SysRoleModel model) {
        return sysRoleDao.selectList(model);
    }

    @Override
    public List<SysRoleModel> selectPage(Page pagination, SysRoleModel model, Wrapper<SysRoleModel> wrapper) {
        return sysRoleDao.selectPage(pagination,model,wrapper);
    }

}
