import java.util.Date;
import java.util.UUID;

public class Song {
    private final String songId;
    private final String title;
    private final double duration;

    public Song(String title, double duration) {
        this.songId = UUID.randomUUID().toString();
        if (title == null){
            throw new IllegalArgumentException("Song please enter the name");
        }
        this.title = title;
        this.duration = duration;
    }

    public String getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public String getDetails() {
        return "Song[" +
                "songId='" + songId + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ']';
    }
}
