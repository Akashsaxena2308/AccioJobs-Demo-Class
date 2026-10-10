import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       Song song1 = new Song("Love",10);
       Album a1 = new Album("Rutik","Jagtap");
       Album a2 = new Album("Prashil","Kamble");
       Album a3 = new Album("Rutik","Jagtap");
       Song song2 = new Song("Music",5);
       Song song3 = new Song("Break",5);
       System.out.println(song1);
       System.out.println("Song 2: "+song2);
       System.out.println("a1 :" + a1);
       System.out.println(a2);
       List<Song> playlist = new ArrayList<>();
       List<Song> playlist2 = new ArrayList<>();
       playlist.add(song1);
       playlist2.add(song2);
       System.out.println(playlist);
       System.out.println(playlist2);
    }
}