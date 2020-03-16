/*
 Navicat Premium Data Transfer

 Source Server         : easycrm
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : easyicc

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 16/03/2020 15:37:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cuour_card_rule
-- ----------------------------
DROP TABLE IF EXISTS `cuour_card_rule`;
CREATE TABLE `cuour_card_rule`  (
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USE_ALLOCATION` int(0) NULL DEFAULT NULL COMMENT '是否启用分配',
  `TIME_INTERVAL` int(0) NULL DEFAULT NULL COMMENT '分配时间间隔',
  `ALLOCATION_SIZE` int(0) NULL DEFAULT NULL COMMENT '间隔时间内分配数量',
  `MAX_ALLOCATION_SIZE` int(0) NULL DEFAULT NULL COMMENT '每天最多分配数量',
  `EXPIRED_RECOVER` int(0) NULL DEFAULT NULL COMMENT '超期回收开关',
  `EXPIRED_HOUR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '超时回收时间',
  `RESET_TIME` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重置时间',
  `MOBILE_HIDE_TIME` int(0) NULL DEFAULT NULL COMMENT '手机号码隐藏时间',
  `SERVER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ALLOCATION_DELAY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分配延迟(分)',
  `DEFAULT_SUBJECT_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认项目',
  `DEFAULT_SCHOOL_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认校区',
  `NEED_ONLINE` int(0) NULL DEFAULT NULL COMMENT '必须在线才能分配',
  `NEED_SCHEEDULING` int(0) NULL DEFAULT NULL COMMENT '必须排班才能分配',
  `ALLOCATION_MODEL` int(0) NULL DEFAULT NULL COMMENT '分配模式 0按校区/项目 1 分配给创建者',
  `ALGORITHM` int(0) NULL DEFAULT NULL,
  `IS_WECHAT_OPEN` int(0) NULL DEFAULT NULL COMMENT '微信推送是否开启 0开启 1关闭',
  `IS_ONLINE_ALLOCTION` int(0) NULL DEFAULT NULL COMMENT '在线分配模式 0 在线分配(只有在线的状态可以进行名片的分配) 1 在线分配(在线.忙碌.离开的状态可以进行名片的分配)',
  `NEED_SUMBIT_TOUTIAO` int(0) NULL DEFAULT NULL COMMENT '是否开启上报头条功能（默认开启）',
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
