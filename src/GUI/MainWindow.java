    package GUI;

    import javax.swing.*;
    import java.awt.*;


    public class MainWindow {
        CustomWindow customWindow;
        JFrame mainWindw;
        SettingsWindow settingsWindow;
        public MainWindow(){
            customWindow = new CustomWindow();
            settingsWindow = new SettingsWindow(mainWindw);


            mainWindw = new JFrame("Main Window");

            mainWindw.setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
            mainWindw.setUndecorated(true);
            mainWindw.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainWindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindw.setResizable(false);

            mainWindw.getContentPane().setLayout(null);
            mainWindw.setLayout(null);


            JPanel mainBackground = customWindow.paintBackground("resources/pictures/MainBackground/MainBackground.png");
            mainBackground.setLayout(null);
            mainWindw.setContentPane(mainBackground);



            int playButtonW = (int) (803 * 0.75);
            int playButtonH = (int) (244 * 0.75);


            JButton playButton = new JButton();
            CustomButton.buttonImage(playButton, "/pictures/MainBackground/PlayButton.png", playButtonW, playButtonH);
            int playButtonX = (int) (customWindow.getMonitorWidth() * 0.375);
            int playButtonY = (int) (customWindow.getMonitorHeight() * 0.178);
            playButton.setLocation(playButtonX, playButtonY);
            mainBackground.add(playButton);
            playButton.addActionListener(e -> {
                System.out.println("zapnuto");
                mainWindw.dispose();

            });




            int EndButtonW = (int) (603 * 0.4);
            int EndButtonH = (int) (243 * 0.4);

//            JButton endButton = new JButton("End");
//            CustomButton.buttonImage(endButton, "/pictures/EndButton.png", EndButtonW, EndButtonH);
//            endButton.setLocation(1500, 800);
//            mainWindw.add(endButton);
//            endButton.setVisible(true);
//            endButton.addActionListener(e ->{
//                System.exit(0);
//            });



            JButton settingsButton = new CustomButton();
            CustomButton.buttonImage(settingsButton, "/pictures/SettingsButton.png",200,200);
            settingsButton.setLocation(30, 15);
            settingsButton.addActionListener(e -> {
                settingsWindow.setVisible(true);
            });
            mainBackground.add(settingsButton);



            mainWindw.setVisible(true);



        }
    }

