import java.util.ArrayList;
import java.util.List;

public class Album {
    String title;
    String artist;
    List<Song> songs = new ArrayList<>();

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void addSong(Song s) throws Exception {
        if(findSong(s.getName()) != null) throw new Exception("Duplicate Song");
        songs.add(s);
    }

    public Song findSong(String name){
        for(Song s : songs){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    public void addToPlaylist(String name, List<Song> playlist){
        if(playlist == null) {
            Song song = findSong(title);
            playlist.add(song);
        }
    }
}
