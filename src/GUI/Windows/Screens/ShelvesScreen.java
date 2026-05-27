package GUI.Windows.Screens;

import Data.Product;
import GUI.Customs.CustomButton;
import GUI.Customs.CustomLabel;
import GUI.Customs.CustomWindow;
import Logic.StoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShelvesScreen {

    private JPanel shelvesBackground;
    private JButton backButton;

    public ShelvesScreen(CustomWindow customWindow, StoreManager storeManager, ArrayList<Product> products) {
        shelvesBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainShelvesBackground.png");
        shelvesBackground.setLayout(null);

        int monitorWidth = CustomWindow.getMonitorWidth();
        int monitorHeight = CustomWindow.getMonitorHeight();

        JLabel capacityLabel = new JLabel(storeManager.getCurrentTotalShelves() + " / " + storeManager.getMaxTotalShelves());
        capacityLabel.setFont(new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.035)));
        capacityLabel.setForeground(new Color(119, 56, 35));
        capacityLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int capW = (int)(monitorWidth * 0.3);
        int capH = (int)(monitorHeight * 0.05);
        int capX = (monitorWidth / 2) - (capW / 2);
        int capY = (int)(monitorHeight * 0.22);

        capacityLabel.setBounds(capX, capY, capW, capH);
        shelvesBackground.add(capacityLabel);

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(4, 2, (int)(monitorWidth * 0.02), (int)(monitorHeight * 0.009)));
        productsPanel.setOpaque(false);

        int fontSize = (int)(monitorHeight * 0.026);
        int nameW = (int)(monitorWidth * 0.057);
        int nameH = (int)(monitorHeight * 0.101);
        int imageW = (int)(monitorWidth * 0.09);
        int imageH = (int)(monitorHeight * 0.101);
        int countW = (int)(monitorWidth * 0.05);
        int countH = (int)(monitorHeight * 0.101);
        int flowHGap = (int)(monitorWidth * 0.005);
        int flowVGap = (int)(monitorHeight * 0.004);

        int btnW = (int)(monitorWidth * 0.028);
        int btnH = (int)(monitorHeight * 0.04);
        Font btnFont = new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.015));
        Color btnBg = new Color(119, 56, 35);
        Color btnFg = Color.WHITE;

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

            JButton minus10Btn = createStyledButton("-10", btnW, btnH, btnFont, btnBg, btnFg);
            cellPanel.add(minus10Btn);

            JButton minus1Btn = createStyledButton("-", btnW, btnH, btnFont, btnBg, btnFg);
            cellPanel.add(minus1Btn);

            JLabel imageLabel = new JLabel();
            CustomLabel.labelImage(imageLabel, product.getURL(), imageW, imageH);
            cellPanel.add(imageLabel);

            JButton plus1Btn = createStyledButton("+", btnW, btnH, btnFont, btnBg, btnFg);
            cellPanel.add(plus1Btn);

            JButton plus10Btn = createStyledButton("+10", btnW, btnH, btnFont, btnBg, btnFg);
            cellPanel.add(plus10Btn);

            int count = storeManager.getShelves().getOrDefault(product.getName(), 0);
            JLabel countLabel = new JLabel(String.valueOf(count));
            countLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            countLabel.setForeground(new Color(119, 56, 35));
            countLabel.setPreferredSize(new Dimension(countW, countH));
            countLabel.setVerticalAlignment(SwingConstants.CENTER);
            cellPanel.add(countLabel);

            Runnable updateUI = () -> {
                countLabel.setText(String.valueOf(storeManager.getShelves().getOrDefault(product.getName(), 0)));
                capacityLabel.setText(storeManager.getCurrentTotalShelves() + " / " + storeManager.getMaxTotalShelves());
            };

            minus10Btn.addActionListener(e -> {
                if (storeManager.moveFromShelvesToStorage(product.getName(), 10)) updateUI.run();
            });
            minus1Btn.addActionListener(e -> {
                if (storeManager.moveFromShelvesToStorage(product.getName(), 1)) updateUI.run();
            });
            plus1Btn.addActionListener(e -> {
                if (storeManager.moveFromStorageToShelves(product.getName(), 1)) updateUI.run();
            });
            plus10Btn.addActionListener(e -> {
                if (storeManager.moveFromStorageToShelves(product.getName(), 10)) updateUI.run();
            });

            productsPanel.add(cellPanel);
        }

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(productsPanel, BorderLayout.NORTH);

        int xPos = (int)(monitorWidth * 0.15);
        int yPos = (int)(monitorHeight * 0.259);
        int widthPnl = (int)(monitorWidth * 0.70);
        int heightPnl = (int)(monitorHeight * 0.63);

        wrapperPanel.setBounds(xPos, yPos, widthPnl, heightPnl);
        shelvesBackground.add(wrapperPanel);

        int backButtonW = (int) (monitorWidth * 0.1822);
        int backButtonH = (int) (monitorHeight * 0.1638);
        int backButtonX = (int) (monitorWidth * 0.0156);
        int backButtonY = (int) (monitorHeight * 0.8333);

        backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        shelvesBackground.add(backButton);
    }

    private JButton createStyledButton(String text, int width, int height, Font font, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(width, height));
        btn.setFont(font);
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setMargin(new Insets(0, 0, 0, 0));
        return btn;
    }

    public JPanel getShelvesBackground() {
        return shelvesBackground;
    }

    public JButton getBackButton() {
        return backButton;
    }
}