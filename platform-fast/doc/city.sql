/*
Navicat MySQL Data Transfer

Source Server         : 192.168.5.11
Source Server Version : 50722
Source Host           : 192.168.5.11:3306
Source Database       : renren_fast

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-06 15:02:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键 用UUID生成',
  `name` varchar(64) NULL COMMENT '名称',
  `shortName` varchar(10) NULL COMMENT '简称',
  `fullName` varchar(128) NULL COMMENT '全称',
  `province` varchar(32) NULL COMMENT '省份',
  `postalCode` varchar(16) NULL COMMENT '邮政编码',
  `STATUS` tinyint DEFAULT 1 COMMENT '(单选框)状态:  0-无效，1-有效',	  
  `GEOGRAPHY` varchar(12) DEFAULT 1 COMMENT '(复选框)地理:  1-平原，2-丘陵，3-多山，4-高原，5-盆地',	    
   `TYPE` tinyint COMMENT '(下拉框)类型: 1-直辖市，2-首府，3-地级市，4-县级市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

-- ----------------------------
-- Records of city
-- ----------------------------

INSERT INTO `city` VALUES ('2001', '湛江', '湛', '中国广东省湛江市', '广东', '524200', 1, '1,2', 3);
INSERT INTO `city` VALUES ('2002', '深圳', '深', '中国广东省深圳市', '广东', '524206', 1, '1,2', 2);
INSERT INTO `city` VALUES ('2003', '广州', '穗', '中国广东省广州市', '广东', '524200', 1, '2,2', 2);
INSERT INTO `city` VALUES ('2004', '惠州', '惠', '中国广东省惠州市', '广东', '524201', 0, '4,5', 3);
INSERT INTO `city` VALUES ('2005', '武汉', '武', '中国湖北省武汉市', '湖北', '524200', 1, '3,4', 2);
INSERT INTO `city` VALUES ('2006', '南昌', '南', '中国江西省南昌市', '江西', '524213', 1, '1,2', 2);
INSERT INTO `city` VALUES ('2007', '桂林', '桂', '中国广西省桂林市', '广西', '524291', 1, '1,2,5', 2);
INSERT INTO `city` VALUES ('2008', '福州', '福', '中国福建省福州市', '福建', '501206', 1, '1,2,3', 2);
INSERT INTO `city` VALUES ('2009', '浦东新区', '浦', '中国上海市浦东新区', '上海', '588200', 1, '1,2', 3);
INSERT INTO `city` VALUES ('2010', '南宁', '南', '中国广西省南宁市', '广西', '524206', 1, '1,2,4', 2);
INSERT INTO `city` VALUES ('2011', '天津', '深', '中国天津市', '天津', '524206', 1 ,'1,2', 1);
INSERT INTO `city` VALUES ('2012', '昆明', '昆', '中国云南省昆明市', '云南', '599206', 1, '2,5', 2);
INSERT INTO `city` VALUES ('2013', '合肥', '肥', '中国安徽省合肥市', '安徽', '524886', 1, '2,4', 2);
