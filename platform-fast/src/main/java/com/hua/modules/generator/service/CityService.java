package com.hua.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.utils.PageUtils;
import com.hua.modules.generator.entity.CityEntity;

import java.util.Map;

/**
 * 城市表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-06 14:33:51
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

