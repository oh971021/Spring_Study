create table coffee2 (
	c_name varchar2 (10 char) not null,
	c_price number (4) not null
);

insert into coffee2 values ('테스트1', 1000);
insert into coffee2 values ('테스트2', 2000);

select * from COFFEE2;

update coffee2
set c_price = 500
where c_price >= 1000