package Association;
class musicPlayer{
    public void playmusic(){
        System.out.println("music play");
    }
}
class Truck{
    private musicPlayer player;
    
    public Truck(musicPlayer player){
        this.player = player;
    }
    
    public void playMusic(){
        System.out.println("Truck");
    }
}
public class TrickMain {
    public static void main(String[] args) {
        musicPlayer m = new musicPlayer();
        Truck t = new Truck(m);
        t.playMusic();
        m.playmusic();
    }
}

