import GUI.Windows.MainWindow;
import GUI.Music.MusicManager;

public class Main {
    public static void main(String[] args) {
        MusicManager.play();
        MainWindow window = new MainWindow();
    }
}