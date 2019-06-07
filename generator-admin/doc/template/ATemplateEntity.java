/**
  * @filename ${g.entityName}Entity.java
  * @description 
  * @version 1.0
  * @author ${g.author}
 */
package ${g.codePackage}.entity.local;

import ${g.codePackage}.entity.CoreEntity;

/**
 * @type ${g.entityName}Entity
 * @description ${g.name}
 * @author ${g.author}
 */
public class ${g.entityName}Entity extends CoreEntity
{
	
<%for(field in t.fields){%>
     /* ${field.comment} */
	private ${field.type} ${field.name};

<%}%>
	
}
