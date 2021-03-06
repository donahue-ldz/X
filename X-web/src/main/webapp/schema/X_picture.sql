DROP TABLE IF EXISTS `X_picture`;
CREATE TABLE `X_picture` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `alt` VARCHAR(255)  NULL COMMENT '描述',
  `url` VARCHAR(255)  NULL COMMENT '地址',
  `status`     VARCHAR (2) DEFAULT '1' COMMENT  '状态',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
