package com.Stud_Reco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ViewStudent {
    public static void view() {
        // Ensure this is the same as in AddStudent
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        List<Student> students = session.createQuery("from Student", Student.class).list();
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail());
        }

        session.close();
        factory.close();
    }
}
