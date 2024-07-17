CREATE TABLE STUDENT
(
    id          number primary key,
    name        nvarchar2(30),
    family      nvarchar2(30),
    gender      nvarchar2(30),
    birthDate   date,
    city        nvarchar2(20),
    phoneNumber nvarchar2(12),
    email       nvarchar2(30),
    address     nvarchar2(50),
    Course      nvarchar2(30)



);
CREATE SEQUENCE student_seq start with 1 increment by 1;
CREATE TABLE TEACHER
(
    id          number primary key,
    name        nvarchar2(30),
    family      nvarchar2(30),
    gender      nvarchar2(30),
    birthDate   date,
    city        nvarchar2(20),
    phoneNumber nvarchar2(12),
    email       nvarchar2(30),
    skills      nvarchar2(100),
    Course      nvarchar2(30),
    address     nvarchar2(30)

);
CREATE SEQUENCE teacher_seq START WITH 1 INCREMENT BY 1;
