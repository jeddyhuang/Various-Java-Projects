import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Homework Average:");
        double homework = scanner.nextDouble();
        System.out.println("Enter Midterm Grade:");
        double midterm = scanner.nextDouble();
        System.out.println("Enter Final Exam Grade:");
        double finalExam = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Course Name:");
        String courseName = scanner.nextLine();

        System.out.println("Enter Credits:");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Professor Name:");
        String professor = scanner.nextLine();

        /* DO NOT MODIFY BELOW */
        double grade = .20 * homework + .40 * midterm + .40 * finalExam;
        double points = 0;

        if (grade >= 90) {
            points = 4;
        } else if (grade >= 80) {
            points = 3;
        } else if (grade >= 70) {
            points = 2;
        } else if (grade >= 60) {
            points = 1;
        }
        /* DO NOT MODIFY ABOVE */
        
        System.out.println(courseName + ": " + professor);
        System.out.printf("Grade: %.2f\n", grade);
        System.out.printf("Quality Points: %.2f", points * credits);
    }
}
