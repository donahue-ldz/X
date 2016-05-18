-- MySQL dump 10.13  Distrib 5.7.12, for osx10.11 (x86_64)
--
-- Host: 162.221.196.101    Database: X
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `X_admin`
--

DROP TABLE IF EXISTS `X_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL COMMENT '电子邮件,唯一',
  `adminName` varchar(255) DEFAULT NULL COMMENT '名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `avatar_ID` int(11) DEFAULT NULL COMMENT '头像',
  `nick` varchar(255) DEFAULT NULL COMMENT '昵称',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_admin`
--

LOCK TABLES `X_admin` WRITE;
/*!40000 ALTER TABLE `X_admin` DISABLE KEYS */;
INSERT INTO `X_admin` VALUES (1,'admin@admin.com','admin','1',NULL,'与水','1',NULL,NULL);
/*!40000 ALTER TABLE `X_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_comment`
--

DROP TABLE IF EXISTS `X_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` bigint(11) NOT NULL COMMENT '帖子ID',
  `user_ID` bigint(11) NOT NULL COMMENT '用户ID',
  `user_role` varchar(40) NOT NULL COMMENT '用户角色',
  `content` longtext NOT NULL COMMENT '评论内容',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '评论状态(正常:1,删除:0)',
  `gmt_create` datetime DEFAULT NULL COMMENT '评论发起时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '评论更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_comment`
--

LOCK TABLES `X_comment` WRITE;
/*!40000 ALTER TABLE `X_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `X_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_comment_favorite`
--

DROP TABLE IF EXISTS `X_comment_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_comment_favorite` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `comment_ID` bigint(11) NOT NULL COMMENT '评论ID',
  `user_ID` bigint(11) NOT NULL COMMENT '用户ID',
  `user_role` varchar(40) NOT NULL COMMENT '用户角色',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '最受欢迎的帖子状态(正常:1,删除:0)',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_comment_favorite`
--

LOCK TABLES `X_comment_favorite` WRITE;
/*!40000 ALTER TABLE `X_comment_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `X_comment_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_course`
--

DROP TABLE IF EXISTS `X_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '课程名',
  `description` longtext COMMENT '描述',
  `picture_ID` int(11) DEFAULT NULL COMMENT '图片ID',
  `short_desc` varchar(255) NOT NULL COMMENT '简短描述',
  `course_hours` int(11) DEFAULT NULL COMMENT '课时',
  `course_credit` int(11) DEFAULT NULL COMMENT '学分',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_course`
--

LOCK TABLES `X_course` WRITE;
/*!40000 ALTER TABLE `X_course` DISABLE KEYS */;
INSERT INTO `X_course` VALUES (1,'ss','ss',1,'ss',11,11,'1','2016-05-16',NULL),(2,'ss','ss',1,'ss',11,11,'1','2016-05-16',NULL),(3,'测试课程','测试，我只是测试',1,'测试啊，傻',11,1111,'1','2016-05-16',NULL),(4,'测试','测试下',5,'测试',11,11,'1','2016-05-16',NULL);
/*!40000 ALTER TABLE `X_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_course_and_category`
--

DROP TABLE IF EXISTS `X_course_and_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_course_and_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_ID` varchar(255) DEFAULT NULL COMMENT '电子邮件,唯一',
  `category_ID` int(11) DEFAULT NULL COMMENT '分类ID',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_course_and_category`
--

LOCK TABLES `X_course_and_category` WRITE;
/*!40000 ALTER TABLE `X_course_and_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `X_course_and_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_course_category`
--

DROP TABLE IF EXISTS `X_course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_course_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '分类名',
  `parent_ID` int(11) DEFAULT NULL COMMENT '父ID',
  `description` varchar(255) DEFAULT NULL COMMENT '昵称',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_course_category`
--

LOCK TABLES `X_course_category` WRITE;
/*!40000 ALTER TABLE `X_course_category` DISABLE KEYS */;
INSERT INTO `X_course_category` VALUES (1,'所有',-1,'根节点','1',NULL,NULL),(2,'软件开发',1,NULL,'1','2016-05-15',NULL),(3,'金融管理',1,NULL,'1','2016-05-15',NULL);
/*!40000 ALTER TABLE `X_course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_course_rate`
--

DROP TABLE IF EXISTS `X_course_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_course_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_ID` varchar(255) DEFAULT NULL COMMENT '电子邮件,唯一',
  `student_ID` int(11) DEFAULT NULL COMMENT '头像',
  `rate_type` varchar(1) DEFAULT NULL COMMENT '昵称',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_course_rate`
--

LOCK TABLES `X_course_rate` WRITE;
/*!40000 ALTER TABLE `X_course_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `X_course_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_picture`
--

DROP TABLE IF EXISTS `X_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alt` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` varchar(255) DEFAULT NULL COMMENT '地址',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_picture`
--

LOCK TABLES `X_picture` WRITE;
/*!40000 ALTER TABLE `X_picture` DISABLE KEYS */;
INSERT INTO `X_picture` VALUES (2,NULL,'o7716nd3v.bkt.clouddn.com/20160516110629_63622ea9ae7847f6b801b9920dd35ca5.jpg','1','2016-05-16',NULL),(3,NULL,'o7716nd3v.bkt.clouddn.com/20160516142653_dd0f16222a974aaca35849aacca7fc1d.jpg','1','2016-05-16',NULL),(4,NULL,'7xu30m.com1.z0.glb.clouddn.com/20160516143301_a4af71701e514947b4da937a1522048b.jpg','1','2016-05-16',NULL),(5,NULL,'7xu30m.com1.z0.glb.clouddn.com/20160516150844_10c29de0cf32459f851dfd165b901b1f.jpg','1','2016-05-16',NULL);
/*!40000 ALTER TABLE `X_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_rule`
--

DROP TABLE IF EXISTS `X_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(255) NOT NULL COMMENT '规则名,唯一',
  `score` int(11) NOT NULL COMMENT '积分',
  `description` longtext COMMENT '描述',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rule_name` (`rule_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_rule`
--

LOCK TABLES `X_rule` WRITE;
/*!40000 ALTER TABLE `X_rule` DISABLE KEYS */;
INSERT INTO `X_rule` VALUES (1,'学分换积分',1,'1学分＝1积分','admin','1','2016-05-17 16:48:51',NULL),(2,'在线时长',1,'10小时在线时长1个积分','admin','1','2016-05-17 16:58:00',NULL);
/*!40000 ALTER TABLE `X_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_student`
--

DROP TABLE IF EXISTS `X_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_ID` varchar(30) NOT NULL COMMENT '学号,唯一',
  `student_name` varchar(255) NOT NULL COMMENT '学生姓名',
  `avatar_ID` int(11) DEFAULT NULL COMMENT '用户头像',
  `email` varchar(255) NOT NULL COMMENT '电子邮件',
  `nick` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` varchar(2) DEFAULT '1' COMMENT '状态',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_ID` (`student_ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_student`
--

LOCK TABLES `X_student` WRITE;
/*!40000 ALTER TABLE `X_student` DISABLE KEYS */;
INSERT INTO `X_student` VALUES (1,'student','测试',1,'ldz2012yn@gmail.com','与水','1','1',NULL,NULL),(2,'1','yushui',NULL,'mail@qq.com',NULL,'1','1','2016-05-16',NULL),(5,'2','yushui',NULL,'sss@qq.com',NULL,'2','1','2016-05-16',NULL),(7,'donahue','donahue',NULL,'donahue@qq.com',NULL,'donahue','1','2016-05-16',NULL),(8,'321','donahue',NULL,'do@mail.qq',NULL,'1','1','2016-05-16',NULL);
/*!40000 ALTER TABLE `X_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_topic`
--

DROP TABLE IF EXISTS `X_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_topic` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '发布人ID',
  `user_role` varchar(1) NOT NULL COMMENT '发布人角色',
  `title` text NOT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `key_words` varchar(255) DEFAULT NULL COMMENT '贴子关键字',
  `weight` double DEFAULT NULL COMMENT '帖子权重',
  `status` varchar(2) DEFAULT '1' COMMENT '帖子状态(正常:1,删除:2)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_topic`
--

LOCK TABLES `X_topic` WRITE;
/*!40000 ALTER TABLE `X_topic` DISABLE KEYS */;
INSERT INTO `X_topic` VALUES (4,1,'2','测试','测试',NULL,NULL,NULL,'2016-05-18 10:07:19',NULL);
/*!40000 ALTER TABLE `X_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_topic_and_category`
--

DROP TABLE IF EXISTS `X_topic_and_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_topic_and_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` bigint(11) NOT NULL COMMENT '帖子ID',
  `topic_category_ID` bigint(11) NOT NULL COMMENT '分类ID',
  `status` varchar(2) DEFAULT '1' COMMENT '(正常:1,删除:0)',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_topic_and_category`
--

LOCK TABLES `X_topic_and_category` WRITE;
/*!40000 ALTER TABLE `X_topic_and_category` DISABLE KEYS */;
INSERT INTO `X_topic_and_category` VALUES (1,4,2,'1','2016-05-18 10:07:20',NULL);
/*!40000 ALTER TABLE `X_topic_and_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_topic_category`
--

DROP TABLE IF EXISTS `X_topic_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_topic_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父亲节点',
  `name_cn` varchar(20) NOT NULL COMMENT '帖子目录中文名',
  `name_en` varchar(40) NOT NULL COMMENT '帖子目录英文名',
  `pic` varchar(255) DEFAULT NULL COMMENT '贴子目录图片',
  `desc` varchar(255) NOT NULL COMMENT '帖子目录描述',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '帖子目录状态(正常:1,删除:2)',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_topic_category`
--

LOCK TABLES `X_topic_category` WRITE;
/*!40000 ALTER TABLE `X_topic_category` DISABLE KEYS */;
INSERT INTO `X_topic_category` VALUES (1,NULL,'热门','hot',NULL,'一周内最活跃的帖子','1','2016-05-17 21:00:39',NULL),(2,NULL,'编程','program',NULL,'编程爱好','1','2016-05-17 21:08:37',NULL);
/*!40000 ALTER TABLE `X_topic_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `X_topic_favorite`
--

DROP TABLE IF EXISTS `X_topic_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `X_topic_favorite` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` bigint(11) NOT NULL COMMENT '帖子ID',
  `user_ID` bigint(11) NOT NULL COMMENT '用户ID',
  `user_role` varchar(40) NOT NULL COMMENT '用户角色',
  `status` varchar(2) NOT NULL DEFAULT '1' COMMENT '最受欢迎的帖子状态(正常:1,删除:0)',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `X_topic_favorite`
--

LOCK TABLES `X_topic_favorite` WRITE;
/*!40000 ALTER TABLE `X_topic_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `X_topic_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'X'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-18 16:13:36
