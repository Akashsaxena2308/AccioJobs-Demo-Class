import java.util.UUID;

public class Artist {
    private final String artistId;
    private final String name;

    public Artist(String name){
        this.artistId = UUID.randomUUID().toString();
        this.name = name;
    }

    public Song uploadSong(String title, double duration){
        if (title == null || duration < 1){
            throw new IllegalArgumentException("Invalid credentials");
        }
        Song newSong = new Song(title, duration);
        System.out.println("Artist " + name + " uploaded song: " + title);
        return newSong;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Artist{" +
                "artistId='" + artistId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
