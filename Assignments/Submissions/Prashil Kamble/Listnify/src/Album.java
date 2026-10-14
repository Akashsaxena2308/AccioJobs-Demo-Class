import com.sun.jdi.request.DuplicateRequestException;

import java.util.*;

public class Album {

    private final String name;
    private final String artist;

    private final List<Song> songList = new ArrayList<>();

    Album(String name, String artist){
        this.name = name;
        this.artist = artist;
    }

    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }

    public void addSong(String title, int duration){

        if(title == null || title.isBlank()){
            throw  new IllegalArgumentException("Title not be blank or null");
        }
        if(duration <= 0){
            throw new IllegalArgumentException("Duration must be greater than 0");
        }

        for (Song sng : songList){
            if(sng.getTitle() == title){
                throw new DuplicateRequestException("Already song present");
            }
        }

        songList.add(new Song(title, duration));

    }

    public Song findSong(String title){
        for (Song sng : songList){
            if(sng.getTitle().equals(title)){
                return sng;
            }
        }
        return null;
    }

    // Add to playlist




}
