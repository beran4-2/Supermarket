package GUI.Customs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
/**
 * A custom button class that helps with setting images on buttons.
 * It makes the buttons transparent so only the image is visible.
 */

public class CustomButton extends JButton{


    /**
     * Loads an image, resizes it, and applies it to the given button.
     * It also hides the default button background, borders, and text.
     * * @param button The button that will get the image.
     * @param path The path to the image file in the resources folder.
     * @param width The required width of the image and button.
     * @param height The required height of the image and button.
     */
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
}