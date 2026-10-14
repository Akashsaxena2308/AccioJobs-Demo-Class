import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlayListPlayer {
    private Song currentSong;
    private LinkedList<Song> playList = new LinkedList<>();
    private ListIterator<Song> cursor;
    private boolean paused = false;

    public void addSong(Song song) {
        if (song != null) {
            playList.add(song);
            cursor = playList.listIterator();
        }
    }

    public Song nextSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to play.");
            return null;
        }
        // Initialize cursor if null, or reset to start if we've gone past the end
        if (cursor == null || !cursor.hasNext()) {
            cursor = playList.listIterator();
        }
        currentSong = cursor.next();
        paused = false;
        System.out.println("Now playing: " + currentSong.getTitle());
        return currentSong;
    }

    public Song previousSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to play.");
            return null;
        }
        // Initialize cursor if null, or reset to end if we can't go back
        if (cursor == null || !cursor.hasPrevious()) {
            cursor = playList.listIterator(playList.size());
        }
        currentSong = cursor.previous();
        paused = false;
        System.out.println("Now playing: " + currentSong.getTitle());
        return currentSong;
    }

    public Song replayCurrentSong() {
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return null;
        }
        paused = false;
        System.out.println("Replaying: " + currentSong.getTitle());
        return currentSong;
    }

    public void pauseResume() {
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return;
        }
        paused = !paused;
        if (paused) {
            System.out.println("Paused: " + currentSong.getTitle());
        } else {
            System.out.println("Resumed: " + currentSong.getTitle());
        }
    }

    public boolean isPaused() {
        return paused;
    }

    public void removeCurrentSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to remove.");
            return;
        }
        if (currentSong == null) {
            System.out.println("No song is currently playing. Play a song first.");
            return;
        }
        if (playList.remove(currentSong)) {
            System.out.println("Removed: " + currentSong.getTitle());
            // Reset cursor after removal since the list structure changed
            cursor = playList.listIterator();
            if (playList.isEmpty()) {
                currentSong = null;
                System.out.println("Playlist is now empty.");
            } else {
                currentSong = cursor.next();
                System.out.println("Now playing: " + currentSong.getTitle());
            }
        }
    }

    public void showPlaylist() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Playlist (" + playList.size() + " songs) ---");
        int count = 1;
        for (Song song : playList) {
            String marker = (currentSong != null && song == currentSong) ? " >> " : "    ";
            System.out.println(marker + count + ". " + song);
            count++;
        }
        System.out.println("-------------------------------------\n");
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public void play() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        currentSong = playList.poll();
        // Reset cursor since poll() modifies the list structure
        cursor = playList.listIterator();
        System.out.println("Now playing: " + currentSong.getTitle());
    }

    public void playAll() {
        while (!playList.isEmpty()) {
            play();
        }
        // Reset cursor after draining the playlist
        cursor = playList.listIterator();
    }

    public int size() {
        return playList.size();
    }

    public List<Song> getPlaylist() {
        return playList;
    }
}
