import java.util.List;
import java.util.ListIterator;

public class Player {
    private Song curr;
    private String status;
    private Playlist playlist;
    private ListIterator<Song> iterator;
    private int volume;

    public Player(Playlist playlist){
        if (playlist == null || playlist.getSongs() == null || !playlist.getSongs().isEmpty()){
            throw new IllegalArgumentException("invalid credentials");
        }
        this.playlist = playlist;
        this.status = "STOPPED";
        this.volume = 50;
        this.iterator = playlist.getSongs().listIterator();
        this.curr = iterator.next();
    }

    public Song findSongByName(String title){
        if (playlist == null || playlist.getSongs() == null){
            throw new IllegalArgumentException("invalid credentials");
        }

        for (Song song: playlist.getSongs()){
            if (song.getTitle().equals(title)){
                return song;
            }
        }

        throw new IllegalArgumentException("Not Found");
    }

    public void play(){
        if (curr == null){
            throw new IllegalArgumentException("Add songs");
        }
        this.status = "PLAYING";
        System.out.println("Playing : "+curr.getTitle());
    }

    public void pause(){
        if ("PLAYING".equals(status)){
            this.status = "PAUSED";
            System.out.println("Paused : "+curr.getTitle());
        }
        else {
            throw new IllegalArgumentException("Player is not currently playing.");
        }
    }

    public void next(){
        if (iterator == null || !iterator.hasNext()){
            throw new IllegalArgumentException("Last song");
        }
        curr = iterator.next();
        play();
    }

    public void prev(){
        if (iterator == null || iterator.hasPrevious()){
            throw new IllegalArgumentException("Already on first song.");
        }
        curr = iterator.previous();
        play();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    public String getStatus() {
        return status;
    }

    public Song getCurr() {
        return curr;
    }
}
