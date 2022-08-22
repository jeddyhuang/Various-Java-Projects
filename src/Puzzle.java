import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Puzzle
 *
 * A program that is able to translate math equations into secret messages.
 */
public class Puzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the equation:");
        String eqResult = "";
        String line = scanner.nextLine();
        if (line.indexOf('+') > -1) {
            StringTokenizer tokens = new StringTokenizer(line, "+");
            int num1 = Integer.valueOf(tokens.nextToken());
            int num2 = Integer.valueOf(tokens.nextToken());
            eqResult = Integer.toString(num1 + num2);
        } else if (line.indexOf('-') > -1) {
            StringTokenizer tokens = new StringTokenizer(line, "-");
            int num1 = Integer.valueOf(tokens.nextToken());
            int num2 = Integer.valueOf(tokens.nextToken());
            eqResult = Integer.toString(num1 - num2);
        } else if (line.indexOf('*') > -1) {
            StringTokenizer tokens = new StringTokenizer(line, "*");
            int num1 = Integer.valueOf(tokens.nextToken());
            int num2 = Integer.valueOf(tokens.nextToken());
            eqResult = Integer.toString(num1 * num2);
        } else if (line.indexOf('/') > -1) {
            StringTokenizer tokens = new StringTokenizer(line, "/");
            int num1 = Integer.valueOf(tokens.nextToken());
            int num2 = Integer.valueOf(tokens.nextToken());
            eqResult = Integer.toString(num1 / num2);
        }
        String message = "";
        for (int i = 0; i < eqResult.length(); i++) message += (char)(eqResult.charAt(i) + 49);
        int vowel = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'a' || message.charAt(i) == 'e' || message.charAt(i) == 'i') {
                vowel = i;
                break;
            }
        }
        if (vowel == 0) message += "-yay";
        else message = message.substring(vowel) + "-" + message.substring(0, vowel) + "ay";
        System.out.println("The answer to the puzzle is " + message);
    }
}
