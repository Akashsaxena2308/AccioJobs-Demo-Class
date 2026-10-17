package src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayListPlayer {
    //    current song
//    next song
//    previous song
    private Song current;

    private final LinkedList<Song> playlist;

    private ListIterator<Song> cursor;

    public PlayListPlayer(Song current,  LinkedList<Song> playlist) {
        this.playlist = playlist;

        cursor = playlist.listIterator();

        current = cursor.hasNext() ? cursor.next() : null;

    }

    void nextSong() {
        if(current == null){
            System.out.println("Playlist is empty");
        }
        if(!cursor.hasNext()){
            System.out.println("Already at last song");
        }
        current = cursor.next();
    }

    void previousSong(){
        if(current == null){
            System.out.println("Playlist is empty");
        }
        cursor.previous();

        if(!cursor.hasPrevious()){
            cursor.next();
            System.out.println("Already at first song");
        }
        current = cursor.previous();
        cursor.next();

    }






}
