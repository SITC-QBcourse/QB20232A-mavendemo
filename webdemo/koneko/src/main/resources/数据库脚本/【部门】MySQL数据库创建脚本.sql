DROP DATABASE IF EXISTS yootk ;
CREATE DATABASE yootk CHARACTER SET UTF8 ;
USE yootk ;
CREATE TABLE dept (
   deptno    BIGINT    AUTO_INCREMENT ,
   dname     VARCHAR(50) ,
   loc       VARCHAR(50) ,
   CONSTRAINT pk_deptno PRIMARY KEY(deptno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 开发部', '成都') ;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 教学部', '北京') ;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 财务部', '上海') ;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 市场部', '深圳') ;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 后勤部', '洛阳') ;
INSERT INTO dept(dname,loc) VALUES ('沐言科技 - 公关部', '广州') ;
COMMIT;