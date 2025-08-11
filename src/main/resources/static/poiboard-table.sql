create table users(
userid varchar(12) not null primary key,
passwd varchar(12) not null,
username varchar(12) not null,
email varchar(320),
point int not null default 1000,
idate date not null default (current_date)
);

create table menus(
menuid varchar(12) not null primary key,
menuname varchar(20) not null unique,
menuseq int not null
);

create table board(
idx int not null primary key auto_increment,
menuid varchar(12) not null,
title varbinary(300) not null,
content text character set utf8mb4,
writer varchar(12),
regdate datetime not null default current_timestamp,
hit int not null default 0,
constraint FK_ID_MENU foreign key (menuid) references menus (menuid)
);