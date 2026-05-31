package GUI.Windows.Screens;

import Data.Product;
import GUI.Customs.CustomButton;
import GUI.Customs.CustomLabel;
import GUI.Customs.CustomWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the screen where the player can manually order products for the store.
 * It provides a shopping cart interface to select quantities and calculate the total cost.
 */
public class RestockScreen {

    private JPanel restockBackground;
    private JButton backButton;
    private JButton buyButton;
    private JLabel totalPriceLabel;

    private HashMap<String, Integer> cart;
    private HashMap<String, JLabel> countLabels;
    private int currentTotalCost;

    private int monitorWidth;
    private int monitorHeight;

    /**
     * Constructs the restock screen and builds the layout for all available products.
     *
     * @param customWindow The window helper used for screen dimensions and background painting.
     * @param products The list of all available products in the game to be displayed.
     */
    public RestockScreen(CustomWindow customWindow, ArrayList<Product> products) {
        this.monitorWidth = CustomWindow.getMonitorWidth();
        this.monitorHeight = CustomWindow.getMonitorHeight();
        this.cart = new HashMap<>();
        this.countLabels = new HashMap<>();
        this.currentTotalCost = 0;

        restockBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainRestockBackground.png");
        restockBackground.setLayout(null);

        totalPriceLabel = new JLabel();
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.02)));
        totalPriceLabel.setForeground(new Color(119, 56, 35));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int capW = (int)(monitorWidth * 0.3);
        int capH = (int)(monitorHeight * 0.05);
        int capX = (monitorWidth / 2) - (capW / 2);
        int capY = (int)(monitorHeight * 0.22);

        totalPriceLabel.setBounds(capX, capY, capW, capH);
        restockBackground.add(totalPriceLabel);

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(4, 2, (int)(monitorWidth * 0.02), (int)(monitorHeight * 0.009)));
        productsPanel.setOpaque(false);

        int fontSize = (int)(monitorHeight * 0.026);
        int nameW = (int)(monitorWidth * 0.1);
        int nameH = (int)(monitorHeight * 0.101);
        int imageW = (int)(monitorWidth * 0.09);
        int imageH = (int)(monitorHeight * 0.101);
        int countW = (int)(monitorWidth * 0.035);
        int countH = (int)(monitorHeight * 0.101);
        int flowHGap = (int)(monitorWidth * 0.002);
        int flowVGap = (int)(monitorHeight * 0.004);

        int btnW = (int)(monitorWidth * 0.025);
        int btnH = (int)(monitorHeight * 0.04);
        Font btnFont = new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.015));
        Color btnBg = new Color(119, 56, 35);
        Color btnFg = Color.WHITE;

        for (Product product : products) {
            cart.put(product.getName(), 0);

            JPanel cellPanel = new JPanel();
            cellPanel.setLayout(new FlowLayout(FlowLayout.CENTER, flowHGap, flowVGap));
            cellPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(product.getName() + " ($" + product.getPurchasePrice() + ")");
            nameLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setPreferredSize(new Dimension(nameW, nameH));
            nameLabel.setVerticalAlignment(SwingConstants.CENTER);
            nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
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

            JLabel countLabel = new JLabel();
            countLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            countLabel.setForeground(new Color(119, 56, 35));
            countLabel.setPreferredSize(new Dimension(countW, countH));
            countLabel.setVerticalAlignment(SwingConstants.CENTER);
            cellPanel.add(countLabel);

            countLabels.put(product.getName(), countLabel);

            minus10Btn.addActionListener(e -> {
                int current = cart.get(product.getName());
                int toRemove = Math.min(current, 10);
                if (toRemove > 0) {
                    cart.put(product.getName(), current - toRemove);
                    currentTotalCost -= (toRemove * product.getPurchasePrice());
                    updateUI();
                }
            });

            minus1Btn.addActionListener(e -> {
                int current = cart.get(product.getName());
                if (current > 0) {
                    cart.put(product.getName(), current - 1);
                    currentTotalCost -= product.getPurchasePrice();
                    updateUI();
                }
            });

            plus1Btn.addActionListener(e -> {
                int current = cart.get(product.getName());
                cart.put(product.getName(), current + 1);
                currentTotalCost += product.getPurchasePrice();
                updateUI();
            });

            plus10Btn.addActionListener(e -> {
                int current = cart.get(product.getName());
                cart.put(product.getName(), current + 10);
                currentTotalCost += (10 * product.getPurchasePrice());
                updateUI();
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
        restockBackground.add(wrapperPanel);

        int backButtonW = (int) (monitorWidth * 0.1822);
        int backButtonH = (int) (monitorHeight * 0.1638);
        int backButtonX = (int) (monitorWidth * 0.0156);
        int backButtonY = (int) (monitorHeight * 0.8333);

        backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        restockBackground.add(backButton);

        int buyButtonW = (int) (monitorWidth * 0.1822);
        int buyButtonH = (int) (monitorHeight * 0.1638);
        int buyButtonX = (int) (monitorWidth * 0.8021);
        int buyButtonY = (int) (monitorHeight * 0.8333);

        buyButton = new CustomButton();
        CustomButton.buttonImage(buyButton, "/pictures/BuyButton.png", buyButtonW, buyButtonH);
        buyButton.setLocation(buyButtonX, buyButtonY);
        restockBackground.add(buyButton);

        updateUI();
    }

    /**
     * Updates the text labels on the screen, showing the current total cost
     * and the exact amount of each product currently in the cart.
     */
    public void updateUI() {
        totalPriceLabel.setText("Total Cost: $ " + currentTotalCost);

        for (String pName : countLabels.keySet()) {
            JLabel label = countLabels.get(pName);
            int currentCount = cart.getOrDefault(pName, 0);
            label.setText(String.valueOf(currentCount));
        }
    }

    /**
     * Empties the shopping cart and resets the total cost to zero.
     * Usually called after a successful purchase.
     */
    public void resetCart() {
        for (String key : cart.keySet()) {
            cart.put(key, 0);
        }
        currentTotalCost = 0;
        updateUI();
    }

    /**
     * A helper method to create standardized buttons for the plus and minus controls.
     *
     * @param text The text displayed on the button.
     * @param width The required width of the button.
     * @param height The required height of the button.
     * @param font The font used for the button text.
     * @param bg The background color of the button.
     * @param fg The text (foreground) color of the button.
     * @return A fully styled JButton.
     */
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

    public JPanel getRestockBackground() {
        return restockBackground;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public HashMap<String, Integer> getCart() {
        return cart;
    }

    public int getCurrentTotalCost() {
        return currentTotalCost;
    }
}