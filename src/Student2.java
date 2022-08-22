/**
 * Student
 * 
 * A class that represents a Student.
 */
public class Student2 extends Person {
    private int grade;

    public Student2(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}