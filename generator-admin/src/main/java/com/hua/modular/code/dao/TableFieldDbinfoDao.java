package com.hua.modular.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.modular.code.model.TableFieldDbinfoModel;

/**
 * TableFieldDbinfoDao
 *
 * @author JueYue
 * @Date 2017-09-27 20:46
 */
@Repository
public interface TableFieldDbinfoDao extends BaseMapper<TableFieldDbinfoModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableFieldDbinfoModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableFieldDbinfoModel> selectList(@Param("e")TableFieldDbinfoModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableFieldDbinfoModel> selectPage(@Param("p")Page<TableFieldDbinfoModel> pagination,@Param("e") TableFieldDbinfoModel model,@Param("w") Wrapper<TableFieldDbinfoModel> wrapper);

    /**
     * 批量删除数据
     * @param fieldIds
     * @return
     */
    Integer deleteByFieldIds(@Param("fieldIds")List<Integer> fieldIds);

    /**
     * 批量插入
     * @param dbInfoModelList
     * @return
     */
    Integer batchInsert(@Param("list")List<TableFieldDbinfoModel> dbInfoModelList);
}
