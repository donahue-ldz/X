drop table IF EXISTS `X_topic_category_mapping`;
CREATE TABLE `X_topic_category_mapping` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `topic_id` BIGINT(11) NOT NULL COMMENT '评论ID',
  `category_id` BIGINT(11) NOT NULL COMMENT '用户ID',
  `user_role` VARCHAR(40) NOT NULL COMMENT '用户角色',
  `status` VARCHAR(2) NOT NULL COMMENT '最受欢迎的帖子状态(正常:1,删除:2)',
  `gmt_create` DATE COMMENT '创建时间',
  `gmt_modified` DATE COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
