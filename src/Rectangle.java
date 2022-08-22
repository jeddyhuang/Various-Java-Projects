/**
 * Rectangle
 * 
 * This class implements the Polygon Interface. It contains two private variables,
 * length and breadth, that are passed in from the constructor.
 */
public class Rectangle implements Polygon {
    private double breadth;
    private double length;
    
    public Rectangle(double length, double breadth) {
        this.breadth = breadth;
        this.length = length;
    }

    @Override
    public double getLongestDiagonal() {
        return Math.sqrt(Math.pow(breadth, 2) + Math.pow(length, 2));
    }

    @Override
    public double getLongestSide() {
        if (length > breadth) return length;
        else return breadth;
    }

    @Override
    public int getNumberOfDiagonals() {
        return 2;
    }

    @Override
    public int getNumberOfSides() {
        return 4;
    }

    @Override
    public boolean isRegularPolygon() {
        return length == breadth;
    }

    @Override
    public double calculateArea() {
        return breadth * length;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (breadth + length);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
    
    public double getBreadth() {
        return breadth;
    }
    
    public double getLength() {
        return length;
    }
}
