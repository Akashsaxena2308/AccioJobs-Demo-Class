package src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayListPlayer {
    private Song curr;
    private LinkedList<Song> PlayList=new LinkedList<>();
    private ListIterator<Song> cursor= PlayList.listIterator();

    public PlayListPlayer(LinkedList<Song> PlayList){
        this.PlayList=PlayList;
        cursor=PlayList.listIterator();
        curr=cursor.hasNext() ? cursor.next():null;
    }
    void nextSong(){
        if(curr==null){
            System.out.println("PlayList is Empty!");
        }
        if(!cursor.hasNext()){
            System.out.println("already last song");
        }
        curr=cursor.next();
    }
    void prevSong(){
        if(curr==null){
            System.out.println("PlayList is empty !");
        }
        cursor.previous();
        if(!cursor.hasNext()){
            cursor.next();
            System.out.println("alrady at last");
        }
        curr=cursor.previous();
        cursor.next();
    }
}
