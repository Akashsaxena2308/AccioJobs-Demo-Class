import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlayListPlayer {

    // current song
    // next song
    // previous song

    private Song current;
    private final LinkedList<Song> playList;
    private ListIterator<Song> cursor;
    boolean pause = false;

    PlayListPlayer(LinkedList<Song> playList){
        this.playList = playList;
        cursor = playList.listIterator();
        current = cursor.hasNext() ? cursor.next() : null;
    }

    // nextSong
    public void nextSong(){
        if(current == null){
            System.out.println("Playlist is Empty");
            return;
        }
        if(!cursor.hasNext()){
            System.out.println("Already at last song");
            return;
        }
        current = cursor.next();
        System.out.println("Now playing " + current.getTitle());
    }

    //  previous Song
    public void prevSong(){
        if(current == null){
            System.out.println("Playlist is empty");
        }

        cursor.previous();
        if(!cursor.hasPrevious()){
            cursor.next();
            System.out.println("Already at first song");
        }

        current = cursor.previous();
        cursor.next();
        System.out.println("Now playing " + current.getTitle());
    }

    // pause or play song
    public void pauseOrPlay(){
        if(!pause){
            System.out.println("Song is paused");
        }
        else{
            System.out.println("Song is playing");
        }
        pause = !pause;
    }

    // replay current
    public void replaySong(){
        System.out.println("Song playing replay: " + current.getTitle());
    }

    // show playlist song
    public void showPlayListSong(){
        for (int i = 0; i < playList.size(); i++){
            System.out.println(playList.get(i).getTitle());
        }
    }

    // remove current song
    public void removeCurrentSong(){
        String current_title = current.getTitle();
        for (Song sg : playList){
            if(sg.getTitle() == current_title){
                current = cursor.hasNext() ? cursor.next() : cursor.previous();
                playList.remove(sg);
            }
        }
    }





}
