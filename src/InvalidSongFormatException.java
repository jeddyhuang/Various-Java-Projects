/**
 * InvalidSongFormatException
 *
 * A class representing a specific type of exception thrown if the line read in
 * from a file doesn't obey a specific format.
 */
public class InvalidSongFormatException extends Exception {
    public InvalidSongFormatException() {
        super();
    }
    
    public InvalidSongFormatException(String message) {
        super(message);
    }
}
