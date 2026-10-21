package src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayListPlayer {
    private Song curr;
    private  LinkedList<Song> PlayList=new LinkedList<>();
    private boolean paused;
    private  ListIterator<Song> cursor= PlayList.listIterator();

    public String currentSong(){
        return curr==null ? "PlayList Is Empty" : "Now Playing: "+curr;
    }
    public PlayListPlayer(LinkedList<Song> PlayList){
        if(PlayList==null){
            throw new IllegalArgumentException("PlayList Cannot be Empty");
        }
        this.PlayList=PlayList;
        cursor=PlayList.listIterator();
        curr=cursor.hasNext() ? cursor.next():null;
    }
    public void nextSong(){
        if(curr==null){
            System.out.println("PlayList is Empty!");
            return;
        }
        if(!cursor.hasNext()){
            System.out.println("already last song");
            return;
        }
        curr=cursor.next();
        paused=false;
        System.out.println(currentSong());
    }
    void prevSong(){
        if(curr==null){
            System.out.println("PlayList is empty !");
            return;
        }
        cursor.previous();
        if(!cursor.hasPrevious()){
            cursor.next();
            System.out.println("alrady at first song");
            return;
        }
        curr=cursor.previous();
        cursor.next();
        paused=false;
        System.out.println(currentSong());

    }
    public String replay(){
        paused=false;
        return currentSong();
    }
    public String pauseOrResume(){
        if(curr==null) return "PlayList Is Empty";
        paused =!paused;
        return (paused ? "Paused:" : "Resume:"  )+curr;
    }
    public void printPlayList(){
        for(Song song:PlayList){
            System.out.println(song);
        }
    }
    public String removeCurrent(){
        if(curr==null){
            return "PlayList Is Empty";
        }
        Song removed=cursor.previous();
        cursor.remove();
        if(cursor.hasNext()){
            curr=cursor.next();
        } else if (cursor.hasPrevious()) {
            curr=cursor.previous();
            cursor.next();
        }else{
            curr=null;
        }
        paused=false;
        return "Removed:"+ removed+"|"+currentSong();
    }
    public void addSong(Song song){
        if(song==null) {
            throw new IllegalArgumentException("Song required");
        }
        cursor.add(song);
        cursor.previous();
        if(curr==null){
            curr=cursor.next();
            paused=false;
        }
    }

}
