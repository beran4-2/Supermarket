import GUI.Windows.MainWindow;
import GUI.Music.MusicManager;
import Logic.GameManager;

public class Main {
    public static void main(String[] args) {
        MusicManager.play();
        MainWindow window = new MainWindow();

        GameManager manager = new GameManager();
        manager.gameInitialization();
        manager.getData().loadDataInfo();
    }
}