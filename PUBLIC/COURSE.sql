create table COURSE
(
    ID   INTEGER generated always as identity,
    NAME CHARACTER VARYING(30),
    constraint COURSE_PK
        primary key (ID)
);

