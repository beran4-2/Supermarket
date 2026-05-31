import GUI.Windows.MainWindow;
import GUI.Music.MusicManager;

/**
 * The main entry point of the Supermarket Simulator application.
 * Initializes the background music and displays the main menu window.
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Starts the application by playing background music and opening the main window.
         * @param args Command line arguments (not used).
         */
        MusicManager.play();
        MainWindow window = new MainWindow();
    }
}