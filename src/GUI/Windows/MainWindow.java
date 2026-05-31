    package GUI.Windows;

    import GUI.Customs.CustomButton;
    import GUI.Customs.CustomWindow;
    import GUI.Windows.Screens.*;
    import Logic.GameManager;

    import javax.swing.*;

    public class MainWindow {
        private CustomWindow customWindow;
        private JFrame mainWindw;
        private SettingsWindow settingsWindow;
        private GameManager gameManager;

        public MainWindow(){

            customWindow = new CustomWindow();
            mainWindw = new JFrame("Main Window");
            settingsWindow = new SettingsWindow(mainWindw);

            gameManager = new GameManager();
            gameManager.gameInitialization();
            gameManager.getData().loadDataInfo();

            mainWindw.setSize(customWindow.getMonitorWidth(), customWindow.getMonitorHeight());
            mainWindw.setUndecorated(true);
            mainWindw.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainWindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindw.setResizable(false);

            mainWindw.getContentPane().setLayout(null);
            mainWindw.setLayout(null);

            JPanel mainBackground = customWindow.paintBackground("/pictures/MainBackground/MainBackground.png");
            mainBackground.setLayout(null);

            GameScreen gS = new GameScreen(customWindow);
            JPanel mainGameBackground = gS.getMainGameBackground();
            mainGameBackground.setVisible(false);
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
            mainWindw.add(managementGameBackground);

            mainWindw.add(mainBackground);
            mainWindw.add(mainGameBackground);
            mainWindw.add(storageGameBackground);
            mainWindw.add(shelvesGameBackground);
            mainWindw.add(restockGameBackground);

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
                mainGameBackground.setVisible(false);
                mainBackground.setVisible(true);
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
                mainBackground.setVisible(false);
                mainGameBackground.setVisible(true);
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