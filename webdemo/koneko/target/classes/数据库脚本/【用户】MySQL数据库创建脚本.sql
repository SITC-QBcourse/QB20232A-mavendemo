DROP DATABASE IF EXISTS yootk ;
CREATE DATABASE yootk CHARACTER SET UTF8 ;
USE yootk ;
CREATE TABLE member(
	mid		VARCHAR(50) ,
	name		VARCHAR(50) ,
	password		VARCHAR(50) ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) engine=MyISAM;
INSERT INTO member(mid, name, password) VALUES ('muyan', 'yootk', 'java') ;
INSERT INTO member(mid, name, password) VALUES ('admin', 'lee', 'hello') ;
COMMIT;
