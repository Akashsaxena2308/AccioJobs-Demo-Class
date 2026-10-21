public class Song {
    private String song_name;
    private String artist_name;
    private double duration;

    public Song(String song_name, String artist_name, double duration) {
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.duration = duration;
    }

    public String get_Song_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String get_artist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}