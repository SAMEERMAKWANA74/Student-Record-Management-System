package com.Stud_Reco;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddStudent {
    public static void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setEmail(email);

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.Stud_Reco.Student.class);
        config.configure();
        SessionFactory factory =config.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();

        System.out.println("✅ Student added.");
    }
}
