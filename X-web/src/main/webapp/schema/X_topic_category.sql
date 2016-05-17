drop table IF EXISTS `X_topic_category`;
CREATE TABLE `X_topic_category` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `parent_id` BIGINT(11) NOT NULL COMMENT '父亲节点',
  `name_cn` VARCHAR(20) NOT NULL COMMENT '帖子目录中文名',
  `name_en` VARCHAR(40) NOT NULL COMMENT '帖子目录英文名',
  `content` LONGTEXT NOT NULL COMMENT '帖子目录内容',
  `pic` VARCHAR(255) COMMENT '贴子目录图片',
  `desc` VARCHAR(255) NOT NULL COMMENT '帖子目录描述',
  `status` VARCHAR(2) NOT NULL COMMENT '帖子目录状态(正常:1,删除:2)',
  `gmt_create` DATE COMMENT '创建时间',
  `gmt_modified` DATE COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = Innodb
  AUTO_INCREMENT = 1
  DEFAULT CHAR SET = UTF8
