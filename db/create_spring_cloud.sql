/*
 Navicat Premium Data Transfer

 Source Server         : louis
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : spring_cloud

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 20/05/2019 22:15:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for licenses
-- ----------------------------
DROP TABLE IF EXISTS `licenses`;
CREATE TABLE `licenses`  (
  `license_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `organization_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `license_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `license_max` int(11) NOT NULL,
  `license_allocated` int(11) NULL DEFAULT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`license_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of licenses
-- ----------------------------
INSERT INTO `licenses` VALUES ('08dbe05-606e-4dad-9d33-90ef10e334f9', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'core-prod', 'WildCat Application Gateway', 16, 16, NULL);
INSERT INTO `licenses` VALUES ('38777179-7094-4200-9d61-edb101c6ea84', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'user', 'HR-PowerSuite', 100, 4, NULL);
INSERT INTO `licenses` VALUES ('f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user', 'CustomerPro', 100, 5, NULL);
INSERT INTO `licenses` VALUES ('t9876f8c-c338-4abc-zf6a-ttt1', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user', 'suitability-plus', 200, 189, NULL);

-- ----------------------------
-- Table structure for oms_cart
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart`;
CREATE TABLE `oms_cart`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) NOT NULL,
  `product_id` bigint(255) NOT NULL,
  `puqntity` int(255) NOT NULL DEFAULT 1,
  `checked` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `payment` decimal(10, 0) NOT NULL DEFAULT 0,
  `order_status` tinyint(3) NOT NULL DEFAULT 10,
  `postage` int(11) NOT NULL DEFAULT 0,
  `began_time` timestamp(0) NULL DEFAULT NULL,
  `end_time` timestamp(0) NULL DEFAULT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `payment_time` timestamp(0) NULL DEFAULT NULL,
  `sent_time` timestamp(0) NULL DEFAULT NULL,
  `close_time` timestamp(0) NULL DEFAULT NULL,
  `user_id` bigint(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oms_order_code`(`order_code`) USING BTREE,
  INDEX `oms_order_user_id`(`user_id`) USING BTREE,
  INDEX `oms_order_product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_detail`;
CREATE TABLE `oms_order_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `detail_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `user_id` varchar(0) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `product_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `current_unit_price` decimal(10, 2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oms_order_detail_product`(`product_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_pay_info
-- ----------------------------
DROP TABLE IF EXISTS `oms_pay_info`;
CREATE TABLE `oms_pay_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  ` order_code` varchar(0) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `pay_platform` int(11) NOT NULL DEFAULT 0,
  `platform_number` varchar(0) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  ` platform_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_shipping
-- ----------------------------
DROP TABLE IF EXISTS `oms_shipping`;
CREATE TABLE `oms_shipping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `receive_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `receive_phone_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `receive_mobile_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `province_id` bigint(20) NOT NULL,
  `province_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `city_id` bigint(20) NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  ` district_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  ` district_id` bigint(20) NOT NULL,
  `street_id` int(11) NOT NULL,
  `street_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `receive_zip_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `receive_address` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for organizations
-- ----------------------------
DROP TABLE IF EXISTS `organizations`;
CREATE TABLE `organizations`  (
  `org_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `org_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `org_phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organizations
-- ----------------------------
INSERT INTO `organizations` VALUES ('442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'HR-PowerSuite', '920-555-1212');
INSERT INTO `organizations` VALUES ('e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'customer-crm-co', '823-555-1212');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `id` bigint(225) NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `order_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `began_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `goods_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, 'shop_1', 'order_1', 'admin', NULL, NULL, 'goods_1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `role_des` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `mobile_phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `registry_date` datetime(0) NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `status` int(255) NOT NULL DEFAULT 0,
  `deleted` int(255) NOT NULL DEFAULT 0,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key_sys_user_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'test', 'test', '13206033207', 'test', '2019-05-20 21:59:33', NULL, 0, 0, '627460581@qq.com');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, 'admin', 'test', NULL);

SET FOREIGN_KEY_CHECKS = 1;
