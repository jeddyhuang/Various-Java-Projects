import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAnalyzer {

    public static float averageScore;
    public static Score lowestScore;
    public static Score highestScore;
    public static ArrayList<Score> scores = new ArrayList<>();

    public static void readScores(String filename) throws FileNotFoundException{
        try(BufferedReader bfr = new BufferedReader(new FileReader(filename))){
            String line = bfr.readLine();
            while (line != null) {
                String[] lineValues = line.split(", ");
                Score score = new Score(lineValues[0], Integer.parseInt(lineValues[1]));
                scores.add(score);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (FileNotFoundException e){
            throw e;
        } catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public static void calculateResults() {
        lowestScore = scores.get(0);
        highestScore = scores.get(0);
        float sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i).getScore();
            if (highestScore.getScore() < scores.get(i).getScore()) {
                highestScore = scores.get(i);
            }
            if (lowestScore.getScore() > scores.get(i).getScore()) {
                lowestScore = scores.get(i);
            }
        }
        averageScore = sum / scores.size();
    }

    public static void writeResults(String filename) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(filename))){
            pw.println("Highest score was " + highestScore.getScore() + ", by " + highestScore.getName());
            pw.println("Lowest score was " + lowestScore.getScore() + ", by " + lowestScore.getName());
            pw.printf("Average score: %.2f%n", averageScore);
            pw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the location of the scores file");
        String scoresFile = sc.nextLine();
        System.out.println("Enter the location of the results file");
        String resultsFile = sc.nextLine();
        readScores(scoresFile);
        calculateResults();
        writeResults(resultsFile);
        System.out.println("Results written");
    }
}
