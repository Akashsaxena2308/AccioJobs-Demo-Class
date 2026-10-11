import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlayList_Player {
    private Song current;
    private final List<Song> playList;
    private ListIterator<Song> cursor;

    PlayList_Player(List<Song> playList){
        this.playList = playList;
        cursor = playList.listIterator();

        current = cursor.hasNext() ? cursor.next() : null;
    }


//    public Song find_song(){
//        //i     Song1   song 2   song3
//    }

    public Song next(){
        if(cursor.next() == null) throw new IllegalArgumentException("Not present");
        if(!cursor.hasNext()) throw new IllegalArgumentException("Already at last position");
        return cursor.next();
    }



    public Song prev(){
        if(cursor.previous() == null) throw new IllegalArgumentException("Not present");
        current = cursor.previous();
        if (!cursor.hasPrevious()){
            cursor.next();
            throw new IllegalArgumentException("Already at first song");
        }
        current = cursor.previous();
        return cursor.next();
    }
    // current song
    // next
}
