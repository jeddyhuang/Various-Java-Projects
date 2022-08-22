import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * FormGuide
 *
 * A program that that analyzes the performance of the soccer team.
 */
public class FormGuide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teamName = scanner.nextLine();
        int gameNum = Integer.valueOf(scanner.nextLine());
        String formString = "";
        double formScore = 0;
        int pointsEarned = 0;
        int goalsScored = 0;
        int goalsConceded = 0;
        for (int i = 1; i <= gameNum; i ++) {
            StringTokenizer tokens = new StringTokenizer(scanner.nextLine(), " ");
            String homeTeam = tokens.nextToken();
            String awayTeam = tokens.nextToken();
            int homeScore = Integer.valueOf(tokens.nextToken());
            int awayScore = Integer.valueOf(tokens.nextToken());
            if (homeTeam.equalsIgnoreCase(teamName)) {
                if (homeScore > awayScore) {
                    formString += "W";
                    formScore += i * 2 * 1;
                    pointsEarned += 3;
                } else if (homeScore < awayScore) {
                    formString += "L";
                    formScore += i * -2 * 1.5;
                } else {
                    formString += "D";
                    formScore += i * 1 * 0.5;
                    pointsEarned += 1;
                }
                goalsScored += homeScore;
                goalsConceded += awayScore;
            } else {
                if (homeScore < awayScore) {
                    formString += "W";
                    formScore += i * 2 * 1.5;
                    pointsEarned += 3;
                } else if (homeScore > awayScore) {
                    formString += "L";
                    formScore += i * -2 * 1;
                } else {
                    formString += "D";
                    formScore += i * 1 * 1.5;
                    pointsEarned += 1;
                }
                goalsScored += awayScore;
                goalsConceded += homeScore;
            }
        }
        System.out.println("Team Name: " + teamName);
        System.out.println("Form String: " + formString);
        System.out.printf("Form Score: %.2f%n", formScore);
        System.out.println("Points earned: " + pointsEarned);
        System.out.println("Goals scored: " + goalsScored);
        System.out.println("Goals conceded: " + goalsConceded);
    }
}
