DROP TABLE IF EXISTS `X_student`;
CREATE TABLE `X_student` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `student_ID` INT(11) NOT NULL UNIQUE COMMENT '学号,唯一',
  `student_Name` VARCHAR(255) NOT NULL COMMENT '学生姓名',
  `email`     VARCHAR(100)  NOT NULL UNIQUE COMMENT '电子邮件',
  `nick`      VARCHAR(100)  NULL COMMENT '昵称',
  `status`    VARCHAR(2)    DEFAULT '1' COMMENT '状态',
  `gmt_create` DATE COMMENT '创建时间',
  `gmt_modified` DATE COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;