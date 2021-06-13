use master 
go
create database StudentManager
on 
(name =StudentManager_Date,
filename ='D:\大三\植才权SQLServer学生成绩管理系统（代码 数据库）\StudentManager_Date.MDF',
size =20MB,
maxsize =50MB,
filegrowth =10mb)
log on
(NAME =StudentManager_Log,
filename ='D:\大三\植才权SQLServer学生成绩管理系统（代码 数据库）\StudentManager_Log.LDF',
size =20mb,
maxsize =50mb,
filegrowth =10mb)
go

select * from Logon;
drop table StudentTable1
select * from StudentTable1;
select * from TeacherTable1
drop table StudentTable1
drop table ScoreTable
drop table TeachTable

create table Logon
(UserID char(10) primary key,
Passwordr char(10))

create table StudentTable1
(StudentID char(10)primary key,
StudentName char(10) not null,
StudentSex char(2) not null,
StudentBirthday char(8),
Class char(16))

create table TeacherTable1
(TeacherID char(10) primary key,
TeacherName char(10) not null,
TeacherSex char(2) not null,
TeacherBirthday char(8),
Post char(10),
Department char(20))

create table CourseTable
(CourseID char(16) primary key,
CourseName char(16) not null,
Point char(8) not null,
StuNumber char(4) not null)

create table ScoreTable
(CourseID char(16),
StudentID char(10),
Score int,
primary key(CourseID,StudentID),
constraint CourseTable_ScoreTable foreign key(CourseID) references CourseTable,
constraint StudentTable1_ScoreTable foreign key(StudentID) references StudentTable1)

create table TeachTable
(CourseID char(16),
TeacherID char(10),
Location char(15),
primary key(CourseID,TeacherID),
constraint CourseTable_TeachTable foreign key(CourseID) references CourseTable,
constraint TeacherTable1_TeachTable foreign key(TeacherID) references TeacherTable1)

insert into StudentTable1 values('S001001','王兢芳','女','1985','B计算机052');
insert into StudentTable1 values('S001002','汤姆','男','1986','B计算机052');
insert into StudentTable1 values('S001003','杰瑞','男','1987','B自动化051');
insert into StudentTable1 values('S002001','西蒙','女','1986','B国贸052');
insert into StudentTable1 values('S002002','杰克','男','1985','B外语052');
insert into StudentTable1 values('S002003','露西','女','1985','B历史051');

insert into TeacherTable1 values('T01001','张华','男','1976','教授','信息学院')
insert into TeacherTable1 values('T01002','王娟','女','1978','讲师','外语学院')
insert into TeacherTable1 values('T01003','陈格','女','1980','助教','人文学院')
insert into TeacherTable1 values('T01004','吴浩','男','1981','助教','人文学院')

insert into Logon values('Admin','123')
insert into Logon values('S001001','S001001')
insert into Logon values('S001002','S001002')
insert into Logon values('T01001','T01001')
insert into Logon values('T01002','T01002')
insert into Logon values('T01003','T01003')

insert into CourseTable values('C01001','数据结构','4.0','0')
insert into CourseTable values('C01002','网络管理','3.0','0')
insert into CourseTable values('C01003','软件工程','3.5','0')
insert into CourseTable values('C01004','汇编语言','3.5','0')
insert into CourseTable values('C02001','大学英语','3.0','0')
insert into CourseTable values('C02002','法律基础','2.0','0')

insert into ScoreTable values('C01001','S001001',98)
insert into ScoreTable values('C01002','S001002',90)
insert into ScoreTable values('C01003','S001003',85)
insert into ScoreTable values('C01004','S002001',60)
insert into ScoreTable values('C02001','S002002',71)
insert into ScoreTable values('C02002','S002003',91)

insert into TeachTable values('C01001','T01001','01室')
insert into TeachTable values('C01002','T01001','02室')
insert into TeachTable values('C01003','T01003','03室')
insert into TeachTable values('C01004','T01002','04室')
insert into TeachTable values('C02001','T01002','05室')
insert into TeachTable values('C02002','T01003','06室')

create proc AllCourse
as
begin
    select x.CourseID,x.CourseName,x.Point ,y.TeacherName,y.Post,z.Location,x.StuNumber
    from Course x,TeacherTable1 y,TeachTable z
    where x.CourseID=z.CourseID and y.TeacherID=z.TeacherID
end


create proc DeleteLogon(@id char(10))
as
begin 
    delete from Logon
    where UserID=@id
end


create proc DeleteStudent(@id char(10))
as
begin
   delete from StudentTable1
   where StudentID=@id
end


create proc DeleteTeacher(@id char(10))
as
begin
   delete from TeacherTable1
   where TeacherID=@id
end


create proc InsertLogon(@id char(10))
as
begin 
    insert into Logon
    values(@id,@id)
end


create proc InsertStudent(@userid char(10),@username char(10),@sex char(2),@birth datetime,@class char(10))
as
begin
insert into StudentTable1 values(@userid ,@username,@sex,@birth,@class)
end
return


create proc InsertTeacher(@userid char(10),@username char(10),@sex char(2),@birth datetime,@post char(10),@department char(10))
as
begin
insert into TeacherTable1 values(@userid ,@username,@sex,@birth,@post,@department)
end
return


create proc IsExistsStu(@id char(10))
as
begin 
    select * from StudentTable1
    where StudentID=@id
end


create proc IsExistsTea(@id char(10))
as
begin 
    select * from Teachertable1
    where TeacherID=@id
end


create proc ProcAllStu
as
begin
select * from StudentTable1
end


create proc ProcAllTea
as
begin
select * from TeacherTable1
end


create proc ProcLogon(@userid char(16),@password char(10))
as
begin
    select * 
    from Logon 
    where UserID=@userid and Password=@password
end
return


create proc ProcModify(@id char(10),@password char(16))
as
begin
   update Logon 
   set Password=@password
   where UserID=@id
end


create proc ProcStudent(@id char(10))
as
begin
   select * from StudentTable1
   where StudentID=@id
end


create proc SelectCourse(@id char(10),@courseid char(16))
as
begin
    insert into ScoreTable
    values(@courseid,@id,null)
end


create proc SelectedCourse(@id char(10))
as
begin
    select * from ScoreTable
    where @id=StudentID
end


create proc SelectedCourseNum(@id char(10))
as
begin
    select COUNT(*)
    from Scoretable
    where StudentID=@id
end


create proc SelectedDetail(@id char(10))
as
begin
    select x.CourseID,x.CourseName,x.Point ,y.TeacherName,y.Post,z.Location,s.Score
    from Course x,TeacherTable1 y,TeachTable z,ScoreTable s
    where @id=s.StudentID and x.CourseID=z.CourseID and z.TeacherID=y.TeacherID
          and x.CourseID=s.CourseID
end




