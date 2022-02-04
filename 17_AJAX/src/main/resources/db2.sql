create table menu2(
m_name varchar2 (10 char) primary key,
m_price number(5) not null
);

insert into MENU2 values ('테스트', 1000);
insert into MENU2 values ('테스트2', 2000);
insert into MENU2 values ('test1', 2000);
insert into MENU2 values ('test2', 3000);
insert into MENU2 values ('test3', 4000);

select * from menu2;
