package GUI.Customs;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
/**
 * A helper class for JLabels.
 * It provides a simple way to load and display images inside a label.
 */
public class CustomLabel {

    /**
     * Universal method for loading and scaling an image into a JLabel.
     * It is safe for exporting to a .jar file because it uses getResource.
     *
     * @param label The JLabel that will display the image.
     * @param imagePath The path to the image file in the resources folder.
     * @param width The required width of the scaled image.
     * @param height The required height of the scaled image.
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