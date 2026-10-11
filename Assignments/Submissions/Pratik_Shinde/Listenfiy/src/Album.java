import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String name;
    private final String author;

    private final List<Song> songs = new ArrayList<>();

    public Album(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public void addSong(String title, double dur){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Title not found");
        }

        if(dur <= 0){
            throw new IllegalArgumentException("Duration should be positive");
        }

        if (songs.contains(title)){
            throw new IllegalArgumentException();
        }

        songs.add(new Song(title, dur));
    }

    public Song findSong(String title){
        for (Song song : songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }

        return null;
    }

    public void addToPlaylist(String title, List<Song> playlist){
        if (playlist == null){
            throw new IllegalArgumentException("Playlist cannot be");
        }

        Song song = findSong(title);
        if(song == null){
            throw new IllegalArgumentException("Not present");
        }

        playlist.add(song);
    }
}
