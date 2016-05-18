drop table IF EXISTS `X_comment_favorite`;
CREATE TABLE `X_comment_favorite` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `comment_ID` BIGINT(11) NOT NULL COMMENT '评论ID',
  `user_ID` BIGINT(11) NOT NULL COMMENT '用户ID',
  `user_role` VARCHAR(40) NOT NULL COMMENT '用户角色',
  `status` VARCHAR(2) DEFAULT '1' NOT NULL COMMENT '最受欢迎的帖子状态(正常:1,删除:0)',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
