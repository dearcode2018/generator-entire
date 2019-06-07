package com.hua.common.constant.factory;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hua.common.constant.state.Order;
import com.hua.core.support.HttpKit;
import com.hua.core.util.ToolUtil;

/**
 * BootStrap Table默认的分页参数创建
 *
 * @author fengshuonan
 * @date 2017-04-05 22:25
 */
public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if (ToolUtil.isEmpty(sort)) {
            Page<T> page = new Page<T>((offset / limit + 1), limit);
            //page.setOpenSort(false);
            
            return page;
        } else {
            Page<T> page = new Page<T>((offset / limit + 1), limit);
            if (Order.ASC.getDes().equals(order)) {
                //page.setAsc(true);
            } else {
                //page.setAsc(false);
            }
            return page;
        }
    }
}
