import java.io.*;
import java.util.*;

/**
 * Movie
 *
 * A program that models a movie.
 */
public class Movie {
    private ArrayList<String> movieList;
    
    public Movie() {
        movieList = new ArrayList<String>();
    }
    
    public void readMoviesFromFile(String filename) throws UnsupportedMovieException {
        if (!new File(filename).exists()) return;
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] values = line.split("\\s*,\\s*");
                if (values.length != 3) throw new UnsupportedMovieException("Invalid format.");
                this.addMovie(values[0], values[1], values[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void writeMoviesToFile(String filename) {
        if (!new File(filename).exists()) return;
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            for (String movie : movieList) pw.println(movie);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addMovie(String title, String director, String releaseYear) {
        String movie = title + ", " + director + ", " + releaseYear;
        movieList.add(movie);
    }
}
