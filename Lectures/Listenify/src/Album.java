import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String name;
    private final String artist;
    private final List<Song> songs = new ArrayList<>();

    public Album(String name, String artist) {
        if (name == null || name.isBlank() || artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Album name and artist cannot be empty");
        }
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public void addSong(String title, double duration) {
        // Song validates its own title and duration.
        Song song = new Song(title, duration);
        if (findSong(title) != null) {
            throw new IllegalArgumentException("Duplicate song title");
        }
        songs.add(song);
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            // Compare string contents, rather than references.
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public void addToPlaylist(String title, List<Song> playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist cannot be null");
        }
        Song song = findSong(title);
        if (song == null) {
            throw new IllegalArgumentException("Song is not present in this album");
        }
        // Store a reference to the existing Song; do not create another Song.
        playlist.add(song);
    }
}
