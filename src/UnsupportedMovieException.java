/**
 * UnsupportedMovieException
 *
 * A class representing a specific type of exception thrown if the line read in
 * from a file doesn't obey a specific format.
 */
public class UnsupportedMovieException extends Exception {
    public UnsupportedMovieException(String message) {
        super(message);
    }
}
