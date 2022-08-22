/**
 * Shape
 * 
 * An interface the contains declarations for methods to calculate relevant data
 * of a shape, such as Area and Perimeter.
 */
public interface Shape {
    double calculateArea();
    double calculatePerimeter();
    String getName();
    
    default int compareArea(Shape shape) {
        if (this.calculateArea() > shape.calculateArea()) return 1;
        if (this.calculateArea() < shape.calculateArea()) return -1;
        return 0;
    }
    
    default int comparePerimeter(Shape shape) {
        if (this.calculatePerimeter() > shape.calculatePerimeter()) return 1;
        if (this.calculatePerimeter() < shape.calculatePerimeter()) return -1;
        return 0;
    }
}
