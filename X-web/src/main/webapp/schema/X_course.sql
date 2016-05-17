DROP TABLE IF EXISTS `X_course`;
CREATE TABLE `X_course` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL COMMENT '课程名',
  `description` longtext  NULL COMMENT '描述',
  `picture_ID`     INT(11) NULL  COMMENT '图片ID',
  `short_desc`     VARCHAR(255)  NOT NULL  COMMENT '简短描述',
  `course_hours`      INT (11)  NULL COMMENT '课时',
  `course_credit`   INT (11) COMMENT '学分',
  `status`    VARCHAR(2)    DEFAULT '1' COMMENT '状态',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
