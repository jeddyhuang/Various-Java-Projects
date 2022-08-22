import java.io.*;

/**
 * CityEdge
 *
 * A class representing rooms in City Edge
 */
public class CityEdge extends RoomsToRent {
    private double costMultiplier;
    
    public CityEdge(String roomStructureFileName, String tenantInfoFileName, double costMultiplier)
            throws FileNotFoundException, InvalidStudentException {
        super(roomStructureFileName, tenantInfoFileName);
        this.costMultiplier = costMultiplier;
    }
    
    public double getMonthlyCost() {
        return 820.00 * costMultiplier;
    }
}
