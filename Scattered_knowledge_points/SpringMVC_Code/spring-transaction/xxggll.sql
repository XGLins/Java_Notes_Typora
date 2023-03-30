/*
 Navicat Premium Data Transfer

 Source Server         : ProjectOne
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : xxggll

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/03/2023 21:53:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `book_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `price` int(0) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '库存（无符号）',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, '斗破苍\r\n穹', 80, 100);
INSERT INTO `t_book` VALUES (2, '斗罗大陆', 50, 100);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `balance` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '余额（无符号）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默认Id；自增 1',
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号；随机生成',
  `PassWord` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `State` int(0) NOT NULL COMMENT '账号是否停用；0是正常 1是停用',
  `CreateTime` date NOT NULL COMMENT '注册日期',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `UserName`(`UserName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1000', '123456', 0, '2022-11-05');
INSERT INTO `user` VALUES (2, '1301', '123456', 0, '2022-11-05');
INSERT INTO `user` VALUES (3, '1302', '123456', 1, '2022-11-05');
INSERT INTO `user` VALUES (4, '1003', '123456', 1, '2022-11-05');
INSERT INTO `user` VALUES (6, '1007', '123', 0, '2022-11-07');
INSERT INTO `user` VALUES (7, '1008', '1234', 1, '2022-11-07');
INSERT INTO `user` VALUES (8, '1009', '000000', 1, '2022-11-07');
INSERT INTO `user` VALUES (9, '1010', '000000', 1, '2022-11-07');
INSERT INTO `user` VALUES (10, '1011', '11223344', 0, '2022-11-08');
INSERT INTO `user` VALUES (11, 'admin', '000000', 1, '2022-11-08');
INSERT INTO `user` VALUES (12, '小明1', '20', 2, '2022-11-09');
INSERT INTO `user` VALUES (15, '丽丽1', '19', 1, '2022-11-09');
INSERT INTO `user` VALUES (18, 'aaa', '12333', 3, '2022-11-14');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `UserNick` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `ShenFenZheng` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地址',
  `Email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `SexId` int(0) NULL DEFAULT NULL COMMENT '性别Id',
  `IsDianPu` int(0) NOT NULL COMMENT '是否是庖铺',
  `Money` double NOT NULL DEFAULT 0 COMMENT '余额',
  `DianPuMoney` double NOT NULL DEFAULT 0 COMMENT '庖铺余额',
  `Image` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `JianJie` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '庖铺说明',
  INDEX `UserName`(`UserName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1000', 'admin', '杨过', '112233', '四川', '0123@qq.com', '10086', 3, 1, 80000, 6000, '1.jpg', NULL);
INSERT INTO `userinfo` VALUES ('1001', 'unic', '黄蓉', '001122', '云南', '789@qq.com', '785654', 2, 1, 7000, 800, '展示.png', '描述');

SET FOREIGN_KEY_CHECKS = 1;
