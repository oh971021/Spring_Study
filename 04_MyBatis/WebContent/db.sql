create table product01(
p_no number(3) primary key,
p_name varchar2(20 char) not null,
p_price number(8) not null,
p_img varchar2(200 char) not null,
p_exp date not null
);

create sequence product01_seq;

insert into product01 values(product01_seq.nextval, '테스트', 1000, 'a.jpg', sysdate);
insert into product01 values(product01_seq.nextval, '테스트2', 2000, 'a.jpg', sysdate);
insert into product01 values(product01_seq.nextval, '테스트3', 3000, 'a.jpg', sysdate);
insert into product01 values(product01_seq.nextval, '테스트4', 4000, 'a.jpg', sysdate);
insert into product01 values(product01_seq.nextval, '테스트5', 5000, 'a.jpg', sysdate);

select * from product01;