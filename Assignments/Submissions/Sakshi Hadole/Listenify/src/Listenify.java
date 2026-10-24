package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Listenify {
    public static void main(String[] args){

        Song song1 = new Song("Song1", 5.0);
        Song song2 = new Song("Song2", 6.0);
        Song song3 = new Song("Song3", 3.0);
        System.out.println(song1.getTitle());
        System.out.println(song1.getDuration());
        //Song  song2 = new Song("Song2", 5.2);
        Album album = new Album("Album1", "abc");

        album.addSong("song2", 6.0);
        album.addSong("song3", 3.0);
        try{
            album.addSong("song", 5.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Song> playlist1 = new LinkedList<>();
        List<Song> playlist2 = new LinkedList<>();

       album.addToPlayList("song2",playlist1);
       album.addToPlayList("song3",playlist2);

        ListIterator<Song> iterator=playlist1.listIterator();
        System.out.println();


    }
}
