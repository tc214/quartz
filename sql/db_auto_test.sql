/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : db_auto_test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-01-18 11:33:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_autotest_cur_config
-- ----------------------------
DROP TABLE IF EXISTS `t_autotest_cur_config`;
CREATE TABLE `t_autotest_cur_config` (
  `id` bigint(20) NOT NULL,
  `autotest_switch` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '开关',
  `running_mode` varchar(10) DEFAULT NULL,
  `running_app` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `running_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '测试状态',
  `interval_time_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `random_time` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `solid_time` bigint(30) DEFAULT NULL,
  `stop_condition_mode` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `operation_num` bigint(20) DEFAULT NULL,
  `running_time_length` bigint(20) DEFAULT NULL,
  `radios_ip` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `last_modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_autotest_cur_config
-- ----------------------------
INSERT INTO `t_autotest_cur_config` VALUES ('1', 'off', 'mode1', 'test1', 'pendding', 'solid', '13', '12', 'operation', '56', '78', '[{192.168.12.1, 192.168.12.2, }]', '2019-01-11 07:13:39');

-- ----------------------------
-- Table structure for t_autotest_history
-- ----------------------------
DROP TABLE IF EXISTS `t_autotest_history`;
CREATE TABLE `t_autotest_history` (
  `id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `running_mode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '测试模式',
  `running_app` varchar(20) DEFAULT NULL,
  `running_status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '测试状态',
  `interval_time_mode` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '间隔时间',
  `random_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '随机间隔时间',
  `solid_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '固定间隔时间',
  `stop_condition_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '测试终止条件',
  `operation_num` int(11) DEFAULT NULL COMMENT '操作次数',
  `running_time_length` datetime DEFAULT NULL COMMENT '运行总时长',
  `radios_ip` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '电台ip集合',
  `success_num` int(11) DEFAULT NULL COMMENT '执行成功次数',
  `fail_num` int(11) DEFAULT NULL COMMENT '执行失败次数',
  `total_run_num` int(64) DEFAULT NULL COMMENT '总执行次数',
  `test_start_time` datetime DEFAULT NULL COMMENT '测试开始时间',
  `test_end_time` datetime DEFAULT NULL COMMENT '测试结束时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_autotest_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_autotest_result
-- ----------------------------
DROP TABLE IF EXISTS `t_autotest_result`;
CREATE TABLE `t_autotest_result` (
  `id` bigint(30) NOT NULL,
  `test_id` int(11) NOT NULL,
  `radio_ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `radio_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `test_result` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fail_reason` varchar(255) DEFAULT NULL,
  `running_time` datetime DEFAULT NULL COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_autotest_result
-- ----------------------------
