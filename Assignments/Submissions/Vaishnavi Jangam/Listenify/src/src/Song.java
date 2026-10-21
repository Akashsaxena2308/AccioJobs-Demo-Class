package src;

public class Song {
    private final String title;
    private final double duration;

    Song(String title, double duration) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (!Double.isFinite(duration) || duration <= 0) {
            throw new IllegalArgumentException("Duration must be a positive number");
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