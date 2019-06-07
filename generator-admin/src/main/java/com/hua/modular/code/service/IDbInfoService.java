package com.hua.modular.code.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.hua.modular.code.model.DbInfoModel;


/**
 * 数据库管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:15
 */
public interface IDbInfoService extends IService<DbInfoModel> {

    /**
     * <p>
     * 根据 model 条件，查询一条记录
     * </p>
     *
     * @param model 实体对象 非空
     * @return DbInfoModel
     */
    DbInfoModel selectOne(DbInfoModel model);

    /**
     * <p> 根据 entity 条件，查询全部记录 </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<DbInfoModel>
     */
    List<DbInfoModel> selectList(DbInfoModel model);

    /**
     * <p> 根据 entity 条件，查询全部记录 </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @param wrapper    SQL包装
     * @return List<DbInfoModel>
     */
    List<DbInfoModel> selectList(DbInfoModel model, Wrapper<DbInfoModel> wrapper);


    /**
     * <p> 根据 entity 条件，查询全部记录（并翻页） </p>
     *
     * @param pagination 分页查询条件
     * @param model      实体对象封装操作��以为 null）
     * @param wrapper    SQL包装
     * @return List<DbInfoModel>
     */
    List<DbInfoModel> selectPage(Page<DbInfoModel> pagination, DbInfoModel model, Wrapper<DbInfoModel> wrapper);

}
