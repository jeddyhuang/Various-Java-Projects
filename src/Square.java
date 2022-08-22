/**
 * Square
 * 
 * This class extends the Rectangle class, since all of the properties of a
 * Rectangle apply to a shape. Hence, the only methods that need to be created
 * for the Square class are the constructor and getName() methods.
 */
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
    
    public String getName() {
        return "Square";
    }
}
