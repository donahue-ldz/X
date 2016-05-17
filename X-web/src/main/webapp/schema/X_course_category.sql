DROP TABLE IF EXISTS `X_course_category`;
CREATE TABLE `X_course_category` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255) NOT NULL UNIQUE
  COMMENT '分类名',
  `parent_ID`    INT(11)     NULL
  COMMENT '父ID',
  `description`         VARCHAR(255) NULL
  COMMENT '昵称',
  `status`       VARCHAR(2)            DEFAULT '1'
  COMMENT '状态',
  `gmt_create`   DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
INSERT INTO X_course_category(name,parent_ID,description)VALUES ('所有',-1,'根节点');