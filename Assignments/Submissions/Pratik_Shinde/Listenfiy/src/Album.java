import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Album {
    private String albumId;
    private String title;
    private List<Song> songs;

    public Album(String title) {
        this.albumId = UUID.randomUUID().toString();
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        if (song == null || songs.contains(song)){
            throw new IllegalArgumentException("invalid credentials");
        }
        songs.add(song);
        System.out.println("Added song '" + song.getTitle() + "' to album: " + title);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{title='" + title + "', totalSongs=" + songs.size() + '}';
    }
}
