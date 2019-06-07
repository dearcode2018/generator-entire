package com.hua.modular.sysrole.controller;

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
import com.hua.core.util.ToolUtil;
import com.hua.modular.sysrole.model.SysRoleModel;
import com.hua.modular.sysrole.service.ISysRoleService;

/**
 * 角色222控制器
 *
 * @author qianye.zheng
 * @Date 2019-06-05 19:54:53
 */
@Controller
@RequestMapping("/sysrole")
public class SysRoleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    private String PREFIX = "/biz/sysrole/";

    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysrole.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String SysRoleAdd() {
        return PREFIX + "sysrole_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String SysRoleUpdate(@PathVariable Integer id, Model model) {
	model.addAttribute("sysrole", sysRoleService.selectById(id));
        return PREFIX + "sysrole_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(SysRoleModel model) {
        Page<SysRoleModel> page = new PageFactory<SysRoleModel>().defaultPage();
        page.setRecords(sysRoleService.selectPage(page,model,new QueryWrapper<SysRoleModel>()));
        return super.packForBT(page);
    }


    @BussinessLog(value = "角色222新增", key = "companyid" )
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(SysRoleModel model) {
        sysRoleService.insert(model);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "角色222删除", key = "id" )
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        sysRoleService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "角色222修改", key = "id" )
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(SysRoleModel model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        sysRoleService.updateById(model);
        return super.SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(SysRoleModel model) {
        return sysRoleService.selectOne(model);
    }
}
