package GUI.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicThread implements Runnable {

    private String file;
    private Clip audioClip;

    public MusicThread(String file) {
        this.file = file;
    }

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

    public void playMusic() {
        if (audioClip != null && !audioClip.isRunning()) {
            audioClip.start();
        }
    }

    public void pauseMusic() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }
}