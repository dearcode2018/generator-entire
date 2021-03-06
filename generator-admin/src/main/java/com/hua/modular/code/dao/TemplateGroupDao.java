package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TemplateGroupModel;

/**
 * TemplateGroupDao
 *
 * @author JueYue
 * @Date 2017-09-12 13:42
 */
@Repository
public interface TemplateGroupDao extends BaseMapper<TemplateGroupModel> {

    /**
     * 统计数量
     *
     * @param model
     * @return
     */
    Integer selectCount(@Param("e") TemplateGroupModel model);

    /**
     * 查询列表
     *
     * @param model
     * @return
     */
    List<TemplateGroupModel> selectList(@Param("e") TemplateGroupModel model);

    /**
     * 分页查询信息
     *
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TemplateGroupModel> selectPage(@Param("p") Page<TemplateGroupModel> pagination, @Param("e") TemplateGroupModel model, @Param("w") Wrapper<TemplateGroupModel> wrapper);

    /**
     * 分享
     *
     * @param id
     */
    void share(@Param("id") Integer id);
}
