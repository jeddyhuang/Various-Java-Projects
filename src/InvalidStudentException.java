/**
 * InvalidStudentException
 *
 * A class that represents an exception that is thrown if the data read from a
 * file representing a student is malformed
 */
public class InvalidStudentException extends Exception {
    public InvalidStudentException() {
        super();
    }
    
    public InvalidStudentException(String message) {
        super(message);
    }
}
