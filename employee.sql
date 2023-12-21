/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : employee

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 21/12/2023 16:59:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `Id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  CONSTRAINT `employee_chk_1` CHECK (`dept_name` in (_utf8mb4'业务部',_utf8mb4'后勤部',_utf8mb4'人事部')),
  CONSTRAINT `employee_chk_2` CHECK (`emp_degree_name` in (_utf8mb4'大专',_utf8mb4'本科',_utf8mb4'研究生'))
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张一', '男', 25, '业务部', '本科');
INSERT INTO `employee` VALUES (2, '张二', '女', 26, '人事部', '本科');
INSERT INTO `employee` VALUES (3, '张三', '男', 27, '后勤部', '大专');
INSERT INTO `employee` VALUES (4, '张四', '女', 28, '人事部', '大专');
INSERT INTO `employee` VALUES (5, '张五', '男', 29, '后勤部', '大专');
INSERT INTO `employee` VALUES (6, '张六', '女', 29, '后勤部', '本科');
INSERT INTO `employee` VALUES (7, '张七', '男', 33, '业务部', '研究生');
INSERT INTO `employee` VALUES (8, '张八', '男', 32, '业务部', '本科');
INSERT INTO `employee` VALUES (9, '张九', '女', 33, '业务部', '大专');
INSERT INTO `employee` VALUES (10, '李一', '女', 45, '业务部', '研究生');
INSERT INTO `employee` VALUES (11, '李二', '女', 19, '人事部', '本科');
INSERT INTO `employee` VALUES (12, '李三', '男', 28, '业务部', '研究生');
INSERT INTO `employee` VALUES (13, '李四', '女', 46, '后勤部', '研究生');
INSERT INTO `employee` VALUES (14, '李五', '男', 58, '业务部', '大专');
INSERT INTO `employee` VALUES (15, '李六', '女', 22, '人事部', '研究生');
INSERT INTO `employee` VALUES (16, '李七', '男', 26, '后勤部', '大专');
INSERT INTO `employee` VALUES (17, '李八', '男', 25, '人事部', '研究生');
INSERT INTO `employee` VALUES (18, '李九', '女', 29, '后勤部', '研究生');
INSERT INTO `employee` VALUES (19, '王一', '男', 45, '后勤部', '本科');
INSERT INTO `employee` VALUES (20, '王二', '女', 21, '业务部', '本科');
INSERT INTO `employee` VALUES (21, '王三', '男', 21, '业务部', '大专');
INSERT INTO `employee` VALUES (22, '王四', '男', 23, '业务部', '大专');
INSERT INTO `employee` VALUES (23, '王五', '女', 33, '业务部', '大专');
INSERT INTO `employee` VALUES (24, '王六', '男', 45, '人事部', '本科');
INSERT INTO `employee` VALUES (25, '王七', '男', 35, '业务部', '研究生');
INSERT INTO `employee` VALUES (26, '王八', '男', 41, '后勤部', '本科');
INSERT INTO `employee` VALUES (27, '王九', '女', 25, '业务部', '大专');
INSERT INTO `employee` VALUES (28, '赵一', '男', 26, '人事部', '研究生');
INSERT INTO `employee` VALUES (29, '赵二', '男', 20, '后勤部', '本科');
INSERT INTO `employee` VALUES (30, '赵三', '女', 21, '人事部', '研究生');
INSERT INTO `employee` VALUES (31, '赵四', '男', 19, '后勤部', '研究生');
INSERT INTO `employee` VALUES (32, '赵五', '女', 35, '后勤部', '大专');
INSERT INTO `employee` VALUES (33, '赵六', '男', 24, '业务部', '研究生');
INSERT INTO `employee` VALUES (34, '赵七', '男', 29, '业务部', '大专');
INSERT INTO `employee` VALUES (35, '赵八', '女', 33, '业务部', '研究生');
INSERT INTO `employee` VALUES (36, '赵九', '男', 45, '业务部', '本科');

SET FOREIGN_KEY_CHECKS = 1;
