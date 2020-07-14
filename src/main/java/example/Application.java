package example;

import example.entity.Student;
import org.hibernate.Session;


import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        Session session =   HibernateConfig.getSessionFactory().openSession();

        Student student = new Student();
        student.setNumber(1.123456789D);

        session.beginTransaction();
        session.save(student);
       // session.update(student);
        session.getTransaction().commit();

        List<Student> studentInfos = session.createQuery("FROM Student", Student.class).getResultList();
        System.out.println(studentInfos);
        session.close();
    }

}
