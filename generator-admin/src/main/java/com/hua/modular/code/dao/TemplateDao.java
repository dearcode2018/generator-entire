package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TemplateModel;

/**
 * TemplateDao
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@Repository
public interface TemplateDao extends BaseMapper<TemplateModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") TemplateModel model);

    /**
     * 查询列表
     */
    List<TemplateModel> selectList(@Param("e") TemplateModel model);

    /**
     * 分页查询信息
     */
    List<TemplateModel> selectPage(@Param("p") Page<TemplateModel> pagination, @Param("e") TemplateModel model, @Param("w") Wrapper<TemplateModel> wrapper);

    List<TemplateModel> getTemplateByIds(@Param("ids") String[] templates);

    List<TemplateModel> getAllTemplateByGroupId(String groupId);
}
