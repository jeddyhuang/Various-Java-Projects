/**
 * OccupiedRoomException
 *
 * A class that represents an exception that is thrown when a room trying to be
 * inhabited is previous occupied, or all rooms in a building are already occupied
 */
public class OccupiedRoomException extends Exception {
    public OccupiedRoomException() {
        super();
    }
    
    public OccupiedRoomException(String message) {
        super(message);
    }
}
