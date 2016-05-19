drop table IF EXISTS `X_topic_rate`;
CREATE TABLE `X_topic_rate` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` BIGINT(11) NOT NULL COMMENT '帖子ID',
  `user_ID` BIGINT(11) NOT NULL COMMENT '用户ID',
  `user_role` VARCHAR(40) NOT NULL COMMENT '用户角色',
  `rate_type` VARCHAR(1) NOT NULL COMMENT '评价 1. favorite 2.share 4. 浏览次数 5. 收藏',
  `status` VARCHAR(2) DEFAULT '1' NOT NULL  COMMENT '(正常:1,删除:0)',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
