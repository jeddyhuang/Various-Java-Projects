import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Odd Fruit Out
 *
 * Determine if a list of fruits is entered in alphabetical order. If a fruit is
 * out of order, the program prints a short message.
 */
public class OddFruitOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to the Odd Fruit Out game!");
        System.out.println("Please enter a String of fruits separated by commas.");
        StringTokenizer token = new StringTokenizer(scanner.nextLine(), ",");
        int fruits = token.countTokens();
        char currChar = 'a';
        int counter = 0;
        String oddFruit = "";
        for (int i = 0; i < fruits; i++) {
            String currFruit = token.nextToken();
            if (currFruit.charAt(0) - currChar >= 0) currChar = currFruit.charAt(0);
            else {
                counter = i + 1;
                oddFruit = currFruit;
                break;
            }
        }
        System.out.println("The odd fruit out is fruit number " + counter + ": " + oddFruit);
    }
}
