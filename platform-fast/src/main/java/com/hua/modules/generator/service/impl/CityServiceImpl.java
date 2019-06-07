package com.hua.modules.generator.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;
import com.hua.modules.generator.dao.CityDao;
import com.hua.modules.generator.entity.CityEntity;
import com.hua.modules.generator.service.CityService;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	QueryWrapper<CityEntity> wrapper = new QueryWrapper<>();
    	final String value = params.get("key").toString();
    	wrapper.like("name", value).or().like("shortName", value)
    	.or().like("fullName", value).or().like("province", value)
    	.or().like("postalCode", value);
    	
        IPage<CityEntity> page = this.page(new Query<CityEntity>().getPage(params), wrapper);

        return new PageUtils(page);
    }

}