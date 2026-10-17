import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String name;
    private final String author;

    private final List<Song> songs = new ArrayList<>();
    public Album(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }

    public void addSong(String title, int duration){
        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if(duration<0){
            throw new IllegalArgumentException("Duration cannot be negative");
        }

        songs.add(new Song(title, duration));
    }
    public Song findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }
    public void addToPlaylist(String title, List<Song> playlist){
        if(playlist == null){
            return;
        }
        Song song = findSong(title);
        if(song != null){
            playlist.add(song);
        }
    }
    
    @Override
    public String toString() {
        return name + " by " + author;
    }
}
