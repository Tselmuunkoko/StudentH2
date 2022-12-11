package EJBtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import web.entities.Student;

public class Program {
    public static void main(String a[]) { new Program();}
    Program() {
        Student a = new Student("Pippo", "DePippis", 484848);
        Student b = new Student("Suroh", "Dis", 848029);
        System.out.println(a);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(a);
            session.save(b);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                }catch (Exception ex) {ex.printStackTrace();}
            }
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            students.forEach(s -> System.out.println(s.getName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}