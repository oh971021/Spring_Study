create table pj_member(
m_id varchar2(20 char) primary key,
m_pw varchar2(30 char) not null,
m_name varchar2(20 char) not null,
m_addr varchar2(100 char) not null,
m_photo varchar2(200 char) not null
);

insert into pj_member values('js', '1', '1', '1', '1');

select * from pj_member;

delete pj_member;

--------------------------------------------------------
-- 컨셉차이 (계정 삭제하면 글도 삭제되는 것)
	-- 만약 컨셉을 걸거면 위배사항 있는지 확인 (주의사항)
alter table pj_sns
add constraint fk_s_owner
foreign key(s_owner)
references pj_member(m_id)
on delete cascade;
-- 제약조건 추가

create table pj_sns(
s_no number(5) primary key,
s_owner varchar2(20 char) not null,
s_txt varchar2(300 char) not null,
s_date date not null
);

delete pj_sns;

create sequence pj_sns_seq;

insert into pj_sns values (pj_sns_seq.nextval, 'js', 'text~', sysdate);
insert into pj_sns values (pj_sns_seq.nextval, 'js', 'text~ab', sysdate);
insert into pj_sns values (pj_sns_seq.nextval, 'mz', 'text~abcd', sysdate);
insert into pj_sns values (200, 'mz', 'text~abcd', sysdate);

select * from pj_sns;

insert into pj_sns_reply values (100, 200, 'mz', 'oh my god..', sysdate);
insert into pj_sns_reply values (101, 200, 'js', 'oh my god..;;', sysdate);
insert into pj_sns_reply values (102, 1, 'sr', 'ppup..', sysdate);

select * from pj_sns_reply;



--------------------------------------------------------

-- 댓글 기능
create table pj_sns_reply(
	r_no number(5) primary key, 		
	r_s_no number(5) not null,		-- 소속된 글번호
	r_owner varchar2(10 char) not null,
	r_txt varchar2(100 char) not null,
	r_when date not null,
	-- 제약 조건을 미리 건다
		-- 글을 삭제하면, 댓글도 삭제된다.
	constraint s_r	-- 제약조건 : 이 친구 걸면 바로 부를 수 있음 개꿀!
		foreign key(r_s_no)	-- 외래키
		references pj_sns(s_no)	-- 그 외래키는 pj_sns 테이블의 s_no를 바라본다.
		on delete cascade
);

create sequence pj_sns_reply_seq;

delete pj_sns_reply;

---------------------------------------------------------------

create table pj_dataroom(
	d_no number(5) primary key, 			
	d_owner varchar2(10 char) not null,
	d_title varchar2(25 char) not null, 
	d_file varchar2(200 char) not null,
	d_category char(6 char) not null
);

create sequence pj_dataroom_seq;
select * from pj_dataroom;

----------------------------------------------------------------

create table pj_gallery(
	g_no number(5) primary key, 			
	g_owner varchar2(10 char) not null,
	g_title varchar2(25 char) not null, 
	g_file varchar2(200 char) not null
);
create sequence pj_gallery_seq;

select * from pj_gallery;

-----------------------------------------------------------------

create table pj_community(
	c_no number(5) primary key,
	c_from varchar2(10 char) not null,
	c_to varchar2(10 char) not null,
	c_txt varchar2(200 char) not null,
	c_when date not null
);
create sequence pj_community_seq;

select * from PJ_COMMUNITY;
