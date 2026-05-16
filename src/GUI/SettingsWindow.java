package GUI;

import GUI.Music.MusicManager;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JDialog {
    CustomWindow customWindow;
    private boolean isOnActivated = true;

    JButton closeButton = new JButton();
    JButton musicButtonOn = new JButton();
    JButton musicButtonOff = new JButton();
    private int musicButtonPosX =customWindow.getMonitorWidth()/2-500/2;
    private int musicButtonPosY = CustomWindow.getMonitorHeight() - CustomWindow.getMonitorHeight()/2 - CustomWindow.getMonitorHeight()/2/3;
    private int musicButtonWidth = (int) (CustomWindow.getMonitorWidth() * 0.2604);
    private int musicButtonHeight = (int) (CustomWindow.getMonitorHeight() * 0.1417);

    private int closeButtonPosX =0;
    private int closeButtonPosY =0;
    private int closeButtonWidth =0;
    private int closeButtonHeight =0;


    public SettingsWindow(Frame owner) {
        super(owner, "Settings", true);
        customWindow = new CustomWindow();
        setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
        setUndecorated(true);
        setLocationRelativeTo(owner);
        setResizable(false);

        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); ///this deactivate alt + F4

        JPanel SettignsBackgroundImage = customWindow.paintBackground("resources/pictures/SettingsBackground/SettingsBackground2.png");
        add(SettignsBackgroundImage);




//        CustomButton.imageButton(musicButtonOn, "resources/pictures/SettingsBackground/SettingsMusicON.png",500, 153);
//        musicButtonOn.setBounds(customWindow.getMonitorWidth()/2-250, 400, 500, 153);
//        SettignsBackgroundImage.add(musicButtonOn);
//        musicButtonOn.setVisible(false);
//        musicButtonOn.addActionListener(e ->{
//            musicButtonOn.setVisible(false);
//            musicButtonOff.setVisible(true);
//            isOnActivated = false;
//            MusicManager.pause();
//        });
//
//        CustomButton.imageButton(musicButtonOff, "resources/pictures/SettingsBackground/SettingsMusicOFF.png",500, 153);
//        musicButtonOff.setBounds(customWindow.getMonitorWidth()/2-250, 400, 500, 153);
//        SettignsBackgroundImage.add(musicButtonOff);
//        musicButtonOff.setVisible(false);
//        musicButtonOff.addActionListener(e ->{
//            musicButtonOff.setVisible(false);
//            musicButtonOn.setVisible(true);
//            isOnActivated = true;
//            MusicManager.play();
//
//        });




        CustomButton.buttonImage(musicButtonOn,  "/pictures/SettingsBackground/SettingsMusicON.png",musicButtonWidth,musicButtonHeight);
        musicButtonOn.setLocation(musicButtonPosX, musicButtonPosY);
        SettignsBackgroundImage.add(musicButtonOn);
        musicButtonOn.setVisible(false);
        musicButtonOn.addActionListener(e ->{
            musicButtonOn.setVisible(false);
            musicButtonOff.setVisible(true);
            isOnActivated = false;
            MusicManager.pause();
        });


        CustomButton.buttonImage(musicButtonOff, "/pictures/SettingsBackground/SettingsMusicOFF.png",musicButtonWidth,musicButtonHeight);
        musicButtonOff.setLocation(musicButtonPosX, musicButtonPosY);
        SettignsBackgroundImage.add(musicButtonOff);
        musicButtonOff.setVisible(false);
        musicButtonOff.addActionListener(e ->{
            musicButtonOff.setVisible(false);
            musicButtonOn.setVisible(true);
            isOnActivated = true;
            MusicManager.play();

        });


        showButton();


//        //CustomButton.imageButton(closeButton, "resources/pictures/SettingsBackground/SettingsCloseButton.png",375, 114);
//        // CustomButton.setLocation(0.20,0.12   ,closeButton);
//        closeButton.setLocation(375, 114);
//        //closeButton.setBounds(375, 114, 375, 114);
//
//
//        //closeButton.setBounds(customWindow.getMonitorWidth()/2-175, 750, 375, 114);
//
//        SettignsBackgroundImage.add(closeButton);
//        closeButton.setVisible(true);
//        closeButton.addActionListener(e ->{
//            this.dispose();
//        });

        CustomButton.buttonImage(closeButton, "/pictures/SettingsBackground/SettingsCloseButton.png",375, 114);
        closeButton.setLocation(CustomWindow.getMonitorWidth()/2-375/2, CustomWindow.getMonitorHeight()-CustomWindow.getMonitorHeight()/3);
        SettignsBackgroundImage.add(closeButton);
        closeButton.setVisible(true);
        closeButton.addActionListener(e ->{
            this.dispose();
        });

        int EndButtonW = (int) (3211 * 0.2);
        int EndButtonH = (int) (1223* 0.2);

        JButton quitButton = new JButton();
        CustomButton.buttonImage(quitButton, "/pictures/SettingsBackground/QuitButton.png", musicButtonWidth,musicButtonHeight);
        quitButton.setLocation( musicButtonPosX, musicButtonPosY + CustomWindow.getMonitorHeight()/6);
        SettignsBackgroundImage.add(quitButton);
        quitButton.setVisible(true);
        quitButton.addActionListener(e ->{
            System.exit(0);
        });



    }

    public void showButton() {
        if (isOnActivated) {
            musicButtonOn.setVisible(true);
        }
        else {
            musicButtonOff.setVisible(true);
        }
    }


}
