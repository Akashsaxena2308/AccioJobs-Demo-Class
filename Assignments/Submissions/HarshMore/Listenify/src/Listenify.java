public class Listenify {
    public static void main() throws Exception {
        Song s1 = new Song("52 Bars", 3.60, "Karan Aujla");
        Song s2 = new Song("195", 4.30, "Siddhu Mossewala");
        Song s3 = new Song("MF Gabhru", 2.40, "Karan Aujla");

        Album album = new Album("P-POP Culture", "Karan Aujla");
        album.addSong(s1);
        album.addSong(s3);

        Song song = album.findSong("52 Bars");
        Song unknown = album.findSong("Despacito");
        System.out.println(song);
        System.out.println(unknown);
    }
}
