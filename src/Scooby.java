/**
 * Scooby
 *
 * A public class that implements the Halloween interface.
 */
public class Scooby implements Halloween {
    private String fullName;
    private double experienceLevel;
    private int age;
    
    public Scooby(double experienceLevel, int age) {
        fullName = "Scoobert Doo";
        this.experienceLevel = experienceLevel;
        this.age = age;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Scooby's Name: " + fullName);
        System.out.println("Age: " + age + " years");
        System.out.printf("Experience Level: %.2f points%n", experienceLevel);
        System.out.printf("Speed: %.2f MPH%n", this.calcSpeed());
    }

    @Override
    public void printName() {
        System.out.println(fullName);
    }
    
    public double calcSpeed() {
        return experienceLevel * age;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public double getExperienceLevel() {
        return experienceLevel;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setExperienceLevel(double experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
