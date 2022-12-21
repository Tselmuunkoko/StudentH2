create table TEACHER
(
    ID        INTEGER generated always as identity,
    NAME      CHARACTER VARYING(30),
    SURNAME   CHARACTER VARYING(30),
    COURSE_ID INTEGER,
    constraint TEACHER_PK
        primary key (ID),
    constraint COURSE_ID
        foreign key (COURSE_ID) references COURSE
);

