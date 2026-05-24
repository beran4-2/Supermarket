package GUI.Windows.Screens;

import GUI.Customs.CustomButton;
import GUI.Customs.CustomLabel;
import GUI.Customs.CustomWindow;
import javax.swing.*;

public class GameScreen {

    private JPanel mainGameBackground;

    public GameScreen(CustomWindow customWindow) {
        mainGameBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainGameBackground.png");
        mainGameBackground.setLayout(null);

        int backButtonW = (int) (customWindow.getMonitorWidth() * 0.1822);
        int backButtonH = (int) (customWindow.getMonitorHeight() * 0.1638);
        int backButtonX = (int) (customWindow.getMonitorWidth() * 0.0156);
        int backButtonY = (int) (customWindow.getMonitorHeight() * 0.8333);
        JButton backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        backButton.addActionListener(e -> {
        });
        mainGameBackground.add(backButton);

        int storageButtonW = (int) (customWindow.getMonitorWidth() * 0.1546);
        int storageButtonH = (int) (customWindow.getMonitorHeight() * 0.1907);
        int storageButtonX = (int) (customWindow.getMonitorWidth() * 0.1718);
        int storageButtonY = (int) (customWindow.getMonitorHeight() * 0.0833);
        JButton storageButton = new CustomButton();
        CustomButton.buttonImage(storageButton, "/pictures/MainGameBackground/MainGameStorageButton.png", storageButtonW, storageButtonH);
        storageButton.setLocation(storageButtonX, storageButtonY);
        storageButton.addActionListener(e -> {
        });
        mainGameBackground.add(storageButton);

        int shelvesButtonW = (int) (customWindow.getMonitorWidth() * 0.1986);
        int shelvesButtonH = (int) (customWindow.getMonitorHeight() * 0.1315);
        int shelvesButtonX = (int) (customWindow.getMonitorWidth() * 0.4688);
        int shelvesButtonY = (int) (customWindow.getMonitorHeight() * 0.1204);
        JButton shelvesButton = new CustomButton();
        CustomButton.buttonImage(shelvesButton, "/pictures/MainGameBackground/MainGameShelvesButton.png", shelvesButtonW, shelvesButtonH);
        shelvesButton.setLocation(shelvesButtonX, shelvesButtonY);
        shelvesButton.addActionListener(e -> {
        });
        mainGameBackground.add(shelvesButton);

        int restockButtonW = (int) (customWindow.getMonitorWidth() * 0.1480);
        int restockButtonH = (int) (customWindow.getMonitorHeight() * 0.1481);
        int restockButtonX = (int) (customWindow.getMonitorWidth() * 0.8203);
        int restockButtonY = (int) (customWindow.getMonitorHeight() * 0.0556);
        JButton restockButton = new CustomButton();
        CustomButton.buttonImage(restockButton, "/pictures/MainGameBackground/MainGameRestockButton.png", restockButtonW, restockButtonH);
        restockButton.setLocation(restockButtonX, restockButtonY);
        restockButton.addActionListener(e -> {
        });
        mainGameBackground.add(restockButton);

        int continueButtonW = (int) (customWindow.getMonitorWidth() * 0.2);
        int continueButtonH = (int) (customWindow.getMonitorHeight() * 0.15);
        int continueButtonX = (int) (customWindow.getMonitorWidth() * 0.7942);
        int continueButtonY = (int) (customWindow.getMonitorHeight() * 0.8333);
        JButton continueButton = new CustomButton();
        CustomButton.buttonImage(continueButton, "/pictures/MainGameBackground/MainGameContinueButton.png", continueButtonW, continueButtonH);
        continueButton.setLocation(continueButtonX, continueButtonY);
        continueButton.addActionListener(e -> {
        });
        mainGameBackground.add(continueButton);
    }

    public JPanel getMainGameBackground() {
        return mainGameBackground;
    }
}