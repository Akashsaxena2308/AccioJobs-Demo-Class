package listenify;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlaylistPlayer {
    private final LinkedList<Song> playlist;
    private final ListIterator<Song> cursor;
    private Song current;
    private boolean paused;

    public PlaylistPlayer(List<Song> songs) {
        if (songs == null) throw new IllegalArgumentException("Playlist required");
        playlist = new LinkedList<>(songs);
        cursor = playlist.listIterator();
        current = cursor.hasNext() ? cursor.next() : null;
    }

    public String currentSong() {
        return current == null ? "Playlist is empty" : "Now playing: " + current;
    }

    // Cursor invariant: whenever current exists, the cursor is immediately AFTER it.
    public String next() {
        if (current == null) return "Playlist is empty";
        if (!cursor.hasNext()) return "Already at the last song";
        current = cursor.next();
        paused = false;
        return currentSong();
    }

    public String previous() {
        if (current == null) return "Playlist is empty";
        cursor.previous(); // Cross the current song: cursor now BEFORE it.
        if (!cursor.hasPrevious()) {
            cursor.next(); // Restore cursor AFTER the same first song.
            return "Already at the first song";
        }
        current = cursor.previous(); // Reach the preceding song.
        cursor.next(); // Restore cursor AFTER this new current song.
        paused = false;
        return currentSong();
    }

    public String replay() {
        paused = false;
        return currentSong(); // Replaying does not move the cursor.
    }

    public String pauseOrResume() {
        if (current == null) return "Playlist is empty";
        paused = !paused;
        return (paused ? "Paused: " : "Resumed: ") + current;
    }


    //player
    //Cursor
    //just in front of current song
    // C song3 null
    // song2 C song3
    public String removeCurrent() {
        if (current == null) return "Playlist is empty";
        Song removed = cursor.previous(); // Cross current before removing it.
        cursor.remove();
        if (cursor.hasNext()) {
            current = cursor.next(); // Prefer successor; cursor ends after it.
        } else if (cursor.hasPrevious()) {
            current = cursor.previous(); // Otherwise select predecessor.
            cursor.next(); // Restore cursor after it. IMPORTANT STEP
        } else {
            current = null;
        }
        paused = false;
        return "Removed: " + removed + " | " + currentSong();
    }

    public void printPlaylist() {
        for (Song song : playlist) System.out.println(song);
    }

    public void addSong(Song song) {
        if (song == null) throw new IllegalArgumentException("Song required");
        cursor.add(song); // Insert immediately after current using the active iterator.
        cursor.previous(); // Restore cursor immediately after the existing current.
        if (current == null) {
            current = cursor.next(); // Empty playlist: new song becomes current.
            paused = false;
        }
    }
}
