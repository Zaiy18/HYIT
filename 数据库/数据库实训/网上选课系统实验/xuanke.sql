/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : xuanke

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2015-06-19 01:28:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for think_class
-- ----------------------------
DROP TABLE IF EXISTS `think_class`;
CREATE TABLE `think_class` (
  `ClassNo` char(8) NOT NULL,
  `DepartNo` char(2) NOT NULL,
  `ClassName` char(20) NOT NULL,
  PRIMARY KEY  (`ClassNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_class
-- ----------------------------
INSERT INTO `think_class` VALUES ('001', '10', '云计算');

-- ----------------------------
-- Table structure for think_course
-- ----------------------------
DROP TABLE IF EXISTS `think_course`;
CREATE TABLE `think_course` (
  `CouNo` char(3) NOT NULL,
  `CouName` char(30) NOT NULL,
  `Kind` char(8) NOT NULL,
  `Credit` decimal(5,0) NOT NULL,
  `Teacher` char(20) NOT NULL,
  `DepartNo` char(2) NOT NULL,
  `SchoolTime` char(10) NOT NULL,
  `LimitNum` decimal(5,0) NOT NULL,
  `WillNum` decimal(5,0) NOT NULL,
  `ChooseNum` decimal(5,0) NOT NULL,
  `courseimage` varchar(255) NOT NULL,
  `CouID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`CouID`,`CouNo`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_course
-- ----------------------------
INSERT INTO `think_course` VALUES ('001', '云计算导论', '选修', '2', '黄老师', '12', '20', '50', '1', '1', '', '21');
INSERT INTO `think_course` VALUES ('002', '软件工程', '选修', '3', '谢老师', '12', '20', '50', '2', '3', '', '23');
INSERT INTO `think_course` VALUES ('003', '计算机导论', '选修', '2', '邓老师', '12', '20', '50', '3', '2', '', '24');
INSERT INTO `think_course` VALUES ('004', '安卓', '选修', '3', '胡老师', '12', '20', '50', '4', '4', '', '25');
INSERT INTO `think_course` VALUES ('005', '云应用', '选修', '2', '张老师', '12', '20', '50', '5', '6', '', '26');
INSERT INTO `think_course` VALUES ('006', 'PHP程序设计', '选修', '3', '赵老师', '12', '20', '50', '6', '5', '', '27');
INSERT INTO `think_course` VALUES ('007', 'web应用', '选修', '4', '卢老师', '12', '20', '50', '7', '8', '', '28');

-- ----------------------------
-- Table structure for think_department
-- ----------------------------
DROP TABLE IF EXISTS `think_department`;
CREATE TABLE `think_department` (
  `DepartNo` char(2) NOT NULL,
  `DepartName` char(20) NOT NULL,
  PRIMARY KEY  (`DepartNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_department
-- ----------------------------
INSERT INTO `think_department` VALUES ('10', '云计算系');

-- ----------------------------
-- Table structure for think_stucou
-- ----------------------------
DROP TABLE IF EXISTS `think_stucou`;
CREATE TABLE `think_stucou` (
  `StuNo` char(8) NOT NULL,
  `CouNo` char(3) NOT NULL,
  `WillOrder` smallint(6) NOT NULL,
  `State` char(2) NOT NULL,
  `RandomNum` char(50) default NULL,
  PRIMARY KEY  (`CouNo`,`StuNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_stucou
-- ----------------------------
INSERT INTO `think_stucou` VALUES ('12', '003', '1', '已选', null);
INSERT INTO `think_stucou` VALUES ('12', '001', '1', '已选', null);
INSERT INTO `think_stucou` VALUES ('12', '002', '1', '已选', null);
INSERT INTO `think_stucou` VALUES ('12', '004', '1', '已选', null);

-- ----------------------------
-- Table structure for think_student
-- ----------------------------
DROP TABLE IF EXISTS `think_student`;
CREATE TABLE `think_student` (
  `StuNo` char(8) NOT NULL,
  `Classno` char(8) NOT NULL,
  `StuName` char(10) NOT NULL,
  `Pwd` char(8) NOT NULL,
  PRIMARY KEY  (`StuNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_student
-- ----------------------------
INSERT INTO `think_student` VALUES ('064', '001', '888', '11');
INSERT INTO `think_student` VALUES ('1', '2', '丽丽', 'cc');
INSERT INTO `think_student` VALUES ('12', '12', '13', '22');

-- ----------------------------
-- Table structure for think_teacher
-- ----------------------------
DROP TABLE IF EXISTS `think_teacher`;
CREATE TABLE `think_teacher` (
  `TeatNo` char(8) NOT NULL,
  `DepartNo` char(2) NOT NULL,
  `TeaName` char(10) NOT NULL,
  `Pwd` char(8) NOT NULL,
  PRIMARY KEY  (`TeatNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_teacher
-- ----------------------------
INSERT INTO `think_teacher` VALUES ('0123', '10', '赵老师', '123123');
