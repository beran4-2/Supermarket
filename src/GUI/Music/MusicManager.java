package GUI.Music;
/**
 * Manages the background music for the game.
 * It uses a separate thread so the music doesn't freeze the main game.
 */
public class MusicManager {
    static MusicThread mt = new MusicThread("/music/music1.wav");
    static Thread thread = null;
    /**
     * Starts or resumes the background music.
     * If the music thread doesn't exist yet, it creates and starts a new one.
     */
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
    /**
     * Pauses the currently playing background music.
     */
    public static void pause() {
            mt.pauseMusic();

    }
}