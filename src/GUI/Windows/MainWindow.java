package GUI.Windows;

import GUI.Customs.CustomButton;
import GUI.Customs.CustomWindow;

import javax.swing.*;

public class MainWindow {
    private CustomWindow customWindow;
    private JFrame mainWindow;
    private SettingsWindow settingsWindow;
    private GameWindow gameWindow;

    public MainWindow(){
        customWindow = new CustomWindow();
        mainWindow = new JFrame("Main Window");
        settingsWindow = new SettingsWindow(mainWindow);

        mainWindow.setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
        mainWindow.setUndecorated(true);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setLayout(null);

        JPanel mainBackground = customWindow.paintBackground("/pictures/MainBackground/MainBackground.png");
        mainBackground.setLayout(null);

        int playButtonW = (int) (customWindow.getMonitorWidth() * 0.3135);
        int playButtonH = (int) (customWindow.getMonitorHeight() * 0.162);
        int playButtonX = (int) (customWindow.getMonitorWidth() * 0.375);
        int playButtonY = (int) (customWindow.getMonitorHeight() * 0.178);
        JButton playButton = new JButton();
        CustomButton.buttonImage(playButton, "/pictures/MainBackground/PlayButton.png", playButtonW, playButtonH);
        playButton.setLocation(playButtonX, playButtonY);
        mainBackground.add(playButton);

        playButton.addActionListener(e -> {
            if (gameWindow == null) {
                gameWindow = new GameWindow(this);
            }
            gameWindow.showWindow();
            mainWindow.setVisible(false);
        });

        int settingsButtonW = (int) (customWindow.getMonitorWidth() * 0.1042);
        int settingsButtonH = (int) (customWindow.getMonitorHeight() * 0.1852);
        int settingsButtonX = (int) (customWindow.getMonitorWidth() * 0.0156);
        int settingsButtonY = (int) (customWindow.getMonitorHeight() * 0.0139);
        JButton settingsButton = new CustomButton();
        CustomButton.buttonImage(settingsButton, "/pictures/SettingsButton.png",settingsButtonW,settingsButtonH);
        settingsButton.setLocation(settingsButtonX, settingsButtonY);
        settingsButton.addActionListener(e -> {
            settingsWindow.setVisible(true);
        });
        mainBackground.add(settingsButton);

        mainWindow.add(mainBackground);
        mainWindow.setVisible(true);
    }

    public void showWindow() {
        mainWindow.setVisible(true);
    }
}