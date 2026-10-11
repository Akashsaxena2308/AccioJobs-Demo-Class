import java.util.LinkedList;
import java.util.List;

public class PlayListPlayer {
    private Song currentSong;
    private LinkedList<Song> playList = new LinkedList<>();
    private int currentIndex = 0;
    private boolean paused = false;

    public void addSong(Song song) {
        if (song != null) {
            playList.add(song);
        }
    }

    public Song nextSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to play.");
            return null;
        }
        if (currentIndex >= playList.size()) {
            currentIndex = 0;
        }
        currentSong = playList.get(currentIndex);
        currentIndex++;
        paused = false;
        System.out.println("Now playing: " + currentSong.getTitle());
        return currentSong;
    }

    public Song previousSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to play.");
            return null;
        }
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = playList.size() - 1;
        }
        currentSong = playList.get(currentIndex);
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
            if (currentIndex >= playList.size()) {
                currentIndex = 0;
            }
            currentSong = playList.isEmpty() ? null : playList.get(currentIndex);
            if (currentSong != null) {
                System.out.println("Now playing: " + currentSong.getTitle());
            } else {
                System.out.println("Playlist is now empty.");
            }
        }
    }

    public void showPlaylist() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\n--- Playlist (" + playList.size() + " songs) ---");
        for (int i = 0; i < playList.size(); i++) {
            String marker = (i == currentIndex - 1 || (currentSong != null && playList.get(i) == currentSong)) ? " >> " : "    ";
            System.out.println(marker + (i + 1) + ". " + playList.get(i));
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
        System.out.println("Now playing: " + currentSong.getTitle());
    }

    public void playAll() {
        while (!playList.isEmpty()) {
            play();
        }
    }

    public int size() {
        return playList.size();
    }

    public List<Song> getPlaylist() {
        return playList;
    }
}
