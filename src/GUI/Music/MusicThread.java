package GUI.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * Handles loading and playing background music in a separate thread.
 * It uses the Java Sound API to loop the music continuously.
 */
public class MusicThread implements Runnable {

    private String file;
    private Clip audioClip;
    /**
     * Handles loading and playing background music in a separate thread.
     * It uses the Java Sound API to loop the music continuously.
     */
    public MusicThread(String file) {
        this.file = file;
    }
    /**
     * Handles loading and playing background music in a separate thread.
     * It uses the Java Sound API to loop the music continuously.
     */
    @Override
    public void run() {

        try {
            java.net.URL musicURL = MusicThread.class.getResource(file);
            if (musicURL != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicURL);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioIn);
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
                audioClip.start();
                System.out.println("music is playing");
            }else {
                System.out.println("Error with loading music");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Resumes the music if it is currently paused and ready.
     */
    public void playMusic() {
        if (audioClip != null && !audioClip.isRunning()) {
            audioClip.start();
        }
    }

    /**
     * Pauses the currently playing music.
     */
    public void pauseMusic() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }
}