/*
 Navicat Premium Data Transfer

 Source Server         : ProjectOne
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : xgl

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/03/2023 22:04:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `emp_id` int(0) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES (1, '花花', 21, '女', '123@qq.com');
INSERT INTO `t_emp` VALUES (2, NULL, NULL, NULL, NULL);
INSERT INTO `t_emp` VALUES (3, NULL, NULL, NULL, NULL);
INSERT INTO `t_emp` VALUES (4, NULL, NULL, NULL, NULL);
INSERT INTO `t_emp` VALUES (5, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (6, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (7, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (8, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (9, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (10, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (11, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (12, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (13, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (14, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (15, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (16, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (17, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (18, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (19, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (20, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (21, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (22, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (23, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (24, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (25, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (26, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (27, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (28, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (29, '', NULL, '', '');
INSERT INTO `t_emp` VALUES (30, '', NULL, '', '');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(0) NOT NULL,
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, '张三', 87);
INSERT INTO `test` VALUES (22, '张三伞', 99);
INSERT INTO `test` VALUES (66, '公孙离', 98);
INSERT INTO `test` VALUES (333, '李四', 44);

SET FOREIGN_KEY_CHECKS = 1;
