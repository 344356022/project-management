/*
Navicat MySQL Data Transfer

Source Server         : gedi
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : xmgl

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-06-06 17:12:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action_item
-- ----------------------------
DROP TABLE IF EXISTS `action_item`;
CREATE TABLE `action_item` (
  `a_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务项主键ID',
  `a_ name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务项名称',
  `a_pstart_time` date default NULL COMMENT '计划开始时间',
  `a_pend_time` date default NULL COMMENT '计划结束时间',
  `a_astart_time` date default NULL COMMENT '实际开始时间',
  `a_aend_time` date default NULL COMMENT '实际结束时间',
  `a_percentage` int(11) default NULL COMMENT '完成百分比',
  `a_state` int(5) default NULL COMMENT '状态 0 未开始，1 进行中，2 已完成',
  `a_is_result` int(5) default NULL COMMENT '成果是否提交  0 待提交，1 已提交',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务项创建人',
  `create_time` datetime default NULL COMMENT '任务项创建时间',
  `ts_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务子类ID',
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of action_item
-- ----------------------------
INSERT INTO `action_item` VALUES ('00d440ce38b3486dab9d44a1701cd125', '汇总指标梳理过程问题', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:46:11', '70d1de0d950b4fcd938a561e4dd922c6');
INSERT INTO `action_item` VALUES ('02883c237e4f4797a7155d96619ddfad', '生产环境发布', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:22:18', 'aec72143696949d6a23798d8fffe7949');
INSERT INTO `action_item` VALUES ('0d99f974e9704399b50e839993092256', '前后端开发（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:16:40', '95164fcfcc0d4c279e0bd77f6ff170d0');
INSERT INTO `action_item` VALUES ('1', '测试1', '1994-12-31', '1994-12-31', '1994-12-31', '1994-12-31', '50', '2', '0', '张帅', '2019-06-06 12:52:22', '1');
INSERT INTO `action_item` VALUES ('114e3c85dfdd4d2d9f61358864482f96', '系统功能测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:19:25', '7710719964d34bdb8562e89d19f18428');
INSERT INTO `action_item` VALUES ('1da86c4bcd4b449ab1b7ef6504549832', '评审数据链路流转方案', '1994-12-31', '1994-12-31', '1994-12-31', '1994-12-31', '50', '2', '0', '张帅', '2019-06-05 10:13:02', '2e0ce4f866dc459b9a495330c1885d22');
INSERT INTO `action_item` VALUES ('2', '测试2', '1994-12-31', '1994-12-31', '1994-12-31', '1994-12-31', '50', '2', '0', '张帅', '2019-06-06 12:52:24', '2');
INSERT INTO `action_item` VALUES ('21f7b679ae29402984b1ed58f04e4eca', '需求调研及梳理', '2019-03-15', '2019-03-22', '2019-03-15', '2019-06-05', '100', '1', '1', '王炎彬', '2019-05-31 16:18:56', '437f8f5df86345ce9659af33c31a054f');
INSERT INTO `action_item` VALUES ('26182818ebb34c6ebd459eee565ff66c', '数据库设置', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:14:16', '95164fcfcc0d4c279e0bd77f6ff170d0');
INSERT INTO `action_item` VALUES ('2a1d884c4fc94dbf992922add5247fcb', '前后端联调（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:16:42', '95164fcfcc0d4c279e0bd77f6ff170d0');
INSERT INTO `action_item` VALUES ('2ae029f6f27b4e4a86c1e118e0cf8021', '测试用例编写', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:18:24', '263d012e3ee04c9cab59bcaeeb796b6f');
INSERT INTO `action_item` VALUES ('2cf15e17b8184ae792868a17184826ca', '项目工作汇报', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:38:50', 'bfd9f701034b45899626d977ec7ad19f');
INSERT INTO `action_item` VALUES ('381a95d4ec5c404c844f5e786970d8c1', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:55:55', 'd279a4ba4d2e41d9bf8c66b6cdb7d7e5');
INSERT INTO `action_item` VALUES ('444019bc4c5845c08a85c6db41232fb8', '业务原型草图', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:30:51', 'f7568acae50e43af8ae551485df67d05');
INSERT INTO `action_item` VALUES ('4737d22a3e3d4993b26f6af9cb40783b', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:55:25', 'b6910b3a2cc64e30b90201ffb6ad3fe1');
INSERT INTO `action_item` VALUES ('483da0e9776347568b0ace9b700e184f', '数据指标清单表', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:39:30', '0bad05640f944dfd99f45a4a67c6a88c');
INSERT INTO `action_item` VALUES ('5131b979438b4ad7b877d5b67de61f04', '开发环境搭建', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:14:53', '95164fcfcc0d4c279e0bd77f6ff170d0');
INSERT INTO `action_item` VALUES ('5fb97a5c57dd41ed802ad7880889b471', '汇总指标算法', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:46:43', '0c1b94f38c7c4f27806d391839ce0449');
INSERT INTO `action_item` VALUES ('60d9d091ad374aaa86854d98313a03c7', '评审数据设计方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:50:15', '17275cc689e749aba3d354cd9c20ab13');
INSERT INTO `action_item` VALUES ('6b7972febc83490080b5b747cf76a743', '设计表结构', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:47:26', 'e5b91428fccc456793fd2ba04a345fe4');
INSERT INTO `action_item` VALUES ('73ddc58bc9984bc994e7ed9a716b7ec4', '原型确定', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:35:04', 'f688b8bad795449bac3482da47c08d45');
INSERT INTO `action_item` VALUES ('79355b6de24e4d1eb9860a1c43502df7', '编写需求文档（开发版）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:32:44', 'b1e1460b08924088ab5caca212fa7f69');
INSERT INTO `action_item` VALUES ('84b8122e20454cd19518eead16c8bfef', '评审表数据逻辑关系', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:52:53', '7ee1f4ed54514ae0b630cad094ee0314');
INSERT INTO `action_item` VALUES ('88a294364fec448587e08fcf0cd3d89a', '汇总整理所有涉及指标', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:40:18', '6ddc94eaa14445d490e72013b8cb8499');
INSERT INTO `action_item` VALUES ('8a4d353873e947b8ab81eafdea113b27', '评审数据字典文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:51:30', '25c3fb4396824da3a64d6a35633c9595');
INSERT INTO `action_item` VALUES ('8bbad7c1efce4075b2df948535b0c5e6', null, '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:53:24', 'e35206ebf4ea4953b8d594a515cfb56d');
INSERT INTO `action_item` VALUES ('91a140a700d248d887909ae9ac19b743', '单个指标梳理文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:45:14', '009c57ab461248a4986554bb56ca91b7');
INSERT INTO `action_item` VALUES ('924866009d3e41f9b665e153209507f5', '测试环境系统功能验证', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:36:06', '212cf1a61dbc4d6496937ae82d0fcf90');
INSERT INTO `action_item` VALUES ('9c5151d1ee074f91b155e2492fcd53a1', '数据同步及联调', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:22:17', 'aec72143696949d6a23798d8fffe7949');
INSERT INTO `action_item` VALUES ('9dd5b08529414c8f88080802b79769c9', '编写需求文档（用户版）', '2019-05-31', '2019-07-03', '2019-05-31', '2019-06-30', '100', '1', '1', '王炎彬', '2019-05-31 16:20:23', 'f7568acae50e43af8ae551485df67d05');
INSERT INTO `action_item` VALUES ('a2f6ecbc00294dd0ba143ed0e7590163', '原型设计', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:34:32', 'f688b8bad795449bac3482da47c08d45');
INSERT INTO `action_item` VALUES ('a3a996c3a7974d06bebd22e5ad07f5b3', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:56:51', 'b21aa7483b524b2a8515a8ed386ade6f');
INSERT INTO `action_item` VALUES ('a4fe9590438543f38182bbc281a9a961', '确认需求文档（用户版）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:31:53', 'f7568acae50e43af8ae551485df67d05');
INSERT INTO `action_item` VALUES ('aa7f82b4137a4729a3574c75532a39c1', '前后端开发（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:16:41', '95164fcfcc0d4c279e0bd77f6ff170d0');
INSERT INTO `action_item` VALUES ('ac3a13fb7f8747c0a579c7aae5bacf3a', '确定需求文档（开发版）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:33:36', 'b1e1460b08924088ab5caca212fa7f69');
INSERT INTO `action_item` VALUES ('b70ba3be92e34aa284618615cf07c6dc', '编写数据链路流转方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:12:19', '2e0ce4f866dc459b9a495330c1885d22');
INSERT INTO `action_item` VALUES ('bccf391a625242b1a21c58e131b93f80', '编写表数据逻辑关系', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:52:09', '7ee1f4ed54514ae0b630cad094ee0314');
INSERT INTO `action_item` VALUES ('c5dbdb7e958f474da920dedf0fff0475', '编写数据设计方案', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:49:30', '17275cc689e749aba3d354cd9c20ab13');
INSERT INTO `action_item` VALUES ('c5f2d0ae317247d1b01e3f99d447b173', 'ETL程序测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:10:57', 'c41525f2f837487f8dc4270d7cd7c973');
INSERT INTO `action_item` VALUES ('c77511dd42a94ca9a90d059e51ef684e', '开发、测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:56:23', '1bd1f6f22073417a83effe96663f9729');
INSERT INTO `action_item` VALUES ('d45c6a5f6422457fbbb444f3a26ec0d1', '生产环境搭建', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:22:16', 'aec72143696949d6a23798d8fffe7949');
INSERT INTO `action_item` VALUES ('d461243d47524f0b9bbdbce12d1c4474', '系统上线', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:36:39', '4a9f03bc564f4e0eb280ab69c62d2f4a');
INSERT INTO `action_item` VALUES ('d6f05985c5c744bf9b40fdb0f7994ddd', '验收文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:37:30', 'a6940f854a3541ae8564d5f3e055a9e7');
INSERT INTO `action_item` VALUES ('d9c20bfe6cfd4e04a10b2d7fa4dda2a9', '评审表结构', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:48:03', 'e5b91428fccc456793fd2ba04a345fe4');
INSERT INTO `action_item` VALUES ('db0e83d5861b40588c30dd67489160e1', '指标数据核查（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:48:46', '5ad1fe0abebd4c4399fa8b9ff41820d2');
INSERT INTO `action_item` VALUES ('f04e2c0c4f704447839bc9f91c16eea5', 'ETL程序开发', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:10:25', 'c41525f2f837487f8dc4270d7cd7c973');
INSERT INTO `action_item` VALUES ('f5fe465282454e37b5bf3fad320da060', '数据链路清单', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:13:35', '7ebb5c284a8e4284ba19c3fc658b32f4');
INSERT INTO `action_item` VALUES ('f946da57c2b44072932260d36b3704e0', '二次指标数据核查（每个）', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:09:38', '88e704ed4c354f24a96aa5580d494a03');
INSERT INTO `action_item` VALUES ('f977c643b45041b78784b7ec2c0eacb2', '编写数据字典文档', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 09:50:55', '25c3fb4396824da3a64d6a35633c9595');
INSERT INTO `action_item` VALUES ('fb6f6dbb1f964d9982e9340a1cd744e9', '系统回归测试', '2019-06-05', '2019-06-05', '2019-06-05', '2019-06-05', '100', '1', '1', '张帅', '2019-06-05 10:19:26', '7710719964d34bdb8562e89d19f18428');

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
  `p_project_phase_id` int(10) default NULL COMMENT '项目阶段ID',
  `p_progress` int(10) default NULL COMMENT '项目总体完成进度',
  `create_time` datetime default NULL COMMENT '项目创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '项目创建人',
  PRIMARY KEY  (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of project_plan
-- ----------------------------
INSERT INTO `project_plan` VALUES ('99975cbb4d5145dd96ad45622dfe496a', '项目建设进度', '2019-05-01', '2019-09-06', '2', '100', '2019-05-31 16:22:21', '王炎彬');
INSERT INTO `project_plan` VALUES ('a60f4827847047ef92529de6194b22c9', '项目环节合规性监测', '2019-06-04', '2019-06-04', '3', '100', '2019-06-04 16:56:02', '张帅');
INSERT INTO `project_plan` VALUES ('e6b0fda2b9a34d34aaa32e797adb2008', '市县经营评价', '2019-05-01', '2019-08-08', '1', '100', '2019-05-31 16:23:09', '王炎彬');

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
INSERT INTO `project_user_medium` VALUES ('0515e536955a4414aa9a525919d0dda2', 'f9dd3e12f01344b5be057f4a2a8542a2', 'ac3a13fb7f8747c0a579c7aae5bacf3a');
INSERT INTO `project_user_medium` VALUES ('07801963da2c4cc2b38cdd69a9dcc0fc', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'a3a996c3a7974d06bebd22e5ad07f5b3');
INSERT INTO `project_user_medium` VALUES ('0d95d7f76c3a468c93d797416d9d9b02', '6515522b010b400da4b872f65a3434b3', 'aa7f82b4137a4729a3574c75532a39c1');
INSERT INTO `project_user_medium` VALUES ('0f2615572a1d455097d2cfbdcc251889', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'c5dbdb7e958f474da920dedf0fff0475');
INSERT INTO `project_user_medium` VALUES ('0fea6a0520e54d918d94e604adff4f0f', '38563d5a812148a6b8a36d574457a3de', '9c5151d1ee074f91b155e2492fcd53a1');
INSERT INTO `project_user_medium` VALUES ('1c0971b828484e2dbc36f7b96b552848', 'f9dd3e12f01344b5be057f4a2a8542a2', 'd461243d47524f0b9bbdbce12d1c4474');
INSERT INTO `project_user_medium` VALUES ('23f9bde35c4240819493c68b5b7028e4', 'ac68801e62ed4ed1a26d1f4ed807be4a', '84b8122e20454cd19518eead16c8bfef');
INSERT INTO `project_user_medium` VALUES ('3161b93dac4246138ccb68521182fb4a', 'ac68801e62ed4ed1a26d1f4ed807be4a', '8bbad7c1efce4075b2df948535b0c5e6');
INSERT INTO `project_user_medium` VALUES ('4253f3d1b4ea4288a8233e1f43bc2880', '06f737a43556410183eb96ebc85f89e0', 'db0e83d5861b40588c30dd67489160e1');
INSERT INTO `project_user_medium` VALUES ('45d8a7666a334a40840cb681c228f53e', '04061d9cbfec49a3a1ac8816e67f14b9', '2a1d884c4fc94dbf992922add5247fcb');
INSERT INTO `project_user_medium` VALUES ('484ae782bf154964938223fc3a9daadf', 'ac68801e62ed4ed1a26d1f4ed807be4a', '1da86c4bcd4b449ab1b7ef6504549832');
INSERT INTO `project_user_medium` VALUES ('49863e830c2843e9835ea9e89ed5f086', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'b70ba3be92e34aa284618615cf07c6dc');
INSERT INTO `project_user_medium` VALUES ('50ba36537adc4ba19eb9e2a604ba4f15', 'f9dd3e12f01344b5be057f4a2a8542a2', '924866009d3e41f9b665e153209507f5');
INSERT INTO `project_user_medium` VALUES ('546a34e237024a8cb089c977b1de15b2', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'f977c643b45041b78784b7ec2c0eacb2');
INSERT INTO `project_user_medium` VALUES ('5590f17abb26473db20fdf6edfa7f34f', 'ac68801e62ed4ed1a26d1f4ed807be4a', '5fb97a5c57dd41ed802ad7880889b471');
INSERT INTO `project_user_medium` VALUES ('5841f4da047f4d62b7874d4bb1d3054e', '38563d5a812148a6b8a36d574457a3de', 'd45c6a5f6422457fbbb444f3a26ec0d1');
INSERT INTO `project_user_medium` VALUES ('70bc980a11bc400789f9bc94a768711b', 'ac68801e62ed4ed1a26d1f4ed807be4a', '26182818ebb34c6ebd459eee565ff66c');
INSERT INTO `project_user_medium` VALUES ('771e588956a8448ca7e0fec094bf04d9', '20d43deb075d4edd9ea30179c44810fc', 'a2f6ecbc00294dd0ba143ed0e7590163');
INSERT INTO `project_user_medium` VALUES ('7ba809b87e884d15854352f4f1a5230c', '010919d873d649b6bba89c2b8c33556f', 'fb6f6dbb1f964d9982e9340a1cd744e9');
INSERT INTO `project_user_medium` VALUES ('82ef2dd5e4004334ba6e14bb53c72050', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'f5fe465282454e37b5bf3fad320da060');
INSERT INTO `project_user_medium` VALUES ('833e577dc6854138971afd720610455c', '010919d873d649b6bba89c2b8c33556f', '2ae029f6f27b4e4a86c1e118e0cf8021');
INSERT INTO `project_user_medium` VALUES ('834f747c395d4ed8a0732ef082128be6', 'ac68801e62ed4ed1a26d1f4ed807be4a', '60d9d091ad374aaa86854d98313a03c7');
INSERT INTO `project_user_medium` VALUES ('84ce781d454c4814b28e2d78983936dd', 'f9dd3e12f01344b5be057f4a2a8542a2', '21f7b679ae29402984b1ed58f04e4eca');
INSERT INTO `project_user_medium` VALUES ('857ba3153fdc4394a5642ed9bcdde68f', 'f9dd3e12f01344b5be057f4a2a8542a2', 'd6f05985c5c744bf9b40fdb0f7994ddd');
INSERT INTO `project_user_medium` VALUES ('89dba21f66374b3ab68b7bb386beff5f', 'f9dd3e12f01344b5be057f4a2a8542a2', '483da0e9776347568b0ace9b700e184f');
INSERT INTO `project_user_medium` VALUES ('970934531a87457b8f2ad5d760712018', 'ac68801e62ed4ed1a26d1f4ed807be4a', '4737d22a3e3d4993b26f6af9cb40783b');
INSERT INTO `project_user_medium` VALUES ('9cad08006c924b0b8bb4909c5d73089f', 'f9dd3e12f01344b5be057f4a2a8542a2', 'a4fe9590438543f38182bbc281a9a961');
INSERT INTO `project_user_medium` VALUES ('a053a89b40eb48a0b3559c0ba46655bf', 'f9dd3e12f01344b5be057f4a2a8542a2', '9dd5b08529414c8f88080802b79769c9');
INSERT INTO `project_user_medium` VALUES ('a0fd9db234594b7f8d5fddb6d4155745', 'f9dd3e12f01344b5be057f4a2a8542a2', '79355b6de24e4d1eb9860a1c43502df7');
INSERT INTO `project_user_medium` VALUES ('a2519efd0bb349bebc8c4593ab4d5272', 'ac68801e62ed4ed1a26d1f4ed807be4a', '88a294364fec448587e08fcf0cd3d89a');
INSERT INTO `project_user_medium` VALUES ('a50cc92b2dc7490da15a82a3a439c9a4', 'c02c4a1899ba4b50808c525ef42b6a48', '2cf15e17b8184ae792868a17184826ca');
INSERT INTO `project_user_medium` VALUES ('a9ffd7c85f994ae3a922ce5bfc73a7e0', 'f9dd3e12f01344b5be057f4a2a8542a2', '73ddc58bc9984bc994e7ed9a716b7ec4');
INSERT INTO `project_user_medium` VALUES ('abc9fb89dd6d49218e6793298d413847', 'ac68801e62ed4ed1a26d1f4ed807be4a', '91a140a700d248d887909ae9ac19b743');
INSERT INTO `project_user_medium` VALUES ('ad55ed70902444f98f224ea754b7913f', '6515522b010b400da4b872f65a3434b3', '5131b979438b4ad7b877d5b67de61f04');
INSERT INTO `project_user_medium` VALUES ('afb29b391bda4ca6a14438b95e074613', 'ac68801e62ed4ed1a26d1f4ed807be4a', '381a95d4ec5c404c844f5e786970d8c1');
INSERT INTO `project_user_medium` VALUES ('bed00f5a7b29483ba3d56ef9890340d4', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'f04e2c0c4f704447839bc9f91c16eea5');
INSERT INTO `project_user_medium` VALUES ('c3f2cbdee8c24e359074db12821e09ec', '06f737a43556410183eb96ebc85f89e0', 'f946da57c2b44072932260d36b3704e0');
INSERT INTO `project_user_medium` VALUES ('ca5714c5b8c145f8843a3cf612fdcb64', '04061d9cbfec49a3a1ac8816e67f14b9', '0d99f974e9704399b50e839993092256');
INSERT INTO `project_user_medium` VALUES ('d369a6cac6294df1a04977b5b91b80c9', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'd9c20bfe6cfd4e04a10b2d7fa4dda2a9');
INSERT INTO `project_user_medium` VALUES ('d6e189a9581e4f61aea0be2d21894990', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'c5f2d0ae317247d1b01e3f99d447b173');
INSERT INTO `project_user_medium` VALUES ('d7873c8d3a864221a870f5bc618b0f06', 'ac68801e62ed4ed1a26d1f4ed807be4a', '00d440ce38b3486dab9d44a1701cd125');
INSERT INTO `project_user_medium` VALUES ('e30473441ed14f3ebead18ab04fe65e9', 'f9dd3e12f01344b5be057f4a2a8542a2', '444019bc4c5845c08a85c6db41232fb8');
INSERT INTO `project_user_medium` VALUES ('e4ce583e99c24f7fa36a3ec794364530', '38563d5a812148a6b8a36d574457a3de', '02883c237e4f4797a7155d96619ddfad');
INSERT INTO `project_user_medium` VALUES ('eaace99651224a47bf2ade286f6e945e', '2', '1');
INSERT INTO `project_user_medium` VALUES ('ee3427b000ac44faa7d77f083feda4d2', 'ac68801e62ed4ed1a26d1f4ed807be4a', '8a4d353873e947b8ab81eafdea113b27');
INSERT INTO `project_user_medium` VALUES ('f170d7d502d045108b2db53ee75ae044', '2', '2');
INSERT INTO `project_user_medium` VALUES ('f46d5ab6227c460ba6ec1a2684a380f9', 'ac68801e62ed4ed1a26d1f4ed807be4a', '6b7972febc83490080b5b747cf76a743');
INSERT INTO `project_user_medium` VALUES ('f7a8bf5e24f64f84a9b76323ea4bbfee', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'c77511dd42a94ca9a90d059e51ef684e');
INSERT INTO `project_user_medium` VALUES ('f8c20d5ef5d44738885c7270db7a7544', 'ac68801e62ed4ed1a26d1f4ed807be4a', 'bccf391a625242b1a21c58e131b93f80');

-- ----------------------------
-- Table structure for task_class
-- ----------------------------
DROP TABLE IF EXISTS `task_class`;
CREATE TABLE `task_class` (
  `t_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务类主键ID',
  `t_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务类名称',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划表主键',
  `create_time` datetime default NULL COMMENT '任务类创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务类创建人',
  `p_project_phase_id` int(20) default NULL COMMENT '项目阶段ID',
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task_class
-- ----------------------------
INSERT INTO `task_class` VALUES ('19c179bbe8cd4603a5a7f541f1e59bc2', '数据库最终结果表结构设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:02:04', '张帅', '2');
INSERT INTO `task_class` VALUES ('233b6818b2ce44929dc316ff5166611d', '指标数验证、数据质量稽核', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:04:19', '张帅', '2');
INSERT INTO `task_class` VALUES ('2c5a968a89994633b7cc251359acc313', '数据验证', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:02:34', '张帅', '2');
INSERT INTO `task_class` VALUES ('2d6b10e2ca2e486ca3dfa8bc367e3cb1', '指标明细编制', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:01:29', '张帅', '2');
INSERT INTO `task_class` VALUES ('38c0d1f18426483cbb72c7d5b6517156', '数据接入方案确认、数据库设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:03:17', '张帅', '2');
INSERT INTO `task_class` VALUES ('876752c7d0a2480f946bac785aa0a4d8', '数据链路设计及线上数据流转', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:05:08', '张帅', '2');
INSERT INTO `task_class` VALUES ('8ed7eabb4e4841c4ab39a1fb4d9a8669', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31 16:26:41', '王炎彬', '1');
INSERT INTO `task_class` VALUES ('aaba14e91e434f5e8f4ed017f579cbc4', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:06:12', '张帅', '3');
INSERT INTO `task_class` VALUES ('b464e2c7e9bb43f485c481f71d3029ac', '原型设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31 16:26:15', '王炎彬', '1');
INSERT INTO `task_class` VALUES ('caa0db31b8ef4661ba070bc4e6d9e215', '系统开发', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:05:34', '张帅', '3');
INSERT INTO `task_class` VALUES ('d5b5655a246c43fe8bdf5eb657aae7d8', '数据库开发', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:03:31', '张帅', '2');
INSERT INTO `task_class` VALUES ('dd4cb202818747a08dd60d6e9c635eb9', '项目验收', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-03 11:03:25', '张帅', '1');
INSERT INTO `task_class` VALUES ('e8362f9a69ce4ab297eb47aa672bb917', '指标数据需求调研及确定', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:01:03', '张帅', '2');
INSERT INTO `task_class` VALUES ('efa9de57ccab4358bc18d0a7bd43f99a', '需求分析', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-05-31 16:25:35', '王炎彬', '1');
INSERT INTO `task_class` VALUES ('fe18f44faa7d41b9936329fb7dbd9ac3', '系统测试', 'e6b0fda2b9a34d34aaa32e797adb2008', '2019-06-04 17:05:55', '张帅', '3');

-- ----------------------------
-- Table structure for task_subclass
-- ----------------------------
DROP TABLE IF EXISTS `task_subclass`;
CREATE TABLE `task_subclass` (
  `ts_id` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '任务子类主键ID',
  `ts_name` varchar(255) collate utf8_unicode_ci default NULL COMMENT '任务子类名称',
  `p_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '项目总计划表主键',
  `t_id` varchar(50) collate utf8_unicode_ci default NULL COMMENT '任务类ID',
  `create_time` datetime default NULL COMMENT '任务子类创建时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '任务子类创建人',
  PRIMARY KEY  (`ts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of task_subclass
-- ----------------------------
INSERT INTO `task_subclass` VALUES ('009c57ab461248a4986554bb56ca91b7', '指标整理明细表', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05 09:14:16', '张帅');
INSERT INTO `task_subclass` VALUES ('0bad05640f944dfd99f45a4a67c6a88c', '指标数据需求调研及确定', 'e6b0fda2b9a34d34aaa32e797adb2008', 'e8362f9a69ce4ab297eb47aa672bb917', '2019-06-05 09:13:11', '张帅');
INSERT INTO `task_subclass` VALUES ('0c1b94f38c7c4f27806d391839ce0449', '指标计算汇总文档', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05 09:15:06', '张帅');
INSERT INTO `task_subclass` VALUES ('17275cc689e749aba3d354cd9c20ab13', '数据设计方案', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05 09:16:31', '张帅');
INSERT INTO `task_subclass` VALUES ('1bd1f6f22073417a83effe96663f9729', '视图', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05 09:18:59', '张帅');
INSERT INTO `task_subclass` VALUES ('212cf1a61dbc4d6496937ae82d0fcf90', '测试环境系统功能验证', 'e6b0fda2b9a34d34aaa32e797adb2008', '8ed7eabb4e4841c4ab39a1fb4d9a8669', '2019-06-05 09:10:31', '张帅');
INSERT INTO `task_subclass` VALUES ('25c3fb4396824da3a64d6a35633c9595', '数据字典', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05 09:16:49', '张帅');
INSERT INTO `task_subclass` VALUES ('263d012e3ee04c9cab59bcaeeb796b6f', '测试准备', 'e6b0fda2b9a34d34aaa32e797adb2008', 'fe18f44faa7d41b9936329fb7dbd9ac3', '2019-06-05 09:22:02', '张帅');
INSERT INTO `task_subclass` VALUES ('2e0ce4f866dc459b9a495330c1885d22', '线上数据流转', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05 09:20:43', '张帅');
INSERT INTO `task_subclass` VALUES ('437f8f5df86345ce9659af33c31a054f', '需求调研及梳理', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-05-31 16:27:37', '王炎彬');
INSERT INTO `task_subclass` VALUES ('4a9f03bc564f4e0eb280ab69c62d2f4a', '系统上线', 'e6b0fda2b9a34d34aaa32e797adb2008', '8ed7eabb4e4841c4ab39a1fb4d9a8669', '2019-06-05 09:10:50', '张帅');
INSERT INTO `task_subclass` VALUES ('5ad1fe0abebd4c4399fa8b9ff41820d2', '数据核查', 'e6b0fda2b9a34d34aaa32e797adb2008', '2c5a968a89994633b7cc251359acc313', '2019-06-05 09:16:02', '张帅');
INSERT INTO `task_subclass` VALUES ('6ddc94eaa14445d490e72013b8cb8499', '指标整理汇总表', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05 09:13:51', '张帅');
INSERT INTO `task_subclass` VALUES ('70d1de0d950b4fcd938a561e4dd922c6', '指标整理问题清单', 'e6b0fda2b9a34d34aaa32e797adb2008', '2d6b10e2ca2e486ca3dfa8bc367e3cb1', '2019-06-05 09:14:41', '张帅');
INSERT INTO `task_subclass` VALUES ('7710719964d34bdb8562e89d19f18428', '系统测试', 'e6b0fda2b9a34d34aaa32e797adb2008', 'fe18f44faa7d41b9936329fb7dbd9ac3', '2019-06-05 09:22:21', '张帅');
INSERT INTO `task_subclass` VALUES ('7ebb5c284a8e4284ba19c3fc658b32f4', '汇总所有数据链路', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05 09:21:08', '张帅');
INSERT INTO `task_subclass` VALUES ('7ee1f4ed54514ae0b630cad094ee0314', '数据库逻辑关系', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05 09:17:14', '张帅');
INSERT INTO `task_subclass` VALUES ('88e704ed4c354f24a96aa5580d494a03', '二次差异对比表', 'e6b0fda2b9a34d34aaa32e797adb2008', '233b6818b2ce44929dc316ff5166611d', '2019-06-05 09:19:38', '张帅');
INSERT INTO `task_subclass` VALUES ('95164fcfcc0d4c279e0bd77f6ff170d0', '功能开发', 'e6b0fda2b9a34d34aaa32e797adb2008', 'caa0db31b8ef4661ba070bc4e6d9e215', '2019-06-05 09:21:36', '张帅');
INSERT INTO `task_subclass` VALUES ('a6940f854a3541ae8564d5f3e055a9e7', '验收材料', 'e6b0fda2b9a34d34aaa32e797adb2008', 'dd4cb202818747a08dd60d6e9c635eb9', '2019-06-05 09:11:17', '张帅');
INSERT INTO `task_subclass` VALUES ('aec72143696949d6a23798d8fffe7949', '上线前准备工作', 'e6b0fda2b9a34d34aaa32e797adb2008', 'aaba14e91e434f5e8f4ed017f579cbc4', '2019-06-05 09:22:42', '张帅');
INSERT INTO `task_subclass` VALUES ('b1e1460b08924088ab5caca212fa7f69', '需求确认（开发）', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-06-04 16:58:54', '张帅');
INSERT INTO `task_subclass` VALUES ('b21aa7483b524b2a8515a8ed386ade6f', '触发器', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05 09:19:16', '张帅');
INSERT INTO `task_subclass` VALUES ('b6910b3a2cc64e30b90201ffb6ad3fe1', '存储过程', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05 09:18:20', '张帅');
INSERT INTO `task_subclass` VALUES ('bfd9f701034b45899626d977ec7ad19f', '验收汇报', 'e6b0fda2b9a34d34aaa32e797adb2008', 'dd4cb202818747a08dd60d6e9c635eb9', '2019-06-05 09:11:39', '张帅');
INSERT INTO `task_subclass` VALUES ('c41525f2f837487f8dc4270d7cd7c973', '数据链路设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '876752c7d0a2480f946bac785aa0a4d8', '2019-06-05 09:20:09', '张帅');
INSERT INTO `task_subclass` VALUES ('d279a4ba4d2e41d9bf8c66b6cdb7d7e5', '函数', 'e6b0fda2b9a34d34aaa32e797adb2008', 'd5b5655a246c43fe8bdf5eb657aae7d8', '2019-06-05 09:18:40', '张帅');
INSERT INTO `task_subclass` VALUES ('e35206ebf4ea4953b8d594a515cfb56d', 'E-R图', 'e6b0fda2b9a34d34aaa32e797adb2008', '38c0d1f18426483cbb72c7d5b6517156', '2019-06-05 09:17:42', '张帅');
INSERT INTO `task_subclass` VALUES ('e5b91428fccc456793fd2ba04a345fe4', '数据库最终结果结构设计', 'e6b0fda2b9a34d34aaa32e797adb2008', '19c179bbe8cd4603a5a7f541f1e59bc2', '2019-06-05 09:15:43', '张帅');
INSERT INTO `task_subclass` VALUES ('f688b8bad795449bac3482da47c08d45', '移动端原型设计', 'e6b0fda2b9a34d34aaa32e797adb2008', 'b464e2c7e9bb43f485c481f71d3029ac', '2019-06-05 09:09:46', '张帅');
INSERT INTO `task_subclass` VALUES ('f7568acae50e43af8ae551485df67d05', '需求确认（用户）', 'e6b0fda2b9a34d34aaa32e797adb2008', 'efa9de57ccab4358bc18d0a7bd43f99a', '2019-05-31 16:28:18', '王炎彬');

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
  `u_status` tinyint(1) unsigned zerofill default '0' COMMENT '状态 0 正常，1 删除',
  `create_time` datetime default NULL COMMENT '用户创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `creater` varchar(20) collate utf8_unicode_ci default NULL COMMENT '用户创建人',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('010919d873d649b6bba89c2b8c33556f', null, '邢鑫鑫', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('04061d9cbfec49a3a1ac8816e67f14b9', null, '张理想', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('06f737a43556410183eb96ebc85f89e0', null, '张星亚', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('20d43deb075d4edd9ea30179c44810fc', null, '朱聪皓', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('38563d5a812148a6b8a36d574457a3de', null, '待定', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('6515522b010b400da4b872f65a3434b3', null, '黄中杰', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('ac68801e62ed4ed1a26d1f4ed807be4a', null, '申帅博', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('c02c4a1899ba4b50808c525ef42b6a48', null, '汪毅', null, null, '0', null, null, null);
INSERT INTO `user` VALUES ('f9dd3e12f01344b5be057f4a2a8542a2', null, '李双见', null, null, '0', null, null, null);

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