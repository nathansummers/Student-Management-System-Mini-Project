
package model;

import java.util.ArrayList;

public class Teacher extends Person {

    private String teacherId;
    private String subject;
    private ArrayList<Student> students;

    public Teacher(String teacherId, String name, String subject, int age) {
        super(name, age);
        this.subject = subject;
        this.teacherId = teacherId;
        this.students = new ArrayList<Student>();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }


    public void addStudent(Student student)
    {

        if (!students.contains(student))
        {
            students.add(student);
        }
        else
        {
            System.out.println("Student is already in this teachers class");
        }
    }

    public void removeStudent(Student student)
    {
        if (students.contains(student))
        {
            students.remove(student);
        }
        else
        {
            System.out.println("Student is not in this teachers class");
        }
    }


    //sets the grade for one of the teachers students, using a student id passes as a string
    public void gradeStudent(String studentId, double gradePercent)
    {
        Student theStudent = new Student("0", "null", "null", 0, 0.0);
        boolean studentFound = false;
        for (Student student : students)
            {
            if (student.getStudentId().equals(studentId))
            {
                theStudent = student;
                studentFound = true;
            }

        }
        if (studentFound)
        {
            theStudent.setMarks(gradePercent);
        }
        else
        {
            System.out.println("Student is not in this teachers class");
        }
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return this.subject;
    }


    @Override
    public void displayDetails() {
        System.out.println("-----------------------------------------------");
        System.out.println("Teacher ID : " + getTeacherId());
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + getAge());   
        System.out.println("Subject    : " + getSubject());
        System.out.println("Students   :");
        for (Student student : students)
        {
            System.out.println(student);
        }
        System.out.println("-----------------------------------------------");
    }

    @Override
    public String toString() {
        return teacherId + "|" + getName() + "|" + getSubject() + "|" + getAge();
    }
}