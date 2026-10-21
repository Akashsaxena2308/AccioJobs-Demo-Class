package listenify;

public class Song {
    private final String title;
    private final double duration;

    public Song(String title, double duration) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (!Double.isFinite(duration) || duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive and finite");
        }
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }
    @Override
    public String toString() {
        return title + " (" + duration + " min)";
    }
}
