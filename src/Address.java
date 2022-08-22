/**
 * Address
 *
 * A class representing the address of a room in a building
 */
public class Address {
    private final String building;
    private final int roomNumber;
    private final String street;
    
    public Address(int roomNumber, String building, String street) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.street = street;
    }
    
    public String getBuilding() {
        return building;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String toString() {
        return "Address{street='" + street + "', building='" + building +
                "', roomNumber=" + roomNumber + "}";
    }
}
