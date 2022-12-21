create table STUDENT_COURSES
(
    STUDENT_ID INTEGER not null,
    COURSE_ID  INTEGER not null,
    VOTE       INTEGER,
    ID         INTEGER auto_increment,
    constraint ID
        primary key (ID),
    constraint FK_COURSE
        foreign key (COURSE_ID) references COURSE,
    constraint FK_STUDENT
        foreign key (STUDENT_ID) references STUDENT
);

