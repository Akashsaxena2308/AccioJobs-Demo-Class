public class client {
    public static void main(String args[]){
        Artist artist = new Artist("Test_artist_1");
        artist.uploadSong("Test1_song", 1.5);
        artist.toString();
        Album album = new Album("Test1_album");
    }
}
