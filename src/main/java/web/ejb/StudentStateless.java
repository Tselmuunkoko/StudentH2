package web.ejb;

import web.DTOs.CourseDTO;
import web.DTOs.CourseTeacherDTO;
import web.DTOs.StudentDTO;
import javax.ejb.Remote;
import java.util.ArrayList;
@Remote
public interface StudentStateless {
    StudentDTO getByMatriculation(int matriculation);
    ArrayList<CourseDTO> getCourses(int i);
    public ArrayList<CourseTeacherDTO> getCoursesWithTeacher(int i);
}
