package com.Stud_Reco;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                int choice;

                do {
                    System.out.println("""
            \n1. Add Student
            2. View Students
            3. Update Student
            4. Delete Student
            5. Exit
            """);

                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> AddStudent.insert();
                        case 2 -> ViewStudent.view();
                        case 3 -> UpdateStudent.update();
                        case 4 -> DeleteStudent.delete();
                        case 5 -> System.out.println("Goodbye!");
                        default -> System.out.println("Invalid choice.");
                    }

                } while (choice != 5);
            }

}