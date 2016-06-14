DROP TABLE IF EXISTS `X_student`;
CREATE TABLE `X_student` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `student_ID` VARCHAR (50) NOT NULL UNIQUE COMMENT '学号,唯一',
  `student_name` VARCHAR(255) NOT NULL COMMENT '学生姓名',
  `avatar_ID` INTEGER(11)  NULL COMMENT '用户头像',
  `email`     VARCHAR(255)  NOT NULL UNIQUE COMMENT '电子邮件',
  `nick`      VARCHAR(255)  NULL COMMENT '昵称',
  `password`   VARCHAR(255) COMMENT '密码',
  `status`    VARCHAR(2)    DEFAULT '1' COMMENT '状态',
  `gmt_create` DATETIME COMMENT '创建时间',
  `gmt_modified` DATETIME COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
INSERT INTO X_student(student_ID, student_name, email, nick,avatar_ID, password,gmt_create)
              VALUES ('student','测试','ldz2012yn@gmail.com','与水',11,'1','2016-05-16')
INSERT INTO X_student(student_ID, student_name, email, nick, password,gmt_create)
              VALUES ('2','yushui','sss@qq.com','与水3','1','2016-05-18')
INSERT INTO X_student(student_ID, student_name, email, nick, password,gmt_create)
              VALUES ('donahue','donahue','donahue@qq.com','与水4','1','2016-05-18')
INSERT INTO X_student(student_ID, student_name, email, nick, password,gmt_create)
              VALUES ('321','donahue','do@qq.com','与水5','1','2016-06-11')
DELETE  FROM X_student WHERE id=4
