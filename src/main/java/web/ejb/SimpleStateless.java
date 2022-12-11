package web.ejb;

import web.entities.Student;

public interface SimpleStateless {
    String getValue(int i);
    Student getStudent(int i);
}
