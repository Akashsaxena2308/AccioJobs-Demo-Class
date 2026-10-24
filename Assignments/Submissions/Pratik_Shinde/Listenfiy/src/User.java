import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<Playlist> playlists;
    private Player player;


    public User(String name, String email, Player player) {
        if (name == null || email == null){
            throw new IllegalArgumentException("invalid credentails");
        }
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.playlists = new LinkedList<>();
        this.player = player;
    }

    public Playlist createPlaylist(String playlistName){
        if (playlistName == null){
            throw new IllegalArgumentException("enter Valid credentials");
        }
        Playlist newPlaylist = new Playlist(playlistName);
        playlists.add(newPlaylist);
        System.out.println(name+" created playlist: "+playlistName);
        return newPlaylist;
    }

    public void followArtist(Artist artist){
        System.out.println(name+ " started following artist : "+artist.getName());
    }

    public void playSong(String title){
        if (player == null){
            throw new IllegalArgumentException("No player");
        }
        player.play();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}
