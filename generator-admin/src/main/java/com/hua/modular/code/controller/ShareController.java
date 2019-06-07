package com.hua.modular.code.controller;

import com.hua.core.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.hua.common.constant.cache.Cache;
import com.hua.common.constant.cache.CacheKey;
import com.hua.core.base.controller.BaseController;
import com.hua.core.cache.CacheKit;
import com.hua.modular.code.model.TemplateModel;
import com.hua.modular.code.service.ITemplateService;

/**
 * 分享的界面 Created by JueYue on 2017/9/15.
 */
@Controller
public class ShareController extends BaseController {

    private static String PREFIX = "/share";

    @Autowired
    private ITemplateService templateService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/share", method = RequestMethod.GET)
    public String share() {
        return PREFIX + "/index.html";
    }

    @RequestMapping(value = "/share/detail/{groupId}", method = RequestMethod.GET)
    public String sharedetail(@PathVariable String groupId, Model model) {
        model.addAttribute("list", templateService.getAllTemplateByGroupId(groupId));
        model.addAttribute("groupId", groupId);
        return PREFIX + "/single.html";
    }


    @RequestMapping(value = "/share/clone/{groupId}", method = RequestMethod.GET)
    public String clone(@PathVariable String groupId, Model model) {
        if (CacheKit.get(Cache.USER, CacheKey.TEMPLATE_DATA + groupId) == null) {
            List<TemplateModel> list = templateService.getAllTemplateByGroupId(groupId);
            CacheKit.put(Cache.USER, CacheKey.TEMPLATE_DATA + groupId, list);
        }

        if (ShiroKit.isGuest()) {
            model.addAttribute("msg", "未登陆,请先登录!!");
        } else {
            templateService.cloneGroup(groupId, ShiroKit.getUser().getId());
            model.addAttribute("msg", "克隆成功,尽情的使用吧!!");
        }

        model.addAttribute("list", CacheKit.get(Cache.USER, CacheKey.TEMPLATE_DATA + groupId));
        return PREFIX + "/single.html";
    }
}
