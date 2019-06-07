package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.GenParamModel;

/**
 * GenParamDao
 *
 * @author JueYue
 * @Date 2017-09-13 09:12
 */
@Repository
public interface GenParamDao extends BaseMapper<GenParamModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e") GenParamModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<GenParamModel> selectList(@Param("e") GenParamModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<GenParamModel> selectPage(@Param("p") Page<GenParamModel> pagination, @Param("e") GenParamModel model, @Param("w") Wrapper<GenParamModel> wrapper);

}
