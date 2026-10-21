package src;

import java.util.*;

public class Listenify {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Album> albums = new ArrayList<>();
        PlayListPlayer player = new PlayListPlayer(new LinkedList<>());

        while (true) {
            System.out.println();
            System.out.println("0. Quit");
            System.out.println("1. Play next song");
            System.out.println("2. Play previous song");
            System.out.println("3. Replay current song");
            System.out.println("4. Show playlist");
            System.out.println("5. Remove current song");
            System.out.println("6. Pause / Resume");
            System.out.println("7. Add song to an album");
            System.out.println("8. Create album");
            System.out.println("9. Show available albums");
            System.out.println("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong choice, enter a number between 0 and 9");
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    player.nextSong();
                    break;
                case 2:
                    player.previousSong();
                    break;
                case 3:
                    System.out.println(player.replay());
                    break;
                case 4:
                    player.printPlayList();
                    break;
                case 5:
                    System.out.println(player.removeCurrent());
                    break;
                case 6:
                    System.out.println(player.pauseOrResume());
                    break;
                case 7:
                    if (albums.isEmpty()) {
                        System.out.println("Create an album first (option 8).");
                        break;
                    }
                    showAlbums(albums);
                    try {
                        System.out.println("Choose album number: ");
                        int albumNumber = Integer.parseInt(sc.nextLine().trim());
                        Album selected = albums.get(albumNumber - 1);

                        System.out.println("Song title: ");
                        String title = sc.nextLine().trim();
                        System.out.println("Duration: ");
                        double duration = Double.parseDouble(sc.nextLine().trim());

                        selected.addSong(title, duration);

                        LinkedList<Song> added = new LinkedList<>();
                        selected.addToPlaylist(title, added);
                        player.addSong(added.getFirst());
                        System.out.println("Added song to the album and playlist!");
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Invalid number entered.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter album name: ");
                    String albumName = sc.nextLine().trim();
                    System.out.println("Enter artist name: ");
                    String artistName = sc.nextLine().trim();

                    albums.add(new Album(albumName, artistName));
                    System.out.println("Album created!");
                    break;
                case 9:
                    showAlbums(albums);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void showAlbums(List<Album> albums) {
        if (albums.isEmpty()) {
            System.out.println("No albums yet.");
            return;
        }
        for (int i = 0; i < albums.size(); i++) {
            Album album = albums.get(i);
            System.out.println((i + 1) + ". " + album.getAlbumName() + " by " + album.getArtist());
        }
    }
}