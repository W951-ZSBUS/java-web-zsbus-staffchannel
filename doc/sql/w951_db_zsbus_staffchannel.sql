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

insert  into `zsbus_staffchannel_system`(`system_id`,`system_title`,`system_content`,`system_createdate`,`system_createname`) values ('402881034622fb6401462327b545000e','453','werwe','2014-05-22 16:59:03','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
