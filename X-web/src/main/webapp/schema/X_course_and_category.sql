DROP TABLE IF EXISTS `X_course_and_category`;
CREATE TABLE `X_course_and_category` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`course_ID` VARCHAR(255) DEFAULT  NULL COMMENT '电子邮件,唯一',
`category_ID` INT(11) COMMENT '分类ID',
`status`    VARCHAR(2)   DEFAULT '1' COMMENT '状态',
`gmt_create` DATETIME COMMENT '创建时间',
`gmt_modified` DATETIME COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
