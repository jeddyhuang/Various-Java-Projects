import java.util.ArrayList;

/**
 * Leasable
 * 
 * An interface describing the functionalities of buildings with rooms that can
 * be leased in a yearly basis.
 */
public interface Leasable {
    int cancelContract(String purdueId) throws StudentNotFoundException;
    int countFloormates(int floor);
    int countResidents();
    double getContractCost();
    ArrayList<Student> listResidents();
    void saveResidentInfoToFile(String filename);
    int signContract(Student student) throws OccupiedRoomException;
    void signContract(Student student, int roomNo) throws OccupiedRoomException;
    Student viewResident(int roomNo) throws StudentNotFoundException;
}
