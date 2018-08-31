drop database if exists testdb;
create database testdb;
use testdb;
create table test_table(
user_id int,
user_name varchar(225),
password varchar(225)
);

insert into test_table values(1,"taro","123");
insert into test_table values(2,"jiro","456");
insert into test_table values(1,"hanako","789");





