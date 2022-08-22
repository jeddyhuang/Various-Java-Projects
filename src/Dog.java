/**
 * A class that represents a Dog.
 */
public class Dog implements Animal {
    @Override
    public String getSound() {
        return "woof";
    }

    @Override
    public boolean isFriendly() {
        return true;
    }
}
