/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.29 : Database - w951_db_zsbus_staffchannel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`w951_db_zsbus_staffchannel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `w951_db_zsbus_staffchannel`;

/*Table structure for table `zsbus_staffchannel_branch` */

DROP TABLE IF EXISTS `zsbus_staffchannel_branch`;

CREATE TABLE `zsbus_staffchannel_branch` (
  `branch_id` varchar(32) NOT NULL COMMENT '部门ID',
  `branch_pid` varchar(32) DEFAULT NULL COMMENT '上级部门',
  `branch_no` varchar(10) DEFAULT NULL COMMENT '部门编号',
  `branch_name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `branch_manager` varchar(10) DEFAULT NULL COMMENT '部门主管',
  `branch_summary` varchar(100) DEFAULT NULL COMMENT '部门简介',
  `branch_phone` varchar(20) DEFAULT NULL COMMENT '部门电话',
  `branch_email` varchar(20) DEFAULT NULL COMMENT '部门邮箱',
  `branch_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `branch_createname` varchar(10) DEFAULT NULL COMMENT '创建人',
  `branch_createdate` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zsbus_staffchannel_branch` */

insert  into `zsbus_staffchannel_branch`(`branch_id`,`branch_pid`,`branch_no`,`branch_name`,`branch_manager`,`branch_summary`,`branch_phone`,`branch_email`,`branch_remark`,`branch_createname`,`branch_createdate`) values ('402881e746416b410146416d283c0001','0','000','全部部门','CEO','','','','','admin','2014-05-28 14:03:31');

/*Table structure for table `zsbus_staffchannel_notice` */

DROP TABLE IF EXISTS `zsbus_staffchannel_notice`;

CREATE TABLE `zsbus_staffchannel_notice` (
  `notice_id` varchar(32) NOT NULL COMMENT '通知ID',
  `notice_title` varchar(50) DEFAULT NULL COMMENT '通知标题',
  `notice_content` text COMMENT '通知内容',
  `notice_createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `notice_createname` varchar(20) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zsbus_staffchannel_notice` */

insert  into `zsbus_staffchannel_notice`(`notice_id`,`notice_title`,`notice_content`,`notice_createdate`,`notice_createname`) values ('402881e7463735ba0146374e4356000e','关于端午节放假的通知','<h1 style=\"text-align:center\"><strong><span style=\"color:#FF0000\">关于端午节放假的通知</span></strong></h1>\r\n\r\n<p>&nbsp;&nbsp;&nbsp; 关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知.</p>\r\n\r\n<p>&nbsp;&nbsp;&nbsp; 关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知关于端午节放假的通知.</p>\r\n','2014-05-26 14:53:34','admin');

/*Table structure for table `zsbus_staffchannel_staff` */

DROP TABLE IF EXISTS `zsbus_staffchannel_staff`;

CREATE TABLE `zsbus_staffchannel_staff` (
  `staff_id` varchar(32) NOT NULL COMMENT '员工ID',
  `staff_no` varchar(20) DEFAULT NULL COMMENT '员工工号',
  `staff_password` varchar(20) DEFAULT NULL COMMENT '员工密码',
  `staff_name` varchar(20) DEFAULT NULL COMMENT '员工姓名',
  `staff_sex` int(1) DEFAULT NULL COMMENT '员工性别',
  `staff_birthdate` date DEFAULT NULL COMMENT '员工出生日期',
  `staff_age` int(11) DEFAULT NULL COMMENT '员工年龄',
  `staff_entrydate` date DEFAULT NULL COMMENT '员工入职日期',
  `staff_political` int(1) DEFAULT NULL COMMENT '员工政治面貌',
  `staff_marriage` int(1) DEFAULT NULL COMMENT '员工婚姻',
  `staff_departure` varchar(20) DEFAULT NULL COMMENT '员工祖籍',
  `staff_address` varchar(50) DEFAULT NULL COMMENT '员工住址',
  `staff_remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `staff_createname` varchar(10) DEFAULT NULL COMMENT '创建人',
  `staff_createdate` datetime DEFAULT NULL COMMENT '创建日期',
  `staff_branch_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`staff_id`),
  KEY `staff_branch_id` (`staff_branch_id`),
  CONSTRAINT `zsbus_staffchannel_staff_ibfk_1` FOREIGN KEY (`staff_branch_id`) REFERENCES `zsbus_staffchannel_branch` (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zsbus_staffchannel_staff` */

/*Table structure for table `zsbus_staffchannel_system` */

DROP TABLE IF EXISTS `zsbus_staffchannel_system`;

CREATE TABLE `zsbus_staffchannel_system` (
  `system_id` varchar(32) NOT NULL COMMENT '制度ID',
  `system_title` varchar(50) DEFAULT NULL COMMENT '制度标题',
  `system_content` text COMMENT '制度内容',
  `system_createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `system_createname` varchar(20) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zsbus_staffchannel_system` */

insert  into `zsbus_staffchannel_system`(`system_id`,`system_title`,`system_content`,`system_createdate`,`system_createname`) values ('402881e7463735ba01463750034b000f','关于考勤制度','<h1 style=\"text-align: center;\"><span style=\"color:#FF0000\"><strong>关于考勤制度</strong></span></h1>\r\n\r\n<p>&nbsp;&nbsp;&nbsp; 关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度。</p>\r\n\r\n<p>&nbsp;&nbsp;&nbsp; 关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度关于考勤制度。</p>\r\n','2014-05-26 14:55:29','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
