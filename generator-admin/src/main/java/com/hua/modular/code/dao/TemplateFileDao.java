package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TemplateFileModel;

/**
 * TemplateFileDao
 *
 * @author JueYue
 * @Date 2017-09-13 11:26
 */
@Repository
public interface TemplateFileDao extends BaseMapper<TemplateFileModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") TemplateFileModel model);

    /**
     * 查询列表
     */
    List<TemplateFileModel> selectList(@Param("e") TemplateFileModel model);

    /**
     * 分页查询信息
     */
    List<TemplateFileModel> selectPage(@Param("p") Page<TemplateFileModel> pagination, @Param("e") TemplateFileModel model, @Param("w") Wrapper<TemplateFileModel> wrapper);

    /**
     * 删除
     */
    Integer deleteByTemplateId(Integer id);

    /**
     * 更新文件
     */
    Integer updateTemplateId(@Param("e") TemplateFileModel fileModel);
}
