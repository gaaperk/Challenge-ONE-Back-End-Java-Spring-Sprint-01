
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(5000) not null,
    fecha DATETIME not null,
    status varchar(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);