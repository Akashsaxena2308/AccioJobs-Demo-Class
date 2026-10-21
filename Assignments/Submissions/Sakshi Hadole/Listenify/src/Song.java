package src;

public class Song {
    private final String title;
    private final double duration;

    public Song(String title, double duration){
        this.title=title;
        this.duration=duration;

        if (title==null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null");
        }
        if(duration<=0){
            throw new IllegalArgumentException("duration canot not be zero or less than zero")  ;
        }
    }

    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }

}
