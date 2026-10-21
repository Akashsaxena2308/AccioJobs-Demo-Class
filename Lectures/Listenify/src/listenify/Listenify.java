package listenify;

import java.sql.SQLOutput;
import java.util.*;

public class Listenify {
    public static void main(String[] args) {
//        Album album = new Album("Album 1", "John");
//        album.addSong("song", 5.0);
//        album.addSong("song2", 5.1);
//
//        try {
//            album.addSong("song", 5.0);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        LinkedList<Song> playlist1 = new LinkedList<>();
//        LinkedList<Song> playlist2 = new LinkedList<>();
//        album.addToPlaylist("song", playlist1);
//        album.addToPlaylist("song2", playlist1);
//        album.addToPlaylist("song2", playlist2);
//
//        // Both playlists share the same song2 object from the album.
//        System.out.println("Same Song object: " + (playlist1.getLast() == playlist2.getFirst()));
//
//        // ListIterator returns an item only when next() is called.
//        ListIterator<Song> iterator = playlist1.listIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getTitle());
//        }
//
//        PlaylistPlayer player = new PlaylistPlayer(playlist1);
//        System.out.println(player.previous()); // First-song boundary.
//        System.out.println(player.next()); // song2.
//        System.out.println(player.next()); // Last-song boundary.
//        System.out.println(player.previous()); // song.

//        0. Quit
//        1. Play next song
//        2. Play previous song
//        3. Replay current song
//        4. Show playlist
//        5. Remove current song
//        6. Pause / Resume
//        7. Add song to an album
//        8. Create album
//        9. Show available albums

       List<Album> albums = new ArrayList<>();
       PlaylistPlayer player = new PlaylistPlayer(new LinkedList<>());

       Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("0. Quit\n" +
                    "1. Play next song\n" +
                    "2. Play previous song\n" +
                    "3. Replay current song\n" +
                    "4. Show playlist\n" +
                    "5. Remove current song\n" +
                    "6. Pause / Resume\n" +
                    "7. Add song to an album\n" +
                    "8. Create album\n" +
                    "9. Show available albums");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice){
                case 0: return;
                case 1:
                    System.out.println(player.next());
                    break;
                case 2:
                    System.out.println(player.previous());
                    break;
                case 3:
                    System.out.println(player.replay());
                    break;
                case 4:
                    player.printPlaylist();
                    break;
                case 5:
                    System.out.println(player.removeCurrent());
                    break;
                case 6:
                    System.out.println(player.replay());;
                case 7:
                    if(albums.isEmpty()){
                        System.out.println("No Albums yet. Add some Album!");
                    }
                    else{
                        for (int i = 0; i < albums.size() ; i ++){
                            Album alb = albums.get(i);

                            System.out.println(i + ". Album : " + alb.getName());
                        }
                    }
                    System.out.println("Choose album number : ");
                    int albumNumber = Integer.parseInt(scanner.nextLine().trim());
                    Album selected = albums.get(albumNumber);

                    System.out.println("Song title: ");
                    String title = scanner.nextLine().trim();
                    System.out.println("Duration : ");
                    double duration = Double.parseDouble(scanner.nextLine().trim());

                    selected.addSong(title, duration);
                    System.out.println("Added song!");

                    LinkedList<Song> added = new LinkedList<>();
                    selected.addToPlaylist(title, added);
                    player.addSong(added.getFirst());
                    break;
                case 8:
                    System.out.println("Album name :");
                    String name = scanner.nextLine().trim();
                    System.out.println("Artist: ");
                    String artist = scanner.nextLine().trim();

                    Album candidate = new Album(name, artist);
                    //Handle Exception to avoid duplicate albums
                    albums.add(candidate);
                    System.out.println("Album created!");
                    break;
                case 9:
                    if(albums.isEmpty()){
                        System.out.println("No Albums yet. Add some Album!");
                    }
                    else{
                        for (int i = 0; i < albums.size() ; i ++){
                            Album alb = albums.get(i);

                            System.out.println(i+1 + ". Album : " + alb.getName());
                        }
                    }
                    break;
                default:
                    System.out.println("Choose a listed Option!");
            }

        }
    }
}