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
  `name` varchar(64) NOT NULL COMMENT '名称',
  `shortName` varchar(10) NOT NULL COMMENT '简称',
  `fullName` varchar(128) NOT NULL COMMENT '全称',
  `province` varchar(32) NOT NULL COMMENT '省份',
  `postalCode` varchar(16) NOT NULL COMMENT '邮政编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('2001', '湛江', '湛', '中国广东省湛江市', '广东', '524200');
INSERT INTO `city` VALUES ('2002', '深圳', '深', '中国广东省深圳市', '广东', '524206');
INSERT INTO `city` VALUES ('2003', '广州', '穗', '中国广东省广州市', '广东', '524200');
INSERT INTO `city` VALUES ('2004', '惠州', '惠', '中国广东省惠州市', '广东', '524201');
INSERT INTO `city` VALUES ('2005', '武汉', '武', '中国湖北省武汉市', '湖北', '524200');
INSERT INTO `city` VALUES ('2006', '南昌', '南', '中国江西省南昌市', '江西', '524213');
INSERT INTO `city` VALUES ('2007', '桂林', '桂', '中国广西省桂林市', '广西', '524291');
INSERT INTO `city` VALUES ('2008', '福州', '福', '中国福建省福州市', '福建', '501206');
INSERT INTO `city` VALUES ('2009', '浦东新区', '浦', '中国上海市浦东新区', '上海', '588200');
INSERT INTO `city` VALUES ('2010', '南宁', '南', '中国广西省南宁市', '广西', '524206');
INSERT INTO `city` VALUES ('2011', '天津', '深', '中国天津市', '天津', '524206');
INSERT INTO `city` VALUES ('2012', '昆明', '昆', '中国云南省昆明市', '云南', '599206');
INSERT INTO `city` VALUES ('2013', '合肥', '肥', '中国安徽省合肥市', '安徽', '524886');
