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
    address     nvarchar2(50)


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
    address     nvarchar2(30),
    course_id references COURSE

);
CREATE SEQUENCE teacher_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE COURSE
(
    id         number primary key,
    name       nvarchar2(30),
    department nvarchar2(30),
    info       nvarchar2(50),
    capacity   number,
    teacher_id references TEACHER

);
CREATE SEQUENCE course_seq START WITH 1 INCREMENT BY 1;