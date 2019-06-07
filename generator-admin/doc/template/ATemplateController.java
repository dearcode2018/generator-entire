/**
  * @filename ${g.entityName}Controller.java
  * @description 
  * @version 1.0
  * @author ${g.author}
 */
package ${g.codePackage}.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${g.codePackage}.bean.BaseSearchBean;
import ${g.codePackage}.request.local.BaseRequest;
import ${g.codePackage}.service.local.${g.entityName}Service
import ${g.codePackage}.util.EmptyUtil;
import ${g.codePackage}.util.StringUtil;
import ${g.codePackage}.view.LoginUserVo;
import ${g.codePackage}.view.ResultBean;
import ${g.codePackage}.constant.MessageCode;

/**
 * @type ${g.entityName}Controller
 * @description ${g.name}
 * @author ${g.author}
 */
@Controller
@RequestMapping("/${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}")
public class ${g.entityName}Controller extends BaseController
{

	@Resource
	private ${g.entityName}Service ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service;
	
	/**
	 * 
	 * @description 新增
	 * @param request
	 * @param response
	 * @param baseRequest
	 * @return
	 * @author ${g.author}
	 */
	@ResponseBody
	@RequestMapping(value = "/add/v1", method = {RequestMethod.POST})
	public ResultBean add(final HttpServletRequest request, 
			final HttpServletResponse response, final @RequestBody(required = true) BaseRequest baseRequest)
	{
		final ResultBean resultBean = new ResultBean();
		/** ===== begin 参数校验 ===== */
/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/
		/** ===== end of 参数校验 ===== */
		// 获取用户登录信息
		final LoginUserVo loginUserVo = getUser(request);
		
		return ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service.add(baseRequest, loginUserVo);
	}
	
	/**
	 * 
	 * @description 删除
	 * @param request
	 * @param response
	 * @param updateUserRequest
	 * @return
	 * @author ${g.author}
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/v1", method = {RequestMethod.GET})
	public ResultBean delete(final HttpServletRequest request, 
			final HttpServletResponse response, final Integer id)
	{
		final ResultBean resultBean = new ResultBean();
		/** ===== begin 参数校验 ===== */
		if (EmptyUtil.isEmpty(id))
		{
			resultBean.setMessage("id不能为空");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}
		/** ===== end of 参数校验 ===== */
		// 获取用户登录信息
		final LoginUserVo loginUserVo = getUser(request);
		
		return ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service.delete(id, loginUserVo);
	}
	
	/**
	 * 
	 * @description 更新
	 * @param request
	 * @param response
	 * @param updateUserRequest
	 * @return
	 * @author ${g.author}
	 */
	@ResponseBody
	@RequestMapping(value = "/update/v1", method = {RequestMethod.POST})
	public ResultBean update(final HttpServletRequest request, 
			final HttpServletResponse response, final @RequestBody(required = true) BaseRequest baseRequest)
	{
		final ResultBean resultBean = new ResultBean();
		/** ===== begin 参数校验 ===== */
/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/
		/** ===== end of 参数校验 ===== */
		// 获取用户登录信息
		final LoginUserVo loginUserVo = getUser(request);
		
		return ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service.update(baseRequest, loginUserVo);
	}
	
	/**
	 * 
	 * @description 查找
	 * @param request
	 * @param response
	 * @param updateUserRequest
	 * @return
	 * @author ${g.author}
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1", method = {RequestMethod.GET})
	public ResultBean get(final HttpServletRequest request, 
			final HttpServletResponse response, final Integer id)
	{
		final ResultBean resultBean = new ResultBean();
		/** ===== begin 参数校验 ===== */
		if (EmptyUtil.isEmpty(id))
		{
			resultBean.setMessage("id不能为空");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}
		/** ===== end of 参数校验 ===== */
		// 获取用户登录信息
		final LoginUserVo loginUserVo = getUser(request);
		
		return ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service.get(id);
	}
	
	/**
	 * 
	 * @description 搜索
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 * @author ${g.author}
	 */
	@ResponseBody
	@RequestMapping(value = "/search/v1", method = {RequestMethod.POST})
	public ResultBean search(final HttpServletRequest request, 
			final HttpServletResponse response, final @RequestBody(required = true) BaseSearchBean searchBean)
	{
		final ResultBean resultBean = new ResultBean();
		/** ===== begin 参数校验 ===== */
		// 权限校验和条件过滤
/*		if (true)
		{
			resultBean.setMessage("");
			resultBean.setSuccess(false);
			resultBean.setMessageCode(MessageCode.FAILURE_CODE);
			
			return resultBean;
		}*/
		/** ===== end of 参数校验 ===== */
		// 获取用户登录信息
		final LoginUserVo loginUserVo = getUser(request);
		
		return ${strutil.toLowerCase(strutil.subStringTo(g.entityName,0,1))}${strutil.subString(g.entityName,1)}Service.search(searchBean);
	}
	
	
}
