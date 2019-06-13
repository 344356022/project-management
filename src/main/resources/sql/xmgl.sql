/*
Navicat MySQL Data Transfer

Source Server         : gedi
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : xmgl

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-06-13 15:47:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action_item
-- ----------------------------
DROP TABLE IF EXISTS `action_item`;
CREATE TABLE `action_item` (
  `a_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务项主键ID',
  `a_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务项名称',
  `a_pstart_time` date default NULL COMMENT '计划开始时间',
  `a_pend_time` date default NULL COMMENT '计划结束时间',
  `a_astart_time` date default NULL COMMENT '实际开始时间',
  `a_aend_time` date default NULL COMMENT '实际结束时间',
  `a_percentage` int(11) default NULL COMMENT '完成百分比',
  `a_state` int(5) default NULL COMMENT '状态  01-未开始、02-进行中、03-已完成',
  `a_is_result` int(5) default NULL COMMENT '成果是否提交  01待提交、02已提交',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务项创建人',
  `create_time` date default NULL COMMENT '任务项创建时间',
  `ts_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务子类ID',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划表主键',
  `p_project_phase_id` int(10) default NULL COMMENT '项目阶段ID 1-需求分析、2-数据处理、3-系统开发',
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of action_item
-- ----------------------------
INSERT INTO `action_item` VALUES ('00d440ce38b3486dab9d44a1701cd125', '汇总指标梳理过程问题', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '70d1de0d950b4fcd938a561e4dd922c6', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('02883c237e4f4797a7155d96619ddfad', '生产环境发布', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'aec72143696949d6a23798d8fffe7949', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('0d99f974e9704399b50e839993092256', '前后端开发（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '95164fcfcc0d4c279e0bd77f6ff170d0', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('114e3c85dfdd4d2d9f61358864482f96', '系统功能测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '7710719964d34bdb8562e89d19f18428', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('1da86c4bcd4b449ab1b7ef6504549832', '评审数据链路流转方案', '1994-12-31', '1994-12-31', '1994-12-31', '1994-12-31', '50', '1', '1', '张帅', '2019-06-05', '2e0ce4f866dc459b9a495330c1885d22', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('21f7b679ae29402984b1ed58f04e4eca', '需求调研及梳理', '2019-03-15', '2019-03-22', '2019-03-15', '2019-06-05', '100', '1', '1', '王炎彬', '2019-05-31', '437f8f5df86345ce9659af33c31a054f', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('26182818ebb34c6ebd459eee565ff66c', '数据库设置', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '95164fcfcc0d4c279e0bd77f6ff170d0', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('2a1d884c4fc94dbf992922add5247fcb', '前后端联调（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '95164fcfcc0d4c279e0bd77f6ff170d0', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('2ae029f6f27b4e4a86c1e118e0cf8021', '测试用例编写', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '263d012e3ee04c9cab59bcaeeb796b6f', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('2cf15e17b8184ae792868a17184826ca', '项目工作汇报', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'bfd9f701034b45899626d977ec7ad19f', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('381a95d4ec5c404c844f5e786970d8c1', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'd279a4ba4d2e41d9bf8c66b6cdb7d7e5', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('444019bc4c5845c08a85c6db41232fb8', '业务原型草图', '2019-06-14', '2019-06-05', '2019-06-15', '2019-06-05', '50', '2', '1', '张帅', '2019-06-05', 'f7568acae50e43af8ae551485df67d05', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('4737d22a3e3d4993b26f6af9cb40783b', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'b6910b3a2cc64e30b90201ffb6ad3fe1', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('483da0e9776347568b0ace9b700e184f', '数据指标清单表', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '20', '1', '1', '张帅', '2019-06-05', '0bad05640f944dfd99f45a4a67c6a88c', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('5131b979438b4ad7b877d5b67de61f04', '开发环境搭建', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '95164fcfcc0d4c279e0bd77f6ff170d0', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('5aafe8b19f0e421cb6fb8ff914c90580', null, '2019-06-13', '2019-06-13', '2019-06-13', '2019-06-13', '100', '1', '1', '张帅', '2019-06-13', 'e35206ebf4ea4953b8d594a515cfb56d', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('5fb97a5c57dd41ed802ad7880889b471', '汇总指标算法', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '0c1b94f38c7c4f27806d391839ce0449', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('60d9d091ad374aaa86854d98313a03c7', '评审数据设计方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '17275cc689e749aba3d354cd9c20ab13', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('6b7972febc83490080b5b747cf76a743', '设计表结构', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'e5b91428fccc456793fd2ba04a345fe4', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('73ddc58bc9984bc994e7ed9a716b7ec4', '原型确定', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'f688b8bad795449bac3482da47c08d45', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('79355b6de24e4d1eb9860a1c43502df7', '编写需求文档（开发版）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'b1e1460b08924088ab5caca212fa7f69', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('84b8122e20454cd19518eead16c8bfef', '评审表数据逻辑关系', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '7ee1f4ed54514ae0b630cad094ee0314', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('88a294364fec448587e08fcf0cd3d89a', '汇总整理所有涉及指标', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '6ddc94eaa14445d490e72013b8cb8499', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('8a4d353873e947b8ab81eafdea113b27', '评审数据字典文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '25c3fb4396824da3a64d6a35633c9595', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('91a140a700d248d887909ae9ac19b743', '单个指标梳理文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '009c57ab461248a4986554bb56ca91b7', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('924866009d3e41f9b665e153209507f5', '测试环境系统功能验证', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '212cf1a61dbc4d6496937ae82d0fcf90', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('9c5151d1ee074f91b155e2492fcd53a1', '数据同步及联调', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'aec72143696949d6a23798d8fffe7949', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('9dd5b08529414c8f88080802b79769c9', '编写需求文档（用户版）', '2019-05-31', '2019-07-03', '2019-05-31', '2019-06-30', '100', '1', '1', '王炎彬', '2019-05-31', 'f7568acae50e43af8ae551485df67d05', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('a2f6ecbc00294dd0ba143ed0e7590163', '原型设计', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'f688b8bad795449bac3482da47c08d45', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('a3a996c3a7974d06bebd22e5ad07f5b3', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'b21aa7483b524b2a8515a8ed386ade6f', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('a4fe9590438543f38182bbc281a9a961', '确认需求文档（用户版）', '2020-06-05', '2020-06-05', '2020-06-05', '2020-06-05', '50', '1', '1', '张帅', '2019-06-05', 'f7568acae50e43af8ae551485df67d05', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('aa7f82b4137a4729a3574c75532a39c1', '前后端开发（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '95164fcfcc0d4c279e0bd77f6ff170d0', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('ac3a13fb7f8747c0a579c7aae5bacf3a', '确定需求文档（开发版）', '2019-06-09', '2019-06-05', '2019-06-05', '2019-06-05', '30', '1', '1', '张帅', '2019-06-05', 'b1e1460b08924088ab5caca212fa7f69', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('b70ba3be92e34aa284618615cf07c6dc', '编写数据链路流转方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '2e0ce4f866dc459b9a495330c1885d22', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('bccf391a625242b1a21c58e131b93f80', '编写表数据逻辑关系', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '7ee1f4ed54514ae0b630cad094ee0314', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('c5dbdb7e958f474da920dedf0fff0475', '编写数据设计方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '17275cc689e749aba3d354cd9c20ab13', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('c5f2d0ae317247d1b01e3f99d447b173', 'ETL程序测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'c41525f2f837487f8dc4270d7cd7c973', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('c77511dd42a94ca9a90d059e51ef684e', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '1bd1f6f22073417a83effe96663f9729', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('d45c6a5f6422457fbbb444f3a26ec0d1', '生产环境搭建', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'aec72143696949d6a23798d8fffe7949', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');
INSERT INTO `action_item` VALUES ('d461243d47524f0b9bbdbce12d1c4474', '系统上线', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '4a9f03bc564f4e0eb280ab69c62d2f4a', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('d6f05985c5c744bf9b40fdb0f7994ddd', '验收文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'a6940f854a3541ae8564d5f3e055a9e7', 'e6b0fda2b9a34d34aaa32e797adb2008', '1');
INSERT INTO `action_item` VALUES ('d9c20bfe6cfd4e04a10b2d7fa4dda2a9', '评审表结构', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'e5b91428fccc456793fd2ba04a345fe4', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('db0e83d5861b40588c30dd67489160e1', '指标数据核查（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '5ad1fe0abebd4c4399fa8b9ff41820d2', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('f04e2c0c4f704447839bc9f91c16eea5', 'ETL程序开发', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', 'c41525f2f837487f8dc4270d7cd7c973', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('f5fe465282454e37b5bf3fad320da060', '数据链路清单', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '7ebb5c284a8e4284ba19c3fc658b32f4', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('f946da57c2b44072932260d36b3704e0', '二次指标数据核查（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '88e704ed4c354f24a96aa5580d494a03', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('f977c643b45041b78784b7ec2c0eacb2', '编写数据字典文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '25c3fb4396824da3a64d6a35633c9595', 'e6b0fda2b9a34d34aaa32e797adb2008', '2');
INSERT INTO `action_item` VALUES ('fb6f6dbb1f964d9982e9340a1cd744e9', '系统回归测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05', '7710719964d34bdb8562e89d19f18428', 'e6b0fda2b9a34d34aaa32e797adb2008', '3');

-- ----------------------------
-- Table structure for journal
-- ----------------------------
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal` (
  `rb_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '日报主键ID',
  `w_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '周计划主键ID',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划主键ID',
  `a_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务项ID',
  `user_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '责任人ID',
  `finish` int(11) default NULL COMMENT '完成进度',
  `finish_content` varchar(500) collate utf8_unicode_ci default NULL COMMENT '完成内容',
  `finish_process` decimal(10,1) default NULL COMMENT '完成工时',
  `deliver` varchar(20) collate utf8_unicode_ci default NULL COMMENT '抄送人',
  `create_time` datetime default NULL,
  `creater` varchar(20) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`rb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of journal
-- ----------------------------

-- ----------------------------
-- Table structure for project_plan
-- ----------------------------
DROP TABLE IF EXISTS `project_plan`;
CREATE TABLE `project_plan` (
  `p_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '项目总计划表主键',
  `p_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '项目名称',
  `p_start_time` date default NULL COMMENT '项目计划开始时间',
  `p_end_time` date default NULL COMMENT '项目计划结束时间',
  `p_project_phase_id` int(10) default NULL COMMENT '项目阶段ID 1-需求分析、2-数据处理、3-系统开发',
  `p_progress` int(10) default NULL COMMENT '项目总体完成进度',
  `create_time` date default NULL COMMENT '项目创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '项目创建人',
  PRIMARY KEY  (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of project_plan
-- ----------------------------
INSERT INTO `project_plan` VALUES ('99975cbb4d5145dd96ad45622dfe496a', '项目建设进度', '2018-11-06', '2019-01-31', '1', '100', '2019-05-31', '王炎彬');
INSERT INTO `project_plan` VALUES ('a60f4827847047ef92529de6194b22c9', '项目环节合规性监测', '2018-11-07', '2019-01-31', '1', '100', '2019-06-04', '张帅');
INSERT INTO `project_plan` VALUES ('e6b0fda2b9a34d34aaa32e797adb2008', '市县经营评价', '2018-11-05', '2019-01-31', '1', '100', '2019-05-31', '王炎彬');

-- ----------------------------
-- Table structure for project_user_medium
-- ----------------------------
DROP TABLE IF EXISTS `project_user_medium`;
CREATE TABLE `project_user_medium` (
  `id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '主键ID',
  `user_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '用户ID',
  `a_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务项ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of project_user_medium
-- ----------------------------
INSERT INTO `project_user_medium` VALUES ('02144724e1e04858ae66f65fe522cb11', '010919d873d649b6bba89c2b8c33556f', '114e3c85dfdd4d2d9f61358864482f96');
INSERT INTO `project_user_medium` VALUES ('0d95d7f76c3a468c93d797416d9d9b02', '6515522b010b400da4b872f65a3434b3', 'aa7f82b4137a4729a3574c75532a39c1');
INSERT INTO `project_user_medium` VALUES ('0fea6a0520e54d918d94e604adff4f0f', '38563d5a812148a6b8a36d574457a3de', '9c5151d1ee074f91b155e2492fcd53a1');
INSERT INTO `project_user_medium` VALUES ('13f9ff14f26e43c090a6051750b34310', null, 'a4fe9590438543f38182bbc281a9a961');
INSERT INTO `project_user_medium` VALUES ('212eda7d77b34192951dce6ec2f01767', null, '9dd5b08529414c8f88080802b79769c9');
INSERT INTO `project_user_medium` VALUES ('2743a6e12db24d448e1ded9b9aa48356', null, 'ac3a13fb7f8747c0a579c7aae5bacf3a');
INSERT INTO `project_user_medium` VALUES ('3161b93dac4246138ccb68521182fb4a', 'ac68801e62ed4ed1a26d1f4ed807be4a', '8bbad7c1efce4075b2df948535b0c5e6');
INSERT INTO `project_user_medium` VALUES ('45d8a7666a334a40840cb681c228f53e', '04061d9cbfec49a3a1ac8816e67f14b9', '2a1d884c4fc94dbf992922add5247fcb');
INSERT INTO `project_user_medium` VALUES ('5108644aa365446986beeed9d420b868', null, '444019bc4c5845c08a85c6db41232fb8');
INSERT INTO `project_user_medium` VALUES ('5633df0281344b769949b772611d13d6', null, 'd461243d47524f0b9bbdbce12d1c4474');
INSERT INTO `project_user_medium` VALUES ('5841f4da047f4d62b7874d4bb1d3054e', '38563d5a812148a6b8a36d574457a3de', 'd45c6a5f6422457fbbb444f3a26ec0d1');
INSERT INTO `project_user_medium` VALUES ('70bc980a11bc400789f9bc94a768711b', 'ac68801e62ed4ed1a26d1f4ed807be4a', '26182818ebb34c6ebd459eee565ff66c');
INSERT INTO `project_user_medium` VALUES ('7ba809b87e884d15854352f4f1a5230c', '010919d873d649b6bba89c2b8c33556f', 'fb6f6dbb1f964d9982e9340a1cd744e9');
INSERT INTO `project_user_medium` VALUES ('833e577dc6854138971afd720610455c', '010919d873d649b6bba89c2b8c33556f', '2ae029f6f27b4e4a86c1e118e0cf8021');
INSERT INTO `project_user_medium` VALUES ('8ecd5f44120e4ae0971a886c6098f3a1', null, '79355b6de24e4d1eb9860a1c43502df7');
INSERT INTO `project_user_medium` VALUES ('ad55ed70902444f98f224ea754b7913f', '6515522b010b400da4b872f65a3434b3', '5131b979438b4ad7b877d5b67de61f04');
INSERT INTO `project_user_medium` VALUES ('ca5714c5b8c145f8843a3cf612fdcb64', '04061d9cbfec49a3a1ac8816e67f14b9', '0d99f974e9704399b50e839993092256');
INSERT INTO `project_user_medium` VALUES ('cbd37109747a4f1dba8c3618fd65e35e', null, '924866009d3e41f9b665e153209507f5');
INSERT INTO `project_user_medium` VALUES ('da70ff9a48864e56a44adabcfad75e9f', null, 'd6f05985c5c744bf9b40fdb0f7994ddd');
INSERT INTO `project_user_medium` VALUES ('de05ac03a0644ad2b1192074e81ddb0c', null, '73ddc58bc9984bc994e7ed9a716b7ec4');
INSERT INTO `project_user_medium` VALUES ('e4ce583e99c24f7fa36a3ec794364530', '38563d5a812148a6b8a36d574457a3de', '02883c237e4f4797a7155d96619ddfad');
INSERT INTO `project_user_medium` VALUES ('e59d96f598c8439dbc6ff5c3d21dc122', null, '2cf15e17b8184ae792868a17184826ca');
INSERT INTO `project_user_medium` VALUES ('e88840257a454f0d8c9f01eec60a9f41', null, '21f7b679ae29402984b1ed58f04e4eca');
INSERT INTO `project_user_medium` VALUES ('f88df01fe3b244bfaf2276d499cb4cc7', null, 'a2f6ecbc00294dd0ba143ed0e7590163');

-- ----------------------------
-- Table structure for task_class
-- ----------------------------
DROP TABLE IF EXISTS `task_class`;
CREATE TABLE `task_class` (
  `t_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务类主键ID',
  `t_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务类名称',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划表主键',
  `create_time` date default NULL COMMENT '任务类创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务类创建人',
  `p_project_phase_id` int(20) default NULL COMMENT '项目阶段ID 01-需求分析、02-数据处理、03-系统开发',
  `sort_id` int(10) default NULL COMMENT '用于排序的ID',
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task_class
-- ----------------------------
INSERT INTO `task_class` VALUES ('19c179bbe8cd4603a5a7f541f1e59bc2', '数据库最终结果表结构设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '7');
INSERT INTO `task_class` VALUES ('233b6818b2ce44929dc316ff5166611d', '指标数验证、数据质量稽核', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '11');
INSERT INTO `task_class` VALUES ('2c5a968a89994633b7cc251359acc313', '数据验证', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '8');
INSERT INTO `task_class` VALUES ('2d6b10e2ca2e486ca3dfa8bc367e3cb1', '指标明细编制', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '6');
INSERT INTO `task_class` VALUES ('38c0d1f18426483cbb72c7d5b6517156', '数据接入方案确认、数据库设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '9');
INSERT INTO `task_class` VALUES ('876752c7d0a2480f946bac785aa0a4d8', '数据链路设计及线上数据流转', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '12');
INSERT INTO `task_class` VALUES ('8ed7eabb4e4841c4ab39a1fb4d9a8669', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31', '王炎彬', '1', '3');
INSERT INTO `task_class` VALUES ('aaba14e91e434f5e8f4ed017f579cbc4', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '3', '15');
INSERT INTO `task_class` VALUES ('b464e2c7e9bb43f485c481f71d3029ac', '原型设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31', '王炎彬', '1', '2');
INSERT INTO `task_class` VALUES ('caa0db31b8ef4661ba070bc4e6d9e215', '系统开发', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '3', '13');
INSERT INTO `task_class` VALUES ('d5b5655a246c43fe8bdf5eb657aae7d8', '数据库开发', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '10');
INSERT INTO `task_class` VALUES ('dd4cb202818747a08dd60d6e9c635eb9', '项目验收', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-03', '张帅', '1', '4');
INSERT INTO `task_class` VALUES ('e8362f9a69ce4ab297eb47aa672bb917', '指标数据需求调研及确定', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '2', '5');
INSERT INTO `task_class` VALUES ('efa9de57ccab4358bc18d0a7bd43f99a', '需求分析', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31', '王炎彬', '1', '1');
INSERT INTO `task_class` VALUES ('fe18f44faa7d41b9936329fb7dbd9ac3', '系统测试', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04', '张帅', '3', '14');

-- ----------------------------
-- Table structure for task_subclass
-- ----------------------------
DROP TABLE IF EXISTS `task_subclass`;
CREATE TABLE `task_subclass` (
  `ts_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务子类主键ID',
  `ts_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务子类名称',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划表主键',
  `t_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务类ID',
  `create_time` date default NULL COMMENT '任务子类创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务子类创建人',
  PRIMARY KEY  (`ts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task_subclass
-- ----------------------------
INSERT INTO `task_subclass` VALUES ('009c57ab461248a4986554bb56ca91b7', '指标整理明细表', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('0bad05640f944dfd99f45a4a67c6a88c', '指标数据需求调研及确定', 'e6b0fda2b9a34d34aaa32e797adb2008', 'e8362f9a69ce4ab297eb47aa672bb917', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('0c1b94f38c7c4f27806d391839ce0449', '指标计算汇总文档', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('17275cc689e749aba3d354cd9c20ab13', '数据设计方案', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('1bd1f6f22073417a83effe96663f9729', '视图', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('212cf1a61dbc4d6496937ae82d0fcf90', '测试环境系统功能验证', 'e6b0fda2b9a34d34aaa32e797adb2008', '8ed7eabb4e4841c4ab39a1fb4d9a8669', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('25c3fb4396824da3a64d6a35633c9595', '数据字典', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('263d012e3ee04c9cab59bcaeeb796b6f', '测试准备', 'e6b0fda2b9a34d34aaa32e797adb2008', 'fe18f44faa7d41b9936329fb7dbd9ac3', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('2e0ce4f866dc459b9a495330c1885d22', '线上数据流转', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('437f8f5df86345ce9659af33c31a054f', '需求调研及梳理', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-05-31', '王炎彬');
INSERT INTO `task_subclass` VALUES ('4a9f03bc564f4e0eb280ab69c62d2f4a', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '8ed7eabb4e4841c4ab39a1fb4d9a8669', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('5ad1fe0abebd4c4399fa8b9ff41820d2', '数据核查', 'e6b0fda2b9a34d34aaa32e797adb2008', '2c5a968a89994633b7cc251359acc313', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('6ddc94eaa14445d490e72013b8cb8499', '指标整理汇总表', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('70d1de0d950b4fcd938a561e4dd922c6', '指标整理问题清单', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('7710719964d34bdb8562e89d19f18428', '系统测试', 'e6b0fda2b9a34d34aaa32e797adb2008', 'fe18f44faa7d41b9936329fb7dbd9ac3', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('7ebb5c284a8e4284ba19c3fc658b32f4', '汇总所有数据链路', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('7ee1f4ed54514ae0b630cad094ee0314', '数据库逻辑关系', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('88e704ed4c354f24a96aa5580d494a03', '二次差异对比表', 'e6b0fda2b9a34d34aaa32e797adb2008', '233b6818b2ce44929dc316ff5166611d', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('95164fcfcc0d4c279e0bd77f6ff170d0', '功能开发', 'e6b0fda2b9a34d34aaa32e797adb2008', 'caa0db31b8ef4661ba070bc4e6d9e215', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('a6940f854a3541ae8564d5f3e055a9e7', '验收材料', 'e6b0fda2b9a34d34aaa32e797adb2008', 'dd4cb202818747a08dd60d6e9c635eb9', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('aec72143696949d6a23798d8fffe7949', '上线前准备工作', 'e6b0fda2b9a34d34aaa32e797adb2008', 'aaba14e91e434f5e8f4ed017f579cbc4', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('b1e1460b08924088ab5caca212fa7f69', '需求确认（开发）', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-06-04', '张帅');
INSERT INTO `task_subclass` VALUES ('b21aa7483b524b2a8515a8ed386ade6f', '触发器', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('b6910b3a2cc64e30b90201ffb6ad3fe1', '存储过程', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('bfd9f701034b45899626d977ec7ad19f', '验收汇报', 'e6b0fda2b9a34d34aaa32e797adb2008', 'dd4cb202818747a08dd60d6e9c635eb9', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('c41525f2f837487f8dc4270d7cd7c973', '数据链路设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('d279a4ba4d2e41d9bf8c66b6cdb7d7e5', '函数', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('e35206ebf4ea4953b8d594a515cfb56d', 'E-R图', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('e5b91428fccc456793fd2ba04a345fe4', '数据库最终结果结构设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '19c179bbe8cd4603a5a7f541f1e59bc2', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('f688b8bad795449bac3482da47c08d45', '移动端原型设计', 'e6b0fda2b9a34d34aaa32e797adb2008', 'b464e2c7e9bb43f485c481f71d3029ac', '2019-06-05', '张帅');
INSERT INTO `task_subclass` VALUES ('f7568acae50e43af8ae551485df67d05', '需求确认（用户）', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-05-31', '王炎彬');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `u_phone` int(11) default NULL COMMENT '用户手机号',
  `u_name` varchar(20) collate utf8_unicode_ci default NULL COMMENT '用户名称',
  `u_department` varchar(20) collate utf8_unicode_ci default NULL COMMENT '用户所属部门',
  `u_sign` int(1) default NULL COMMENT '权限 1 超管，2 管理员，3 员工',
  `u_status` int(1) unsigned zerofill default '0' COMMENT '状态 0 正常，1 删除',
  `create_time` date default NULL COMMENT '用户创建时间',
  `update_time` date default NULL COMMENT '修改时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '用户创建人',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for weekreport
-- ----------------------------
DROP TABLE IF EXISTS `weekreport`;
CREATE TABLE `weekreport` (
  `w_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '周计划主键ID',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目计划ID',
  `w_start_time` date default NULL COMMENT '设定周计划的开始时间',
  `w_end_time` date default NULL COMMENT '设定周计划的结束时间',
  `a_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务项ID',
  `w_work_report` varchar(255) collate utf8_unicode_ci default NULL COMMENT '工作叙述',
  `user_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '用户ID',
  `w_actual_proportion` int(11) default NULL COMMENT '实际占比',
  `w_plan_proportion` int(11) default NULL COMMENT '计划占比',
  `w_status` int(1) unsigned zerofill default '0' COMMENT '0.已完成  1.进行中  2.暂停',
  `w_remark` varchar(255) collate utf8_unicode_ci default NULL COMMENT '备注/协调人员',
  PRIMARY KEY  (`w_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of weekreport
-- ----------------------------
INSERT INTO `weekreport` VALUES ('weekid', '99975cbb4d5145dd96ad45622dfe496a', '2019-06-12', '2019-06-19', null, null, 'userId', null, null, '0', null);
