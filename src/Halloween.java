/**
 * Halloween
 *
 * An interface about Halloween.
 */
public interface Halloween {
    public void printInfo();
    public void printName();
    default public void printDate() {
        System.out.println("Today is Halloween!");
    }
}
