CREATE TABLE "SYSTEM"."USERS" 
   (	"ID" NUMBER(5,0), 
	"FIRSTNAME" VARCHAR2(25 BYTE), 
	"LASTNAME" VARCHAR2(25 BYTE), 
	"ROLEID" NUMBER(2,0), 
	"LOGINNAME" VARCHAR2(20 BYTE), 
	"PW" VARCHAR2(64 BYTE), 
	"LOCKED" NUMBER(1,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 UNIQUE ("LOGINNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

CREATE SEQUENCE  "SYSTEM"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE ;

create or replace procedure delete_user_sec(loginname1 varchar)
as
begin
delete from users u
where u.loginname = loginname1;
end;

create or replace procedure create_user_SEC (loginname varchar, firstname varchar, lastname varchar, roleid NUMBER, pw varchar)
as
begin
insert into users VALUES(
users_seq.NEXTVAL,
firstname,
 lastname,
 roleid,
 loginname,
 pw,
 0);

end;

create or replace procedure fetch_user_SEC (loginname1 varchar,
cursorParam OUT SYS_REFCURSOR)
as
begin
open cursorparam for
select  u.*
  from users u
where 
 loginname1 = u.loginname;
end;

create or replace procedure login_user_SEC (loginname1 varchar, pw1 varchar, --userid out number(5), userfname out varchar, userlname out varchar, userrole out number )
cursorParam OUT SYS_REFCURSOR)
as
begin
open cursorparam for
select  u.*
  from users u
where 
 loginname1 = u.loginname and
 pw1 = u.pw;

end;

create or replace procedure updatepw_sec(userlogin varchar2, newpw VARCHAR2)
as
begin
update users
set PW = newpw
where loginname = userlogin
;
end;