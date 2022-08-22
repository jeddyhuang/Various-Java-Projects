/**
 * StudentNotFoundException
 *
 * A class that represents an exception that is thrown when a student is not
 * able to be located
 */
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super();
    }
    
    public StudentNotFoundException(String message) {
        super(message);
    }
}
