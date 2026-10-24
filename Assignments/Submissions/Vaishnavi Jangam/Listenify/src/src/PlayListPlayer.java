package src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayListPlayer {
    private Song current;
    private final LinkedList<Song> playlist;
    private ListIterator<Song> cursor;
    private boolean paused;

    public PlayListPlayer(LinkedList<Song> playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("playlist cannot be null");
        }
        this.playlist = new LinkedList<>(playlist);
        cursor = this.playlist.listIterator();
        current = cursor.hasNext() ? cursor.next() : null;
    }

    // FIX: added ": " and this is now the only place that says "Now playing"
    public String currentSong() {
        return current == null ? "Playlist is empty" : "Now playing: " + current;
    }

    void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
            return;
        }
        if (!cursor.hasNext()) {
            System.out.println("Already at last song");
            return;
        }
        current = cursor.next();
        paused = false;
        System.out.println(currentSong());
    }

    void previousSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
            return;
        }
        cursor.previous();
        if (!cursor.hasPrevious()) {
            cursor.next();
            System.out.println("Already at first song");
            return;
        }
        current = cursor.previous();
        cursor.next();
        paused = false;
        System.out.println(currentSong());
    }

    public String replay() {
        if (current == null) {
            return "Playlist is empty";
        }
        paused = false;
        return currentSong();
    }

    // FIX: flips between paused and resumed
    public String pauseOrResume() {
        if (current == null) {
            return "Playlist is empty";
        }
        paused = !paused;
        return (paused ? "Paused: " : "Resumed: ") + current;
    }

    public String removeCurrent() {
        if (current == null) {
            return "Playlist is empty";
        }
        Song removed = cursor.previous();
        cursor.remove();

        if (cursor.hasPrevious()) {
            current = cursor.previous();
            cursor.next();
        } else if (cursor.hasNext()) {
            current = cursor.next();
        } else {
            current = null;
        }
        paused = false;
        return "Removed: " + removed + " | " + currentSong();
    }

    // FIX: shows a message when the playlist is empty
    public void printPlayList() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void addSong(Song song) {
        if (song == null) {
            throw new NullPointerException("Song is required");
        }
        cursor.add(song);
        cursor.previous();

        if (current == null) {
            current = cursor.next();
            paused = false;
        }
    }
}