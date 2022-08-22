/**
 * Song
 *
 * A class that defines a Song. A song is a medium of music, and this file is
 * representative of it.
 */
public class Song {
    private final String songName;
    private final int songLengthInSeconds;
    private final String songGenre;
    private final Artist mainArtist;
    private final Artist[] accompanyingArtists;
    
    public Song() {
        songName = "NO NAME SONG";
        songLengthInSeconds = -1;
        songGenre = "Unknown";
        mainArtist = null;
        accompanyingArtists = null;
    }
    
    public Song(String songName, int songLengthInSeconds, String songGenre,
            Artist mainArtist, Artist[] accompanyingArtists) {
        this.songName = songName;
        this.songLengthInSeconds = songLengthInSeconds;
        this.songGenre = songGenre;
        this.mainArtist = mainArtist;
        this.accompanyingArtists = accompanyingArtists;
    }
    
    public Song(Song copy) {
        songName = copy.getSongName();
        songLengthInSeconds = copy.getSongLengthInSeconds();
        songGenre = copy.getSongGenre();
        mainArtist = copy.getMainArtist();
        accompanyingArtists = copy.getAccompanyingArtists();
    }
    
    public String getSongName() {
        return songName;
    }
    
    public String getSongLengthInMinutesAndSeconds() {
        if (songLengthInSeconds < 0) return "";
        int minutes = songLengthInSeconds / 60;
        int seconds = songLengthInSeconds % 60;
        String min = String.format("%02d", minutes);
        String sec = String.format("%02d", seconds);
        return min + ":" + sec;
    }
    
    public int getSongLengthInSeconds() {
        return songLengthInSeconds;
    }
    
    public String getSongGenre() {
        return songGenre;
    }
    
    public Artist getMainArtist() {
        return mainArtist;
    }
    
    public Artist[] getAccompanyingArtists() {
        return accompanyingArtists;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Song) {
            Song song = (Song) o;
            return songName.equals(song.getSongName()) &&
                    songLengthInSeconds == song.getSongLengthInSeconds() &&
                    songGenre.equals(song.getSongGenre());
        }
        return false;
    }
}
