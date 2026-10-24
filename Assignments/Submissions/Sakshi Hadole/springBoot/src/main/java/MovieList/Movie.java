package MovieList;

public class Movie {
     private final long id;
     private final String  title;
     private final int releaseyear;

     public Movie(long id,String title,int releaseyear){
         this.id=id;
         this.title=title;
         this.releaseyear=releaseyear;
     }
     public long getId(){
         return id;
     }
     public String getTitle(){
         return title;
     }
     public int getReleaseyear(){
         return releaseyear;
     }
}
