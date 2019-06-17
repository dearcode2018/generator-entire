/**
  * @filename ${g.entityName}Service.java
  * @description 
  * @version 1.0
  * @author ${g.author}
 */
package ${g.codePackage}.service.local;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import ${g.codePackage}.bean.BaseSearchBean;
import ${g.codePackage}.bean.request.BaseRequest;
import ${g.codePackage}.constant.MessageCode;
import ${g.codePackage}.entity.local.${g.entityName}Entity;
import ${g.codePackage}.service.CoreService;
import ${g.codePackage}.view.LoginUserVo;
import ${g.codePackage}.view.ResultBean;


/**
 * @type ${g.entityName}Service
 * @description ${g.name}
 * @author ${g.author}
 */
@Service
public class ${g.entityName}Service extends CoreService
{
	
	@Resource
	private ${g.entityName}Dao ${g.lowerEntityName}Dao;
	
	/**
	 * 
	 * @description 新增
	 * @param baseRequest
	 * @param loginUserVo
	 * @return
	 * @author ${g.author}
	 */
	public ResultBean add(final BaseRequest request, final LoginUserVo loginUserVo)
	{
		final ResultBean resultBean = new ResultBean();
		/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/	
		final ${g.entityName}Entity entity = new ${g.entityName}Entity();
		// 更新者
		entity.setOperator(loginUserVo.getId().toString());
		// 创建时间
		entity.setCreateDt(new Date());
		// 拷贝属性
		try
		{
			BeanUtils.copyProperties(entity, request);
		} catch (Exception e)
		{
			logger.error("拷贝属性异常: {}", e);
		}
		if (${g.entityName}Dao.insert(entity))
		{ // 新增成功
			
		} else
		{ // 新增失败
			//logger.warn(": {} 新增失败", );
			resultBean.setMessage(MessageCode.FAILURE_MESSAGE);
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 删除
	 * @param id
	 * @param loginUserVo
	 * @return
	 * @author ${g.author}
	 */
	public ResultBean delete(final Integer id, final LoginUserVo loginUserVo)
	{
		final ResultBean resultBean = new ResultBean();
		/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/	
		if (${g.entityName}Dao.delete(id))
		{ // 删除成功
			
		} else
		{ // 删除失败
			logger.warn("id: {} 删除失败", id);
			resultBean.setMessage(MessageCode.FAILURE_MESSAGE);
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 修改
	 * @param request
	 * @param loginUserVo
	 * @return
	 * @author ${g.author}
	 */
	public ResultBean update(final BaseRequest request, final LoginUserVo loginUserVo)
	{
		final ResultBean resultBean = new ResultBean();
		/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/	
		final ${g.entityName}Entity entity = new ${g.entityName}Entity();
		// 更新者
		entity.setOperator(loginUserVo.getId().toString());
		// 更新时间
		entity.setUpdateDt(new Date());
		// 拷贝属性
		try
		{
			BeanUtils.copyProperties(entity, request);
		} catch (Exception e)
		{
			logger.error("拷贝属性异常: {}", e);
		}
		// 更新
		if (${g.entityName}Dao.update(entity))
		{ // 更新成功
			
		} else
		{ // 更新失败
			logger.warn("id: {} 更新失败", request.getId());
			resultBean.setMessage(MessageCode.FAILURE_MESSAGE);
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 查找
	 * @param id
	 * @return
	 * @author ${g.author}
	 */
	public ResultBean get(final Integer id)
	{
		final ResultBean resultBean = new ResultBean();
		/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/	
		// 设置数据
		//resultBean.setData(${g.entityName}Dao.get(id));
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 搜索
	 * @param baseRequest
	 * @param searchBean
	 * @return
	 * @author ${g.author}
	 */
	public ResultBean search(final BaseSearchBean searchBean)
	{
		final ResultBean resultBean = new ResultBean();
		/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/	
		// 设置数据
		resultBean.setData(${g.entityName}Dao.search(searchBean));
		
		return resultBean;
	}
	
}
