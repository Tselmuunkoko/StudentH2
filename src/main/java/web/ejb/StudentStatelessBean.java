package web.ejb;

import web.DTOs.CourseDTO;
import web.DTOs.CourseTeacherDTO;
import web.DTOs.StudentDTO;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote(StudentStateless.class)
public class StudentStatelessBean implements StudentStateless{
    @PersistenceContext(unitName="default")
    private EntityManager entityManager;

    @Override
    public ArrayList<CourseDTO> getCourses(int i) {
        Query q = entityManager.createQuery("Select c.name, sc.vote From StudentCourses sc, Course c, Student s where " +
                "s.matriculation = "+i+" and sc.student.id= s.id and sc.course.id = c.id");
        ArrayList<CourseDTO> a = new ArrayList<>();
        List<Object[]> results = q.getResultList();
        for (Object[] result: results) {
            CourseDTO something =  new CourseDTO((String) result[0], (Integer) result[1]);
            a.add(something);
        }
        return a;
    }

    @Override
    public ArrayList<CourseTeacherDTO> getCoursesWithTeacher(int i) {
        Query q = entityManager.createQuery("Select c.name, t.name, t.surName From StudentCourses sc, Course c, Teacher t, Student s" +
                " where " +
                "s.matriculation = "+i+" and sc.student.id= s.id and sc.course.id = c.id and t.course.id = sc.course.id");
        ArrayList<CourseTeacherDTO> a = new ArrayList<>();
        List<Object[]> results = q.getResultList();
        for (Object[] result: results) {
            CourseTeacherDTO something =  new CourseTeacherDTO((String) result[0], (String) result[1], (String) result[2]);
            a.add(something);
        }
        return a;
    }

    @Override
    public StudentDTO getByMatriculation(int matriculation) {
        Query q=entityManager.createQuery("Select name, surName From Student where MATRICULATION = "+matriculation);
        List<Object[]> results = q.getResultList();
        for(Object[] result: results) {
            return new StudentDTO((String) result[0], (String) result[1]);
        }
        return null;
    }
}