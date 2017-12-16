/*
database type   :   mysql
database name   :   mybatisTest
database port   :   3306
database server :   localhost

database tables :
  - users
*/

-- ----------------------------------------------------------------------
-- ---------------------------       database      ----------------------
-- ----------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS mixsuper default charset utf8 COLLATE utf8_general_ci;
grant all privileges on mixsuper.* to root@"*" identified by 'Passw0rd';
-- ----------------------------------------------------------------------
-- ---------------------------       users      -------------------------
-- ----------------------------------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;