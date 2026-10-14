import java.util.LinkedList;
import java.util.ListIterator;

public class PlaylistPlayer {
    private Song current;
    private final LinkedList<Song> playlist;
    private final ListIterator<Song> cursor;

    public PlaylistPlayer(LinkedList<Song> playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist cannot be null");
        }
        // Copy the list structure so outside edits cannot invalidate our iterator.
        // Both lists still refer to the same Song objects.
        this.playlist = new LinkedList<>(playlist);
        cursor = this.playlist.listIterator();
        current = cursor.hasNext() ? cursor.next() : null;
    }

    // Invariant: the cursor is immediately AFTER the current song.
    public void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
            return;
        }
        if (!cursor.hasNext()) {
            System.out.println("Already at the last song");
            return;
        }
        current = cursor.next();
        System.out.println("Now playing: " + current.getTitle());
    }

    public void prevSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
            return;
        }
        cursor.previous(); // Cross current: cursor is now BEFORE it.
        if (!cursor.hasPrevious()) {
            cursor.next(); // Restore cursor after the first song.
            System.out.println("Already at the first song");
            return;
        }
        current = cursor.previous();
        cursor.next(); // Restore cursor AFTER the newly selected song.
        System.out.println("Now playing: " + current.getTitle());
    }
}
