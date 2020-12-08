/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.7.29-log : Database - livable
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`livable` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `livable`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `belong_to` varchar(32) NOT NULL DEFAULT '0' COMMENT '上一级行政单位名',
  `name` varchar(32) NOT NULL COMMENT '行政单位中文名',
  `shortname` varchar(32) NOT NULL COMMENT '简称',
  `level` varchar(1) NOT NULL COMMENT '行政级别 市-city 地区-region',
  `baidu_map_lng` varchar(20) NOT NULL COMMENT '百度地图经度',
  `baidu_map_lat` varchar(20) NOT NULL COMMENT '百度地图纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `address` */

/*Table structure for table `allocation` */

DROP TABLE IF EXISTS `allocation`;

CREATE TABLE `allocation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tv` int(11) DEFAULT '0' COMMENT '电视',
  `refrigerator` int(11) DEFAULT '0' COMMENT '冰箱',
  `washing_machine` int(11) DEFAULT '0' COMMENT '洗衣机',
  `air_condition` int(11) DEFAULT '0' COMMENT '空调',
  `wifi` int(11) DEFAULT '0' COMMENT 'WI-FI',
  `beds` int(11) DEFAULT '0' COMMENT '床',
  `water_heater` int(11) DEFAULT '0' COMMENT '热水器',
  `chest` int(11) DEFAULT '0' COMMENT '衣柜',
  `desk` int(11) DEFAULT '0' COMMENT '书桌',
  `cooking` int(11) DEFAULT '0' COMMENT '烹饪',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `allocation` */

/*Table structure for table `databasechangelog` */

DROP TABLE IF EXISTS `databasechangelog`;

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) COLLATE utf8_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `databasechangelog` */

insert  into `databasechangelog`(`ID`,`AUTHOR`,`FILENAME`,`DATEEXECUTED`,`ORDEREXECUTED`,`EXECTYPE`,`MD5SUM`,`DESCRIPTION`,`COMMENTS`,`TAG`,`LIQUIBASE`,`CONTEXTS`,`LABELS`,`DEPLOYMENT_ID`) values ('change','zhang','classpath:db/sql/livable.sql','2020-11-05 15:49:27',1,'EXECUTED','8:8a23c61ac028d6411f7894756ad52e67','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('1','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:27',2,'EXECUTED','8:dd921cf7cdec8cfe087e3aba0c0e3036','addColumn tableName=house','',NULL,'3.6.2','master',NULL,'4562563097'),('2','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:35',3,'EXECUTED','8:ab2385e508f7a180d99b31de67f4ac1f','sql; dropColumn tableName=house; sql; sql; sql; sql; sql; sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('3','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:36',4,'EXECUTED','8:eed04937b174bda2a33ba943aff0504b','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('4','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:37',5,'EXECUTED','8:24878e6f8a358d32f919f6cc19a617e2','sql; sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('5','wws','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:38',6,'EXECUTED','8:5485cef09f417272a90dd53a238dddd4','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('6','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:39',7,'EXECUTED','8:9e3055a2fb9e5b6f9e82b8065748460e','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('7','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:41',8,'EXECUTED','8:acf023cb6bfef68ac3bc19887afeb5d8','sql; sql; sql; sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('8','wws','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:41',9,'EXECUTED','8:8b6cb79c854b93df6532afabbe169ef9','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('9','wws','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:43',10,'EXECUTED','8:ea6da6f4ebf222febf6c0801f2fbcb38','sql; sql; sql; sql; sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('10','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:43',11,'EXECUTED','8:48db41a4e2b1d786336148be0da0e5a8','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('11','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:44',12,'EXECUTED','8:6bf08e1d9bff5753616e70aa166369cf','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('12','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:44',13,'EXECUTED','8:a2e3910e87a4cab1e29b3984fe1e2bab','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('13','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:45',14,'EXECUTED','8:250862dcad49cdbef8213ea19f70a5a9','sql','',NULL,'3.6.2',NULL,NULL,'4562563097'),('14','yesanqiu','classpath:/db/db.changelog-master.xml','2020-11-05 15:49:47',15,'EXECUTED','8:00effd7bce56b83548fd2425d2a3b5ed','sql','',NULL,'3.6.2',NULL,NULL,'4562563097');

/*Table structure for table `databasechangeloglock` */

DROP TABLE IF EXISTS `databasechangeloglock`;

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `databasechangeloglock` */

insert  into `databasechangeloglock`(`ID`,`LOCKED`,`LOCKGRANTED`,`LOCKEDBY`) values (1,'\0',NULL,NULL);

/*Table structure for table `feature` */

DROP TABLE IF EXISTS `feature`;

CREATE TABLE `feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `independent_bathroom` int(11) DEFAULT '0' COMMENT '独立卫浴',
  `independent_balcony` int(11) DEFAULT '0' COMMENT '独立阳台',
  `smart_sock` int(11) DEFAULT '0' COMMENT '智能锁',
  `self_decorating` int(11) DEFAULT '0' COMMENT '可自行装修',
  `first_rent` int(11) DEFAULT '0' COMMENT '首次出租',
  `fully_furnished` int(11) DEFAULT '0' COMMENT '拎包入住',
  `nearby_subway` int(11) DEFAULT '0' COMMENT '地铁十分钟',
  `any_time_to_see` int(11) DEFAULT '0' COMMENT '随时看房',
  `check_in_at_once` int(11) DEFAULT '0' COMMENT '随时入住',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `feature` */

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `house_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房源ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `house_type` varchar(255) DEFAULT NULL COMMENT '房型',
  `rent` varchar(255) DEFAULT NULL COMMENT '租金',
  `rent_way` varchar(255) DEFAULT NULL COMMENT '方式',
  `rent_type` varchar(20) DEFAULT NULL COMMENT '租房方式',
  `number_of_people` int(11) DEFAULT NULL COMMENT '租房人数',
  `elevator` varchar(10) DEFAULT NULL COMMENT '电梯有无',
  `toward` varchar(10) DEFAULT NULL COMMENT '电梯有无',
  `carport` varchar(10) DEFAULT NULL COMMENT '电梯有无',
  `energy_charge` varchar(255) DEFAULT NULL COMMENT '电费',
  `water_charge` varchar(255) DEFAULT NULL COMMENT '水费',
  `feature_id` int(11) DEFAULT NULL COMMENT '特色id',
  `acreage` varchar(255) DEFAULT NULL COMMENT '面积',
  `layout` varchar(255) DEFAULT NULL COMMENT '布局',
  `allocation_id` int(11) DEFAULT NULL COMMENT '配置id',
  `introduction` text COMMENT '介绍',
  `status` varchar(10) DEFAULT NULL COMMENT '电梯有无',
  `house_proprietary_certificate` varchar(255) DEFAULT NULL COMMENT '房产证',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`house_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `house` */

/*Table structure for table `id_information` */

DROP TABLE IF EXISTS `id_information`;

CREATE TABLE `id_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `name` varchar(11) NOT NULL COMMENT '真实姓名',
  `id_card_type` varchar(25) NOT NULL COMMENT '证件类型',
  `id_number` int(25) NOT NULL COMMENT '证件号',
  `id_card_pic_z` varchar(255) NOT NULL COMMENT '证件照正面',
  `id_card_pic_f` varchar(255) NOT NULL COMMENT '证件照背面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `id_information` */

/*Table structure for table `landlord_house_relation` */

DROP TABLE IF EXISTS `landlord_house_relation`;

CREATE TABLE `landlord_house_relation` (
  `user_id` int(11) NOT NULL COMMENT '房东ID',
  `house_id` int(11) NOT NULL COMMENT '房子ID',
  `relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `publish_time` datetime DEFAULT NULL COMMENT '发行时间',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `landlord_house_relation` */

/*Table structure for table `landlord_information` */

DROP TABLE IF EXISTS `landlord_information`;

CREATE TABLE `landlord_information` (
  `user_id` int(11) NOT NULL COMMENT '房东ID',
  `id_number` varchar(25) NOT NULL,
  `id_card_picture_f` varchar(255) DEFAULT NULL COMMENT '身份证正面',
  `id_card_picture_r` varchar(255) DEFAULT NULL COMMENT '身份证反面',
  `alipay_name` varchar(255) DEFAULT NULL COMMENT '支付宝账户名',
  `alipay_account` varchar(255) DEFAULT NULL COMMENT '支付宝账号',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `landlord_information` */

/*Table structure for table `like_house` */

DROP TABLE IF EXISTS `like_house`;

CREATE TABLE `like_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '用户id',
  `house_id` int(11) DEFAULT '0' COMMENT '房源id',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `like_house` */

/*Table structure for table `looked` */

DROP TABLE IF EXISTS `looked`;

CREATE TABLE `looked` (
  `looked_id` int(11) NOT NULL AUTO_INCREMENT,
  `looking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`looked_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `looked` */

/*Table structure for table `looking` */

DROP TABLE IF EXISTS `looking`;

CREATE TABLE `looking` (
  `looking_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `house_id` int(11) NOT NULL COMMENT '房源ID',
  `data` varchar(255) NOT NULL COMMENT '时间',
  `site` varchar(25) NOT NULL COMMENT '地点',
  PRIMARY KEY (`looking_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `looking` */

/*Table structure for table `opinion_count` */

DROP TABLE IF EXISTS `opinion_count`;

CREATE TABLE `opinion_count` (
  `opinion_id` int(11) NOT NULL COMMENT '意见ID',
  `count` int(11) DEFAULT NULL COMMENT '点赞次数',
  PRIMARY KEY (`opinion_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `opinion_count` */

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `title` varchar(20) NOT NULL COMMENT '权限标题',
  `uri` varchar(50) NOT NULL COMMENT '权限路径',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `permission` */

/*Table structure for table `personal_information` */

DROP TABLE IF EXISTS `personal_information`;

CREATE TABLE `personal_information` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `job` varchar(255) DEFAULT NULL COMMENT '职业',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `personal_information` */

insert  into `personal_information`(`user_id`,`head_portrait`,`age`,`job`,`hobby`) values (1,'test',18,'worker','tennis'),(3,'testUrl',20,'worker','none');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `role` */

insert  into `role`(`role_id`,`name`) values (1,'管理员'),(2,'物业管理员'),(3,'经纪人'),(4,'普通用户');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `role_permission` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `name` varchar(25) NOT NULL COMMENT '姓名',
  `gender` char(1) NOT NULL COMMENT '性别',
  `email` varchar(25) NOT NULL COMMENT '邮箱',
  `password` varchar(25) NOT NULL COMMENT '密码',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `phone` varchar(25) NOT NULL COMMENT '手机号码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`user_id`,`name`,`gender`,`email`,`password`,`role_id`,`phone`) values (1,'aaa','男','319039695@qq.com','123456',1,'111'),(2,'testUpdate','女','liwnw@163.com','123',2,'222'),(4,'test','男','123233@qq.com','123',3,'333'),(5,'test','男','123233@qq.com','123',4,'444'),(6,'test','男','123233@qq.com','123',4,'123423'),(7,'test','男','123233@qq.com','123',4,'123423'),(8,'test','男','123233@qq.com','123',4,'123423');

/*Table structure for table `user_opinion` */

DROP TABLE IF EXISTS `user_opinion`;

CREATE TABLE `user_opinion` (
  `opinion_id` int(11) NOT NULL COMMENT '意见ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `opinion` text COMMENT '意见',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `star` int(11) DEFAULT NULL COMMENT '星数',
  PRIMARY KEY (`opinion_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_opinion` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
