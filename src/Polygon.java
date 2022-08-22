/**
 * Polygon
 * 
 * An interface the contains declarations for methods to get relevant data of a
 * polygon, such as number of diagonals and longest side, as well as methods that
 * are relevant across all shapes like Area and Perimeter.
 */
public interface Polygon extends Shape {
    double getLongestDiagonal();
    double getLongestSide();
    int getNumberOfDiagonals();
    int getNumberOfSides();
    boolean isRegularPolygon();
}
