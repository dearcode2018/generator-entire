package com.hua.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 城市表
 * 
 * @author qianye.zheng
 * @email dearcode2019@qq.com
 * @date 2019-06-25 19:49:31
 */
@Data
@TableName("city")
public class CityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键 用UUID生成
	 */
	@TableId
	private Integer id;
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
	/**
	 * (单选框)状态:  0-无效，1-有效
	 */
	private Integer status;
	/**
	 * (复选框)地理:  1-平原，2-丘陵，3-多山，4-高原，5-盆地
	 */
	private String geography;
	/**
	 * (下拉框)类型: 1-直辖市，2-首府，3-地级市，4-县级市
	 */
	private Integer type;

}
