package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TableInfoModel;

/**
 * TableInfoDao
 *
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@Repository
public interface TableInfoDao extends BaseMapper<TableInfoModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableInfoModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableInfoModel> selectList(@Param("e")TableInfoModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableInfoModel> selectPage(@Param("p")Page<TableInfoModel> pagination,@Param("e") TableInfoModel model,@Param("w") Wrapper<TableInfoModel> wrapper);

}
