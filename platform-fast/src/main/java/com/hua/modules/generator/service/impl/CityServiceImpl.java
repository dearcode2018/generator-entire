package com.hua.modules.generator.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.util.PageUtils;
import com.hua.common.util.Query;
import com.hua.modules.generator.dao.CityDao;
import com.hua.modules.generator.entity.CityEntity;
import com.hua.modules.generator.service.CityService;


@Service("cityService")
//@DataSource("x")
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

	/** 若使用其他数据源(非默认数据源，则去掉该注释，并且修改@DataSource("x") 为指定的数据源)

    @Override
    public CityEntity getById(Serializable id) {
        return baseMapper.selectById(id);
    }


    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
    }
    
    @Override
    public boolean save(CityEntity entity) {
        return retBool(baseMapper.insert(entity));
    }
    
    @Override
    public boolean updateById(CityEntity entity) {
        return retBool(baseMapper.updateById(entity));
    }
	
	*/   
    

}