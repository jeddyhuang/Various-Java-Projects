/**
 * UnsupportedFileException
 *
 * A class representing a specific type of exception thrown if the file type is
 * unsupported
 */
public class UnsupportedFileException extends Exception {
    public UnsupportedFileException(String toWrite) {
        super(toWrite);
    }
}
