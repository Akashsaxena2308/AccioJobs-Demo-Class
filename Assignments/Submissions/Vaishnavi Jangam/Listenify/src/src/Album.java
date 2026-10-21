package src;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String albumName;
    private final String artist;
    private final List<Song> songs = new ArrayList<>();

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
        if (findSong(title) != null) {
            throw new IllegalArgumentException("Song already exists");
        }
        songs.add(new Song(title, duration));   // FIX: song is now actually saved
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public void addToPlaylist(String title, List<Song> playList) {
        if (playList == null) {
            throw new IllegalArgumentException("Playlist cannot be null");
        }
        Song song = findSong(title);
        if (song == null) {
            throw new IllegalArgumentException("Song not found");
        }
        playList.add(song);
    }
}