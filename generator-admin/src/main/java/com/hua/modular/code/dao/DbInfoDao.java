package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.DbInfoModel;

/**
 * DbInfoDao
 *
 * @author JueYue
 * @Date 2017-09-11 11:15
 */
@Repository
public interface DbInfoDao extends BaseMapper<DbInfoModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") DbInfoModel model);

    /**
     * 查询列表
     */
    List<DbInfoModel> selectList(@Param("e") DbInfoModel model, @Param("w") Wrapper<DbInfoModel> wrapper);

    /**
     * 分页查询信息
     */
    List<DbInfoModel> selectPage(@Param("p") Page<DbInfoModel> pagination, @Param("e") DbInfoModel model, @Param("w") Wrapper<DbInfoModel> wrapper);

}
