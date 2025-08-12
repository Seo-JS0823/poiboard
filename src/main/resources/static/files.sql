create table files(
filenum int not null auto_increment,
idx int not null,
filename varchar(300) not null,
fileext varchar(300) not null,
sfilename varchar(300) not null,
primary key(filenum, idx),
constraint FK_BOARD_FILES_IDX
FOREIGN KEY (IDX)
REFERENCES BOARD(IDX)
ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;