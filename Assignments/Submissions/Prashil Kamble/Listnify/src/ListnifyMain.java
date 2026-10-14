public class ListnifyMain {
    public static void main(String[] args) {

        Song s1 = new Song("song1", 10);
        System.out.println(s1.getTitle());
        System.out.println(s1.getDuration());

        Album a1 = new Album("Album1", "YoYo");

        try{
            a1.addSong("Blue Eyes", 7);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            a1.addSong("Desi Kalakar", 5);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        try {
            a1.addSong("Desi Kalakar", 4);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(a1.getArtist());
        System.out.println(a1.findSong("Desi Kalakar").getDuration());
    }
}
