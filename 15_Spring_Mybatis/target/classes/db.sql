create table product02 (
	p_no number(3) primary key,
	p_name varchar2(20 char) not null,
	p_img varchar2(200 char) not null,
	p_price number(7) not null,
	p_exp date not null
);

create sequence product02_seq;

insert into product02 values(product02_seq.nextval, '테스트', 'aa.jpg', 1000, to_date('2022-01-01','YYYY-MM-DD'));
insert into product02 values(product02_seq.nextval, '테스트', 'aa2.jpg', 2000, to_date('2023-02-02','YYYY-MM-DD'));

select * from product02;