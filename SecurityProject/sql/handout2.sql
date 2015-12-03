create Table medicalrecords(
id NUMBER(10) primary key,
patreportid number(10),
patientid number(5),
datePat date,
age number(3),
medicalcaseid number(10),
diseaseid number(4),
prescription varchar2(1000),
noter varchar2(1000),
doctorid number(5),
admininfoid number(10),
price float(5),
medicalcenter VARCHAR2(300),
creationdate timestamp,
createdby number(5),
lastmodified TIMESTAMP,
modifiedby number(5)
);






CREATE SEQUENCE  MED_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

create or replace procedure create_medicalrecord (userid number, cursorParam OUT SYS_REFCURSOR)
as
idmed number;
begin
idmed := MED_SEQ.NEXTVAL;
insert into MEDICALRECORDS VALUES(
idmed,
0, NULL, NULL, NULL, 0, 
NULL, NULL, NULL, NULL, 0,
NULL, NULL, CURRENT_TIMESTAMP, userid, NULL,
 userid
);
open cursorparam for
select  med.*
  from users med
where 
 med.id = idmed;

end;

create or replace procedure update_patrecord (userid number, medrecordid number,patid number,datepatrep date,agep number,cursorParam OUT SYS_REFCURSOR )
as
begin
update MEDICALRECORDS 
set patreportid = medrecordid,
patientid = patid,
datepat = datepatrep,
age=agep,
modifiedby = userid,
LASTMODIFIED = CURRENT_TIMESTAMP
where id = medrecordid
;
open cursorparam for
select  med.*
  from users med
where 
 med.id = medrecordid;
end;

create or replace procedure update_medicalcase (userid number, medrecordid number,disease number,pres varchar, notes varchar,doctor number,cursorParam OUT SYS_REFCURSOR )
as
begin
update MEDICALRECORDS 
set medicalcaseid = medrecordid,
diseaseid = disease,
prescription = pres,
noter=notes,
doctorid = doctor,
modifiedby = userid,
LASTMODIFIED = CURRENT_TIMESTAMP
where id = medrecordid
;
open cursorparam for
select  med.*
  from users med
where 
 med.id = medrecordid;
end;

create or replace procedure update_admininfo (userid number, medrecordid number,priceadm float,medicalc varchar,cursorParam OUT SYS_REFCURSOR )
as
begin
update MEDICALRECORDS 
set ADMININFOID = medrecordid,
price = priceadm,
medicalcenter = medicalc,
modifiedby = userid,
LASTMODIFIED = CURRENT_TIMESTAMP
where id = medrecordid
;
open cursorparam for
select  med.*
  from users med
where 
 med.id = medrecordid;
end;

create table roles(
id number(1) primary key,
name varchar(20)
);

insert into roles values(
1,'root'
);

insert into roles values(
2,'patient'
);

insert into roles values(
3,'Doctor'
);

insert into roles values(
4,'Administrative'
);

insert into roles values(
5,'Manager'
);

create table diseases(
id number primary key,
name varchar(50),
percentageofpatients float,
percentageofrecords float
);

insert into diseases values(
1,
'Cancer',
null,
null
);

insert into diseases values(
2,
'Aids',
null,
null
);

insert into diseases values(
3,
'Flu',
null,
null
);

insert into diseases values(
4,
'Headache',
null,
null
);

create or replace procedure fetchmedrecordbyid (medrecordid number,cursorParam OUT SYS_REFCURSOR )
as
begin
open cursorparam for
select  med.*
  from MEDICALRECORDS med
where 
 med.id = medrecordid;
end;


create or replace procedure fetchmedrecordbypatient (patid number,cursorParam OUT SYS_REFCURSOR )
as
begin
open cursorparam for
select *
from  
( select * 
  from MEDICALRECORDS
  where patientid = patid
  order by id desc ) 
where ROWNUM <= 1;
end;

create or replace procedure update_stats 
as
totalpatients number(10);
totalrecords number(10);
begin
select count(*) into totalrecords from medicalrecords where diseaseid is not null;
select count(distinct(patientid)) into totalpatients from medicalrecords where diseaseid is not null and patientid != 0;
update diseases
set percentageofpatients = ((select count(distinct(patientid)) from MEDICALRECORDS where MEDICALRECORDS.diseaseid = diseases.id and patientid != 0)/totalpatients) ,
percentageofrecords = ((select count(*) from MEDICALRECORDS where MEDICALRECORDS.diseaseid = diseases.id)/totalrecords) 
;
end;

create or replace procedure diseasestats (diseaseid number,cursorParam OUT SYS_REFCURSOR )
as
begin
open cursorparam for
select  diseases.*
  from  diseases
where 
 diseases.id = diseaseid;
end;

