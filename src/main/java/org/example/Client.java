package org.example;
import org.example.model.Student;
import org.example.model.StudentAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;

/**
 * Hibernate (ORM Framework) - 101
 */

public class Client
{
    public static void main( String[] args )
    {
        System.out.println("Hibernate Project");
        Configuration cf = new Configuration();
        cf.configure("hibernate.cfg.xml");
        // It will help us to create new sessions.
        try(SessionFactory sessionFactory = cf.buildSessionFactory();
            Session session=sessionFactory.openSession();
            FileInputStream fis = new FileInputStream("src/main/resources/pic.png");){
            System.out.println(sessionFactory);
            // Object of Implementation Class of Session Factory Interface
            Student student = new Student(101,"Nitesh","Noida");

            // Creating object of address class
            StudentAddress studentAddress = new StudentAddress();
            studentAddress.setCity("Noida");
            studentAddress.setAddedDate(new Date());
            studentAddress.setOpen(true);
            studentAddress.setStreet("One Murti");
            studentAddress.setX(100.00);

            // Reading Image
            byte[] data = new byte[fis.available()];
            int i = fis.read(data);
            studentAddress.setImage(data);
            Transaction tx = session.beginTransaction();
            session.save(student);
            session.save(studentAddress);
            tx.commit();
            System.out.println("Done...");

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
