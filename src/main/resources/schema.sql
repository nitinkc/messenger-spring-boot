DROP TABLE IF EXISTS messages;
create table messages
(
    id integer not null,
    author varchar(60) not null,
    message varchar(100) not null,
    create_dt DATETIME not null,
    primary key(id)
);