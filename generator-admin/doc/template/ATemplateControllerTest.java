/**
 * ${g.entityName}ControllerTest.java
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.controller;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.hua.test.common.BaseControllerTest;

import ${g.codePackage}.controller.${g.entityName}Controller;

/**
 * 
 * @type ${g.entityName}ControllerTest
 * @description ${g.name} - 测试
 * @author ${g.author}
 */
public final class ${g.entityName}ControllerTest extends BaseControllerTest {

	
	/* 注入对象的调用方式 */
	@Resource
	private ${g.entityName}Controller ${g.lowerEntityName}Controller;
	
	/**
	 * 
	 * @description [每个测试-方法]开始之前运行
	 * @author ${g.author}
	 */
	@Before
	public void beforeMethod() {
		prefix = "/${g.entityName}";
	}	
	
	/**
	 * 
	 * @description 新增
	 * @author ${g.author}
	 */
	@Test
	public void testAdd() {
		try {
			// 页面/服务 地址
			String url = prefix + "/add/v1";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.content("");
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testAdd =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 删除
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDelete() {
		try {
			// 页面/服务 地址
			String url = prefix + "/delete/v1?id=" + 1;
			// 请求构建器
			// get 方法
			MockHttpServletRequestBuilder requestBuilder = get(url);
			// post 方法
			//MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 修改/更新
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			// 页面/服务 地址
			String url = prefix + "/update/v1";
			// 请求构建器
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.content("");
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 查找 (根据id查询)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGet() {
		try {
			// 页面/服务 地址
			String url = prefix + "/get/v1?id=" + 1;
			// 请求构建器
			// get 方法
			MockHttpServletRequestBuilder requestBuilder = get(url);
			// post 方法
			//MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 搜索
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
		try {
			// 页面/服务 地址
			String url = prefix + "/search/v1";
			// 请求构建器
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.content("{\"pageSize\":20, \"currentPage\":1, \"needPage\":true, \"status\":1,\"value\":\"\"}");
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: POST方式 - 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemplatePost() {
		try {
			// 页面/服务 地址
			String url = prefix + "";
			// 请求构建器
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.content("");
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testMockMVC =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: GET方式 - 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemplateGet() {
		try {
			// 页面/服务 地址
			String url = prefix + "";
			// 请求构建器
			// get 方法
			MockHttpServletRequestBuilder requestBuilder = get(url);

			/*
			 * 设置请求参数
			 */
			requestBuilder.param("", "");
			requestBuilder.param("", "");
			requestBuilder.param("", "");
			
			// 响应对象
			MockHttpServletResponse response = perform(requestBuilder);
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println("响应数据:");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testMockMVC =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		
	}

}
