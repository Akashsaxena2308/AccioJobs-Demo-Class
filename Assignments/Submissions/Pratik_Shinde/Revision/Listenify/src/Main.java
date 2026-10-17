
void main() {
    Song song1 = new Song("Hello", "MJ", 2.5);
    Song song2 = new Song("Hello1", "MJ", 2.5);
    Song song3 = new Song("Hello2", "MJ", 2.5);
    Song song4 = new Song("Hello3", "MJ", 2.5);
    Song song5 = new Song("Hello4", "MJ", 2.5);
    Song song6 = new Song("Hello5", "MJ", 2.5);
    Song song7 = new Song("Hello6", "MJ", 2.5);

    Album al1 = new Album("test1");
    al1.add_song(song1);
    al1.add_song(song2);
    al1.add_song(song3);
    al1.add_song(song4);
    List<Song> list = al1.getAllSongs(al1.get_ablum_name());
    for (Song ls: list){
        System.out.println(ls.get_Song_name()+" "+ls.get_artist_name());
    }
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    while (flag){
        int n = sc.nextInt();
        switch (n){
            case 0:
                flag = false;
                break;
            case 8:

            case 9:
                System.out.println(al1.Available_album());
                break;
        }
    }
}
