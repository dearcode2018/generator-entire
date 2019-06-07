/**
  * @filename ${g.entityName}Mapper.java
  * @description 
  * @version 1.0
  * @author ${g.author}
 */
package ${g.codePackage}.mapper.local;

import java.util.List;

import ${g.codePackage}.entity.PagerEntity;
import ${g.codePackage}.entity.local.${g.entityName}Entity;
import ${g.codePackage}.view.${g.entityName}Vo;
import ${g.codePackage}.mapper.CoreMapper;

/**
 * @type ${g.entityName}Mapper
 * @description ${g.name}
 * @author ${g.author}
 */
public interface ${g.entityName}Mapper extends CoreMapper<${g.entityName}Entity>
{

	/**
	 * 
	 * @description 搜索
	 * @param pagerEntity
	 * @return
	 * @author ${g.author}
	 */
	public List<${g.entityName}Vo> search(final PagerEntity pagerEntity);

}
