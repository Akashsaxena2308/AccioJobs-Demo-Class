import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Playlist {
    private String playlistId;
    private String name;
    private List<Song> list;

    public Playlist(String name) {
        this.playlistId = UUID.randomUUID().toString();
        this.name = name;
        this.list = new LinkedList<>();
    }

    public void addSong(Song song){
        if(song == null && list.contains(song)){
            throw new IllegalArgumentException("Please enter valid credentials");
        }
        list.add(song);
    }

    public void removeSong(Song song){
        if (song == null || !list.contains(song)){
            throw new IllegalArgumentException("Please enter valid credentials");
        }
        list.remove(song);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("invalid credentials");
        }
        this.name = name;
    }

    public List<Song> getSongs(){
        return list;
    }

    public String toString() {
        return "Playlist{name='" + name + "', totalSongs=" + list.size() + '}';
    }
}
