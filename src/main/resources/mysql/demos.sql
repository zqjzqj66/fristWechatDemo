/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : demos

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-12-28 14:02:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` int(255) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `priority` int(11) NOT NULL,
  `create_date_time` datetime NOT NULL,
  `updata_date_time` datetime NOT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('8', 'r', '10', '2018-12-28 13:11:39', '2018-12-28 13:55:47');
INSERT INTO `area` VALUES ('9', 'fg', '1', '2018-12-28 13:12:07', '2018-12-28 13:12:07');
INSERT INTO `area` VALUES ('10', 'fdg', '1', '2018-12-28 13:12:56', '2018-12-28 13:12:56');
INSERT INTO `area` VALUES ('11', '312', '1', '2018-12-28 13:14:08', '2018-12-28 13:14:08');
INSERT INTO `area` VALUES ('15', '12', '12', '2018-12-28 13:20:57', '2018-12-28 13:20:57');
INSERT INTO `area` VALUES ('16', '1', '45', '2018-12-28 14:00:46', '2018-12-28 14:00:46');
