drop table IF EXISTS `X_topic`;
CREATE TABLE `X_topic` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(11) NOT NULL COMMENT '发布人ID',
  `user_role` VARCHAR(1) NOT NULL COMMENT '发布人角色',
  `title` TEXT NOT NULL COMMENT '帖子标题',
  `content` LONGTEXT NOT NULL COMMENT '帖子内容',
  `key_words` VARCHAR(255) COMMENT '贴子关键字',
  `weight` DOUBLE  NULL COMMENT '帖子权重',
  `status` VARCHAR(2) DEFAULT '1' NOT NULL COMMENT '帖子状态(正常:1,删除:0)',
  `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
