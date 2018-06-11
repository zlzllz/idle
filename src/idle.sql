--删除表
--drop table iusers;
--drop table iexpress;
--drop table iproducts;
--drop table iorder;
--drop table inote;
--drop table ireply;
--创建表
create table iusers(id number(4) primary key not null,username varchar(50),passwordd varchar(20),sex varchar(2),tel varchar(11),address varchar(50),idnum number(20),cardnum number(30),grade number(1) default 0);
create table iexpress(id number(4) primary key not null,ename varchar(20),perprice number(5,2));
create table iproducts(id number(4) primary key not null,u_id number(4),pname varchar(10),typee varchar(10),oldprice number(10,2),currentprice number(10,2),description varchar(1000),img varchar(500), releasedate date,status number(1) default 0);
create table iorder(id number(4) primary key not null,p_id number(4),u_id number(4),methodd number(1) default 0,begindate date,enddate date);
create table inote(id number(4) primary key not null,u_id number(4),p_id number(4),notedate date,contentt varchar(1000));
create table ireply(id number(4) primary key not null,u_id number(4),n_id number(4),replycontent varchar(1000),replydate date);

--外键约束
alter table iproducts add constraint iproducts_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table iorder add constraint iorder_p_id foreign key (p_id) references iproducts(id) on delete cascade;
alter table iorder add constraint iorder_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table inote add constraint inote_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table inote add constraint inote_p_id foreign key (p_id) references iproducts(id) on delete cascade;
alter table ireply add constraint ireply_u_id foreign key (u_id) references iusers(id) on delete cascade;
alter table ireply add constraint ireply_n_id foreign key (n_id) references inote(id) on delete cascade;

--创建序列，id自增
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
--更新数据时自动更新时间
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
--更新数据时自动更新时间
--create or replace trigger iorder_insert_btime
--  before insert of begindate on iorder
--  for each row
--begin
--  :new.begindate := sysdate;
--end;
--更新数据时自动更新时间
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
--更新数据时自动更新时间
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
--更新数据时自动更新时间
create or replace trigger ireply_insert_time
  before insert or update of replydate on ireply
  for each row
begin
  :new.replydate := sysdate;
end;

--测试数据
insert into iusers(username,passwordd,sex,tel,address,idnum,cardnum,grade) values('张三','yly123456','男','13112345678','山西农业大学男生宿舍楼',142726199502040987,65373847297529864276592465,default);
insert into iusers(username,passwordd,sex,tel,address,idnum,cardnum,grade) values('李四','123456yly','女','13187654321','山西农业大学女生宿舍楼',153875829492048576,19837465928569185692865947,default);
insert into iexpress(ename,perprice) values('圆通',1.1);
insert into iexpress(ename,perprice) values('顺丰',2.2);
insert into iproducts(u_id,pname,typee,oldprice,currentprice,description,img,releasedate,status) values(1,'高等数学','书籍',23,12,'接近全新','xxx.img',sysdate,default);
insert into iproducts(u_id,pname,typee,oldprice,currentprice,description,img,releasedate,status) values(2,'水壶','生活用品',54,12,'很保温','23.img',sysdate,default);
insert into iorder(p_id,u_id,methodd,begindate,enddate) values(1,1,default,sysdate,sysdate);
insert into iorder(p_id,u_id,methodd,begindate,enddate) values(2,2,default,sysdate,sysdate);
insert into inote(u_id,p_id,notedate,contentt) values(1,1,sysdate,'东西不错，五星好评');
insert into inote(u_id,p_id,notedate,contentt) values(2,2,sysdate,'很适合我，卖家很温柔');
insert into ireply(u_id,n_id,replycontent,replydate) values(1,1,'大小为l号',sysdate);
insert into ireply(u_id,n_id,replycontent,replydate) values(2,2,'高等数学第七版，考研可以用',sysdate);

