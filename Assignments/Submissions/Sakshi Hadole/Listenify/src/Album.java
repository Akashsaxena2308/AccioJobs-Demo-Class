package src;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String name;
    private final String artist;

    private final List<Song> Songs=new ArrayList<>();
    public Album(String name, String artist){
        if(name==null|| name.isBlank()|| artist==null ||artist.isBlank()){
            throw new IllegalArgumentException("Album name and artist cannot be empty");
        }
        this.name=name;
        this.artist=artist;
    }
    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }

    public void addSong(String title,double duration){
        Song song=new Song(title,duration);
        if(findSong(title )!= null){
            throw new IllegalArgumentException("Duplicate song title");
        }
        Songs.add(new Song(title,duration));
    }

    public Song findSong(String title){
        if(title==null){
            return null;
        }
        for(Song song :Songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;

        }
    //add to playList
    public void addToPlayList(String title, List<Song> PlayList){
        if(PlayList==null){
            throw new IllegalArgumentException("PlayList cannot empty");
        }
        Song song=findSong(title);
        if(song==null){
            throw new IllegalArgumentException("Song not found in album");
        }
        PlayList.add(song);
    }

}
