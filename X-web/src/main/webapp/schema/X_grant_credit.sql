DROP TABLE IF EXISTS `X_grant_credit`;
CREATE TABLE `X_grant_credit` (
  `id`           BIGINT(11)   NOT NULL AUTO_INCREMENT,
  `rules`        LONGTEXT     NULL
  COMMENT '规则名',
  `student_ID`   VARCHAR(255) NOT NULL
  COMMENT '学号',
  `scores`       INT(11)      NOT NULL
  COMMENT '分数',
  `creator`      VARCHAR(255) NOT NULL NULL
  COMMENT '操作人',
  `description`  LONGTEXT              DEFAULT NULL
  COMMENT '备注',
  `status`       VARCHAR(2)            DEFAULT '1'
  COMMENT '状态',
  `gmt_create`   DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
