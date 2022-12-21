create table STUDENT
(
    ID            INTEGER generated always as identity,
    NAME          CHARACTER VARYING(30),
    SURNAME       CHARACTER VARYING(30),
    MATRICULATION CHARACTER VARYING(30),
    constraint STUDENT_PK
        primary key (ID)
);

