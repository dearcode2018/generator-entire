package com.hua.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.common.util.PageUtils;
import com.hua.modules.generator.entity.CityEntity;

import java.util.Map;

/**
 * 城市表
 *
 * @author qianye.zheng
 * @email dearcode2019@qq.com
 * @date 2019-06-25 19:49:31
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

