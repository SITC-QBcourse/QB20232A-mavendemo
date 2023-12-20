DROP DATABASE IF EXISTS qb2022 ;
CREATE DATABASE qb2022 CHARACTER SET UTF8 ;
USE qb2022 ;
CREATE TABLE member(
	mid VARCHAR(50) ,
	name VARCHAR(50) ,
	password VARCHAR(50) ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) engine=MyISAM;
INSERT INTO member(mid, name, password) VALUES ('knk002', 'laoyang', 'shirahagi') ;
INSERT INTO member(mid, name, password) VALUES ('knk003', 'lee', '123456') ;
COMMIT;
