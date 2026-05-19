package GUI.Customs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CustomButton extends JButton{

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