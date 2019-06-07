package com.hua.modular.code.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.common.annotion.Permission;
import com.hua.common.constant.factory.PageFactory;
import com.hua.common.exception.BizExceptionEnum;
import com.hua.common.exception.BussinessException;
import com.hua.core.base.controller.BaseController;
import com.hua.core.shiro.ShiroKit;
import com.hua.core.util.ToolUtil;
import com.hua.modular.code.model.TableBaseFieldModel;
import com.hua.modular.code.model.TableFieldModel;
import com.hua.modular.code.model.TableFieldVerifyModel;
import com.hua.modular.code.service.ITableBaseFieldService;
import com.hua.modular.code.service.ITableFieldService;
import com.hua.modular.code.service.ITableFieldVerifyService;
import com.hua.modular.system.warpper.BeanKeyConvert;

/**
 * 控制器
 * 基础字段
 *
 * @author
 * @Date
 */
@Controller
@RequestMapping("/tablebasefield")
public class TableBaseFieldController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableBaseFieldController.class);

    private String PREFIX = "/code/tablebasefield/";

    @Autowired
    private ITableBaseFieldService tableBaseFieldService;
    @Autowired
    private ITableFieldService tableFieldService;
    @Autowired
    private ITableFieldVerifyService tableFieldVerifyService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tablebasefield.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String gotoAdd() {
        return PREFIX + "tablebasefield_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        TableBaseFieldModel baseFieldModel = tableBaseFieldService.getById(id);
        model.addAttribute("tablebasefield", baseFieldModel);
        model.addAttribute("tablefield", tableFieldService.selectById(baseFieldModel.getFieldId()));
        model.addAttribute("verifyfield", tableFieldVerifyService.selectOne(new TableFieldVerifyModel(baseFieldModel.getFieldId())));
        return PREFIX + "tablebasefield_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(TableBaseFieldModel model, HttpServletRequest req, HttpServletResponse res) {
        Page<TableBaseFieldModel> page = new PageFactory<TableBaseFieldModel>().defaultPage();
        model.setUserId(ShiroKit.getUser().id);
        page.setRecords(tableBaseFieldService.selectPage(page, model, new QueryWrapper<TableBaseFieldModel>()));
        BeanKeyConvert.systemUserNameConvert(page.getRecords());
        return super.packForBT(page);
    }

    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel) {
        model.setUserId(ShiroKit.getUser().id);
        //统一强制大写
        fieldModel.setFieldName(fieldModel.getFieldName().toUpperCase());
        tableBaseFieldService.insert(model, fieldModel, verifyModel);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        tableBaseFieldService.deleteById(id);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(TableBaseFieldModel model, TableFieldModel fieldModel, TableFieldVerifyModel verifyModel) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //统一强制大写
        fieldModel.setFieldName(fieldModel.getFieldName().toUpperCase());
        tableBaseFieldService.updateById(model, fieldModel, verifyModel);
        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(TableBaseFieldModel model) {
        return tableBaseFieldService.selectOne(model);
    }
}