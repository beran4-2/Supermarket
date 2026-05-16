package GUI.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicThread implements Runnable {

    private String file;
    private Clip audioClip;

    public MusicThread(String file) {
        this.file = file;
    }



    @Override
    public void run() {

        try {
            File songFile = new File(file);
            if (songFile.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(songFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioIn);
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
                audioClip.start();
                System.out.println("music is playing");
            }
        }catch (Exception e) {

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
