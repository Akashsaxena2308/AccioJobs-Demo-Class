import java.util.LinkedList;
import java.util.ListIterator;

public class Listenify {
    public static void main(String[] args) {
        // Hardcoded setup: the dynamic version remains a student assignment.
        Album album = new Album("Album 1", "John");
        album.addSong("song", 5.0);
        album.addSong("song2", 5.1);

        try {
            album.addSong("song", 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        LinkedList<Song> playlist1 = new LinkedList<>();
        LinkedList<Song> playlist2 = new LinkedList<>();
        album.addToPlaylist("song", playlist1);
        album.addToPlaylist("song2", playlist1);
        album.addToPlaylist("song2", playlist2);

        // Both playlists share the same song2 object from the album.
        System.out.println("Same Song object: " + (playlist1.getLast() == playlist2.getFirst()));

        // ListIterator returns an item only when next() is called.
        ListIterator<Song> iterator = playlist1.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        PlaylistPlayer player = new PlaylistPlayer(playlist1);
        player.prevSong(); // First-song boundary.
        player.nextSong(); // song2.
        player.nextSong(); // Last-song boundary.
        player.prevSong(); // song.
    }
}
