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
    private int musicButtonWidth = (int) (CustomWindow.getMonitorWidth() * 0.2604);
    private int musicButtonHeight = (int) (CustomWindow.getMonitorHeight() * 0.1417);
    private int musicButtonPosX = CustomWindow.getMonitorWidth() / 2 - musicButtonWidth / 2;
    private int musicButtonPosY = CustomWindow.getMonitorHeight() - CustomWindow.getMonitorHeight() / 2 - CustomWindow.getMonitorHeight() / 2 / 3;

    private int closeButtonWidth = (int) (CustomWindow.getMonitorWidth() * 0.1953);
    private int closeButtonHeight = (int) (CustomWindow.getMonitorHeight() * 0.1056);
    private int closeButtonPosX = CustomWindow.getMonitorWidth() / 2 - closeButtonWidth / 2;
    private int closeButtonPosY = CustomWindow.getMonitorHeight() - CustomWindow.getMonitorHeight() / 3;

    public SettingsWindow(Frame owner) {

        super(owner, "Settings", true);
        customWindow = new CustomWindow();
        setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
        setUndecorated(true);
        setLocationRelativeTo(owner);
        setResizable(false);

        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); ///this deactivate alt + F4

        JPanel SettignsBackgroundImage = customWindow.paintBackground("/pictures/SettingsBackground/SettingsBackground.png");
        add(SettignsBackgroundImage);

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

        CustomButton.buttonImage(closeButton, "/pictures/SettingsBackground/SettingsCloseButton.png", closeButtonWidth, closeButtonHeight);
        closeButton.setLocation(closeButtonPosX, closeButtonPosY);
        SettignsBackgroundImage.add(closeButton);
        closeButton.setVisible(true);
        closeButton.addActionListener(e -> {
            this.dispose();
        });

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