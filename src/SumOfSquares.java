import java.util.Scanner;

/**
 * Sum of Squares
 *
 * Computes the smallest integer sum of squares that is equal to or larger than
 * a given input.
 */
public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int limit = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        int counter = 1;
        while(limit > sum){
            sum += counter * counter;
            counter ++;
        }
        System.out.println("The sum is " + sum + ".");
    }
}
