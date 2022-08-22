import java.io.*;
import java.util.*;

/**
 * MusicAnalyzer
 *
 * A class that defines a MusicAnalyzer. This will read and process song files.
 */
public class MusicAnalyzer {
    private static Artist[] artists;
    private static MusicAnalyzer musicAnalyzer;
    private static Song[] songs;
    
    public MusicAnalyzer() {
        artists = new Artist[10];
        songs = new Song[10];
    }
    
    public int addArtist(Artist artist) {
        for (Artist tocheck : artists) {
            if (tocheck != null) {
                if (artist.equals(tocheck)) return -1;
            }
        }
        for (int i = 0; i < artists.length; i++) {
            if (artists[i] == null) {
                artists[i] = artist;
                return i;
            }
        }
        Artist[] temp = new Artist[artists.length * 2];
        for (int i = 0; i < artists.length; i++) {
            temp[i] = artists[i];
        }
        temp[artists.length] = artist;
        int index = artists.length;
        artists = temp;
        return index;
    }
    
    public void addSong(Song song) {
        for (int i = 0; i < songs.length; i++) {
            if (songs[i] == null) {
                songs[i] = song;
                return;
            }
        }
        Song[] temp = new Song[songs.length * 2];
        for (int i = 0; i < songs.length; i++) {
            temp[i] = songs[i];
        }
        temp[songs.length] = song;
        songs = temp;
    }
    
    public void countSongsByArtist(String artistName) {
        for (Artist artist : artists) {
            if (artist != null) {
                if (artistName.equals(artist.getArtistName())) {
                    int counter = 0;
                    for (Song song : artist.getArtistSongs()) {
                        if (song != null) counter++;
                    }
                    System.out.println("The artist you entered has recorded " + counter + " songs.");
                    return;
                }
            }
        }
        System.out.println("The artist you entered has recorded 0 songs.");
    }
    
    public void exportByArtist(Scanner scanner, String filename) {
        if (new File(filename).exists()) {
            System.out.println("The file you entered already exists. Continuing"
                    + "will overwrite it. Enter 1 if this is okay, or 2 to exit.");
            String line;
            for (line = scanner.nextLine(); !"1".equals(line) && !"2".equals(line); line = scanner.nextLine()) {
                System.out.println("Invalid choice. Try again.");
            }
            if ("2".equals(line)) return;
        }
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            for (Artist artist : artists) {
                if (artist != null) {
                    if (artist.getArtistSongs()[0] != null) {
                        pw.print(artist.getArtistName() + "\t");
                        boolean isfirst = true;
                        for (Song song : artist.getArtistSongs()) {
                            if (song != null) {
                                if (!isfirst) pw.print(", ");
                                pw.print(song.getSongName());
                                isfirst = false;
                            }
                        }
                        pw.println();
                    }
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void findArtistGenre(String artistName) {
        for (Artist artist : artists) {
            if (artist != null) {
                if (artistName.equals(artist.getArtistName())) {
                    System.out.println("The artist you entered has a genre of " + artist.getArtistGenre() + ".");
                    return;
                }
            }
        }
        System.out.println("The artist you entered couldn't be found!");
    }
    
    public void findArtistsAndFeatures(String artistName, String[] features) {
        for (Artist artist : artists) {
            if (artist != null) {
                if (artistName.equals(artist.getArtistName())) {
                    boolean isEmpty = true;
                    int counter = 1;
                    for (int i = 0; i < artist.getArtistSongs().length; i++) {
                        if (artist.getArtistSongs()[i] != null) {
                            isEmpty = false;
                            boolean ispresent1 = true;
                            for (String feature : features) {
                                boolean ispresent2 = false;
                                for (Artist featuring : artist.getArtistSongs()[i].getAccompanyingArtists()) {
                                    if (feature.equals(featuring.getArtistName())) ispresent2 = true;
                                }
                                if (!ispresent2) ispresent1 = false;
                            }
                            if (ispresent1) {
                                System.out.println("(" + counter + ") " + artist.getArtistSongs()[i].getSongName());
                                counter++;
                            }
                        }
                    }
                    if (isEmpty) System.out.println("The artist has no songs!");
                    return;
                }
            }
        }
    }
    
    public void findMainArtistOnSong(String songName) {
        for (Song song : songs) {
            if (song != null) {
                if (songName.equals(song.getSongName())) {
                    System.out.println("The song you entered was recorded by " +
                            song.getMainArtist().getArtistName() + ".");
                    return;
                }
            }
        }
        System.out.println("The song you entered couldn't be found!");
    }
    
    public void findSongLength(String songName) {
        for (Song song : songs) {
            if (song != null) {
                if (songName.equals(song.getSongName())) {
                    System.out.println("The song you entered has a length of "
                            + song.getSongLengthInMinutesAndSeconds() + ".");
                    return;
                }
            }
        }
        System.out.println("The song you entered couldn't be found!");
    }
    
    public void listFeaturesOnSong(String songName) {
        for (Song song : songs) {
            if (song != null) {
                if (songName.equals(song.getSongName())) {
                    boolean isEmpty = true;
                    for (int i = 0; i < song.getAccompanyingArtists().length; i++) {
                        isEmpty = false;
                        System.out.println("(" + (i + 1) + ") " + song.getAccompanyingArtists()[i].getArtistName());
                    }
                    if (isEmpty) System.out.println("This song doesn't have any features!");
                    return;
                }
            }
        }
        System.out.println("The song you entered couldn't be found!");
    }
    
    public void listSongsByArtist(String artistName) {
        for (Artist artist : artists) {
            if (artist != null) {
                if (artistName.equals(artist.getArtistName())) {
                    for (int i = 0; i < artist.getArtistSongs().length; i++) {
                        if (artist.getArtistSongs()[i] != null) {
                            System.out.println("(" + (i + 1) + ") " + artist.getArtistSongs()[i].getSongName());
                        }
                    }
                    return;
                }
            }
        }
        System.out.println("The artist you entered couldn't be found!");
    }
    
    public static void main(String[] args) throws InvalidSongFormatException {
        Scanner scanner = new Scanner(System.in);
        MusicAnalyzer.performInitialization(scanner);
        int choice = 0;
        while (choice != 9) {
            MusicAnalyzer.showMenu();
            String input = scanner.nextLine();
            boolean latch = true;
            for (char curr : input.toCharArray()) {
                if (!Character.isDigit(curr)) {
                    latch = false;
                    choice = 0;
                }
            }
            if (latch) choice = Integer.valueOf(input);
            switch (choice) {
                case 1:
                    System.out.println("What is the name of the artist you want all the songs by?");
                    musicAnalyzer.listSongsByArtist(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("What is the name of the song you want the features of?");
                    musicAnalyzer.listFeaturesOnSong(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("What is the name of the song you want the main artist of?");
                    musicAnalyzer.findMainArtistOnSong(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("What is the name of the artist?");
                    musicAnalyzer.countSongsByArtist(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("What is the name of the song?");
                    musicAnalyzer.findSongLength(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("What is the name of the artist?");
                    musicAnalyzer.findArtistGenre(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("What is the name of the main artist?");
                    String mainartist = scanner.nextLine();
                    System.out.println("How many features are there?");
                    int num = Integer.valueOf(scanner.nextLine());
                    String[] features = new String[num];
                    System.out.println("Enter the artist names, each one on its own line.");
                    for (int i = 0; i < num; i++) {
                        features[i] = scanner.nextLine();
                    }
                    musicAnalyzer.findArtistsAndFeatures(mainartist, features);
                    break;
                case 8:
                    System.out.println("What is the filename you want to export to?"
                            + "Be sure to include the extension.");
                    musicAnalyzer.exportByArtist(scanner, scanner.nextLine());
                    break;
                case 9:
                    System.out.println("Exiting the Music Analyzer");
                    break;
                default:
                    System.out.println("You entered something other than a number, try again!");
                    break;
            }
        }
    }
    
    public static void performInitialization(Scanner scanner) throws InvalidSongFormatException {
        musicAnalyzer = new MusicAnalyzer();
        System.out.println("What is the name of the song file you'd like to read?");
        String line = scanner.nextLine();
        if (!line.contains(".")) {
            throw new InvalidSongFormatException("Make sure you include the extension of your file!");
        }
        if (line.indexOf(".") == line.length() - 1) {
            throw new InvalidSongFormatException("Make sure you enter a valid file extension!");
        }
        if (!new File(line).exists()) {
            throw new InvalidSongFormatException("The file you gave doesn't exist!");
        }
        try {
            MusicAnalyzer.processFile(line);
        } catch (InvalidSongFormatException e) {
            throw e;
        }
    }
    
    public static void processFile(String filename) throws InvalidSongFormatException {
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                int commas = 0;
                for (char temp : line.substring(0, line.indexOf("[")).toCharArray()) {
                    if (temp == ',') commas++;
                }
                if (commas != 4) throw new InvalidSongFormatException();
                String[] songinfo = line.substring(0, line.indexOf("[")).split("\\s*,\\s*");
                String artistname = songinfo[1];
                int mainind = -1;
                for (int i = 0; i < artists.length; i++) {
                    if (artists[i] != null) {
                        if (artists[i].getArtistName().equals(artistname)) {
                            mainind = i;
                        }
                    }
                }
                if (mainind == -1) {
                    musicAnalyzer.addArtist(new Artist(artistname));
                }
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] songinfo = line.substring(0, line.indexOf("[")).split("\\s*,\\s*");
                String songname = songinfo[0];
                String artistname = songinfo[1];
                String genre = songinfo[2];
                int length = Integer.valueOf(songinfo[3]);
                String[] features;
                if (line.substring(line.indexOf("[") + 1, line.indexOf("]")).isEmpty()) {
                    features = new String[]{};
                } else if (!line.substring(line.indexOf("[") + 1, line.indexOf("]")).contains(",")) {
                    features = new String[]{line.substring(line.indexOf("[") + 1, line.indexOf("]"))};
                } else features = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split("\\s*,\\s*");
                int mainind = -1;
                for (int i = 0; i < artists.length; i++) {
                    if (artists[i] != null) {
                        if (artists[i].getArtistName().equals(artistname)) {
                            mainind = i;
                        }
                    }
                }
                if (mainind == -1) {
                    mainind = musicAnalyzer.addArtist(new Artist(artistname));
                }
                int[] featureind = new int[features.length];
                for (int i = 0; i < featureind.length; i++) featureind[i] = -1;
                for (int j = 0; j < features.length; j++) {
                    for (int i = 0; i < artists.length; i++) {
                        if (artists[i] != null) {
                            if (artists[i].getArtistName().equals(features[j])) {
                                featureind[j] = i;
                            }
                        }
                    }
                }
                for (int i = 0; i < featureind.length; i++) {
                    if (featureind[i] == -1) {
                        featureind[i] = musicAnalyzer.addArtist(new Artist(features[i]));
                    }
                }
                Artist mainartist = artists[mainind];
                Artist[] featureartists = new Artist[features.length];
                for (int i = 0; i < features.length; i++) {
                    featureartists[i] = artists[featureind[i]];
                }
                Song tobeadded = new Song(songname, length, genre, mainartist, featureartists);
                musicAnalyzer.addSong(tobeadded);
                artists[mainind].recordOwnSong(tobeadded);
                for (int i = 0; i < featureind.length; i++) {
                    artists[featureind[i]].recordFeaturedSong(tobeadded);
                }
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print the menu for the Music Analyzer.
     */
    public static void showMenu() {
        System.out.println("****************");
        System.out.println("Music Analyzer");
        System.out.println("(1) List all songs by an artist");
        System.out.println("(2) List all features on a song");
        System.out.println("(3) List the main artist of a song");
        System.out.println("(4) How many songs does this artist have?");
        System.out.println("(5) What is the length of a specific song?");
        System.out.println("(6) What genre does this artist fall under?");
        System.out.println("(7) What are the songs which are by a specific artist featuring other specific artists?");
        System.out.println("(8) Export all artist data by artist");
        System.out.println("(9) Exit");
        System.out.println("****************");
    }
}
