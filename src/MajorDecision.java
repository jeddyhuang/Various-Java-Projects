import java.util.Scanner;

/**
 * Major Decision
 *
 * Accepts input from a user to help decide which major is right for them.
 */
public class MajorDecision {
    public static final String WELCOME_MESSAGE = "Hi! Welcome to the major decider. Answer \"Yes\" or \"No\" to " +
            "our questions.";
    public static final String ALREADY_KNOW = "Do you already know which major you want?";
    public static final String MATH = "Do you like math?";
    public static final String PEOPLE = "Do you like talking to people?";
    public static final String TEACHING = "Do you like teaching?";
    public static final String SCIENCES = "Do you like the sciences?";
    public static final String MONEY = "Do you think of ways to make money?";
    public static final String LANGUAGES = "Do you like languages?";
    public static final String ENGLISH = "Do you like English?";
    public static final String COMPUTERS = "Do you like using computers?";
    public static final String BUILDING = "Do you like building things?";
    public static final String GOODBYE_MESSAGE = "Thank you. Goodbye.";
    // ------------------------- DO NOT MODIFY ABOVE -------------------------
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ALREADY_KNOW);
        if (scanner.nextLine().equals("Yes")) System.out.println(GOODBYE_MESSAGE);
        else {
            System.out.println(MATH);
            if (scanner.nextLine().equals("Yes")) {
                System.out.println(COMPUTERS);
                if (scanner.nextLine().equals("Yes")) System.out.println("Computer Science");
                else {
                    System.out.println(BUILDING);
                    if (scanner.nextLine().equals("Yes")) System.out.println("Engineering");
                    else {
                        System.out.println(SCIENCES);
                        if (scanner.nextLine().equals("Yes")) System.out.println("Natural Sciences");
                        else System.out.println("Math");
                    }
                }
            } else {
                System.out.println(PEOPLE);
                if (scanner.nextLine().equals("Yes")) {
                    System.out.println(TEACHING);
                    if (scanner.nextLine().equals("Yes")) System.out.println("Education");
                    else {
                        System.out.println(SCIENCES);
                        if (scanner.nextLine().equals("Yes")) System.out.println("Medicine");
                        else {
                            System.out.println(MONEY);
                            if (scanner.nextLine().equals("Yes")) System.out.println("Business");
                            else System.out.println("Psychology");
                        }
                    }
                } else {
                    System.out.println(LANGUAGES);
                    if (scanner.nextLine().equals("No")) System.out.println("Art");
                    else {
                        System.out.println(ENGLISH);
                        if (scanner.nextLine().equals("Yes")) System.out.println("English");
                        else System.out.println("Foreign Languages");
                    }
                }
            }
        }
    }
}
