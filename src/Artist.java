import java.util.Arrays;

/**
 * Artist
 *
 * A class representing a musician or artist.
 */
public class Artist {
    private final String artistName;
    private String artistGenre;
    private Song[] artistSongs;
    private Song[] appearsOnSongs;
    
    public Artist(String artistName) {
        this.artistName = artistName;
        artistGenre = "";
        artistSongs = new Song[5];
        appearsOnSongs = new Song[5];
    }
    
    public Artist(String artistName, String artistGenre) {
        this.artistName = artistName;
        this.artistGenre = artistGenre;
        artistSongs = new Song[5];
        appearsOnSongs = new Song[5];
    }
    
    public Artist(Artist copy) {
        artistName = copy.getArtistName();
        artistGenre = copy.getArtistGenre();
        artistSongs = copy.getArtistSongs();
        appearsOnSongs = copy.getAppearsOnSongs();
    }
    
    public void recordOwnSong(Song song) {
        for (int i = 0; i < artistSongs.length; i++) {
            if (artistSongs[i] == null) {
                artistSongs[i] = song;
                this.calculateArtistGenre();
                return;
            }
        }
        Song[] temp = new Song[artistSongs.length * 2];
        for (int i = 0; i < artistSongs.length; i++) {
            temp[i] = artistSongs[i];
        }
        temp[artistSongs.length] = song;
        artistSongs = temp;
        this.calculateArtistGenre();
    }
    
    public void recordFeaturedSong(Song song) {
        for (int i = 0; i < appearsOnSongs.length; i++) {
            if (appearsOnSongs[i] == null) {
                appearsOnSongs[i] = song;
                this.calculateArtistGenre();
                return;
            }
        }
        Song[] temp = new Song[appearsOnSongs.length * 2];
        for (int i = 0; i < appearsOnSongs.length; i++) {
            temp[i] = appearsOnSongs[i];
        }
        temp[appearsOnSongs.length] = song;
        appearsOnSongs = temp;
        this.calculateArtistGenre();
    }
    
    public void calculateArtistGenre() {
        int max = 0;
        String genre = "";
        for (Song song1 : artistSongs) {
            if (song1 != null) {
                int counter = 0;
                for (Song song2 : artistSongs) {
                    if (song2 != null) {
                        if (song2.getSongGenre().equals(song1.getSongGenre())) counter++;
                    }
                }
                for (Song song2 : appearsOnSongs) {
                    if (song2 != null) {
                        if (song2.getSongGenre().equals(song1.getSongGenre())) counter++;
                    }
                }
                if (counter > max) {
                    max = counter;
                    genre = song1.getSongGenre();
                }
            }
        }
        for (Song song1 : appearsOnSongs) {
            if (song1 != null) {
                int counter = 0;
                for (Song song2 : artistSongs) {
                    if (song2 != null) {
                        if (song2.getSongGenre().equals(song1.getSongGenre())) counter++;
                    }
                }
                for (Song song2 : appearsOnSongs) {
                    if (song2 != null) {
                        if (song2.getSongGenre().equals(song1.getSongGenre())) counter++;
                    }
                }
                if (counter > max) {
                    max = counter;
                    genre = song1.getSongGenre();
                }
            }
        }
        artistGenre = genre;
    }
    
    public String getArtistName() {
        return artistName;
    }
    
    public String getArtistGenre() {
        return artistGenre;
    }
    
    public Song[] getArtistSongs() {
        return artistSongs;
    }
    
    public Song[] getAppearsOnSongs() {
        return appearsOnSongs;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Artist) {
            Artist artist = (Artist) o;
            return artistName.equals(artist.getArtistName()) &&
                    artistGenre.equals(artist.getArtistGenre()) &&
                    Arrays.equals(artistSongs, artist.getArtistSongs()) &&
                    Arrays.equals(appearsOnSongs, artist.getAppearsOnSongs());
        }
        return false;
    }
}
