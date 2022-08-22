/**
 * Car1
 * 
 * A class that models a car.
 */
public class Car1 {
    private String make;
    private String model;
    private int year;
    
    public Car1(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString() {
        return "Make: " + make + " | Model: " + model + " | Year: " + Integer.toString(year);
    }
}