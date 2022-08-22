import java.io.*;
import java.util.ArrayList;

/**
 * ResidenceHall
 *
 * A class representing Leasable rooms at Resident Halls
 */
public class ResidenceHall implements Leasable {
    private ArrayList<Integer> availableDorms;
    private ArrayList<Student> currentResidents;
    private final String residentHallName;
    private final String streetName;
    
    public ResidenceHall(String filename) throws FileNotFoundException, InvalidStudentException {
        availableDorms = new ArrayList<Integer>();
        currentResidents = new ArrayList<Student>();
        String building = "";
        String address = "";
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line = bfr.readLine();
            if (line != null) {
                String[] hallInfo = line.split("\\s*,\\s*");
                if (hallInfo.length != 2) throw new InvalidStudentException();
                building = hallInfo[0];
                address = hallInfo[1];
            } else throw new InvalidStudentException();
            while ((line = bfr.readLine()) != null) {
                String[] roomInfo = line.split("\\s*:\\s*");
                if (roomInfo.length != 2) throw new InvalidStudentException();
                int roomNum = Integer.valueOf(roomInfo[0]);
                if ("Unknown".equals(roomInfo[1].substring(0, 7))) {
                    availableDorms.add(roomNum);
                } else {
                    String[] studentInfo = roomInfo[1].split("\\s*,\\s*");
                    if (studentInfo.length != 4) throw new InvalidStudentException();
                    Student student = new Student(studentInfo[0], studentInfo[1],
                            studentInfo[2], Integer.valueOf(studentInfo[3]),
                            new Address(roomNum, building, address));
                    currentResidents.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (NumberFormatException e) {
            throw new InvalidStudentException();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            residentHallName = building;
            streetName = address;
        }
    }
    
    @Override
    public int cancelContract(String purdueId) throws StudentNotFoundException {
        for (Student student : currentResidents) {
            if (purdueId.equals(student.getPurdueId())) {
                int roomNum = student.getAddress().getRoomNumber();
                availableDorms.add(roomNum);
                currentResidents.remove(student);
                return roomNum;
            }
        }
        throw new StudentNotFoundException();
    }

    @Override
    public int countFloormates(int floor) {
        int counter = 0;
        for (Student student : currentResidents) {
            String floorNum = Integer.toString(student.getAddress().getRoomNumber()).substring(0, 1);
            if (Integer.toString(floor).equals(floorNum)) counter++;
        }
        return counter;
    }

    @Override
    public int countResidents() {
        return currentResidents.size();
    }

    @Override
    public double getContractCost() {
        return 4860.00;
    }

    @Override
    public ArrayList<Student> listResidents() {
        return currentResidents;
    }

    @Override
    public void saveResidentInfoToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            pw.println(residentHallName + ", " + streetName);
            for (int roomNum : availableDorms) {
                pw.println(roomNum + ": Unknown");
            }
            for (Student student : currentResidents) {
                pw.println(student.getAddress().getRoomNumber() + ": " + student.getPurdueId() + ", " +
                        student.getName() + ", " + student.getEmail() + ", " + student.getGradYear());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int signContract(Student student) throws OccupiedRoomException {
        if (availableDorms.size() == 0) throw new OccupiedRoomException();
        int roomNum = availableDorms.remove(0);
        student.setAddress(new Address(roomNum, residentHallName, streetName));
        currentResidents.add(student);
        return roomNum;
    }

    @Override
    public void signContract(Student student, int roomNo) throws OccupiedRoomException {
        for (int i = 0; i < availableDorms.size(); i++) {
            if (availableDorms.get(i) == roomNo) {
                availableDorms.remove(i);
                student.setAddress(new Address(roomNo, residentHallName, streetName));
                currentResidents.add(student);
                return;
            }
        }
        throw new OccupiedRoomException();
    }

    @Override
    public Student viewResident(int roomNo) throws StudentNotFoundException {
        for (Student student : currentResidents) {
            if (student.getAddress().getRoomNumber() == roomNo) return student;
        }
        throw new StudentNotFoundException();
    }
}
