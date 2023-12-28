DROP DATABASE IF EXISTS yootk ;
CREATE DATABASE yootk CHARACTER SET UTF8 ;
USE yootk ;
CREATE TABLE ad (
   aid		BIGINT    AUTO_INCREMENT ,
   title		VARCHAR(50) ,
   url		VARCHAR(50) ,
   photo		VARCHAR(100) ,
   note		TEXT ,
   CONSTRAINT pk_aid PRIMARY KEY(aid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO ad(title, url, photo) VALUES ('沐言科技：www.yootk.com', 'https://www.yootk.com', 'ads-pic-01.png') ;
INSERT INTO ad(title, url, photo) VALUES ('沐言科技：www.yootk.com', 'https://www.yootk.com', 'ads-pic-02.png') ;
INSERT INTO ad(title, url, photo) VALUES ('沐言科技：www.yootk.com', 'https://www.yootk.com', 'ads-pic-03.png') ;
INSERT INTO ad(title, url, photo) VALUES ('沐言科技：www.yootk.com', 'https://www.yootk.com', 'ads-pic-04.png') ;
INSERT INTO ad(title, url, photo) VALUES ('沐言科技：www.yootk.com', 'https://www.yootk.com', 'ads-pic-05.png') ;
COMMIT;
