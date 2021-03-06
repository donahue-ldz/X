DROP TABLE IF EXISTS `X_teacher`;
CREATE TABLE `X_teacher` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`teacher_ID` int(11) NOT NULL COMMENT '教师工号,唯一',
`teacher_name` VARCHAR(255) NOT NULL COMMENT '教师名',
`avatar_ID` INT COMMENT '头像ID',
`email` VARCHAR(100) DEFAULT  NULL COMMENT '电子邮件',
`nick` VARCHAR(100) DEFAULT NULL COMMENT '昵称',
`status`    VARCHAR(2)       DEFAULT '1' COMMENT '状态',
`gmt_create` DATETIME COMMENT '创建时间',
`gmt_modified` DATETIME COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
