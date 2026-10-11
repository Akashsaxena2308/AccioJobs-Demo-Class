public class Song {
    private final String title;
    private final double duration;

    public Song(String title, double duration){
        if(title == null || duration > 0){
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    public double getDuration(){
        return duration;
    }

}
