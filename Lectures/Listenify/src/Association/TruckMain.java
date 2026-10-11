package Association;

class Truck {
    // Aggregation: supplied from outside and usable independently.
    private final MusicPlayer musicPlayer;
    // Composition: privately owned; created as part of this Truck.
    private final Engine engine;

    Truck(MusicPlayer musicPlayer) {
        if (musicPlayer == null) {
            throw new IllegalArgumentException("Music player required");
        }
        this.musicPlayer = musicPlayer;
        this.engine = new Engine();
    }

    public void truck() {
        System.out.println("Truck");
    }

    void playMusic() {
        musicPlayer.playMusic();
    }
}

class Engine {
}

class MusicPlayer {
    public void playMusic() {
        System.out.println("Playing music!");
    }
}

public class TruckMain {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        Truck truck = new Truck(musicPlayer);
        truck.truck();
        truck.playMusic();
        musicPlayer.playMusic(); // Still usable independently of the Truck.
    }
}
