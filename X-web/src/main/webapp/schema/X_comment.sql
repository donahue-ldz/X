drop table IF EXISTS `X_comment`;
CREATE TABLE `X_comment` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` BIGINT(11) NOT NULL COMMENT '帖子ID',
  `user_ID` BIGINT(11) NOT NULL COMMENT '用户ID',
  `user_role` VARCHAR(40) NOT NULL COMMENT '用户角色',
  `content` LONGTEXT NOT NULL COMMENT '评论内容',
  `status` VARCHAR(2) DEFAULT '1' NOT NULL COMMENT '评论状态(正常:1,删除:0)',
  `gmt_create` DATETIME COMMENT '评论发起时间',
  `gmt_modified` DATETIME COMMENT '评论更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
