/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : ssm_subject

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2020-07-07 22:20:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_number` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1815925', '李华', null, null, null, '男', '1234@qq.com', '1');
