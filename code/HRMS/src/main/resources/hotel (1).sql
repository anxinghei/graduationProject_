-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2020 �?04 �?02 �?02:34
-- 服务器版本: 5.5.53
-- PHP 版本: 5.6.27

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `hotel`
--

-- --------------------------------------------------------

--
-- 表的结构 `band`
--

CREATE TABLE IF NOT EXISTS `band` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) NOT NULL COMMENT '房间类别',
  `discount` int(3) NOT NULL COMMENT '折扣',
  `startDay` varchar(4) NOT NULL COMMENT '打折开始时间',
  `endDay` varchar(4) NOT NULL COMMENT '打折结束时间',
  `description` varchar(255) DEFAULT NULL COMMENT '打折缘故',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='房间打折表' AUTO_INCREMENT=22 ;

--
-- 转存表中的数据 `band`
--

INSERT INTO `band` (`id`, `typeId`, `discount`, `startDay`, `endDay`, `description`) VALUES
(1, 4, 90, '0308', '0309', '妇女节优惠'),
(2, 1, 95, '1110', '1112', '双十一优惠'),
(3, 2, 85, '0213', '0215', '情人节双人房优惠'),
(4, 3, 85, '0213', '0215', '情人节双人房优惠'),
(6, 2, 95, '0101', '0102', '喜迎元旦'),
(7, 3, 95, '0101', '0102', '喜迎元旦'),
(8, 4, 95, '0101', '0102', '喜迎元旦'),
(9, 6, 95, '0101', '0102', '喜迎元旦'),
(10, 7, 95, '0101', '0102', '喜迎元旦'),
(11, 1, 95, '0403', '0405', '清明节寄宿'),
(12, 7, 95, '0403', '0405', '清明节寄宿'),
(13, 4, 90, '0601', '0601', '儿童节的祝福'),
(14, 1, 90, '0929', '1004', '喜庆国庆节'),
(15, 2, 90, '0929', '1004', '喜庆国庆节'),
(16, 3, 90, '0929', '1004', '喜庆国庆节'),
(17, 4, 90, '0929', '1004', '喜庆国庆节'),
(18, 6, 90, '0929', '1004', '喜庆国庆节'),
(19, 7, 90, '0929', '1004', '喜庆国庆节'),
(20, 2, 90, '0310', '0315', '测试测试');

-- --------------------------------------------------------

--
-- 表的结构 `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNum` int(11) NOT NULL COMMENT '房间号',
  `guestId` int(11) NOT NULL COMMENT '入住客人',
  `customerId` int(11) NOT NULL COMMENT '顾客',
  `startDay` varchar(8) NOT NULL COMMENT '开始入住时间',
  `endDay` varchar(8) NOT NULL COMMENT '住店结束时间',
  `date` varchar(8) NOT NULL COMMENT '生成订单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='订单表' AUTO_INCREMENT=60 ;

--
-- 转存表中的数据 `book`
--

INSERT INTO `book` (`id`, `roomNum`, `guestId`, `customerId`, `startDay`, `endDay`, `date`) VALUES
(50, 102, 10, 10, '20200403', '20200405', '20200324'),
(51, 205, 11, 11, '20200403', '20200405', '20200324'),
(53, 202, 13, 13, '20200328', '20200401', '20200328'),
(54, 507, 14, 14, '20200325', '20200330', '20200328'),
(55, 205, 15, 15, '20200325', '20200330', '20200328'),
(56, 407, 16, 16, '20200327', '20200408', '20200328'),
(57, 503, 17, 17, '20200325', '20200329', '20200328'),
(58, 203, 18, 18, '20200327', '20200329', '20200328'),
(59, 102, 19, 19, '20200330', '20200403', '20200328');

-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '顾客姓名',
  `sex` int(1) NOT NULL COMMENT '顾客性别，0男1女',
  `phone` varchar(11) NOT NULL COMMENT '顾客电话',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='顾客表，打电话预订的人' AUTO_INCREMENT=20 ;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`id`, `name`, `sex`, `phone`) VALUES
(1, '张山南', 0, '13556129403'),
(5, '周勇', 0, '13923338103'),
(3, '张三', 0, '13229186549'),
(4, '程娜', 0, '13559238452'),
(6, '杨堪', 0, '14828430516'),
(7, '成康', 0, '13248690375'),
(8, '林珊珊', 0, '13553760983'),
(9, '钟山', 0, '13228475602'),
(10, '崔健', 0, '13557369802'),
(11, '离司', 0, '13927743902'),
(12, '巴鎏', 0, '13597230573'),
(13, '周泰', 0, '13924438106'),
(14, '孙策', 0, '13663957263'),
(15, '鲁肃', 0, '13228476082'),
(16, '李催', 0, '18925538520'),
(17, '孙尚香', 0, '18936724951'),
(18, '李典', 0, '13224793865'),
(19, '曹丕', 0, '15615934758');

-- --------------------------------------------------------

--
-- 表的结构 `facility`
--

CREATE TABLE IF NOT EXISTS `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '设施名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='房间设施表' AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `facility`
--

INSERT INTO `facility` (`id`, `name`) VALUES
(1, '空调'),
(2, '洗衣机'),
(3, '电视机'),
(4, '阳台'),
(5, '饮水机'),
(6, '熨斗'),
(7, '电吹风');

-- --------------------------------------------------------

--
-- 表的结构 `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '客人姓名',
  `sex` int(1) NOT NULL COMMENT '客人性别，0男1女',
  `phone` varchar(11) NOT NULL COMMENT '客人电话',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='客人表，住房的人' AUTO_INCREMENT=20 ;

--
-- 转存表中的数据 `guest`
--

INSERT INTO `guest` (`id`, `name`, `sex`, `phone`) VALUES
(1, '张山南', 0, '13556129403'),
(5, '周勇', 0, '13923338103'),
(3, '李四', 0, '13556129506'),
(4, '菲娜', 0, '13447295702'),
(6, '杨堪', 0, '14828430516'),
(7, '李林', 0, '12558470738'),
(8, '林珊珊', 0, '13553760983'),
(9, '钟山', 0, '13228475602'),
(10, '崔健', 0, '13557369802'),
(11, '离司', 0, '13927743902'),
(12, '巴鎏', 0, '13597230573'),
(13, '周泰', 0, '13924438106'),
(14, '孙策', 0, '13663957263'),
(15, '鲁肃', 0, '13228476082'),
(16, '李催', 0, '18925538520'),
(17, '孙尚香', 0, '18936724951'),
(18, '李典', 0, '13224793865'),
(19, '曹丕', 0, '15615934758');

-- --------------------------------------------------------

--
-- 表的结构 `oldbook`
--

CREATE TABLE IF NOT EXISTS `oldbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) NOT NULL COMMENT '房间号',
  `guestId` int(11) NOT NULL COMMENT '入住客人',
  `customerId` int(11) NOT NULL COMMENT '顾客',
  `startDay` varchar(8) NOT NULL COMMENT '开始入住时间',
  `endDay` varchar(8) NOT NULL COMMENT '住店结束时间',
  `date` varchar(8) NOT NULL COMMENT '付款时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='订单表' AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `oldbook`
--

INSERT INTO `oldbook` (`id`, `roomId`, `guestId`, `customerId`, `startDay`, `endDay`, `date`) VALUES
(1, 102, 1, 2, '20200301', '20200302', '20200301'),
(2, 101, 1, 1, '20200303', '20200304', '20200303'),
(3, 201, 3, 3, '20200313', '20200314', '20200313'),
(4, 503, 4, 4, '20200313', '20200314', '20200314'),
(5, 101, 5, 5, '20200316', '20200317', '20200316'),
(6, 207, 6, 6, '20200314', '20200318', '20200316'),
(7, 606, 8, 8, '20200316', '20200318', '20200317'),
(8, 101, 7, 7, '20200320', '20200322', '20200317'),
(9, 101, 9, 9, '20200323', '20200325', '20200324'),
(10, 201, 12, 12, '20200325', '20200328', '20200326');

-- --------------------------------------------------------

--
-- 表的结构 `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guest` varchar(255) NOT NULL COMMENT '入住者',
  `amount` int(11) NOT NULL COMMENT '支付金额',
  `date` varchar(8) NOT NULL COMMENT '付款时间',
  `roomNum` int(11) NOT NULL COMMENT '房号',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='支付表，收账记录' AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `payment`
--

INSERT INTO `payment` (`id`, `guest`, `amount`, `date`, `roomNum`) VALUES
(1, '李四', 252, '20200313', 201),
(2, '菲娜', 360, '20200314', 503),
(3, '周勇', 100, '20200316', 101),
(4, '杨堪', 350, '20200316', 207),
(5, '李林', 100, '20200317', 101),
(6, '林珊珊', 350, '20200317', 606),
(7, '钟山', 100, '20200324', 101),
(8, '崔健', 100, '20200324', 102),
(9, '离司', 95, '20200324', 205),
(10, '巴鎏', 280, '20200326', 201),
(11, '周泰', 280, '20200328', 202),
(12, '孙策', 400, '20200328', 507),
(13, '鲁肃', 100, '20200328', 205),
(14, '李催', 400, '20200328', 407),
(15, '孙尚香', 400, '20200328', 503),
(16, '李典', 200, '20200328', 203),
(17, '曹丕', 100, '20200328', 102);

-- --------------------------------------------------------

--
-- 表的结构 `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL COMMENT '链接网址',
  `perm` varchar(255) NOT NULL COMMENT '具体权限',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `pid` int(11) NOT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='权限表' AUTO_INCREMENT=44 ;

--
-- 转存表中的数据 `permission`
--

INSERT INTO `permission` (`id`, `url`, `perm`, `name`, `pid`) VALUES
(1, '/', 'order', '订单管理', 0),
(2, '/BookManage', 'book:manager', '查询订单', 1),
(4, '/update', 'book:update', '修改订单', 2),
(7, '/book/deleteById', 'book:deleteById', '删除订单', 2),
(8, '/AddBook', 'book:save', '添加订单', 1),
(14, '/RoomManage', 'room', '房间管理', 0),
(15, '/room/getRoom', 'room:getRoom', '获取所有已入住房间', 17),
(16, '/room/getUnroom', 'room:getUnroom', '获取所有未入住房间', 17),
(17, '/RoomManage', 'room:roomManage', '查看房间', 14),
(18, '/GuestList', 'hotel', '酒店管理', 0),
(19, '/GuestList', 'hotel:guestList', '顾客列表', 18),
(20, '/guest/findAll', 'guest:findAll', '获取所有客人/入住者', 19),
(21, '/customer/findAll', 'customer:findAll', '获取所有顾客/预订者', 19),
(22, '/RoomOf', 'hotel:roomOf', '房间相关', 18),
(23, '/type/findAll', 'type:findAll', '获取所有房间类别，分页', 22),
(33, '/band/findAll', 'band:findAll', '获取所有折扣', 22),
(38, '/FacilityManager', 'hotel:facilityManager', '设施管理', 18),
(39, '/facility/deleteById', 'facility:deleteById', '删除设施', 38),
(40, '/facility/save', 'facility:save', '添加设施', 38),
(41, '/Payment', 'hotel:payment', '收费统计', 18),
(42, '/payment/findAll', 'payment:findAll', '获取所有账单', 41),
(43, '/payment/getTotal', 'payment:getTotal', '账单统计', 41);

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '角色名',
  `chineseName` varchar(255) NOT NULL COMMENT '角色名中文表示',
  `perm` varchar(255) NOT NULL DEFAULT '1,2,4,7,8,14,15,16,17' COMMENT '权限集',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='角色表' AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `name`, `chineseName`, `perm`) VALUES
(1, 'root', 'root', '1,2,4,7,8,14,15,16,17,18,19,20,21,22,23,33,38,39,40,41,42,43'),
(2, 'reception', '前台', '1,2,4,7,8,14,15,16,17'),
(3, 'manager', '经理', '1,2,4,7,8,14,15,16,17,18,19,20,21'),
(5, 'president', '总经理', '1,2,4,7,8,14,15,16,17,18,19,20,21,38,39,40'),
(6, 'shopowner', '店长', '1,2,4,7,8,14,15,16,17,18,19,20,21,22,23,33,38,39,40,41,42,43');

-- --------------------------------------------------------

--
-- 表的结构 `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL DEFAULT '0' COMMENT '订单号',
  `typeId` int(11) NOT NULL COMMENT '房间类别',
  `num` int(11) NOT NULL COMMENT '房号',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='房间表' AUTO_INCREMENT=52 ;

--
-- 转存表中的数据 `room`
--

INSERT INTO `room` (`id`, `bookId`, `typeId`, `num`) VALUES
(1, 0, 1, 101),
(2, 59, 1, 102),
(3, 0, 2, 201),
(4, 0, 1, 103),
(5, 0, 5, 901),
(6, 58, 7, 203),
(7, 53, 2, 202),
(8, 55, 1, 205),
(9, 0, 1, 206),
(10, 0, 1, 301),
(11, 0, 1, 302),
(12, 0, 1, 303),
(13, 0, 1, 304),
(14, 0, 2, 305),
(15, 0, 2, 306),
(16, 0, 2, 401),
(17, 0, 2, 402),
(18, 0, 2, 403),
(19, 0, 2, 404),
(20, 0, 2, 405),
(21, 0, 2, 406),
(22, 0, 2, 501),
(23, 0, 2, 502),
(24, 57, 3, 503),
(25, 0, 3, 504),
(26, 0, 3, 505),
(27, 0, 3, 506),
(28, 0, 3, 601),
(29, 0, 3, 602),
(30, 0, 3, 603),
(31, 0, 3, 604),
(32, 0, 4, 605),
(33, 0, 4, 606),
(34, 0, 4, 701),
(35, 0, 4, 702),
(36, 0, 4, 703),
(37, 0, 4, 704),
(38, 0, 4, 705),
(39, 0, 4, 706),
(40, 0, 4, 107),
(41, 0, 4, 207),
(42, 0, 5, 902),
(43, 0, 6, 307),
(44, 56, 6, 407),
(45, 54, 6, 507),
(46, 0, 7, 607),
(47, 0, 7, 707),
(48, 0, 7, 801),
(49, 0, 7, 802),
(50, 0, 7, 803),
(51, 0, 1, 804);

-- --------------------------------------------------------

--
-- 表的结构 `sysuser`
--

CREATE TABLE IF NOT EXISTS `sysuser` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) NOT NULL DEFAULT '新的用户' COMMENT '用户昵称',
  `userName` varchar(255) NOT NULL COMMENT '登录账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '用户状态，2锁定1正常0禁用',
  `lockEnding` varchar(12) NOT NULL DEFAULT '202004012142' COMMENT '用户解除锁定的时间',
  `role` int(11) NOT NULL DEFAULT '2' COMMENT '所属角色',
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  KEY `role_2` (`role`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户表' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `sysuser`
--

INSERT INTO `sysuser` (`id`, `nickName`, `userName`, `password`, `status`, `lockEnding`, `role`) VALUES
(1, 'root', 'root', 'root', 1, '202004012142', 1),
(2, '前台', '2', '2', 1, '202004012142', 2),
(3, '经理', '3', '3', 1, '202004012142', 3),
(4, '总经理', '5', '5', 1, '202004012142', 5),
(5, '店长', '6', '6', 1, '202004012142', 6);

-- --------------------------------------------------------

--
-- 表的结构 `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '房间类别名',
  `lives` int(1) NOT NULL COMMENT '可住人数',
  `price` int(11) NOT NULL COMMENT '价格',
  `area` int(4) NOT NULL COMMENT '房间大小',
  `facilities` varchar(255) NOT NULL COMMENT '房间设施',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='房间类别表' AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `type`
--

INSERT INTO `type` (`id`, `name`, `lives`, `price`, `area`, `facilities`) VALUES
(1, '普通单人房', 1, 100, 30, '1,3,7,5'),
(2, '高级双人床', 2, 280, 50, '1,2,3,5,7'),
(3, '豪华双人床', 2, 400, 60, '1,2,3,5,7'),
(4, '亲子房', 2, 350, 50, '1,2,3,7'),
(5, '总统套房', 2, 5000, 90, '1,2,3,4,5,6,7'),
(6, '商务房', 2, 400, 60, '1,2,3,5,6,7'),
(7, '标准房', 2, 200, 40, '1,3,5,7');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
