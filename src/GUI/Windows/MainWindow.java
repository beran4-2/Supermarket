    package GUI.Windows;

    import GUI.Customs.CustomButton;
    import GUI.Customs.CustomWindow;

    import javax.swing.*;

    public class MainWindow {
        CustomWindow customWindow;
        JFrame mainWindw;
        SettingsWindow settingsWindow;
        public MainWindow(){

            customWindow = new CustomWindow();
            mainWindw = new JFrame("Main Window");
            settingsWindow = new SettingsWindow(mainWindw);

            mainWindw.setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
            mainWindw.setUndecorated(true);
            mainWindw.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainWindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindw.setResizable(false);

            mainWindw.getContentPane().setLayout(null);
            mainWindw.setLayout(null);

            JPanel mainBackground = customWindow.paintBackground("/pictures/MainBackground/MainBackground.png");
            mainBackground.setLayout(null);
            mainWindw.setContentPane(mainBackground);

            int playButtonW = (int) (customWindow.getMonitorWidth() * 0.3135);
            int playButtonH = (int) (customWindow.getMonitorHeight() * 0.162);
            int playButtonX = (int) (customWindow.getMonitorWidth() * 0.375);
            int playButtonY = (int) (customWindow.getMonitorHeight() * 0.178);
            JButton playButton = new JButton();
            CustomButton.buttonImage(playButton, "/pictures/MainBackground/PlayButton.png", playButtonW, playButtonH);
            playButton.setLocation(playButtonX, playButtonY);
            mainBackground.add(playButton);
            playButton.addActionListener(e -> {
                System.out.println("game started");
                mainWindw.dispose();
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

            mainWindw.setVisible(true);
        }
    }