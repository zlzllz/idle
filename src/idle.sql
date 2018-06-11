--ɾ����
--drop table iusers;
--drop table iexpress;
--drop table iproducts;
--drop table iorder;
--drop table inote;
--drop table ireply;
--������
create table iusers(id number(4) primary key not null,username varchar(50),passwordd varchar(20),sex varchar(2),tel varchar(11),address varchar(50),idnum number(20),cardnum number(30),grade number(1) default 0);
create table iexpress(id number(4) primary key not null,ename varchar(20),perprice number(5,2));
create table iproducts(id number(4) primary key not null,u_id number(4),pname varchar(10),typee varchar(10),oldprice number(10,2),currentprice number(10,2),description varchar(1000),img varchar(500), releasedate date,status number(1) default 0);
create table iorder(id number(4) primary key not null,p_id number(4),u_id number(4),methodd number(1) default 0,begindate date,enddate date);
create table inote(id number(4) primary key not null,u_id number(4),p_id number(4),notedate date,contentt varchar(1000));
create table ireply(id number(4) primary key not null,u_id number(4),n_id number(4),replycontent varchar(1000),replydate date);

--���Լ��
alter table iproducts add constraint iproducts_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table iorder add constraint iorder_p_id foreign key (p_id) references iproducts(id) on delete cascade;
alter table iorder add constraint iorder_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table inote add constraint inote_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table inote add constraint inote_p_id foreign key (p_id) references iproducts(id) on delete cascade;
alter table ireply add constraint ireply_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table ireply add constraint ireply_n_id foreign key (n_id) references inote(id) on delete cascade;

--�������У�id����
Create sequence iusers_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger iusers_insert
  before insert on iusers
  for each row
begin
  select iusers_id.nextval into :new.id from sys.dual;
end;

Create sequence iexpress_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger iexpress_insert
  before insert on iexpress
  for each row
begin
  select iexpress_id.nextval into :new.id from sys.dual;
end;

Create sequence iproducts_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger iproducts_insert
  before insert on iproducts
  for each row
begin
  select iproducts_id.nextval into :new.id from sys.dual;
end;
--��������ʱ�Զ�����ʱ��
create or replace trigger iproducts_insert_time
  before insert or update of releasedate on iproducts
  for each row
begin
  :new.releasedate := sysdate;
end;

Create sequence iorder_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger iorder_insert
  before insert on iorder
  for each row
begin
  select iorder_id.nextval into :new.id from sys.dual;
end;
--��������ʱ�Զ�����ʱ��
--create or replace trigger iorder_insert_btime
--  before insert of begindate on iorder
--  for each row
--begin
--  :new.begindate := sysdate;
--end;
--��������ʱ�Զ�����ʱ��
create or replace trigger iorder_insert_etime
  before insert or update of enddate on iorder
  for each row
begin
  :new.enddate := sysdate;
end;

Create sequence inote_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger inote_insert
  before insert on inote
  for each row
begin
  select inote_id.nextval into :new.id from sys.dual;
end;
--��������ʱ�Զ�����ʱ��
create or replace trigger inote_insert_time
  before insert or update of notedate on inote
  for each row
begin
  :new.notedate := sysdate;
end;

Create sequence ireply_id start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
create or replace trigger ireply_insert
  before insert on ireply
  for each row
begin
  select ireply_id.nextval into :new.id from sys.dual;
end;
--��������ʱ�Զ�����ʱ��
create or replace trigger ireply_insert_time
  before insert or update of replydate on ireply
  for each row
begin
  :new.replydate := sysdate;
end;

--��������
insert into iusers(username,passwordd,sex,tel,address,idnum,cardnum,grade) values('����','yly123456','��','13112345678','ɽ��ũҵ��ѧ��������¥',142726199502040987,65373847297529864276592465,default);
insert into iusers(username,passwordd,sex,tel,address,idnum,cardnum,grade) values('����','123456yly','Ů','13187654321','ɽ��ũҵ��ѧŮ������¥',153875829492048576,19837465928569185692865947,default);
insert into iexpress(ename,perprice) values('Բͨ',1.1);
insert into iexpress(ename,perprice) values('˳��',2.2);
insert into iproducts(u_id,pname,typee,oldprice,currentprice,description,img,releasedate,status) values(1,'�ߵ���ѧ','�鼮',23,12,'�ӽ�ȫ��','xxx.img',sysdate,default);
insert into iproducts(u_id,pname,typee,oldprice,currentprice,description,img,releasedate,status) values(2,'ˮ��','������Ʒ',54,12,'�ܱ���','23.img',sysdate,default);
insert into iorder(p_id,u_id,methodd,begindate,enddate) values(1,1,default,sysdate,sysdate);
insert into iorder(p_id,u_id,methodd,begindate,enddate) values(2,2,default,sysdate,sysdate);
insert into inote(u_id,p_id,notedate,contentt) values(1,1,sysdate,'�����������Ǻ���');
insert into inote(u_id,p_id,notedate,contentt) values(2,2,sysdate,'���ʺ��ң����Һ�����');
insert into ireply(u_id,n_id,replycontent,replydate) values(1,1,'��СΪl��',sysdate);
insert into ireply(u_id,n_id,replycontent,replydate) values(2,2,'�ߵ���ѧ���߰棬���п�����',sysdate);

