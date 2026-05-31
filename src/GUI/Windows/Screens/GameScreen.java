package GUI.Windows.Screens;

import GUI.Customs.CustomButton;
import GUI.Customs.CustomLabel;
import GUI.Customs.CustomWindow;
import javax.swing.*;
import java.awt.*;

public class GameScreen {

    private JPanel mainGameBackground;
    private JButton storageButton;
    private JButton shelvesButton;
    private JButton backButton;
    private JButton continueButton;
    private JButton restockButton;
    private JButton managementButton;

    private JLabel balanceLabel;
    private JLabel dayLabel;
    private JLabel activeCustomersLabel;


    public GameScreen(CustomWindow customWindow) {
        mainGameBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainGameBackground.png");
        mainGameBackground.setLayout(null);

        int monitorWidth = CustomWindow.getMonitorWidth();
        int monitorHeight = CustomWindow.getMonitorHeight();

        int backButtonW = (int) (customWindow.getMonitorWidth() * 0.1822);
        int backButtonH = (int) (customWindow.getMonitorHeight() * 0.1638);
        int backButtonX = (int) (customWindow.getMonitorWidth() * 0.0156);
        int backButtonY = (int) (customWindow.getMonitorHeight() * 0.8333);
        backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        mainGameBackground.add(backButton);

        int storageButtonW = (int) (customWindow.getMonitorWidth() * 0.1546);
        int storageButtonH = (int) (customWindow.getMonitorHeight() * 0.1907);
        int storageButtonX = (int) (customWindow.getMonitorWidth() * 0.1718);
        int storageButtonY = (int) (customWindow.getMonitorHeight() * 0.0833);
        storageButton = new CustomButton();
        CustomButton.buttonImage(storageButton, "/pictures/MainGameBackground/MainGameStorageButton.png", storageButtonW, storageButtonH);
        storageButton.setLocation(storageButtonX, storageButtonY);
        mainGameBackground.add(storageButton);

        int shelvesButtonW = (int) (customWindow.getMonitorWidth() * 0.1986);
        int shelvesButtonH = (int) (customWindow.getMonitorHeight() * 0.1315);
        int shelvesButtonX = (int) (customWindow.getMonitorWidth() * 0.4688);
        int shelvesButtonY = (int) (customWindow.getMonitorHeight() * 0.1204);
        shelvesButton = new CustomButton();
        CustomButton.buttonImage(shelvesButton, "/pictures/MainGameBackground/MainGameShelvesButton.png", shelvesButtonW, shelvesButtonH);
        shelvesButton.setLocation(shelvesButtonX, shelvesButtonY);
        mainGameBackground.add(shelvesButton);

        int restockButtonW = (int) (customWindow.getMonitorWidth() * 0.1480);
        int restockButtonH = (int) (customWindow.getMonitorHeight() * 0.1481);
        int restockButtonX = (int) (customWindow.getMonitorWidth() * 0.8203);
        int restockButtonY = (int) (customWindow.getMonitorHeight() * 0.0556);
        restockButton = new CustomButton();
        CustomButton.buttonImage(restockButton, "/pictures/MainGameBackground/MainGameRestockButton.png", restockButtonW, restockButtonH);
        restockButton.setLocation(restockButtonX, restockButtonY);
        mainGameBackground.add(restockButton);

        int continueButtonW = (int) (customWindow.getMonitorWidth() * 0.25);
        int continueButtonH = (int) (customWindow.getMonitorHeight() * 0.175);
        int continueButtonX = (int) (customWindow.getMonitorWidth() * 0.745);
        int continueButtonY = (int) (customWindow.getMonitorHeight() * 0.82);
        continueButton = new CustomButton();
        CustomButton.buttonImage(continueButton, "/pictures/MainGameBackground/MainGameContinueButton.png", continueButtonW, continueButtonH);
        continueButton.setLocation(continueButtonX, continueButtonY);
        mainGameBackground.add(continueButton);

        int managmentButtonW = (int) (customWindow.getMonitorWidth() * 0.25);
        int managmentButtonH = (int) (customWindow.getMonitorHeight() * 0.22);
        int managmentButtonX = (int) (customWindow.getMonitorWidth() * 0.4);
        int managmentButtonY = (int) (customWindow.getMonitorHeight() * 0.79);
        managementButton = new CustomButton();
        CustomButton.buttonImage(managementButton, "/pictures/ManagmentButton.png", managmentButtonW, managmentButtonH);
        managementButton.setLocation(managmentButtonX, managmentButtonY);
        mainGameBackground.add(managementButton);

        int infoTabW = (int)(monitorWidth * 0.25);
        int infoTabH = (int)(monitorHeight * 0.30);
        int infoTabX = (int)(monitorWidth * 0.745);
        int infoTabY = (int)(monitorHeight * 0.559);

        JLabel infoTabLabel = new JLabel();
        GUI.Customs.CustomLabel.labelImage(infoTabLabel, "/informationTab.png", infoTabW, infoTabH);
        infoTabLabel.setBounds(infoTabX, infoTabY, infoTabW, infoTabH);

        infoTabLabel.setLayout(null);

        Font labelFont = new Font("Arial", Font.BOLD, (int)(infoTabH * 0.08));

        int textWidth = (int)(infoTabW * 0.8);
        int textHeight = (int)(infoTabH * 0.15);

        balanceLabel = new JLabel();
        balanceLabel.setFont(labelFont);
        balanceLabel.setForeground(Color.BLACK);
        balanceLabel.setBounds(85, 85, textWidth, textHeight);
        infoTabLabel.add(balanceLabel);

        dayLabel = new JLabel();
        dayLabel.setFont(labelFont);
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBounds(85, 145, textWidth, textHeight);
        infoTabLabel.add(dayLabel);

        activeCustomersLabel = new JLabel();
        activeCustomersLabel.setFont(labelFont);
        activeCustomersLabel.setForeground(Color.BLACK);
        activeCustomersLabel.setBounds(85, 200, textWidth, textHeight);
        infoTabLabel.add(activeCustomersLabel);

        mainGameBackground.add(infoTabLabel);



    }

    public void updateLabels(int balance, int day, int activeCustomers) {
        balanceLabel.setText("$ " + balance);
        dayLabel.setText("Day: " + day);
        activeCustomersLabel.setText("Active Customers: " + activeCustomers);
    }

    public JPanel getMainGameBackground() {
        return mainGameBackground;
    }
    public JButton getStorageButton() { return storageButton; }
    public JButton getShelvesButton() { return shelvesButton; }
    public JButton getBackButton() { return backButton; }
    public JButton getContinueButton(){
        return continueButton;
    }

    public JButton getRestockButton() {
        return restockButton;
    }

    public JButton getManagementButton() {
        return managementButton;
    }
}