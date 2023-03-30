/*
 Navicat Premium Data Transfer

 Source Server         : ProjectOne
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : hnsm

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/03/2023 22:02:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for _sex
-- ----------------------------
DROP TABLE IF EXISTS `_sex`;
CREATE TABLE `_sex`  (
  `Sexld` int(0) NOT NULL AUTO_INCREMENT COMMENT '性别Id',
  `SexName` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Sexld`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of _sex
-- ----------------------------
INSERT INTO `_sex` VALUES (1, '男');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `Image` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Banner 图',
  `BgColor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '背景颜色',
  `Href` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Uri 连接',
  `IsTingYong` int(0) NOT NULL COMMENT '是否停用；0正常1停用',
  `备注` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for daohangtiao
-- ----------------------------
DROP TABLE IF EXISTS `daohangtiao`;
CREATE TABLE `daohangtiao`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `DaoHangTiaoName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导航条名称',
  `Href` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Uri 连接',
  `IsTingYong` int(0) NOT NULL COMMENT '是否停用',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of daohangtiao
-- ----------------------------

-- ----------------------------
-- Table structure for dingdanbiao
-- ----------------------------
DROP TABLE IF EXISTS `dingdanbiao`;
CREATE TABLE `dingdanbiao`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `DingDanNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `ZhuRenUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖家账号',
  `Price` double NOT NULL COMMENT '订单金额',
  `StateId` int(0) NOT NULL COMMENT '订单状态 id',
  `CreateTime` date NOT NULL COMMENT '下单时间',
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家账号',
  `ZhiFuId` int(0) NOT NULL COMMENT '支付方式 Id',
  `Address` int(0) NOT NULL COMMENT '收货地址 Id',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dingdanbiao
-- ----------------------------

-- ----------------------------
-- Table structure for dingdanstate
-- ----------------------------
DROP TABLE IF EXISTS `dingdanstate`;
CREATE TABLE `dingdanstate`  (
  `StateId` int(0) NOT NULL COMMENT '订单状态 Id',
  `StateName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态名称'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dingdanstate
-- ----------------------------

-- ----------------------------
-- Table structure for dingdanxiangqing
-- ----------------------------
DROP TABLE IF EXISTS `dingdanxiangqing`;
CREATE TABLE `dingdanxiangqing`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `DingDanNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `ShopId` int(0) NOT NULL COMMENT '商品 Id',
  `ChiCui` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尺寸',
  `Color` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '颜色',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dingdanxiangqing
-- ----------------------------

-- ----------------------------
-- Table structure for gouwuche
-- ----------------------------
DROP TABLE IF EXISTS `gouwuche`;
CREATE TABLE `gouwuche`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `ShopName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品标题',
  `ChiCui` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尺寸',
  `Color` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '颜色',
  `Count` int(0) NOT NULL COMMENT '数量',
  `Price` double NOT NULL COMMENT '单价',
  `Image` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图片',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gouwuche
-- ----------------------------

-- ----------------------------
-- Table structure for jibeninfo
-- ----------------------------
DROP TABLE IF EXISTS `jibeninfo`;
CREATE TABLE `jibeninfo`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `Key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '键',
  `Value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jibeninfo
-- ----------------------------

-- ----------------------------
-- Table structure for pinglun
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `ShopId` int(0) NOT NULL COMMENT '商品 Id',
  `ZhuRenUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖家账号',
  `Context` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的内容',
  `ZiJiUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家账号',
  `CreateTime` date NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pinglun
-- ----------------------------

-- ----------------------------
-- Table structure for shaddress
-- ----------------------------
DROP TABLE IF EXISTS `shaddress`;
CREATE TABLE `shaddress`  (
  `Id` int(0) NOT NULL COMMENT '默讣 Id',
  `UserName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `BYPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备用手机号',
  `City` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在地区',
  `Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `Lable` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shaddress
-- ----------------------------

-- ----------------------------
-- Table structure for shopcolor
-- ----------------------------
DROP TABLE IF EXISTS `shopcolor`;
CREATE TABLE `shopcolor`  (
  `ShopId` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品 id',
  `Color` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '颜色参数',
  `S_Img` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小图',
  `B_Img` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '大图',
  PRIMARY KEY (`ShopId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shopcolor
-- ----------------------------

-- ----------------------------
-- Table structure for shopinfo
-- ----------------------------
DROP TABLE IF EXISTS `shopinfo`;
CREATE TABLE `shopinfo`  (
  `ShopId` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品 Id',
  `ShopName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `ShopMiaoShu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品描述',
  `ShopPrice` double NOT NULL COMMENT '商品价格',
  `ChiCun` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尺寸',
  `Color` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品颜色',
  `ZhuRenUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖家账号',
  `ShopTypeId` int(0) NOT NULL COMMENT '商品类别 id',
  `Image` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品封面图',
  `Context` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品介绍',
  `CreateTime` date NOT NULL COMMENT '商品发表日期',
  PRIMARY KEY (`ShopId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shopinfo
-- ----------------------------

-- ----------------------------
-- Table structure for shopmingxi
-- ----------------------------
DROP TABLE IF EXISTS `shopmingxi`;
CREATE TABLE `shopmingxi`  (
  `ShopId` int(0) NOT NULL COMMENT '商品 id',
  `SImg` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品小图',
  `BImg` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品大图'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shopmingxi
-- ----------------------------

-- ----------------------------
-- Table structure for shoptype
-- ----------------------------
DROP TABLE IF EXISTS `shoptype`;
CREATE TABLE `shoptype`  (
  `ShopTypeId` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品 id',
  `ShopTypeName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类别名称',
  PRIMARY KEY (`ShopTypeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shoptype
-- ----------------------------

-- ----------------------------
-- Table structure for shouyeshop
-- ----------------------------
DROP TABLE IF EXISTS `shouyeshop`;
CREATE TABLE `shouyeshop`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默讣 Id',
  `ShopId` int(0) NOT NULL COMMENT '商品 Id',
  `ShopTypeId` int(0) NOT NULL COMMENT '商品类型 Id',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shouyeshop
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '默认Id；自增 1',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号；随机生成',
  `passWord` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `State` int(0) NOT NULL DEFAULT 0 COMMENT '账号是否停用；0是正常 1是停用',
  `CreateTime` date NULL DEFAULT NULL COMMENT '注册日期',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 0, '2022-11-21');
INSERT INTO `user` VALUES (2, 'tom', '123456', 0, '2022-11-21');
INSERT INTO `user` VALUES (3, 'sandy', '123456', 0, '2022-11-21');
INSERT INTO `user` VALUES (5, '1000', '123456', 0, '2022-11-05');

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
  `JianJie` varchar(9999) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '庖铺说明'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('admin', 'hahah', '张三丰', '10010110101', '四川成都', '2819194126@qq.com', '18876524569', 1, 0, 20000, 15000, '3.jpg', '卖零食');
INSERT INTO `userinfo` VALUES ('tom', 'heiheiehi', '李兴', '10010114141', '四川遂宁', '3289708767@qq.com', '11876548796', 1, 0, 4000, 70000, '4.jpg', '卖衣服');

-- ----------------------------
-- Table structure for zhifutype
-- ----------------------------
DROP TABLE IF EXISTS `zhifutype`;
CREATE TABLE `zhifutype`  (
  `ZhiFuId` int(0) NOT NULL COMMENT '支付方式 Id',
  `ZhiFuName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付方式名称',
  PRIMARY KEY (`ZhiFuId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhifutype
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
