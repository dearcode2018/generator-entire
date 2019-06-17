/**
  * @filename ${g.entityName}Dao.java
  * @description 
  * @version 1.0
  * @author ${g.author}
 */
package ${g.codePackage}.dao.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ${g.codePackage}.bean.BaseSearchBean;
import ${g.codePackage}.entity.PagerEntity;
import ${g.codePackage}.view.Pager;
import ${g.codePackage}.dao.CoreDao;
import ${g.codePackage}.entity.local.${g.entityName}Entity;
import ${g.codePackage}.mapper.local.${g.entityName}Mapper;

/**
 * @type ${g.entityName}Dao
 * @description ${g.name}
 * @author ${g.author}
 */
@Repository
public class ${g.entityName}Dao extends CoreDao<${g.entityName}Entity>
{
	
	@Resource
	private ${g.entityName}Mapper ${g.lowerEntityName}Mapper;
	
	/**
	 * 
	 * @description 搜索
	 * @param searchBean
	 * @return
	 * @author ${g.author}
	 */
	public Pager search(final BaseSearchBean searchBean)
	{
		final PagerEntity pagerEntity = new PagerEntity(searchBean, searchBean.getOffset(), searchBean.getPageSize());
		final Pager pager = new Pager();
		pager.setPageSize(searchBean.getPageSize());
		pager.setCurrentPage(searchBean.getCurrentPage());
		pager.setBeanList(${g.entityName}Mapper.search(pagerEntity));
		pager.setDataSize(${g.entityName}Mapper.searchDataSize(pagerEntity));
		
		return pager;
	}
	
	/**
	 * 
	 * @description 设置核心映射器引用
	 * @param ${g.entityName}Mapper
	 * @author ${g.author}
	 */
	@Resource
	public final void set${g.entityName}Mapper(final ${g.entityName}Mapper ${g.entityName}Mapper)
	{
		super.coreMapper = ${g.entityName}Mapper;
	}
	
	
}
