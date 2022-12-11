package web.ejb;

import web.DTOs.CourseDTO;
import web.DTOs.CourseTeacherDTO;
import web.DTOs.StudentDTO;
import web.entities.Student;

import java.util.ArrayList;
import java.util.HashMap;

public interface StudentStateless {
    StudentDTO getByMatriculation(int matriculation);
    ArrayList<CourseDTO> getCourses(int i);
    public ArrayList<CourseTeacherDTO> getCoursesWithTeacher(int i);
}
