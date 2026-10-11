import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Album album = new Album("Pratik favorite", "Pratik Shinde");
        Song song1 = new Song("2026", 5);
        Song song2 = new Song("2025", 5);
        Song song3 = new Song("2024", 6);
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        LinkedList<Song> playList1 = new LinkedList<>();
        LinkedList<Song> PlayList2 = new LinkedList<>();
        album.addToPlaylist("2026", playList1);
        album.addToPlaylist("2025", playList1);
        album.addToPlaylist("2024", playList1);

    }
}