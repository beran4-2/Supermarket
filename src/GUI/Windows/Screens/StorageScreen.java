package GUI.Windows.Screens;

import Data.Product;
import GUI.Customs.CustomButton;
import GUI.Customs.CustomLabel;
import GUI.Customs.CustomWindow;
import Logic.StoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the storage management screen.
 * This screen allows the player to view the current state of storage
 * as well as the amount of items currently pending delivery.
 */
public class StorageScreen {

    private JPanel storageBackground;
    private JButton backButton;
    private JPanel productsPanel;
    private JLabel capacityLabel;
    private JLabel pendingLabel;
    private StoreManager storeManager;
    private ArrayList<Product> products;
    private int monitorWidth;
    private int monitorHeight;

    /**
     * Constructs the storage screen and initializes all UI components.
     * Generates a grid layout displaying each product and its current quantity in storage.
     *
     * @param customWindow The utility instance handling window dimensions and background rendering.
     * @param storeManager The manager handling inventory logic, capacities, and pending orders.
     * @param products     The list of available products in the game.
     */
    public StorageScreen(CustomWindow customWindow, StoreManager storeManager, ArrayList<Product> products) {
        this.storeManager = storeManager;
        this.products = products;

        storageBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainStorageBackground.png");
        storageBackground.setLayout(null);

        monitorWidth = CustomWindow.getMonitorWidth();
        monitorHeight = CustomWindow.getMonitorHeight();

        capacityLabel = new JLabel();
        capacityLabel.setFont(new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.02)));
        capacityLabel.setForeground(new Color(119, 56, 35));
        capacityLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int capW = (int)(monitorWidth * 0.3);
        int capH = (int)(monitorHeight * 0.05);
        int capX = (monitorWidth / 2) - (capW / 2);
        int capY = (int)(monitorHeight * 0.22);
        capacityLabel.setBounds(capX, capY, capW, capH);
        storageBackground.add(capacityLabel);

        pendingLabel = new JLabel();
        pendingLabel.setFont(new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.02)));
        pendingLabel.setForeground(new Color(119, 56, 35));
        pendingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pendingLabel.setBounds(capX, (int)(monitorHeight * 0.8), capW, capH);
        storageBackground.add(pendingLabel);

        productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(4, 2, (int)(monitorWidth * 0.02), (int)(monitorHeight * 0.009)));
        productsPanel.setOpaque(false);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(productsPanel, BorderLayout.NORTH);

        int xPos = (int)(monitorWidth * 0.15);
        int yPos = (int)(monitorHeight * 0.259);
        int widthPnl = (int)(monitorWidth * 0.70);
        int heightPnl = (int)(monitorHeight * 0.63);

        wrapperPanel.setBounds(xPos, yPos, widthPnl, heightPnl);
        storageBackground.add(wrapperPanel);

        int backButtonW = (int) (monitorWidth * 0.1822);
        int backButtonH = (int) (monitorHeight * 0.1638);
        int backButtonX = (int) (monitorWidth * 0.0156);
        int backButtonY = (int) (monitorHeight * 0.8333);

        backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        storageBackground.add(backButton);

        updateUI();
    }

    /**
     * Refreshes the user interface to reflect the most up-to-date storage data.
     * Updates the total capacity, pending deliveries, and the individual quantities of each product.
     */
    public void updateUI() {
        capacityLabel.setText("current in storage: " + storeManager.getCurrentTotalStorage() + " / " + storeManager.getMaxTotalStorage());

        int totalPending = 0;
        for (int amount : storeManager.getInOrder().values()) {
            totalPending += amount;
        }
        pendingLabel.setText("Pending items: " + totalPending);

        productsPanel.removeAll();

        int fontSize = (int)(monitorHeight * 0.035);
        int nameW = (int)(monitorWidth * 0.09);
        int nameH = (int)(monitorHeight * 0.101);
        int imageW = (int)(monitorWidth * 0.104);
        int imageH = (int)(monitorHeight * 0.101);
        int countW = (int)(monitorWidth * 0.078);
        int countH = (int)(monitorHeight * 0.101);
        int flowHGap = (int)(monitorWidth * 0.01);
        int flowVGap = (int)(monitorHeight * 0.004);

        for (Product product : products) {
            JPanel cellPanel = new JPanel();
            cellPanel.setLayout(new FlowLayout(FlowLayout.CENTER, flowHGap, flowVGap));
            cellPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(product.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setPreferredSize(new Dimension(nameW, nameH));
            nameLabel.setVerticalAlignment(SwingConstants.CENTER);
            cellPanel.add(nameLabel);

            JLabel imageLabel = new JLabel();
            CustomLabel.labelImage(imageLabel, product.getURL(), imageW, imageH);
            cellPanel.add(imageLabel);

            int count = storeManager.getStorage().getOrDefault(product.getName(), 0);
            JLabel countLabel = new JLabel(String.valueOf(count));
            countLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            countLabel.setForeground(new Color(119, 56, 35));
            countLabel.setPreferredSize(new Dimension(countW, countH));
            countLabel.setVerticalAlignment(SwingConstants.CENTER);
            cellPanel.add(countLabel);

            productsPanel.add(cellPanel);
        }

        productsPanel.revalidate();
        productsPanel.repaint();
    }

    public JPanel getStorageBackground() {
        return storageBackground;
    }

    public JButton getBackButton() {
        return backButton;
    }
}