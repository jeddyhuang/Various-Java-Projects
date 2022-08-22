/**
 * Zombie
 *
 * A public class that extends Monster.
 */
public class Zombie extends Monster {
    private String favoriteFood;
    private double stamina;
    
    public Zombie(String name, double monsterPowerRating, double stamina) {
        super(name, monsterPowerRating);
        this.stamina = stamina;
        this.setDeadOrAlive("Dead");
        favoriteFood = "Caesar Salad";
    }
    
    @Override
    public void printInfo() {
        System.out.println("Monster: Zombie");
        System.out.println("Name: " + this.getName());
        System.out.printf("Power Rating: %.2f%n", this.getMonsterPowerRating());
        System.out.println("Dead or Alive: " + this.getDeadOrAlive());
        System.out.println("Favorite Food: " + favoriteFood);
        System.out.printf("Speed: %.2f MPH%n", this.calcRunSpeed());
    }
    
    public double calcRunSpeed() {
        return this.getMonsterPowerRating() * stamina;
    }
    
    public String getFavoriteFood() {
        return favoriteFood;
    }
    
    public double getStamina() {
        return stamina;
    }
    
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    
    public void setStamina(double stamina) {
        this.stamina = stamina;
    }
}
