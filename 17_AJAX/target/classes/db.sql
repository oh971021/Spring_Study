create table building(
	b_floor number(2) primary key,
	b_shopName varchar2(20 char) not null
);

create sequence building_seq;

insert into building values (building_seq.nextval, '로비');
insert into building values (building_seq.nextval, '임대문의');
insert into building values (building_seq.nextval, '헬스장');
insert into building values (building_seq.nextval, '볼링장');
insert into building values (building_seq.nextval, '학원');
insert into building values (building_seq.nextval, '병원');

select * from building;