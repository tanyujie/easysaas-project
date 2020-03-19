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

 Date: 17/03/2020 16:55:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `chat_record_detail`;
CREATE TABLE `chat_record_detail`  (
  `recorder_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` date NULL DEFAULT NULL COMMENT '发送时间',
  `chat_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聊天记录ID',
  `message` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送消息',
  `from_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织id',
  `sender_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题id',
  `robot` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`recorder_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '聊天记录明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_record_detail
-- ----------------------------
INSERT INTO `chat_record_detail` VALUES ('35060183935746048', '2020-02-05', '35060177707204608', 'xieyulin', '我是今天的值班客服，请问您需要咨询哪方面的问题？为了更好的服务效果，请在对话结束后对我的服务满意度进行评价，非常感谢您的支持!', 'RECORD_RICH_TEXT', NULL, '0', '-1', 1);
INSERT INTO `chat_record_detail` VALUES ('35066211804905472', '2020-02-05', '35066210026520576', 'xieyulin', '我是今天的值班客服，请问您需要咨询哪方面的问题？为了更好的服务效果，请在对话结束后对我的服务满意度进行评价，非常感谢您的支持!', 'RECORD_RICH_TEXT', NULL, '0', '-1', 1);
INSERT INTO `chat_record_detail` VALUES ('40812515701030912', '2020-02-21', '40812489176252416', 'xieyulin', '123', 'RECORD_RECORD', NULL, '0', '-1', 0);
INSERT INTO `chat_record_detail` VALUES ('43384818628558848', '2020-02-28', '43384817953275904', 'o4t2UuN2bAbpJwkosYidvXxitcHE', '7好', 'RECORD_RECORD', NULL, '1', '-1', 0);

SET FOREIGN_KEY_CHECKS = 1;
