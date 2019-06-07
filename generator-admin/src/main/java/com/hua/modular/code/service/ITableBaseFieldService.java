package com.hua.modular.code.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.hua.modular.code.model.TableBaseFieldModel;
import com.hua.modular.code.model.TableFieldModel;
import com.hua.modular.code.model.TableFieldVerifyModel;

/**
 * Service
 * 基础字段
 *
 * @author
 * @Date
 */
public interface ITableBaseFieldService extends IService<TableBaseFieldModel> {

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return boolean
     */
    boolean deleteById(Integer id);

    /**
     * <p>
     * 根据 model 条件，查询一条记录
     * </p>
     *
     * @param model 实体对象 非空
     * @return TableBaseFieldModel
     */
    TableBaseFieldModel selectOne(TableBaseFieldModel model);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<TableBaseFieldModel>
     */
    List<TableBaseFieldModel> selectList(TableBaseFieldModel model);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model   实体对象封装操作类（可以为 null）
     * @param wrapper SQL包装
     * @return List<TableBaseFieldModel>
     */
    List<TableBaseFieldModel> selectList(TableBaseFieldModel model, Wrapper<TableBaseFieldModel> wrapper);


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model      实体对象封装操作可以为 null）
     * @param wrapper    SQL包装
     * @return List<TableBaseFieldModel>
     */
    List<TableBaseFieldModel> selectPage(Page<TableBaseFieldModel> pagination, TableBaseFieldModel model, Wrapper<TableBaseFieldModel> wrapper);

    /**
     * 插入
     *
     * @param model
     * @param fieldModel
     * @param verifyModel
     */
    void insert(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel);

    /**
     * 更新
     *
     * @param model
     * @param fieldModel
     * @param verifyModel
     */
    void updateById(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel);

    /**
     * 查询这个用户下是否有这个基础字段
     * @param fileName
     * @param userId
     */
    TableBaseFieldModel queryBaseField(String fileName, int userId);
}
