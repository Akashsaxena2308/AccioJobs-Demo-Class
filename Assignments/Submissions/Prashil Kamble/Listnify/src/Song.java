public class Song {

    private final String title;
    private final int duration;

    Song(String title, int duration){

        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if(duration <= 0){
            throw new IllegalArgumentException("Duration cannot be zero or less than zero");
        }
        this.title = title;
        this.duration = duration;

    }

    public String getTitle(){
        return title;
    }
    public int getDuration(){
        return duration;
    }





}
