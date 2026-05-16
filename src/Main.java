import GUI.MainWindow;
import GUI.Music.MusicManager;
import GUI.Music.MusicThread;

public class Main {
    public static void main(String[] args) {
        MusicManager.play();
        MainWindow window = new MainWindow();
    }
}