/**
 * Vampire
 *
 * A public class that extends Monster.
 */
public class Vampire extends Monster {
    private String favoriteDrink;
    private double transformationSpeed;
    
    public Vampire(String name, double monsterPowerRating, String favoriteDrink,
            double transformationSpeed) {
        super(name, monsterPowerRating);
        this.favoriteDrink = favoriteDrink;
        this.transformationSpeed = transformationSpeed;
        this.setDeadOrAlive("Alive");
    }
    
    @Override
    public void printInfo() {
        System.out.println("Monster: Vampire");
        System.out.println("Name: " + this.getName());
        System.out.printf("Power Rating: %.2f%n", this.getMonsterPowerRating());
        System.out.println("Dead or Alive: " + this.getDeadOrAlive());
        System.out.println("Favorite Drink: " + favoriteDrink);
        System.out.printf("Flight Speed: %.2f MPH%n", this.calcFlightSpeed());
    }
    
    public double calcFlightSpeed() {
        return this.getMonsterPowerRating() * 5 - transformationSpeed;
    }
    
    public String getFavoriteDrink() {
        return favoriteDrink;
    }
    
    public double getTransformationSpeed() {
        return transformationSpeed;
    }
    
    public void setFavoriteDrink(String favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }
    
    public void setTransformationSpeed(double transformationSpeed) {
        this.transformationSpeed = transformationSpeed;
    }
}
