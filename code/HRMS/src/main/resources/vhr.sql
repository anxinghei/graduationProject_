-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2020 �?12 �?13 �?14:22
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
-- 表的结构 `dept`
--

CREATE TABLE IF NOT EXISTS `dept` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  `simplename` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '中文名称',
  `description` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门介绍',
  `manager` int(8) NOT NULL DEFAULT '1' COMMENT '部门主管，1默认向老板负责',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门表' AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `dept`
--

INSERT INTO `dept` (`id`, `name`, `simplename`, `description`, `manager`) VALUES
(1, 'development', '技术部', '负责项目的开发及工具的开发', 2),
(2, 'Operation', '运营部', '运营分为市场运营，用户运营，内容运营，社区运营以及商务运营几个大类', 3);

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
  `position` int(3) NOT NULL COMMENT '职位',
  `startyear` int(4) NOT NULL COMMENT '入职年份',
  `startmonth` int(2) NOT NULL COMMENT '入职月份',
  `salary` int(7) NOT NULL COMMENT '薪资',
  `tel` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '联系方式',
  `mid` int(5) NOT NULL DEFAULT '1' COMMENT '部门经理/直接上级',
  `department` int(3) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='正式员工' AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `employee`
--

INSERT INTO `employee` (`id`, `name`, `position`, `startyear`, `startmonth`, `salary`, `tel`, `mid`, `department`) VALUES
(1, 'BOSS', 0, 2000, 2, 99999, '13924436106', 0, 0),
(2, '李四', 1, 2020, 11, 9000, '13229186541', 1, 1),
(3, '王五', 2, 2020, 12, 10000, '13924336106', 1, 2),
(4, '张三', 1, 2020, 3, 9000, '13226536541', 2, 1);

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
  `simplename` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '岗位名称',
  `duty` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '职责',
  `request` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '岗位要求',
  `welfare` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '福利待遇',
  `cid` int(5) NOT NULL DEFAULT '0' COMMENT '所属公司',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1启用，0停用',
  `jclass` int(1) NOT NULL DEFAULT '0' COMMENT '0实习生，1校招，2社招',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职位' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `job`
--

INSERT INTO `job` (`id`, `name`, `simplename`, `duty`, `request`, `welfare`, `cid`, `status`, `jclass`) VALUES
(1, 'juniorJava', 'Java开发工程师', '岗位职责： 1、参与需求分析、模块设计、编码实现、技术文档、内部测试等工作。 2、负责指导客户开发商，使用公司产品完成开发集成和部署。 3、解决技术难题。 职位要求： 1、熟悉Java开发相关知识，Servlet后端开发； 掌握使用S2SH或SSM主流后端开发框架和相关的技术； 掌握Spring Boot 将是一个优势； 2、熟悉HTML、JavaScript、CSS，掌握Ajax、jQuery前', '1、熟悉Java开发相关知识，Servlet后端开发；\n掌握使用S2SH或SSM主流后端开发框架和相关的技术；\n掌握Spring Boot 将是一个优势；\n2、熟悉HTML、JavaScript、CSS，掌握Ajax、jQuery前端技术，了解主流前端框架；\n3、具有扎实的基本功，具备良好的团队合作精神和承受压力的能力。\n※以下非必备条件，具备其中之一将是一个优势：\n1、了解设计模式，具有面向对象的分析和设计的能力；\n2、了解WebService、REST等分布式开发；\n3、了解Extjs、React、VUE等前端开发；\n4、了解PKI/CA技术。', '8-12K*13薪', 0, 1, 0),
(2, 'serverDevEelopmentEngineer', '服务端开发工程师', '游戏产品的服务端开发、优化，为游戏提供稳定高效可靠的后台支撑体系。', '1、计算机、软件、数学相关专业，热爱编程、热爱游戏； 2、基础扎实，至少熟练掌握一门编程语言：C/C++、Java、PHP、Python、.net等； 3、扎实的知识结构：数据结构、常用算法、常用数据库、网络协议、通讯编程等专业知识； 4、良好的逻辑思维和学习能力、规范的编程风格、解决问题的能力； 5、富有团队精神，乐于接受挑战。', '11-22K', 0, 1, 0),
(3, 'JavaTrainee', 'Java开发实习生', '1、配合项目经理完成开发工作； 2、编写相关研发文档和操作手册； 3、客户现场的软件安装部署培训； 4、配合测试经理进行相关测试工作。', '1、大专及以上学历，计算机、软件工程、自动化相关专业； 2、有计算机语言基础，如：JAVA、C语言、C++、C#、Net、Android等，有J2EE相关开发经验优先； 3、熟悉HTML、CSS、Javascript、 XML等技术，有Ajax开发经验优先； 4、熟悉Oracle、Mysql.SQLServer中的一种数据库，熟悉JBOSS、Tomcat中的一种应用服务器； 5、良好的团队协作，沟通表达，问题解决能力，能承受压力，强烈的责任感和进取心。', '2-3K', 0, 1, 0),
(4, 'webEngineer', '前端工程师', '1、根据产品原型，选择合适的技术方案，并进行页面制作； 2、负责小程序和Web端的界面和交互实现； 3、使用小程序实现音视频相关的展示和交互；', '1、本科以上学历， 3年WEB前端开发工作经验； 2、精通微信小程序的开发；熟练掌握Vue以及相关框架； 3、有音视频相关开发经验； 4、有后端开发经验（Nodejs也算）优先； 5、对技术有激情，有持续学习心态； 6、主观能动性强，具备强烈的责任心和团队合作精神；', '25-50K*18薪', 0, 1, 0),
(5, 'makeupsCategoryOperation', '品类运营（美妆）', '1、通过各种渠道了解美妆商品信息，结合市场潮流风向，通过市场分析和数据分析开发具有市场潜力的商品； 2、结合平台美妆商品的销售数据，制定及实施每季度美妆的选品计划，控制货品结构及价格策略，提高商品利润； 3、紧跟客户需求，找出市场趋势商品，打造爆款； 4、及时解决缺货商品、爆款商品的供货问题，保证货不断供； 5、以业绩指标为导向，协助招商运营挖掘有实力的供应商，配合推广人员进行推广。\n', '1、本科及以上学历，3年以上工作经验，英语口语流畅，有电商、跨境电商运营经验者优先； 2、有很强的市场风向敏锐度，审美素养好，组货搭配能力强，对美妆信息敏感； 3、对美妆市场消费需求有较强的分析判断，对消费者行为和心理有较强的理解； 4、具有较强的商品知识，对所负责品类的市场消费需求有较强的分析判断、归纳总结能力，对行业的竞争格局与发展趋势有深入了解，并能应用指导工作开展； 5、有较强的逻辑分析能力、归纳总结能力；自我认知清晰，自驱力强。', '15-22K*14薪', 0, 1, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限表' AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `permission`
--

INSERT INTO `permission` (`id`, `url`, `perm`, `name`, `pid`) VALUES
(1, '/DeptManage', 'dept', '部门管理', 0),
(2, '/DeptSearch', 'dept:search', '部门概况', 1),
(3, '/DeptDelete', 'dept:delete', '删除部门', 2),
(4, '/DeptUpdate', 'dept:update', '更新部门', 2),
(5, '/DeptCreate', 'dept:create', '增加部门', 2),
(6, '/EmpManage', 'emp', '人员管理', 0),
(7, '/EmpSearch', 'emp:search', '人员概况', 6),
(8, '/EmpDelete', 'emp:delete', '删除人员', 7),
(9, '/EmpUpdate', 'emp:update', '更新人员', 6),
(10, '/EmpCreate', 'emp:create', '增加人员', 7),
(11, '/ResManage', 'res', '招聘管理', 0),
(12, '/ResPost', 'res:post', '发布岗位', 11),
(13, '/ResView', 'res:view', '近期简历', 11),
(14, '/ResTrainee', 'res:trainee', '实习生', 11),
(15, '/ResEmpee', 'res:empee', '校招/社招', 11);

-- --------------------------------------------------------

--
-- 表的结构 `position`
--

CREATE TABLE IF NOT EXISTS `position` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '职位名称',
  `simplename` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '岗位名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='正式员工职位' AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `position`
--

INSERT INTO `position` (`id`, `name`, `simplename`) VALUES
(1, 'serverDevEelopmentEngineer', '服务端开发工程师'),
(2, 'juniorJava', 'Java工程师'),
(3, 'JavaTrainee', 'Java开发实习生'),
(4, 'webEngineer', '前端工程师'),
(5, 'ArtificialIntelligenceExpert', '人工智能工程师/专家'),
(6, 'ProjectManager', '项目经理'),
(7, 'makeupsCategoryOperation', '品类运营（美妆）');

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
(1, 'root', 'root', '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15'),
(2, 'HR', 'HR', '11,12,13,14,15'),
(3, 'HRP', '人力资源管理师', '11,12,13,14,15'),
(5, 'manager', '部门经理', '6,7,8,9,10'),
(6, 'candidate', '应聘者', '100'),
(7, 'employee', '正式员工', '101'),
(8, 'trainee', '实习生', '101');

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
