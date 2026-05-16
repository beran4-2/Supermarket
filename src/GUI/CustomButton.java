package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CustomButton extends JButton{

    public static void defaultButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 28));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

    }

    public static void setLocation(double x, double y, double w, double h, JButton button) {
        int ButtonX = (int) (CustomWindow.getMonitorWidth() * x);
        int ButtonY = (int) (CustomWindow.getMonitorHeight() * y);
        int ButtonW = (int) (CustomWindow.getMonitorWidth() * w);
        int ButtonH = (int) (CustomWindow.getMonitorHeight() * h);
        button.setBounds(ButtonX, ButtonY, ButtonW, ButtonH);
    }

    public static void makeInvisible(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setText("");
    }

//    public static void imageButton(JButton button, String filePath, int width, int height) {
//        ImageIcon iconImage = new ImageIcon(filePath);
//        Image scaledImage = iconImage.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
//        button.setIcon(new ImageIcon(scaledImage));
//        button.setText("");
//        button.setContentAreaFilled(false);
//        button.setBorderPainted(false);
//        button.setFocusPainted(false);
//        button.setOpaque(false);
//
//    }

    public static void buttonImage(JButton button, String path, int width, int height) {
        try {
            URL url = CustomButton.class.getResource(path);
            if (url != null) {
                Image original = ImageIO.read(url);
                Image zmenseny = original.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(zmenseny));
            } else {
                System.err.println("Error" + path);
            }
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
            button.setBorder(null);
            button.setText(null);

            button.setPreferredSize(new Dimension(width, height));
            button.setSize(width, height);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }










    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        super.paintComponent(g);
    }
}

