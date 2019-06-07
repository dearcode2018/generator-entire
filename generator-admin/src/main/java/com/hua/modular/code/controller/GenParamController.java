package com.hua.modular.code.controller;

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

import com.hua.common.annotion.BussinessLog;
import com.hua.common.annotion.Permission;
import com.hua.common.constant.factory.PageFactory;
import com.hua.common.exception.BizExceptionEnum;
import com.hua.common.exception.BussinessException;
import com.hua.core.base.controller.BaseController;
import com.hua.core.shiro.ShiroKit;
import com.hua.core.util.ToolUtil;
import com.hua.modular.code.model.GenParamModel;
import com.hua.modular.code.service.IGenParamService;
import com.hua.modular.system.warpper.BeanKeyConvert;

/**
 * 生成参数控制器
 *
 * @author JueYue
 * @Date 2017-09-13 09:14
 */
@Controller
@RequestMapping("/genparam")
public class GenParamController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenParamController.class);

    private String PREFIX = "/code/genparam/";

    @Autowired
    private IGenParamService genParamService;
    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "genparam.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String GenParamAdd() {
        return PREFIX + "genparam_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String GenParamUpdate(@PathVariable Integer id, Model model) {
	model.addAttribute("genparam", genParamService.selectById(id));
        return PREFIX + "genparam_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(GenParamModel model) {
        Page<GenParamModel> page = new PageFactory<GenParamModel>().defaultPage();
        model.setUserId(ShiroKit.getUser().getId());
        page.setRecords(genParamService.selectPage(page,model,new QueryWrapper<GenParamModel>()));
        BeanKeyConvert.systemUserNameConvert(page.getRecords());
        return super.packForBT(page);
    }


    @BussinessLog(value = "生成参数新增", key = "codePackage" )
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(GenParamModel model) {
        genParamService.insert(model);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "生成参数删除", key = "id" )
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        genParamService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "生成参数修改", key = "id" )
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(GenParamModel model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        genParamService.updateById(model);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(GenParamModel model) {
        return genParamService.selectOne(model);
    }
}
