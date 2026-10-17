package src;
import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String albumName;
    private final String artist;

    private final List<Song> album = new ArrayList<>();
    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }
    public String getArtist() {
        return artist;
    }

    public void addSong(String title, double duration) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if(duration <=0 ){
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        album.add(new Song(title, duration));
    }

    public Song findSong(String title) {
        for (Song song : album) {
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    public void addToPlaylist(String title, List<Song> playList) {
        if(playList == null){
            throw new IllegalArgumentException("Playlist cannot be null");
        }
        Song song = findSong(title);
        if(song == null){
            throw new IllegalArgumentException("Song not found");
        }

        playList.add(song);
    }
}
