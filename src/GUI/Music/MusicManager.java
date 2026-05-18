package GUI.Music;

public class MusicManager {
    static MusicThread mt = new MusicThread("/music/music1.wav");
    static Thread thread = null;

    public static void play() {
        if (thread == null) {
            thread = new Thread(mt);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
            mt.playMusic();
        }else {
            mt.playMusic();
        }
    }

    public static void pause() {
            mt.pauseMusic();

    }
}