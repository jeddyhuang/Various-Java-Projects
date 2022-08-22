/**
 * Monster
 *
 * A public class that implements the Halloween interface.
 */
public class Monster implements Halloween {
    private String name;
    private double monsterPowerRating;
    private String deadOrAlive;
    
    public Monster(String name, double monsterPowerRating) {
        this.name = name;
        this.monsterPowerRating = monsterPowerRating;
        deadOrAlive = "Unknown";
    }
    
    @Override
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.printf("Power Rating: %.2f%n", monsterPowerRating);
        System.out.println("Dead or Alive: " + deadOrAlive);
    }

    @Override
    public void printName() {
        System.out.println(name);
    }
    
    public String getName() {
        return name;
    }
    
    public double getMonsterPowerRating() {
        return monsterPowerRating;
    }
    
    public String getDeadOrAlive() {
        return deadOrAlive;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMonsterPowerRating(double monsterPowerRating) {
        this.monsterPowerRating = monsterPowerRating;
    }
    
    public void setDeadOrAlive(String deadOrAlive) {
        this.deadOrAlive = deadOrAlive;
    }
}
