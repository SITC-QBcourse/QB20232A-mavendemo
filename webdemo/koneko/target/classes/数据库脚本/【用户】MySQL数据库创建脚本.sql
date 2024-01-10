DROP DATABASE IF EXISTS `qb2023`;
CREATE DATABASE `qb2023` CHARACTER SET utf8;
USE `qb2023`;
CREATE TABLE member(
    `mid` VARCHAR(50),
    `name` VARCHAR(50),
    `password` VARCHAR(50),
    CONSTRAINT `pk_mid` PRIMARY KEY(`mid`)
);
INSERT INTO member(`mid`, `name`, `password`) VALUES ('tmc10001','laoyang','123456');
INSERT INTO member(`mid`, `name`, `password`) VALUES ('tmc10002','yamakawa','654321');