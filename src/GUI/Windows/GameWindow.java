package GUI.Windows;

import GUI.Customs.CustomWindow;
import GUI.Windows.Screens.*;
import Logic.GameManager;

import javax.swing.*;

public class GameWindow {
    private CustomWindow customWindow;
    private JFrame gameFrame;
    private GameManager gameManager;

    public GameWindow() {
        customWindow = new CustomWindow();
        gameFrame = new JFrame();

        gameManager = new GameManager();
        gameManager.gameInitialization();
        gameManager.getData().loadDataInfo();

        gameFrame.setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
        gameFrame.setUndecorated(true);
        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLayout(null);

        GameScreen gS = new GameScreen(customWindow);
        JPanel mainGameBackground = gS.getMainGameBackground();
        mainGameBackground.setVisible(true);
        gS.updateLabels(gameManager.getCurrentBalance(), gameManager.getCurrentDay(), gameManager.getCustomers().size());

        StorageScreen storageScreen = new StorageScreen(customWindow, gameManager.getStoreManager(), gameManager.getProducts());
        JPanel storageGameBackground = storageScreen.getStorageBackground();
        storageGameBackground.setVisible(false);

        ShelvesScreen shelvesScreen = new ShelvesScreen(customWindow, gameManager.getStoreManager(), gameManager.getProducts());
        JPanel shelvesGameBackground = shelvesScreen.getShelvesBackground();
        shelvesGameBackground.setVisible(false);

        RestockScreen restockScreen = new RestockScreen(customWindow, gameManager.getProducts());
        JPanel restockGameBackground = restockScreen.getRestockBackground();
        restockGameBackground.setVisible(false);

        ManagementScreen managementScreen = new ManagementScreen(customWindow, gameManager);
        JPanel managementGameBackground = managementScreen.getManagementBackground();
        managementGameBackground.setVisible(false);

        gameFrame.add(mainGameBackground);
        gameFrame.add(storageGameBackground);
        gameFrame.add(shelvesGameBackground);
        gameFrame.add(restockGameBackground);
        gameFrame.add(managementGameBackground);

        gS.getStorageButton().addActionListener(e -> {
            storageScreen.updateUI();
            mainGameBackground.setVisible(false);
            storageGameBackground.setVisible(true);
        });

        gS.getShelvesButton().addActionListener(e -> {
            shelvesScreen.updateUI();
            mainGameBackground.setVisible(false);
            shelvesGameBackground.setVisible(true);
        });

        gS.getBackButton().addActionListener(e -> {
            new MainWindow();
            gameFrame.dispose();
        });

        gS.getContinueButton().addActionListener(e -> {
            gameManager.nextTurn();
            gS.updateLabels(gameManager.getCurrentBalance(), gameManager.getCurrentDay(), gameManager.getCustomers().size());
        });

        storageScreen.getBackButton().addActionListener(e -> {
            storageGameBackground.setVisible(false);
            mainGameBackground.setVisible(true);
        });

        shelvesScreen.getBackButton().addActionListener(e -> {
            shelvesGameBackground.setVisible(false);
            mainGameBackground.setVisible(true);
        });

        gS.getRestockButton().addActionListener(e -> {
            mainGameBackground.setVisible(false);
            restockGameBackground.setVisible(true);
        });

        restockScreen.getBackButton().addActionListener(e -> {
            restockGameBackground.setVisible(false);
            mainGameBackground.setVisible(true);
        });

        restockScreen.getBuyButton().addActionListener(e -> {
            boolean success = gameManager.processRestock(restockScreen.getCart(), restockScreen.getCurrentTotalCost());
            if (success) {
                restockScreen.resetCart();
            }
        });

        gS.getManagementButton().addActionListener(e -> {
            mainGameBackground.setVisible(false);
            managementGameBackground.setVisible(true);
        });

        managementScreen.getBackButton().addActionListener(e -> {
            mainGameBackground.setVisible(true);
            managementGameBackground.setVisible(false);
        });

        gameFrame.setVisible(true);
    }
}