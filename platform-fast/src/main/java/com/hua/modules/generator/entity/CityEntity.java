package com.hua.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 城市表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-06 14:33:51
 */
@Data
@TableName("city")
public class CityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键 用UUID生成
	 */
	@TableId
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 简称
	 */
	private String shortname;
	/**
	 * 全称
	 */
	private String fullname;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 邮政编码
	 */
	private String postalcode;

}
