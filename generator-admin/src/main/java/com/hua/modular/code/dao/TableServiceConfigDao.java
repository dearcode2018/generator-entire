package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TableServiceConfigModel;

/**
 * TableServiceConfigDao
 *
 * @author JueYue
 * @Date 2017-09-20 09:21
 */
@Repository
public interface TableServiceConfigDao extends BaseMapper<TableServiceConfigModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableServiceConfigModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableServiceConfigModel> selectList(@Param("e")TableServiceConfigModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableServiceConfigModel> selectPage(@Param("p")Page<TableServiceConfigModel> pagination,@Param("e") TableServiceConfigModel model,@Param("w") Wrapper<TableServiceConfigModel> wrapper);

    /**
     * 批量插入
     * @param serviceConfig
     */
    void batchInsert(List<TableServiceConfigModel> serviceConfig);

}
