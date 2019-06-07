package com.hua.modular.sysrole.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.sysrole.model.SysRoleModel;

/**
 * SysRoleDao
 *
 * @author qianye.zheng
 * @Date 2019-06-05 19:54:53
 */
@Repository
public interface SysRoleDao extends BaseMapper<SysRoleModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")SysRoleModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<SysRoleModel> selectList(@Param("e")SysRoleModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<SysRoleModel> selectPage(@Param("p")Page pagination,@Param("e") SysRoleModel model,@Param("w") Wrapper<SysRoleModel> wrapper);

}
