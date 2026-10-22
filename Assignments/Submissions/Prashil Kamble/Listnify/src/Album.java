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

    // add song to a album
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
        System.out.println("Song added to an album");

    }

    // check song is present or not in the album
    public Song findSong(String title){
        for (Song sng : songList){
            if(sng.getTitle().equals(title)){
                return sng;
            }
        }
        return null;
    }

    // Add to playlist
    public void addToPlayList(String title, List<Song> playlist){
        if(playlist == null){
            throw new IllegalArgumentException("Playlist cannot be null");
        }

        Song song = findSong(title);
        if(song == null){
            throw new IllegalArgumentException("Song is not present in this album");
        }

        playlist.add(song);
    }



}
