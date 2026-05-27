import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;
    String grade;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Method to calculate grade
    String calculateGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    // Display student details
    void display() {
        System.out.println("-----------------------------------");
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + grade);
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    static void addStudent() {
        System.out.println("\n===== Add Student =====");

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));

        System.out.println("✅ Student Added Successfully!");
    }

    // Display all students
    static void displayStudents() {
        System.out.println("\n===== Student Report =====");

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Calculate statistics
    static void calculateStatistics() {

        if (students.isEmpty()) {
            System.out.println("No records available!");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest)
                highest = s.marks;

            if (s.marks < lowest)
                lowest = s.marks;
        }

        double average = total / students.size();

        System.out.println("\n===== Statistics =====");
        System.out.println("Average Marks : " + average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
    }

    // Search student
    static void searchStudent() {

        if (students.isEmpty()) {
            System.out.println("No records available!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter student name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Student not found!");
        }
    }

    // Main menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("   STUDENT GRADE TRACKER SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Statistics");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateStatistics();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    System.out.println("✅ Exiting Program...");
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }

        } while (choice != 5);
    }
}