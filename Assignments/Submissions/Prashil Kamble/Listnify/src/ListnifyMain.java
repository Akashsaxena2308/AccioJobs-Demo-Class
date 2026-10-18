import java.util.LinkedList;
import java.util.Scanner;

public class ListnifyMain {
    public static void main(String[] args) {

//        Song s1 = new Song("song1", 10);
//        System.out.println(s1.getTitle());
//        System.out.println(s1.getDuration());
//
//        Album a1 = new Album("Album1", "YoYo");
//
//        try{
//            a1.addSong("Blue Eyes", 7);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            a1.addSong("Desi Kalakar", 5);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//
//        try {
//            a1.addSong("Desi Kalakar", 4);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(a1.getArtist());
//        System.out.println(a1.findSong("Desi Kalakar").getDuration());


        Scanner sc = new Scanner(System.in);

        Album a2 = new Album("album 2", "abc");

        a2.addSong("song1", 5);
        a2.addSong("song2", 3);
        a2.addSong("song3", 2);
        a2.addSong("song4", 1);

        LinkedList<Song> playlist = new LinkedList<>();

        a2.addToPlayList("song1", playlist);
        a2.addToPlayList("song2", playlist);
        a2.addToPlayList("song3", playlist);
        a2.addToPlayList("song4", playlist);

        PlayListPlayer player = new PlayListPlayer(playlist);

        while(true){

//            0. quit
//            1. Play next song
//            2. Play previous song
//            3. Replay current song
//            4. Show playlist
//            5. Remove current song
//            6. Pause / Resume
//            7. Add song to an album
//            8. Create album
//            9. Show available albums


            System.out.println("0: for quite");
            System.out.println("1: for next song");
            System.out.println("2: for previous song");
            System.out.println("3: for pause or play");
            System.out.println("4: for replay");
            System.out.println("5: for show playlist songs");
            System.out.println("6: remove current song");
            System.out.println("7: add song to the album");

            int input = sc.nextInt();

            if(input == 0) break;

            switch (input){

                case 1 : {
                    player.nextSong();
                    break;
                }
                case 2 :{
                    player.prevSong();
                    break;
                }
                case 3 :{
                    player.pauseOrPlay();
                    break;
                }
                case 4 :{
                    player.replaySong();
                    break;
                }
                case 5 :{
                    player.showPlayListSong();
                    break;
                }
                case 6 :{
                    player.removeCurrentSong();
                    break;
                }
                case 7 :{
                    System.out.println("Enter song name:");
                    String title = sc.next();
                    System.out.println("Enter song duration");
                    int dur = sc.nextInt();
                    a2.addSong(title, dur);
                    System.out.println("Are you want this song add to playlist ?");
                    System.out.println("if yes press 1");
                    System.out.println("if no press 0");
                    int choice = sc.nextInt();
                    if(choice == 1){
                        a2.addToPlayList(title, playlist);
                        break;
                    } else if (choice == 0) {
                        break;
                    }
                }
                default:{
                    System.out.println("Please select valid input");
                }

            }
            System.out.println();

        }



    }
}
