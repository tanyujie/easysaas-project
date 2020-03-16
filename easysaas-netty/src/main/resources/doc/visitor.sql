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

 Date: 16/03/2020 19:09:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COMPANY_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visitor_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_STATIC_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visitor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` date NULL DEFAULT NULL,
  `ACTIVE_TIME` date NULL DEFAULT NULL,
  `LAST_ACTIVE_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_ACTIVE_URL_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIRST_ACTIVE_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIRST_ACTIVE_URL_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COUNTRY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PROVINCE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LOCATION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REFER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `KEYWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEARCHING` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEARCH_ENGINE_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ACCEPT_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DENY_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INVITE_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VIEW_PAGE_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUEST_COUNT_OF_CLICK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUEST_COUNT_OF_INVITE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUEST_COUNT_OF_AUTO_INVITE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_COUNT_OF_CLICK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_COUNT_OF_INVITE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_COUNT_OF_AUTO_INVITE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LEAVE_MESSAGE_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HAS_EXT_DATA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HAS_VCARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SPAN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SPREAD_FLAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SITE_ID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `PROMOTION_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HAS_CARD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HAS_CHAT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HAS_LEAVE_MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_ACTIVE_URL2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIRST_ACTIVE_URL2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SITE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PROMOTION_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DEVICE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REFER_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_AGENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_USER_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_CAMPAIGIN_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_ADGROUND_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_KEYWORD_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_CREATIVE_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NTAG_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('190552969', '90', '01000000000090463702707187992810', '01000000008741462372578066169165', NULL, '2018-04-25', '2018-04-25', 'http://115.28.170.190:8080/rycm/test.html', '测试网页', 'http://115.28.170.190:8080/rycm/test.html', '测试网页', '124.65.159.146', '中国', '北京市', NULL, '中国北京市联通', NULL, NULL, NULL, '0', 'Chrome', 'Windows NT 6.1', '0', '0', '0', '3', '1', '0', '0', '0', '2', '0', '0', '0', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, '3027', NULL, '6481', '0', '0', '1', '0', 'http://115.28.170.190:8080/rycm/test.html', 'http://115.28.170.190:8080/rycm/test.html', NULL, 'rycm', NULL, 'pc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `visitor` VALUES ('190555095', '91', '01000000000091329067506680848794', '01000000000091329067506680848794', NULL, '2019-03-23', '2019-03-23', 'http://jkysgl.com/', '腰椎病怎么治疗_北京前海股骨头医院怎么样_风湿类风湿治疗方法_肩周炎如何治疗', 'http://jkysgl.com/', '腰椎病怎么治疗_北京前海股骨头医院怎么样_风湿类风湿治疗方法_肩周炎如何治疗', '40.77.189.20', '美国', NULL, NULL, '美国', NULL, NULL, NULL, '0', 'Mozilla', 'Windows NT 6.1', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, '0', '0', '0', '0', '0', 'http://jkysgl.com/', 'http://jkysgl.com/', NULL, NULL, NULL, 'pc', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `visitor` VALUES ('190555706', '91', '01000000000091417336671713501007', '01000000000091417336671713501007', NULL, '2019-07-27', '2019-07-27', 'http://www.sczjxx.com/ggjy/44525.html', '骨性关节炎有哪些危害呢', 'http://www.sczjxx.com/ggjy/44525.html', '骨性关节炎有哪些危害呢', '111.225.148.160', '中国', '河北省', '张家口市', '中国河北省张家口市电信', NULL, NULL, NULL, '0', 'WISE', NULL, '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, '0', '0', '0', '0', '0', 'http://www.sczjxx.com/ggjy/44525.html', 'http://www.sczjxx.com/ggjy/44525.html', NULL, NULL, NULL, 'pc', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `visitor` VALUES ('190555712', '91', '01000000000091420827335890253118', '01000000000091420827335890253118', NULL, '2019-07-27', '2019-07-27', 'http://www.sczjxx.com/ggjy/44905.html', '骨性关节炎常见的五种症状', 'http://www.sczjxx.com/ggjy/44905.html', '骨性关节炎常见的五种症状', '110.249.202.98', '中国', '河北省', '石家庄市', '中国河北省石家庄市联通', NULL, NULL, NULL, '0', 'WISE', NULL, '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, '0', '0', '0', '0', '0', 'http://www.sczjxx.com/ggjy/44905.html', 'http://www.sczjxx.com/ggjy/44905.html', NULL, NULL, NULL, 'pc', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
