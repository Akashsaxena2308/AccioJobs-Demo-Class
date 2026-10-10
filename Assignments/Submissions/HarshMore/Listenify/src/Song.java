import java.time.LocalDateTime;

public class Song {
    String name;
    Double duration;
    String artist;


    public Song(String name, Double duration, String artist) {
        if(name == null && name.isBlank()){
            throw new IllegalArgumentException();
        }
        if(duration <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.duration = duration;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", artist='" + artist + '\'' +
                '}';
    }
}
