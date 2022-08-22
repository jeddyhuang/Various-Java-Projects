/**
 * Triangle
 * 
 * This class implements the Polygon Interface. It contains one private variable,
 * an array of the three sides in the triangle, created from the sides passed in
 * the constructor.
 */
public class Triangle implements Polygon {
    private double[] sides;
    
    public Triangle(double side) {
        sides = new double[]{side, side, side};
    }
    
    public Triangle(double side1, double side2, double side3) {
        sides = new double[]{side1, side2, side3};
    }
    
    @Override
    public double calculateArea() {
        double s = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
    }
    
    @Override
    public double calculatePerimeter() {
        return sides[0] + sides[1] + sides[2];
    }
    
    @Override
    public double getLongestDiagonal() {
        return 0;
    }
    
    @Override
    public double getLongestSide() {
        double max = Double.MIN_VALUE;
        for (double side : sides) if (side > max) max = side;
        return max;
    }
    
    @Override
    public String getName() {
        return "Triangle";
    }
    
    @Override
    public int getNumberOfDiagonals() {
        return 0;
    }
    
    @Override
    public int getNumberOfSides() {
        return 3;
    }
    
    public double[] getSides() {
        return sides;
    }
    
    @Override
    public boolean isRegularPolygon() {
        return sides[0] == sides[1] && sides[1] == sides[2];
    }
}
