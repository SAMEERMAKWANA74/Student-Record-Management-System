package com.Stud_Reco;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void delete() {
        int studentId = 1; // ID to delete

        Configuration config = new Configuration();
        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.remove(student);
                tx.commit();
                System.out.println("Student deleted.");
            } else {
                System.out.println("Student not found.");
            }
        } finally {
            session.close();
            factory.close();
        }
    }
}
