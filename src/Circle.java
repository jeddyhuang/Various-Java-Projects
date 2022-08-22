/**
 * Circle
 * 
 * This class implements the Shape Interface. It contains a single variable,
 * radius, in the class.
 */
public class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String getName() {
        return "Circle";
    }
}
