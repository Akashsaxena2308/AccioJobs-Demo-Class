package src;

public class Song {
    public  final String title;
    public final double duration;

    Song(String title, double duration) {

        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
}
