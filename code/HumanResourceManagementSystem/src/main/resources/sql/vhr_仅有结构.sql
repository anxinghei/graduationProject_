-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2020 �?11 �?13 �?06:25
-- 服务器版本: 5.5.53
-- PHP 版本: 5.6.27

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `vhr`
--

-- --------------------------------------------------------

--
-- 表的结构 `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '城市',
  `addr` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `cid` int(5) NOT NULL DEFAULT '0' COMMENT '所属公司',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='工作城市' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `education`
--

CREATE TABLE IF NOT EXISTS `education` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '学历',
  `years` int(2) NOT NULL COMMENT '就读年限',
  `entrance` int(1) NOT NULL DEFAULT '1' COMMENT '是否统招，1是0否',
  `fulltime` int(1) NOT NULL DEFAULT '1' COMMENT '是否全日制，1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学历' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `position` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '职位',
  `startyear` int(4) NOT NULL COMMENT '入职年份',
  `startmonth` int(2) NOT NULL COMMENT '入职月份',
  `salary` int(7) NOT NULL COMMENT '薪资',
  `tel` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '联系方式',
  `mid` int(5) NOT NULL COMMENT '部门经理/直接上级',
  `department` int(3) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='正式员工' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `rid` int(8) NOT NULL COMMENT '简历',
  `schedule` int(2) NOT NULL DEFAULT '1' COMMENT '招聘进度，0不合适，1待洽谈，2通过一面，20未通过一面，3通过二面，30未通过二面，4通过终面，40未通过终面，5录用，50取消录用',
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '面试情况',
  `time` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '投递时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='简历投递反馈' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '职位',
  `description` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '职位描述',
  `welfare` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '福利待遇',
  `cid` int(5) NOT NULL DEFAULT '0' COMMENT '所属公司',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职位' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '链接网址',
  `perm` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '具体权限',
  `name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '权限名称',
  `pid` int(11) NOT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `probation`
--

CREATE TABLE IF NOT EXISTS `probation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `position` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '职位',
  `startyear` int(4) NOT NULL COMMENT '入职年份',
  `startmonth` int(2) NOT NULL COMMENT '入职月份',
  `salary` int(7) NOT NULL COMMENT '薪资',
  `tel` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '联系方式',
  `mid` int(5) NOT NULL COMMENT '部门经理/直接上级',
  `department` int(3) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='试用期员工' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

CREATE TABLE IF NOT EXISTS `record` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `thing` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '操作',
  `time` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '时间',
  `userid` int(5) NOT NULL COMMENT '操作对象',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `resume`
--

CREATE TABLE IF NOT EXISTS `resume` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `selfintroduction` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '自我介绍',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `years` int(2) NOT NULL COMMENT '工作年限',
  `tel` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `email` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '通知邮箱',
  `job` int(3) NOT NULL COMMENT '意向岗位',
  `city` int(3) NOT NULL COMMENT '意向城市',
  `salary` int(6) DEFAULT NULL COMMENT '意向薪资',
  `intime` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '入职时间',
  `schools` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '教育背景',
  `skills` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '技能掌握',
  `works` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '工作经历',
  `oname` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '紧急联系人',
  `relationship` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '关系',
  `otel` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '联系方式',
  `pushcode` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '内推码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='简历' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '角色名',
  `chineseName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '角色名中文表示',
  `perm` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '1,2,4,7,8,14,15,16,17' COMMENT '权限集',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表' AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `name`, `chineseName`, `perm`) VALUES
(1, 'root', 'root', '1,2,4,7,8,14,15,16,17,18,19,20,21,22,23,33,38,39,40,41,42,43'),
(2, 'HR', 'HR', '1,2,4,7,8,14,15,16,17'),
(3, 'HRP', '人力资源管理师', '1,2,4,7,8,14,15,16,17,18,19,20,21'),
(5, 'manager', '部门经理', '1,2,4,7,8,14,15,16,17,18,19,20,21,38,39,40'),
(6, 'candidate', '应聘者', '1,2,4,7,8,14,15,16,17,18,19,20,21,22,23,33,38,39,40,41,42,43'),
(7, 'employee', '正式员工', '1,2,4,7,8,14,15,16,17'),
(8, 'trainee', '实习生', '1,2,4,7,8,14,15,16,17');

-- --------------------------------------------------------

--
-- 表的结构 `schools`
--

CREATE TABLE IF NOT EXISTS `schools` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cid` int(8) NOT NULL COMMENT '所属简历',
  `startyear` int(4) NOT NULL COMMENT '起始时间：年',
  `startmonth` int(2) NOT NULL COMMENT '起始时间：月',
  `endyear` int(4) NOT NULL COMMENT '终止时间：年',
  `endmonth` int(2) NOT NULL COMMENT '终止时间：月',
  `schoolname` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '学校',
  `career` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '专业',
  `education` int(3) NOT NULL COMMENT '就学情况',
  `performance` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '在校表现',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='教育背景' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `sysuser`
--

CREATE TABLE IF NOT EXISTS `sysuser` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '新的用户' COMMENT '用户昵称',
  `userName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '用户状态，2锁定1正常0禁用',
  `lockEnding` varchar(12) CHARACTER SET utf8 NOT NULL DEFAULT '202004012142' COMMENT '用户解除锁定的时间',
  `role` int(11) NOT NULL DEFAULT '2' COMMENT '所属角色',
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  KEY `role_2` (`role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `sysuser`
--

INSERT INTO `sysuser` (`id`, `nickName`, `userName`, `password`, `status`, `lockEnding`, `role`) VALUES
(1, 'root', 'root', 'root', 1, '202004012142', 1),
(2, 'HR', '2', '2', 1, '202004012142', 2),
(3, 'HRP', '3', '3', 1, '202004012142', 3),
(4, 'manager', '5', '5', 1, '202004012142', 5),
(5, 'candidate', '6', '6', 1, '202004012142', 6);

-- --------------------------------------------------------

--
-- 表的结构 `works`
--

CREATE TABLE IF NOT EXISTS `works` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cid` int(8) NOT NULL COMMENT '所属简历',
  `startyear` int(4) NOT NULL COMMENT '起始时间：年',
  `startmonth` int(2) NOT NULL COMMENT '起始时间：月',
  `endyear` int(4) NOT NULL COMMENT '终止时间：年',
  `endmonth` int(2) NOT NULL COMMENT '终止时间：月',
  `campanyname` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '公司',
  `position` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '职位',
  `work` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '工作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='工作经历' AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
