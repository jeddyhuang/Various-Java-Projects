import java.io.*;

/**
 * FewApartments
 *
 * A class representing rooms in Few Apartments
 */
public class FewApartments extends RoomsToRent {
    
    public FewApartments(String roomStructureFileName, String tenantInfoFileName)
            throws FileNotFoundException, InvalidStudentException {
        super(roomStructureFileName, tenantInfoFileName);
    }
    
    public double getMonthlyCost() {
        return 795.00;
    }
}
