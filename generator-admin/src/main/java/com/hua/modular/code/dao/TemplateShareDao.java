package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TemplateShareModel;

/**
 * TemplateShareDao
 *
 * @author JueYue
 * @Date 2017-09-11 11:26
 */
@Repository
public interface TemplateShareDao extends BaseMapper<TemplateShareModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") TemplateShareModel model);

    /**
     * 查询列表
     */
    List<TemplateShareModel> selectList(@Param("e") TemplateShareModel model);

    /**
     * 分页查询信息
     */
    List<TemplateShareModel> selectPage(@Param("p") Page<TemplateShareModel> pagination, @Param("e") TemplateShareModel model, @Param("w") Wrapper<TemplateShareModel> wrapper);

}
