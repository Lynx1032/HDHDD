/*
Bài tập giữa kì
Nhóm: 2A
Thành viên:
	+ Phạm Huỳnh Chí - 20200143 - Lập trình, tìm code tham khảo
	+ Ngô Xuân Đạt - 20200161 - Lập trình
	+ Hồ Hoàng Nghiệp - 20200277 - Debug, nộp báo cáo
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Course {
    private String name;
    private int numberOfStudents;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.numberOfStudents = 0;
        this.students = new ArrayList<Student>();
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student ID: ");
        String id = sc.nextLine();
		System.out.println("Enter student attendance score: ");
        double attendance = sc.nextInt();
		System.out.println("Enter student seminar score: ");
		double seminar = sc.nextInt();
		System.out.println("Enter student midterm score: ");
        double midterm = sc.nextInt();
		System.out.println("Enter student final exam score: ");
        double finalExam = sc.nextInt();
        Student newStudent = new Student(name, id, attendance, seminar, midterm, finalExam);
        this.students.add(newStudent);
        this.numberOfStudents++;
    }

    public void removeStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to remove: ");
        String id = sc.nextLine();
        for (Student student : this.students) {
            if (student.getId().equals(id)) {
                this.students.remove(student);
                this.numberOfStudents--;
                System.out.println("Removed student with ID " + id);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to search: ");
        String id = sc.nextLine();
        for (Student student : this.students) {
            if (student.getId().equals(id)) {
                System.out.println("Found student with ID " + id + ":");
                student.printStudentInfo();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void sortStudents() {
        Collections.sort(this.students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });
        System.out.println("Sorted students by ID.");
        this.printCourseInfo();
    }

    public void printCourseInfo() {
        System.out.println("Course name: " + this.name);
        System.out.println("Number of students: " + this.numberOfStudents);
        for (Student student : this.students) {
            student.printStudentInfo();
        }
    }

    public static void main(String[] args) {
        Course course = new Course("Programming");
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Sort students by ID");
            System.out.println("5. Print course information");
            System.out.println("6. Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    course.addStudent();
                    break;
                case 2:
                    course.removeStudent();
                    break;
                case 3:
                    course.searchStudent();
                    break;
                case 4:
                    course.sortStudents();
                    break;
                case 5:
                    course.printCourseInfo();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

class Student {
    private String name;
    private String id;
    private double attendance;
    private double seminar;
    private double midterm;
    private double finalExam;
    private double overallGrade;

    public Student(String name, String id, double attendance, double seminar, double midterm, double finalExam) {
this.name = name;
this.id = id;
this.attendance = attendance;
this.seminar = seminar;
this.midterm = midterm;
this.finalExam = finalExam;
this.overallGrade = this.attendance * 0.2 + this.seminar * 0.15 + this.midterm * 0.15 + this.finalExam * 0.5;
}
public void setAttendance(double attendance) {
    this.attendance = attendance;
}

public void setSeminar(double seminar) {
    this.seminar = seminar;
}

public void setMidterm(double midterm) {
    this.midterm = midterm;
}

public void setFinalExam(double finalExam) {
    this.finalExam = finalExam;
}
/*
public double calculateOverallGrade() {
    this.overallGrade = this.attendance * 0.1 + this.seminar * 0.1 + this.midterm * 0.4 + this.finalExam * 0.4;
    return this.overallGrade;
}
*/
public void printStudentInfo() {
    System.out.println("Student name: " + this.name);
    System.out.println("Student ID: " + this.id);
    System.out.println("Attendance grade: " + this.attendance);
    System.out.println("Seminar grade: " + this.seminar);
    System.out.println("Midterm grade: " + this.midterm);
    System.out.println("Final exam grade: " + this.finalExam);
    System.out.println("Overall grade: " + this.overallGrade);
}

public String getId() {
    return this.id;
}
}
