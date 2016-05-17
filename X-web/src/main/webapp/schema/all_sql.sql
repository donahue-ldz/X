use X;
-- X_student --
DROP TABLE IF EXISTS `X_student`;
CREATE TABLE `X_student` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `student_ID` VARCHAR(30) NOT NULL UNIQUE COMMENT '学号,唯一',
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
INSERT INTO X_student(student_ID, student_name, email, nick, password)
            VALUES ('student','测试','ldz2012yn@gmail.com','与水','1');


-- X_course --

DROP TABLE IF EXISTS `X_course`;
CREATE TABLE `X_course` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL COMMENT '课程名',
  `description` longtext  NULL COMMENT '描述',
  `picture_ID`     INT(11) NULL  COMMENT '图片ID',
  `short_desc`     VARCHAR(255)  NOT NULL UNIQUE COMMENT '简短描述',
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


-- X_course_category --

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


-- X_picture --
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

