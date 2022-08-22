import java.util.Arrays;

/**
 * Course
 * 
 * A class that models a course.
 */
public class Course {
    private int courseNumber;
    private int credits;
    private String department;
    private String description;
    private Course[] prerequisites;
    private String professor;
    private String subject;
    private int[][] time;
    
    public Course(String subject, int courseNumber, String department,
            int credits, Course[] prerequisites, String description) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.department = department;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.description = description;
    }
    
    public Course(String subject, int courseNumber, String department,
            String professor, int credits, Course[] prerequisites, String description, int[][] time) {
        this(subject, courseNumber, department, credits, prerequisites, description);
        this.professor = professor;
        this.time = time;
    }
    
    public int getCourseNumber() {
        return courseNumber;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Course[] getPrerequisites() {
        return prerequisites;
    }
    
    public String getProfessor() {
        return professor;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public int[][] getTime() {
        return time;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPrerequisites(Course[] prerequisites) {
        this.prerequisites = prerequisites;
    }
    
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    public void setTime(int[][] time) {
        this.time = time;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Course) {
            Course course = (Course) o;
            return this.subject.equals(course.getSubject()) &&
                    this.courseNumber == course.getCourseNumber() &&
                    this.department.equals(course.getDepartment());
        }
        return false;
    }
}
