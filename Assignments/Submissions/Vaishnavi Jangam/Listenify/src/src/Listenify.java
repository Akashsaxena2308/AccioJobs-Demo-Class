package src;

import java.util.*;

public class Listenify {
    public static void main(String[] args) {
        Song song1 = new Song("Song1", 5.0);

        Album album = new Album("Album1", "abc");

        album.addSong("song1", 5.0);

        album.addSong("song2", 4.0);
        try{
            album.addSong("song", 5.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        LinkedList<Song> playlist1 = new LinkedList<>();
        LinkedList<Song> playlist2 = new LinkedList<>();

        album.addToPlaylist("song1", playlist1);
        album.addToPlaylist("song2", playlist2);

        ListIterator<Song> iterator = playlist1.listIterator();
        System.out.println(iterator.next().getTitle());
    }

}
