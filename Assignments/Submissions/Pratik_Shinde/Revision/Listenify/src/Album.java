import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
    private final List<String> list_album = new ArrayList<>();
    private final String al_name;
    private final Map<String, List<Song>> album = new HashMap<>();

    public Album(String al_Name){
        if (al_Name == null){
            throw new Listenify_exception("Please enter the name of the album");
        }
        list_album.add(al_Name);
        this.al_name = al_Name;
        album.put(al_name, new ArrayList<>());
    }

    public void add_song(Song song) throws Listenify_exception{
        if (album.containsKey(song)){
            throw new Listenify_exception("Song ");
        }
        album.get(al_name).add(song);
    }

    public void remove_song(String al_name, Song song){
        if (!album.containsKey(song)){
            throw new Listenify_exception("Song is not present");
        }
        album.get(al_name).remove(song);
    }

    public List<Song> getAllSongs(String al_name){
        return album.get(al_name);
    }

    public String get_ablum_name(){
        return al_name;
    }

    public List<String> Available_album(){
        return list_album;
    }
}
