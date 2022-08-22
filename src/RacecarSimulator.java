/**
 * RacecarSimulator
 *
 * A class that models a Race car Simulator.
 */
public class RacecarSimulator {
    public static void main(String[] args) {
        Nascar nascar = new Nascar("Chevrolet", "Dale Earnhardt Sr.", 195.8, 3.1);
        FormulaOne formulaOne = new FormulaOne("McLaren", "Aryton Senna", 186.3, 5.0);
        nascar.start();
        formulaOne.start();
    }
}
