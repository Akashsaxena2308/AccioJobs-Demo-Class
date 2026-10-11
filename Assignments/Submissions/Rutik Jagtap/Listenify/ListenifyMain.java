import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListenifyMain {

    private static final List<Album> albums = new ArrayList<>();
    private static final PlayListPlayer player = new PlayListPlayer();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Listenify!");
        System.out.println("Create albums, add songs, and enjoy your playlist.\n");

        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number between 0 and 9.\n");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 0:
                    System.out.println("Thank you for using Listenify. Goodbye!");
                    return;
                case 1:
                    playNextSong();
                    break;
                case 2:
                    playPreviousSong();
                    break;
                case 3:
                    replayCurrentSong();
                    break;
                case 4:
                    showPlaylist();
                    break;
                case 5:
                    removeCurrentSong();
                    break;
                case 6:
                    pauseResume();
                    break;
                case 7:
                    addSongToAlbum();
                    break;
                case 8:
                    createAlbum();
                    break;
                case 9:
                    showAvailableAlbums();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("========= LISTENIFY =========");
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
        System.out.println("=============================");
        System.out.print("Enter your choice: ");
    }

    private static void playNextSong() {
        if (player.size() == 0) {
            System.out.println("Playlist is empty. Add songs to your playlist first.\n");
            return;
        }
        Song song = player.nextSong();
        if (song != null) {
            System.out.println();
        } else {
            System.out.println();
        }
    }

    private static void playPreviousSong() {
        if (player.size() == 0) {
            System.out.println("Playlist is empty. Add songs to your playlist first.\n");
            return;
        }
        Song song = player.previousSong();
        if (song != null) {
            System.out.println();
        } else {
            System.out.println();
        }
    }

    private static void replayCurrentSong() {
        Song song = player.replayCurrentSong();
        System.out.println();
    }

    private static void showPlaylist() {
        player.showPlaylist();
    }

    private static void removeCurrentSong() {
        player.removeCurrentSong();
        System.out.println();
    }

    private static void pauseResume() {
        player.pauseResume();
        System.out.println();
    }

    private static void createAlbum() {
        System.out.print("Enter album name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Album name cannot be empty.\n");
            return;
        }
        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine().trim();
        if (artist.isEmpty()) {
            System.out.println("Artist name cannot be empty.\n");
            return;
        }
        Album album = new Album(name, artist);
        albums.add(album);
        System.out.println("Album created: " + album + "\n");
    }

    private static void showAvailableAlbums() {
        if (albums.isEmpty()) {
            System.out.println("No albums available. Create an album first.\n");
            return;
        }
        System.out.println("\n--- Available Albums ---");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println((i + 1) + ". " + albums.get(i));
        }
        System.out.println("------------------------\n");
    }

    private static void addSongToAlbum() {
        if (albums.isEmpty()) {
            System.out.println("No albums available. Create an album first.\n");
            return;
        }

        System.out.println("\nSelect an album:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println((i + 1) + ". " + albums.get(i));
        }

        System.out.print("Enter album number: ");
        String input = scanner.nextLine().trim();
        if (!input.matches("\\d+")) {
            System.out.println("Invalid input.\n");
            return;
        }

        int albumIndex = Integer.parseInt(input) - 1;
        if (albumIndex < 0 || albumIndex >= albums.size()) {
            System.out.println("Invalid album number.\n");
            return;
        }

        Album selectedAlbum = albums.get(albumIndex);
        System.out.print("Enter song title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Song title cannot be empty.\n");
            return;
        }

        System.out.print("Enter song duration (seconds): ");
        String durationInput = scanner.nextLine().trim();
        if (!durationInput.matches("\\d+")) {
            System.out.println("Invalid duration.\n");
            return;
        }

        int duration = Integer.parseInt(durationInput);
        if (duration <= 0) {
            System.out.println("Duration must be a positive number.\n");
            return;
        }

        try {
            selectedAlbum.addSong(title, duration);
            System.out.println("Song added: " + title + " (" + duration + "s) to " + selectedAlbum.getName() + "\n");

            // Ask whether to add to playlist
            System.out.print("Add this song to the playlist? (yes/no): ");
            String addToPlaylist = scanner.nextLine().trim().toLowerCase();
            if (addToPlaylist.equals("yes") || addToPlaylist.equals("y")) {
                selectedAlbum.addToPlaylist(title, player.getPlaylist());
                System.out.println("Added to playlist!\n");
            } else {
                System.out.println("Song not added to playlist.\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}