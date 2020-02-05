/*
 Navicat Premium Data Transfer

 Source Server         : easycompany
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3307
 Source Schema         : easysaas

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/02/2020 21:44:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_export
-- ----------------------------
DROP TABLE IF EXISTS `company_export`;
CREATE TABLE `company_export`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `query_condition_md5` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'md5查询条件',
  `query_condition` json COMMENT '查询条件',
  `skip` int(10) DEFAULT NULL COMMENT '跳过指定数量的数据',
  `query_number` int(10) DEFAULT NULL COMMENT '查询的条数',
  `member_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户编号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `url` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接口url',
  `keyword` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '查询关键字',
  `record_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '记录编号',
  `qiniu_address` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '七牛云地址',
  `to_mail` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目的地',
  `role_sn` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company_export_history
-- ----------------------------
DROP TABLE IF EXISTS `company_export_history`;
CREATE TABLE `company_export_history`  (
  `company_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `random_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `member_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `query_condition_md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '导出明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_export_history
-- ----------------------------
INSERT INTO `company_export_history` VALUES ('130070179', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('166861796', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('193331816', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('2393075', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('67315', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('164648136', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('102867226', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('192777496', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('518955', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('535663', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('69676', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('91305', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('38051994', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('503871', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('535934', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('573049', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('614736', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('162061903', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('181568679', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('177722879', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('128890009', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('77454994', NULL, 'memberId', '2020-01-30 22:28:38', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('130070179', NULL, '1', '2020-01-31 19:54:55', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('166861796', NULL, '1', '2020-01-31 19:56:30', '07a1d780df1224acf84c4a9c26bc1108');
INSERT INTO `company_export_history` VALUES ('193331816', NULL, '1', '2020-01-31 20:14:17', '07a1d780df1224acf84c4a9c26bc1108');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `member_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'member编号',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '男' COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `company_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名称',
  `department` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门',
  `position` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `head_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像地址',
  `phone_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `email` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `modify_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名字',
  `enabled` tinyint(1) DEFAULT 1 COMMENT '启用/禁用',
  PRIMARY KEY (`member_id`) USING BTREE,
  UNIQUE INDEX `id`(`member_id`) USING BTREE,
  UNIQUE INDEX `phone_number`(`phone_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'GDE2019102913551259347', '男', NULL, NULL, NULL, 'e10adc3949ba59abbe56e057f20f883e', '$2a$10$RI.6z92z38bM3vjy2ZrdAOmM7vbnBDk9EIO6UVrH0ENAadj1KY0M.', NULL, '13551259347', NULL, NULL, '2019-10-29 11:29:24', 'GDElfabozabau', 1);

-- ----------------------------
-- Table structure for member_role
-- ----------------------------
DROP TABLE IF EXISTS `member_role`;
CREATE TABLE `member_role`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `member_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'member_id',
  `role_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'role_id',
  `from_time` datetime(0) DEFAULT NULL COMMENT '有效期起始',
  `to_time` datetime(0) DEFAULT NULL COMMENT '有效期结束',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_role
-- ----------------------------
INSERT INTO `member_role` VALUES ('1', '1', '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permission_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '不包含域名的路径',
  `return_class` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '返回类',
  `resource_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `parent_id` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上一级资源',
  `return_file` tinyint(1) DEFAULT 0 COMMENT '是否返回的是文件',
  PRIMARY KEY (`permission_id`) USING BTREE,
  UNIQUE INDEX `id`(`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/api/demo', NULL, 'api/demo', NULL, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `role_sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ROLE_开头,用于security判断',
  `template_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  PRIMARY KEY (`role_name`) USING BTREE,
  UNIQUE INDEX `id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '注册会员', '1', '1');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `permission_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源 id',
  `return_field` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '返回字段,分隔',
  `role_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'role_id',
  `export_number` int(20) DEFAULT NULL COMMENT '条数',
  `query_number` int(20) DEFAULT NULL COMMENT '查询条数',
  PRIMARY KEY (`permission_id`, `role_id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, '1', NULL, '1', NULL, NULL);

-- ----------------------------
-- Table structure for send_sms
-- ----------------------------
DROP TABLE IF EXISTS `send_sms`;
CREATE TABLE `send_sms`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `send_time` datetime(0) DEFAULT NULL COMMENT '发送时间',
  `send_type` int(255) DEFAULT NULL COMMENT '发送类型1注册验证码2登录验证码3找回密码验证码',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '发送短消息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of send_sms
-- ----------------------------
INSERT INTO `send_sms` VALUES ('dd60648a-440e-47d8-ba3f-88a6f0cef278', '13551259347', '2020-01-12 17:15:43', 1, '406703');

SET FOREIGN_KEY_CHECKS = 1;
