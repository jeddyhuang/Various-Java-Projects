import java.util.Scanner;

/**
 * Business Card
 *
 * A program that prints a Business Card
 */
public class BusinessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your gpa:");
        double gpa = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter your major:");
        String major = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.printf("GPA: %.2f\n", gpa);
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }
}