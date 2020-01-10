DROP TABLE IF EXISTS messages;
create table messages
(
    id integer not null,
    author varchar(60) not null,
    message varchar(100) not null,
    create_dt DATETIME not null,
    primary key(id)
);

insert into messages values(10001,'Stud1', 'Tweet 1 by Stud 1',sysdate());
insert into messages values(10002,'Ravi', 'Tweet 1 by Ravi', sysdate());
insert into messages values(10003,'Stud 2', 'Tweet 1 by Stud 2',sysdate());
insert into messages values(10004,'Ravi', 'Tweet 2 by Ravi', sysdate());
insert into messages values(10005,'Stud1', 'Tweet 2 by Stud 1',sysdate());
insert into messages values(10006,'Ravi', 'Tweet 3 by Ravi', sysdate());
insert into messages values(10007,'Stud1', 'Tweet 3 by Stud 1',sysdate());
insert into messages values(10008,'Ravi', 'Tweet 4 by Ravi', sysdate());
insert into messages values(10009,'Stud1', 'Tweet 4 by Stud 1',sysdate());
insert into messages values(100010,'Ravi', 'Tweet 5 by Ravi', sysdate());
insert into messages values(100011,'Stud1', 'Tweet 5 by Stud 1',sysdate());
insert into messages values(100012,'Tom', 'Tweet 1 by Tom', sysdate());
insert into messages values(100013,'Tom', 'Tweet 2 by Tom',sysdate());
insert into messages values(100014,'Harry', 'Tweet 1 by Harry', sysdate());
insert into messages values(100015,'Harry', 'Tweet 2 by Harry',sysdate());
insert into messages values(100016,'Harry', 'Tweet 3 by Harry', sysdate());