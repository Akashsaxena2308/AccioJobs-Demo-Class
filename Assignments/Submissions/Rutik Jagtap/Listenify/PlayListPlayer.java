import java.util.LinkedList;

public class PlayListPlayer {
    private Song currentSong;
    private LinkedList<Song> playList = new LinkedList<>();
    private int currentIndex = 0;

    public void addSong(Song song) {
        if (song != null) {
            playList.add(song);
        }
    }
    public Song nextSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty.");
            return null;
        }
        if (currentIndex >= playList.size()) {
            currentIndex = 0;
        }
        currentSong = playList.get(currentIndex);
        currentIndex++;
        return currentSong;
    }
    public Song previousSong() {
        if (playList.isEmpty()) {
            System.out.println("Playlist is empty.");
            return null;
        }
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = playList.size() - 1;
        }
        currentSong = playList.get(currentIndex);
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
}
