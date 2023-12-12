/*
 Navicat Premium Data Transfer

 Source Server         : 本地-mysql
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/12/2023 21:40:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('Ame', 'Ameame', '123456');

-- ----------------------------
-- Table structure for approval
-- ----------------------------
DROP TABLE IF EXISTS `approval`;
CREATE TABLE `approval`  (
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacherId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `result` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `beginTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `endTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `courseName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rejectReason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `chooseReason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `confirm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `secondResult` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courseName`(`courseName`) USING BTREE,
  INDEX `studentId`(`studentId`) USING BTREE,
  INDEX `teacherId`(`teacherId`) USING BTREE,
  CONSTRAINT `approval_ibfk_1` FOREIGN KEY (`courseName`) REFERENCES `course` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `approval_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `approval_ibfk_3` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of approval
-- ----------------------------
INSERT INTO `approval` VALUES ('20216645', 'T19881122', '123321', 'end', 'true', '2023-05-28 13:03:33', '2023-05-26 11:25:39', 'Class5', 'null', '123', 'true', 'true');
INSERT INTO `approval` VALUES ('20226645', 'T19981225', '1233211', 'end', 'true', '2023-05-28 18:10:06', '2023-05-28 18:12:04', 'Chinese', '', '有点怪怪的', NULL, 'null');
INSERT INTO `approval` VALUES ('20216645', 'T19881122', '12345', 'end', 'false', '2023-05-28 20:24:52', '2023-05-28 17:33:49', 'Math', '123', '123', '', 'null');
INSERT INTO `approval` VALUES ('20236645', 'T19881122', '2321313', 'end', 'true', '2023-04-29 15:10:05', '2023-05-28 13:08:33', 'Class4', '我没吃饱！', '今天吃饱了', NULL, 'null');
INSERT INTO `approval` VALUES ('20206645', 'T19981225', '234141321', 'end', 'false', '2023-04-29 15:10:01', '2023-05-28 13:08:33', 'English', '132', '今天没下雨', NULL, 'null');
INSERT INTO `approval` VALUES ('20216645', 'T19981225', '32132113', 'unapproved', 'Null', '2023-05-28 20:25:15', '2023-05-25 20:14:16', 'English', '今天晴转多云', '111', '', 'null');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `approval` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacherName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('A103', 'Chinese', '2003-05-05 00:00:00', 'false', 'zheng');
INSERT INTO `course` VALUES ('A256', 'English', '2003-04-04 00:00:00', 'true', 'li');
INSERT INTO `course` VALUES ('A293', 'Math', '2023-04-04 00:00:00', 'true', 'huang');
INSERT INTO `course` VALUES ('B123', 'Class4', '2023-04-04 00:00:00', NULL, 'qian');
INSERT INTO `course` VALUES ('C321', 'Class5', '2023-04-04 00:00:00', NULL, 'zhao');

-- ----------------------------
-- Table structure for selection
-- ----------------------------
DROP TABLE IF EXISTS `selection`;
CREATE TABLE `selection`  (
  `stuName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `courseName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `courseId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacherName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `id`(`id`) USING BTREE,
  INDEX `courseId`(`courseId`) USING BTREE,
  CONSTRAINT `selection_ibfk_1` FOREIGN KEY (`id`) REFERENCES `approval` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `selection_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selection
-- ----------------------------
INSERT INTO `selection` VALUES ('zhangsan', 'Class5', 'C321', '20216645', 'liu', '123321');
INSERT INTO `selection` VALUES ('Lisi', 'Chinese', 'A103', '20226645', 'li', '1233211');
INSERT INTO `selection` VALUES ('zihao', 'Class4', 'B123', '20236645', 'liu', '2321313');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chosenCourse` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20206645', 'huang', '123zxc', NULL);
INSERT INTO `student` VALUES ('20216645', 'zhangsan', 'yyyzzz', '{serializeNulls:falsefactories:[Factory[typeHierarchy=com.google.gson.JsonElement,adapter=com.google.gson.internal.bind.TypeAdapters$25@7690781], com.google.gson.internal.bind.ObjectTypeAdapter$1@77eca502, com.google.gson.internal.Excluder@3246fb96, Factory[type=java.lang.String,adapter=com.google.gson.internal.bind.TypeAdapters$13@2e222612], Factory[type=java.lang.Integer+int,adapter=com.google.gson.internal.bind.TypeAdapters$7@61386958], Factory[type=java.lang.Boolean+boolean,adapter=com.google.gson.internal.bind.TypeAdapters$3@73ee04c8], Factory[type=java.lang.Byte+byte,adapter=com.google.gson.internal.bind.TypeAdapters$5@7671cb68], Factory[type=java.lang.Short+short,adapter=com.google.gson.internal.bind.TypeAdapters$6@49dc7102], Factory[type=java.lang.Long+long,adapter=com.google.gson.internal.bind.TypeAdapters$8@6b8ca3c8], Factory[type=java.lang.Double+double,adapter=com.google.gson.Gson$3@68c72235], Factory[type=java.lang.Float+float,adapter=com.google.gson.Gson$4@10959ece], Factory[type=java.lang.Number,adapter=com.google.gson.internal.bind.TypeAdapters$11@3a6bb9bf], Factory[type=java.lang.Character+char,adapter=com.google.gson.internal.bind.TypeAdapters$12@34f7cfd9], Factory[type=java.lang.StringBuilder,adapter=com.google.gson.internal.bind.TypeAdapters$16@65f095f8], Factory[type=java.lang.StringBuffer,adapter=com.google.gson.internal.bind.TypeAdapters$17@59af0466], Factory[type=java.math.BigDecimal,adapter=com.google.gson.internal.bind.TypeAdapters$14@3e6ef8ad], Factory[type=java.math.BigInteger,adapter=com.google.gson.internal.bind.TypeAdapters$15@346d61be], Factory[type=java.net.URL,adapter=com.google.gson.internal.bind.TypeAdapters$18@55536d9e], Factory[type=java.net.URI,adapter=com.google.gson.internal.bind.TypeAdapters$19@747edf66], Factory[type=java.util.UUID,adapter=com.google.gson.internal.bind.TypeAdapters$21@3d1cfad4], Factory[type=java.util.Locale,adapter=com.google.gson.internal.bind.TypeAdapters$24@62230c58], Factory[typeHierarchy=java.net.InetAddress,adapter=com.google.gson.internal.bind.TypeAdapters$20@2cd2a21f], Factory[type=java.util.BitSet,adapter=com.google.gson.internal.bind.TypeAdapters$2@2e55dd0c], com.google.gson.internal.bind.DateTypeAdapter$1@74455848, Factory[type=java.util.Calendar+java.util.GregorianCalendar,adapter=com.google.gson.internal.bind.TypeAdapters$23@e7edb54], com.google.gson.internal.bind.TimeTypeAdapter$1@378542de, com.google.gson.internal.bind.SqlDateTypeAdapter$1@3738449f, com.google.gson.internal.bind.TypeAdapters$22@69e1dd28, com.google.gson.internal.bind.ArrayTypeAdapter$1@11bd0f3b, Factory[type=java.lang.Class,adapter=com.google.gson.internal.bind.TypeAdapters$1@c333c60], com.google.gson.internal.bind.CollectionTypeAdapterFactory@79da8dc5, com.google.gson.internal.bind.MapTypeAdapterFactory@1eb5174b, com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory@67080771, com.google.gson.internal.bind.TypeAdapters$26@72cde7cc, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory@5fd4f8f5],instanceCreators:{}}');
INSERT INTO `student` VALUES ('20226645', 'Lisi', '123456', '{serializeNulls:falsefactories:[Factory[typeHierarchy=com.google.gson.JsonElement,adapter=com.google.gson.internal.bind.TypeAdapters$25@7690781], com.google.gson.internal.bind.ObjectTypeAdapter$1@77eca502, com.google.gson.internal.Excluder@3246fb96, Factory[type=java.lang.String,adapter=com.google.gson.internal.bind.TypeAdapters$13@2e222612], Factory[type=java.lang.Integer+int,adapter=com.google.gson.internal.bind.TypeAdapters$7@61386958], Factory[type=java.lang.Boolean+boolean,adapter=com.google.gson.internal.bind.TypeAdapters$3@73ee04c8], Factory[type=java.lang.Byte+byte,adapter=com.google.gson.internal.bind.TypeAdapters$5@7671cb68], Factory[type=java.lang.Short+short,adapter=com.google.gson.internal.bind.TypeAdapters$6@49dc7102], Factory[type=java.lang.Long+long,adapter=com.google.gson.internal.bind.TypeAdapters$8@6b8ca3c8], Factory[type=java.lang.Double+double,adapter=com.google.gson.Gson$3@68c72235], Factory[type=java.lang.Float+float,adapter=com.google.gson.Gson$4@10959ece], Factory[type=java.lang.Number,adapter=com.google.gson.internal.bind.TypeAdapters$11@3a6bb9bf], Factory[type=java.lang.Character+char,adapter=com.google.gson.internal.bind.TypeAdapters$12@34f7cfd9], Factory[type=java.lang.StringBuilder,adapter=com.google.gson.internal.bind.TypeAdapters$16@65f095f8], Factory[type=java.lang.StringBuffer,adapter=com.google.gson.internal.bind.TypeAdapters$17@59af0466], Factory[type=java.math.BigDecimal,adapter=com.google.gson.internal.bind.TypeAdapters$14@3e6ef8ad], Factory[type=java.math.BigInteger,adapter=com.google.gson.internal.bind.TypeAdapters$15@346d61be], Factory[type=java.net.URL,adapter=com.google.gson.internal.bind.TypeAdapters$18@55536d9e], Factory[type=java.net.URI,adapter=com.google.gson.internal.bind.TypeAdapters$19@747edf66], Factory[type=java.util.UUID,adapter=com.google.gson.internal.bind.TypeAdapters$21@3d1cfad4], Factory[type=java.util.Locale,adapter=com.google.gson.internal.bind.TypeAdapters$24@62230c58], Factory[typeHierarchy=java.net.InetAddress,adapter=com.google.gson.internal.bind.TypeAdapters$20@2cd2a21f], Factory[type=java.util.BitSet,adapter=com.google.gson.internal.bind.TypeAdapters$2@2e55dd0c], com.google.gson.internal.bind.DateTypeAdapter$1@74455848, Factory[type=java.util.Calendar+java.util.GregorianCalendar,adapter=com.google.gson.internal.bind.TypeAdapters$23@e7edb54], com.google.gson.internal.bind.TimeTypeAdapter$1@378542de, com.google.gson.internal.bind.SqlDateTypeAdapter$1@3738449f, com.google.gson.internal.bind.TypeAdapters$22@69e1dd28, com.google.gson.internal.bind.ArrayTypeAdapter$1@11bd0f3b, Factory[type=java.lang.Class,adapter=com.google.gson.internal.bind.TypeAdapters$1@c333c60], com.google.gson.internal.bind.CollectionTypeAdapterFactory@79da8dc5, com.google.gson.internal.bind.MapTypeAdapterFactory@1eb5174b, com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory@67080771, com.google.gson.internal.bind.TypeAdapters$26@72cde7cc, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory@5fd4f8f5],instanceCreators:{}}');
INSERT INTO `student` VALUES ('20236645', 'hao', '123', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unApprovedCourse` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('T19881122', 'liu', '123456', NULL);
INSERT INTO `teacher` VALUES ('T19981225', 'li', '1234567', NULL);

SET FOREIGN_KEY_CHECKS = 1;
