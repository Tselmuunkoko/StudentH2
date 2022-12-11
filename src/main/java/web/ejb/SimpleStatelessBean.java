package web.ejb;

import web.entities.Student;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote(SimpleStateless.class)
public class SimpleStatelessBean implements SimpleStateless {

    @PersistenceContext(unitName="default")
    private EntityManager entityManager;

    @Override
    public String getValue(int i) {
        Query q=entityManager.createQuery("From Student where ID = "+i);
        System.out.println(q.getSingleResult());
        Student s = (Student) (q.getSingleResult());
        return s.getName();
    }

    @Override
    public Student getStudent(int i) {
        Query q=entityManager.createQuery("From Student where ID = "+i);
        return (Student) (q.getSingleResult());
    }
}
