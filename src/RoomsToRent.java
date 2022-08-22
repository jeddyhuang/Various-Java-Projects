import java.io.*;
import java.util.ArrayList;

/**
 * RoomsToRent
 *
 * A class implementing the functionality of buildings with rooms that can be rented
 */
public class RoomsToRent {
    private ArrayList<Integer> availableRooms;
    private ArrayList<Student> currentTenants;
    private final String buildingName;
    private final String streetName;
    
    public RoomsToRent(String roomStructureFileName, String tenantInfoFileName)
            throws FileNotFoundException, InvalidStudentException {
        availableRooms = new ArrayList<Integer>();
        currentTenants = new ArrayList<Student>();
        String building = "";
        String address = "";
        try (BufferedReader bfr1 = new BufferedReader(new FileReader(roomStructureFileName));
                BufferedReader bfr2 = new BufferedReader(new FileReader(tenantInfoFileName))) {
            String line1;
            while ((line1 = bfr1.readLine()) != null) {
                String[] floor = line1.split("\\s*,\\s*");
                for (String room : floor) availableRooms.add(Integer.valueOf(room));
            }
            String line2 = bfr2.readLine();
            if (line2 != null) {
                String[] hallInfo = line2.split("\\s*,\\s*");
                if (hallInfo.length != 2) throw new InvalidStudentException();
                building = hallInfo[0];
                address = hallInfo[1];
            } else throw new InvalidStudentException();
            while ((line2 = bfr2.readLine()) != null) {
                String[] studentInfo = line2.split("\\s*,\\s*");
                if (studentInfo.length != 5) throw new InvalidStudentException(); 
                Student student = new Student(studentInfo[0], studentInfo[1],
                            studentInfo[2], Integer.valueOf(studentInfo[3]));
                int roomNum = Integer.valueOf(studentInfo[4]);
                this.addTenant(student, roomNum);
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (NumberFormatException | OccupiedRoomException e) {
            throw new InvalidStudentException();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buildingName = building;
            streetName = address;
        }
    }
    
    public int addTenant(Student student) throws OccupiedRoomException {
        if (availableRooms.size() == 0) throw new OccupiedRoomException();
        int roomNum = availableRooms.remove(0);
        student.setAddress(new Address(roomNum, buildingName, streetName));
        currentTenants.add(student);
        return roomNum;
    }
    
    public void addTenant(Student student, int roomNo) throws OccupiedRoomException {
        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i) == roomNo) {
                availableRooms.remove(i);
                student.setAddress(new Address(roomNo, buildingName, streetName));
                currentTenants.add(student);
                return;
            }
        }
        throw new OccupiedRoomException();
    }
    
    public int getAvailability() {
        return availableRooms.size();
    }
    
    public double getMonthlyCost() {
        return 800.00;
    }
    
    public ArrayList<Student> listTenants() {
        return currentTenants;
    }
    
    public Student locateTenant(String purdueId) throws StudentNotFoundException {
        for (Student student : currentTenants) {
            if (purdueId.equals(student.getPurdueId())) return student;
        }
        throw new StudentNotFoundException();
    }
    
    public int removeTenant(String purdueId) throws StudentNotFoundException {
        for (Student student : currentTenants) {
            if (purdueId.equals(student.getPurdueId())) {
                int roomNum = student.getAddress().getRoomNumber();
                availableRooms.add(roomNum);
                currentTenants.remove(student);
                return roomNum;
            }
        }
        throw new StudentNotFoundException();
    }
    
    public void saveTenantInfoToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            pw.println(buildingName + ", " + streetName);
            for (Student student : currentTenants) {
                pw.println(student.getPurdueId() + ", " + student.getName() + ", " +
                        student.getEmail() + ", " + student.getGradYear() + ", " +
                        student.getAddress().getRoomNumber());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
