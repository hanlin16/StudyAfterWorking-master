/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 127.0.0.1
 Source Database       : test_springboot

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 08/27/2018 20:39:27 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('55', '林颖', '18', '女'), ('22', '刘常江', '29', '男'), ('60', '林条达', '99', '男'), ('30', '阿绿', '33', '男');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
