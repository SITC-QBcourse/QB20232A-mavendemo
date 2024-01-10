use qb2023;
create table ad(
    aid bigint auto_increment,
    title varchar(50),
    url varchar(50),
    photo varchar(100),
    note text,
    constraint pk_aid primary key(aid)
)engine=InnoDB default charset=utf8;

insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-01.png');
insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-02.png');
insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-03.png');
insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-04.png');
insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-05.png');
insert into ad(title, url, photo) values ('(株)コネコ・コンサルティング','http://www.koneko-consulting.com','ads-pic-06.png');
commit;