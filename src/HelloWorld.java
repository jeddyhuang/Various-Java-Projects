/**
 * A program that prints Hello World!
 */
public class HelloWorld {
    public static void main(String[] args) {
        String x = "Purdue";
        String y = "Pete";
        
        y = x;
        y.concat(" Pete");
        
        System.out.println(y);
    }
}
