drop table IF EXISTS `X_topic_and_category`;
CREATE TABLE `X_topic_and_category` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `topic_ID` BIGINT(11) NOT NULL COMMENT '帖子ID',
  `topic_category_ID` BIGINT(11) NOT NULL COMMENT '分类ID',
  `status` VARCHAR(2) DEFAULT '1' NULL COMMENT '(正常:1,删除:0)',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
