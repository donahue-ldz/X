DROP TABLE IF EXISTS `X_admin`;
CREATE TABLE `X_admin` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`email` VARCHAR(255)  NOT NULL UNIQUE COMMENT '电子邮件,唯一',
`adminName` VARCHAR(255) DEFAULT  NULL COMMENT '名',
`password` VARCHAR(255) DEFAULT NULL COMMENT '密码',
`avatar_ID` INT(11) DEFAULT NULL COMMENT '头像',
`nick` VARCHAR(255) DEFAULT NULL COMMENT '昵称',
`status`    VARCHAR(2)       DEFAULT '1' COMMENT '状态',
`gmt_create` DATETIME COMMENT '创建时间',
`gmt_modified` DATETIME COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO X_admin(email, adminName, password, nick)
    VALUES ('admin@admin.com','admin','1','与水')