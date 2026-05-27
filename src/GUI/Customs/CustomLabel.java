package GUI.Customs;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CustomLabel {

    /**
     * Universal method for loading and scaling an image into a JLabel.
     * Safe for exporting to a .jar file.
     */
    public static void labelImage(JLabel label, String imagePath, int width, int height) {
        try {
            URL imgURL = CustomLabel.class.getResource(imagePath);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));
            } else {
                System.out.println("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading image into Label: " + imagePath);
            e.printStackTrace();
        }
    }
}