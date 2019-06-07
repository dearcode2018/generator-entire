package com.hua.modular.code.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.common.annotion.BussinessLog;
import com.hua.common.annotion.Permission;
import com.hua.common.constant.factory.PageFactory;
import com.hua.core.base.controller.BaseController;
import com.hua.core.shiro.ShiroKit;
import com.hua.core.util.ToolUtil;
import com.hua.modular.code.model.TemplateFileModel;
import com.hua.modular.code.model.TemplateGroupModel;
import com.hua.modular.code.model.TemplateModel;
import com.hua.modular.code.service.ITemplateFileService;
import com.hua.modular.code.service.ITemplateGroupService;
import com.hua.modular.code.service.ITemplateService;
import com.hua.modular.system.warpper.BeanKeyConvert;

/**
 * 模板管理控制器
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    private String PREFIX = "/code/template/";

    @Autowired
    private ITemplateService templateService;
    @Autowired
    private ITemplateFileService templateFileService;
    @Autowired
    private ITemplateGroupService templateGroupService;


    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        return PREFIX + "template.html";
    }

    @RequestMapping("/history")
    public String history(Model modelMap, String originalId) {
        modelMap.addAttribute("originalId", originalId);
        return PREFIX + "template_history.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String gotoAdd(Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        return PREFIX + "template_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String gotoUpdate(@PathVariable Integer id, Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        modelMap.addAttribute("template", templateService.selectById(id));
        modelMap.addAttribute("file", templateFileService.selectOne(new TemplateFileModel(id)));
        return PREFIX + "template_edit.html";
    }

    /**
     * 跳转到另存为
     */
    @RequestMapping("/goto_save_as/{id}")
    public String gotoSaveAs(@PathVariable Integer id, Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        modelMap.addAttribute("template", templateService.selectById(id));
        modelMap.addAttribute("file", templateFileService.selectOne(new TemplateFileModel(id)));
        return PREFIX + "template_save_as.html";
    }


    @RequestMapping("/goto_detail/{id}")
    public String gotoDetail(@PathVariable Integer id, Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        modelMap.addAttribute("template", templateService.selectById(id));
        modelMap.addAttribute("file", templateFileService.selectOne(new TemplateFileModel(id)));
        return PREFIX + "template_detail.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(TemplateModel model) {
        Page<TemplateModel> page = new PageFactory<TemplateModel>().defaultPage();
        model.setUserId(ShiroKit.getUser().getId());
        page.setRecords(templateService.selectPage(page, model, new QueryWrapper<TemplateModel>()));
        BeanKeyConvert.systemUserNameConvert(page.getRecords());
        return super.packForBT(page);
    }


    @BussinessLog(value = "模板管理新增", key = "companyid")
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(@RequestBody TemplateModel model) throws UnsupportedEncodingException {
        model.getFileModel().setFile(hanlderFileEncode(model.getFileModel().getFile()));
        model.setVersion(1);
        templateService.insert(model, model.getFileModel());
        return SUCCESS_TIP;
    }

    @BussinessLog(value = "模板管理删除", key = "id")
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        templateService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "模板管理修改", key = "id")
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(@RequestBody TemplateModel model) throws UnsupportedEncodingException {
        if (ToolUtil.isOneEmpty(model.getId())) {
            add(model);
        } else {
            model.getFileModel().setFile(hanlderFileEncode(model.getFileModel().getFile()));
            templateService.updateById(model, model.getFileModel());
        }
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(TemplateModel model) {
        return templateService.selectOne(model);
    }

    private String hanlderFileEncode(String file) {
        return file.replaceAll("& #40;", "(")
                .replaceAll("& #41;", ")")
                .replaceAll("& lt;", "<")
                .replaceAll("& gt;", ">")
                .replaceAll("& #39;", "'");
    }
}
