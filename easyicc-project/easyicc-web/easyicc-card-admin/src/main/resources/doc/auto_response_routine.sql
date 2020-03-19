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

 Date: 18/03/2020 18:25:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auto_response_routine
-- ----------------------------
DROP TABLE IF EXISTS `auto_response_routine`;
CREATE TABLE `auto_response_routine`  (
  `自动回复状态` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自动回复状态',
  `访客与客服接通对话时，系统自动回复消息内容设置` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `当客服长时间未回复访客时，系统自动回复消息内容设置` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `内容` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `时间2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `内容2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `循环次数` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `循环回复间隔` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `时间21` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `内容22` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自动回复设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for back_type
-- ----------------------------
DROP TABLE IF EXISTS `back_type`;
CREATE TABLE `back_type`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退回类型',
  `depict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退回描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回类型设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_action_config
-- ----------------------------
DROP TABLE IF EXISTS `card_action_config`;
CREATE TABLE `card_action_config`  (
  `CARD_ACTION_CONFIG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_api_push_log
-- ----------------------------
DROP TABLE IF EXISTS `card_api_push_log`;
CREATE TABLE `card_api_push_log`  (
  `CARD_API_PUSH_LOG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_template
-- ----------------------------
DROP TABLE IF EXISTS `card_template`;
CREATE TABLE `card_template`  (
  `CARD_TEMPLATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_weixin_info
-- ----------------------------
DROP TABLE IF EXISTS `card_weixin_info`;
CREATE TABLE `card_weixin_info`  (
  `CARD_WEIXIN_INFO` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat_group
-- ----------------------------
DROP TABLE IF EXISTS `chat_group`;
CREATE TABLE `chat_group`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat_record
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record`  (
  `chart_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL,
  `VISITOR_ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPINION` int(0) NULL DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_STATIC_ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INVITE_MODE` int(0) NULL DEFAULT NULL,
  `EFFECTIVE` int(0) NULL DEFAULT NULL,
  `MSG_COUNT` int(0) NULL DEFAULT NULL,
  `SUMMARIZE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `END_TIME` datetime(0) NULL DEFAULT NULL,
  `ALL_TIME` int(0) NULL DEFAULT NULL,
  `FIRST_TIME` int(0) NULL DEFAULT NULL,
  `RESEVE_KEY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_CONNECTED` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MSG_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_MSG_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `QUESTION_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REFER_PAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COMPANY_ID` int(0) NULL DEFAULT NULL,
  `TRANS_FROM_USER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_LOCATION_CITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_LOCATION_PROVINCE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_LOCATION_COUNTRY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_IP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEARCH_ENGINE_ID` int(0) NULL DEFAULT NULL,
  `SEARCH_ENGINE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `KEYWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CLOSE_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_REQUEST_ID` int(0) NULL DEFAULT NULL,
  `IS_QC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_TIMEOUT_TIMES` int(0) NULL DEFAULT NULL,
  `CHAT_CATEGORY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GROUP_ID` int(0) NULL DEFAULT NULL,
  `IS_VIDEO` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MEET_USERS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MEET_VISITORS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MEET_VISITORS_NUM` int(0) NULL DEFAULT NULL,
  `MEET_USERS_NUM` int(0) NULL DEFAULT NULL,
  `EXT_COLUM1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT_COLUM2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT_COLUM3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT_COLUM4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT_COLUM5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXT_COLUM6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANS_TO_USER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANS_FROM_CHAT_ID` int(0) NULL DEFAULT NULL,
  `CHAT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIRST_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEARCH_HOST` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SPREAD_FLAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SITE_ID` int(0) NULL DEFAULT NULL,
  `PROMOTION_ID` int(0) NULL DEFAULT NULL,
  `CHAT_URL2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIRST_URL2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VISITOR_FIRST_TIME` datetime(0) NULL DEFAULT NULL,
  `USER_FIRST_RESP_TIME` datetime(0) NULL DEFAULT NULL,
  `LAST_MESSAGE_TIME` datetime(0) NULL DEFAULT NULL,
  `EFFECT_TIME` int(0) NULL DEFAULT NULL,
  `CHAT_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_REAL_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GROUP_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANS_FROM_USER_REAL_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANS_TO_USER_REAL_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SITE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PROMOTION_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GLOBAL_STATIC_ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROBOT_MSG_COUNT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TAG_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OVERFLOW_S_GROUP_ID` int(0) NULL DEFAULT NULL,
  `OVERFLOW_S_GROUP_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OVERFLOW_S_GROUP_QUEUE_TIME` int(0) NULL DEFAULT NULL,
  `GROUP_QUEUE_TIME` int(0) NULL DEFAULT NULL,
  `CLICK_TEXT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONTACT` int(0) NULL DEFAULT NULL,
  `USER_AGENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_USER_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_CAMPAIGIN_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_ADGROUND_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_KEYWORD_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BD_CREATIVE_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROBOT` int(0) NULL DEFAULT NULL,
  `TAKEOVER` int(0) NULL DEFAULT NULL,
  `LAST_VISITOR_MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`chart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '聊天记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_record
-- ----------------------------
INSERT INTO `chat_record` VALUES ('33215576843223040', '2020-01-31 15:46:50', '01000000000100000044226054410630', 'xieyulin', 0, NULL, '01000000000100000044226054410630', 2, 1, 7, NULL, '2020-01-31 15:48:33', 103, 8, NULL, '1', '4', '3', '0', NULL, 1, NULL, NULL, NULL, 'Internet保留地址', '172.16.1.109', -1, NULL, NULL, '1', 1967128576, NULL, 0, NULL, 2280, '0', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 6523, 0, NULL, NULL, '2020-01-31 15:47:20', '2020-01-31 15:47:48', '2020-01-31 15:48:21', 60, 'pc', '谢玉林', 'x-test2', NULL, NULL, '测试', NULL, '82c2b2d8-1414-426f-99ee-af67ce90bc14', '1', NULL, NULL, 0, NULL, 0, 0, NULL, 0, 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36', NULL, NULL, NULL, NULL, NULL, 1, 0, '88');
INSERT INTO `chat_record` VALUES ('35067428811571200', '2020-02-05 18:25:26', 'b14d72ea4be1656ad3d8a63d1ce5209e', 'xieyulin', 0, NULL, 'b14d72ea4be1656ad3d8a63d1ce5209e', 2, 1, 2, NULL, '2020-03-17 17:09:01', 11, -1, NULL, '1', '1', '1', '0', 'http://www.baidu.com/bcp', 1, NULL, '舟山市', '浙江省', '中国', '183.245.243.150', 2, 'www.baidu.com', '剖腹产痛吗', '1', -1, NULL, 0, NULL, 2280, '0', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 'imid=1e25fe56861604563e104069a3b93a3d#backbd64#bd1#mobile#zhejiang#pfcbh#004339&bd_vid=10364797436265860449', NULL, NULL, NULL, NULL, 0, 'https:\\/\\/ada.baidu.com\\xyl', NULL, '2020-02-05 18:25:32', NULL, '2020-02-05 18:25:32', 0, 'baidu-bcp', '谢玉林', 'x-test2', NULL, NULL, NULL, NULL, 'b14d72ea4be16', '1', '0', '0', 0, NULL, NULL, NULL, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, '我孩子的头发白了两三年了，他从六岁就开始白了');
INSERT INTO `chat_record` VALUES ('35306091571052544', '2020-02-06 10:13:48', 'b14d72ea4be1656ad3d8a63d1ce5209e', 'xieyulin', 0, NULL, 'b14d72ea4be1656ad3d8a63d1ce5209e', 2, 1, 3, NULL, '2020-02-06 10:14:48', 59, -1, NULL, '1', '1', '2', '0', 'http://www.baidu.com/bcp', 1, NULL, '舟山市', '浙江省', '中国', '183.245.243.150', 2, 'www.baidu.com', '剖腹产痛吗', '1', -1, NULL, 0, NULL, 2280, '0', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 'https:\\/\\/ada.baidu.com\\xyl?imid=1e25fe56861604563e104069a3b93a3d#backbd64#bd1#mobile#zhejiang#pfcbh#004339&bd_vid=10364797436265860449', NULL, 'www.baidu.com', NULL, 0, 0, 'https:\\/\\/ada.baidu.com\\xyl', NULL, '2020-02-06 10:14:10', NULL, '2020-02-06 10:14:42', 32, 'baidu-bcp', '谢玉林', 'x-test2', NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, 0, NULL, 0, 10, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, '我孩子的头发白了两三年了，他从六岁就开始白了');
INSERT INTO `chat_record` VALUES ('38306196121190400', '2020-02-14 16:55:08', '01000000000100000044226054410630', 'xieyulin', 0, NULL, '01000000000100000044226054410630', 2, 0, 1, NULL, '2020-02-14 16:55:25', 16, -1, NULL, '1', '1', '0', '0', NULL, 1, NULL, NULL, NULL, 'Internet保留地址', '172.16.1.109', -1, NULL, NULL, '2', -2051014656, NULL, 0, NULL, 2280, '0', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 6523, 0, NULL, NULL, NULL, NULL, '2020-02-14 16:55:09', 0, 'pc', '谢玉林', 'x-test2', NULL, NULL, '测试', NULL, '82c2b2d8-1414-426f-99ee-af67ce90bc14', '0', NULL, NULL, 0, NULL, 0, 0, NULL, 0, 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36', NULL, NULL, NULL, NULL, NULL, 1, 0, NULL);
INSERT INTO `chat_record` VALUES ('39739583658721280', '2020-02-18 15:50:55', '01000000000100000044226054410630', 'xieyulin', 0, NULL, '01000000000100000044226054410630', 2, 1, 4, NULL, '2020-02-18 15:51:23', 28, 1, NULL, '1', '2', '2', '0', NULL, 1, NULL, NULL, NULL, 'Internet保留地址', '172.16.1.109', -1, NULL, NULL, '1', -499122176, NULL, 0, NULL, 2280, '0', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 6523, 0, NULL, NULL, '2020-02-18 15:51:00', '2020-02-18 15:51:01', '2020-02-18 15:51:18', 18, 'pc', '谢玉林', 'x-test2', NULL, NULL, '测试', NULL, '82c2b2d8-1414-426f-99ee-af67ce90bc14', '0', NULL, NULL, 0, NULL, 0, 0, NULL, 0, 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36', NULL, NULL, NULL, NULL, NULL, 0, 0, 'uio9');

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

-- ----------------------------
-- Table structure for common_language
-- ----------------------------
DROP TABLE IF EXISTS `common_language`;
CREATE TABLE `common_language`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `常用语类别` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用语类别',
  `USER_ID` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONTENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用语内容',
  `TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_IDX` int(0) NULL DEFAULT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用语标题',
  `HOT_KEY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_language_category
-- ----------------------------
DROP TABLE IF EXISTS `common_language_category`;
CREATE TABLE `common_language_category`  (
  `ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `NOTE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARENT_ID` int(0) NULL DEFAULT NULL,
  `ORDER_IDX` int(0) NULL DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '常用语分类管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company_global_conf
-- ----------------------------
DROP TABLE IF EXISTS `company_global_conf`;
CREATE TABLE `company_global_conf`  (
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1',
  `SPENDING_TYPE` int(0) NOT NULL DEFAULT 1 COMMENT '预知访客输入1 显示 0不显示',
  `SERVER_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '结束对话弹出访客评价1 弹出0不弹出',
  `SHOW_ROBOT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_BOX_HEAD_IMG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_BOX_LEFT_SMALL_IMG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CHAT_BOX_LEFT_LARGE_IMG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SAVE_RECORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE_MSG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AUTO_ACCEPT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROBOT_UNKNOW_MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONF` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `robot_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器人显示名称',
  `ROBOT_WELCOME_MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_MODIFY_TIME` datetime(0) NULL DEFAULT NULL,
  `CUSTOMER_TIMEOUT` int(0) NULL DEFAULT NULL,
  `ONLY_FIRST_MSG` int(0) NULL DEFAULT NULL,
  `CYCLE_TIME_OF_TO_VISITOR_MSG` int(0) NULL DEFAULT NULL,
  `TIMES_OF_TO_VISITOR_MSG` int(0) NULL DEFAULT NULL,
  `CHAT_AUTO_CLOSE_TIME` int(0) NULL DEFAULT NULL,
  `CHAT_AUTO_CLOSE_MSG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONF2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_TIMEOUT` datetime(0) NULL DEFAULT NULL,
  `INTERFACE_DATAS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONF3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneOverTimeSwitch` int(0) NULL DEFAULT 1 COMMENT '手机号超时隐藏1 开启 0 关闭 ',
  `validate` int(0) NULL DEFAULT 0 COMMENT '对话是否使用验证码1 使用 0不使用',
  `onlyAChat` int(0) NULL DEFAULT 0 COMMENT '同一访客建立一通对话：1使用0 不使用 ',
  `leaveMsgSaveType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言分配方式1 分配到座席 ',
  `visitorPhoneVerification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客电话验证',
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公司全局配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cuour_card_interface
-- ----------------------------
DROP TABLE IF EXISTS `cuour_card_interface`;
CREATE TABLE `cuour_card_interface`  (
  `CUOUR_CARD_INTERFACE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cuour_card_log
-- ----------------------------
DROP TABLE IF EXISTS `cuour_card_log`;
CREATE TABLE `cuour_card_log`  (
  `CUOUR_CARD_LOG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form`  (
  `ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COMPANY_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TEMPLATE_ID` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SUCCESS_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL,
  `JS_CONFIG_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO `form` VALUES ('1251', '1', '777', NULL, 'form', '777', 'ceshi', '2018-10-09 11:39:29', '21642');
INSERT INTO `form` VALUES ('1345', '1', '1', NULL, 'form', NULL, 'ceshi', '2018-11-28 15:34:12', NULL);
INSERT INTO `form` VALUES ('2', '2', 'yue', 'yue', 'yue', 'yue', 'yue', '2018-07-03 11:54:44', '1');

-- ----------------------------
-- Table structure for form_data
-- ----------------------------
DROP TABLE IF EXISTS `form_data`;
CREATE TABLE `form_data`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FORM_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COMPANY_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JS_CONF_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for form_field
-- ----------------------------
DROP TABLE IF EXISTS `form_field`;
CREATE TABLE `form_field`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FORM_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIELD_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIELD_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FIELD_MAPPING` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SORT_INDEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUIRED` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COLUMN_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for form_field_item
-- ----------------------------
DROP TABLE IF EXISTS `form_field_item`;
CREATE TABLE `form_field_item`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIELD_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ITEM_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for html_alias
-- ----------------------------
DROP TABLE IF EXISTS `html_alias`;
CREATE TABLE `html_alias`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` int(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `ALIAS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网页别名',
  `DESP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `CREATE_USER_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL,
  `MODIFY_USER_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网页别名设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for promotion_channel
-- ----------------------------
DROP TABLE IF EXISTS `promotion_channel`;
CREATE TABLE `promotion_channel`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道名称',
  `PROMOTION_TYPE` int(0) NULL DEFAULT NULL COMMENT '匹配方式0根据嵌入代码配置1根据来源地址2根据落地页地址',
  `DESP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道描述',
  `MATCH_TYPE` int(0) NULL DEFAULT NULL COMMENT '匹配算法-1无0包含1以...开头2正则表达式',
  `MATCH_RULE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '匹配内容',
  `STATUS` int(0) NULL DEFAULT NULL COMMENT '状态0停用1启用2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接入渠道配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '\r\n校区名称',
  `depict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校区描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '校区配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site`  (
  `ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COMPANY_ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子站点名称',
  `DESP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子站点描述',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '子站点管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `depict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subject_copy1
-- ----------------------------
DROP TABLE IF EXISTS `subject_copy1`;
CREATE TABLE `subject_copy1`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `depict` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `user_login_logs`;
CREATE TABLE `user_login_logs`  (
  `ID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOGIN_TIME` datetime(0) NULL DEFAULT NULL,
  `LOGIN_OUT_TIME` datetime(0) NULL DEFAULT NULL,
  `RESIDENCE_TIME` int(0) NULL DEFAULT NULL,
  `staff_ID` int(0) NULL DEFAULT NULL,
  `STATUS_TYPE` int(0) NULL DEFAULT NULL COMMENT '状态类型0在线1忙碌2离开',
  `TYPE` int(0) NULL DEFAULT NULL,
  `STATUS` int(0) NULL DEFAULT NULL,
  `IP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MAC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_REAL_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `org_ID` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客服状态日志查询' ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for visitor_col_self
-- ----------------------------
DROP TABLE IF EXISTS `visitor_col_self`;
CREATE TABLE `visitor_col_self`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COL_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SELF_TEXT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COL_TYPE` int(0) NULL DEFAULT NULL,
  `HIDDEN` int(0) NULL DEFAULT NULL,
  `SORT_INDEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EDITABLE` int(0) NULL DEFAULT NULL,
  `REFER_TABLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUIRED` int(0) NULL DEFAULT NULL,
  `FORMATTER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for visitor_filter
-- ----------------------------
DROP TABLE IF EXISTS `visitor_filter`;
CREATE TABLE `visitor_filter`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `org_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过滤条件',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过滤模式0访客ID1IP地址2地区屏蔽',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `EXPIRES` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `USER_ID` int(0) NULL DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访客屏蔽管理' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
