package com.Stud_Reco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateStudent {
    public static void update() {
        int studentId = 1; // ID to update
        String newEmail = "updatedemail@example.com";

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory factory = config.buildSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            Student student = session.find(Student.class, studentId);

            if (student != null) {
                student.setEmail(newEmail);
                tx.commit();
                System.out.println("✅ Student updated successfully.");
            } else {
                System.out.println("❌ Student not found.");
            }
        } finally {
            factory.close();
        }
    }
}
