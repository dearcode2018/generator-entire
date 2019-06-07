package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TableBaseFieldModel;

/**
 * TableBaseFieldDao
 * 基础字段
 * @author 
 * @Date 
 */
@Repository
public interface TableBaseFieldDao extends BaseMapper<TableBaseFieldModel>{

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableBaseFieldModel> selectList(@Param("e") TableBaseFieldModel model, @Param("ew") Wrapper<TableBaseFieldModel> wrapper);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableBaseFieldModel> selectPage(@Param("p") Page<TableBaseFieldModel> pagination, @Param("e") TableBaseFieldModel model, @Param("ew") Wrapper<TableBaseFieldModel> wrapper);

}
