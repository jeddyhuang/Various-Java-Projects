/**
 * Student
 * 
 * A class that models a student.
 */
public class Student1 {
    private int age;
    private String[] majors;
    private String[] minors;
    private String name;
    private Course[] previousCourses;
    private Course[][] schedule;
    
    public Student1(String name, int age, String[] majors) {
        this.name = name;
        this.age = age;
        this.majors = majors;
    }
    
    public int addCourse(Course course) {
        if (course.getPrerequisites() != null) {
            if (previousCourses == null) return -1;
            for (Course curr : course.getPrerequisites()) {
                boolean latch = false;
                for (Course compareTo : previousCourses) {
                    if (curr.equals(compareTo)) latch = true;
                }
                if (!latch) return -1;
            }
        }
        Course[][] updated;
        if (schedule == null) updated = new Course[7][10];
        else {
            updated = new Course[schedule.length][];
            for (int i = 0; i < updated.length; i++) updated[i] = schedule[i].clone();
        }
        for (int i = 0; i < course.getTime().length; i++) {
            for (int j = 0; j < course.getTime()[i].length; j++) {
                if (course.getTime()[i][j] == 1) {
                    if (updated[i][j] == null) updated[i][j] = course;
                    else return -2;
                }
            }
        }
        schedule = updated;
        return 1;
    }
    
    public void addMajor(String major) {
        if (majors == null) majors = new String[0];
        String[] updated = new String[majors.length + 1];
        for (int i = 0; i < majors.length; i++) updated[i] = majors[i];
        updated[majors.length] = major;
        majors = updated;
    }
    
    public void addMinor(String minor) {
        if (minors == null) minors = new String[0];
        String[] updated = new String[minors.length + 1];
        for (int i = 0; i < minors.length; i++) updated[i] = minors[i];
        updated[minors.length] = minor;
        minors = updated;
    }
    
    public int createSchedule(Course[] courseList) {
        Course[][] updated = new Course[7][10];
        for (Course course : courseList) {
            for (int i = 0; i < course.getTime().length; i++) {
                for (int j = 0; j < course.getTime()[i].length; j++) {
                    if (course.getTime()[i][j] == 1) {
                        if (updated[i][j] == null) updated[i][j] = course;
                        else return -1;
                    }
                }
            }
        }
        schedule = updated;
        return 1;
    }
    
    public boolean dropCourse(Course course) {
        boolean hasDropped = false;
        if (schedule == null) return hasDropped;
        if (course == null) return true;
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                if (course.equals(schedule[i][j])) {
                    schedule[i][j] = null;
                    hasDropped = true;
                }
            }
        }
        return hasDropped;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public int removeMajor(String major) {
        int index = -1;
        if (majors == null) return -1;
        for (int i = 0; i < majors.length; i++) {
            if (majors[i].equalsIgnoreCase(major)) index = i;
        }
        if (index == -1) return index;
        String[] updated = new String[majors.length - 1];
        for (int i = 0; i < index; i++) updated[i] = majors[i];
        for (int i = index + 1; i < majors.length; i++) updated[i - 1] = majors[i];
        majors = updated;
        return index;
    }
    
    public int removeMinor(String minor) {
        int index = -1;
        if (minors == null) return -1;
        for (int i = 0; i < minors.length; i++) {
            if (minors[i].equalsIgnoreCase(minor)) index = i;
        }
        if (index == -1) return index;
        String[] updated = new String[minors.length - 1];
        for (int i = 0; i < index; i++) updated[i] = minors[i];
        for (int i = index + 1; i < minors.length; i++) updated[i - 1] = minors[i];
        minors = updated;
        return index;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        
    }
}
