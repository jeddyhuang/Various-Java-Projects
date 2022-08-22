/**
 * Student
 *
 * A class representing the address of a room in a building
 */
public class Student {
    private Address address;
    private String email;
    private int gradYear;
    private String name;
    private String purdueId;
    
    public Student(String purdueId, String name, String email, int gradYear) {
        this.purdueId = purdueId;
        this.name = name;
        this.email = email;
        this.gradYear = gradYear;
    }
    
    public Student(String purdueId, String name, String email, int gradYear, Address address) {
        this(purdueId, name, email, gradYear);
        this.address = address;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getGradYear() {
        return gradYear;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPurdueId() {
        return purdueId;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPurdueId(String purdueId) {
        this.purdueId = purdueId;
    }
    
    public String toString() {
        return "Student{purdueId='" + purdueId + "', name='" + name +
                "', email='" + email + "', gradYear=" + gradYear +
                ", address=" + address.toString() + "}";
    }
}
