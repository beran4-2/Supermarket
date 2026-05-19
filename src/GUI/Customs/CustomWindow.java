package GUI.Customs;

import javax.swing.*;
import java.awt.*;

public class CustomWindow {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int width = (int) screenSize.getWidth();
    static int height = (int) screenSize.getHeight();
    public static int getMonitorWidth(){
        return width;
    }

    public static int getMonitorHeight(){
        return height;
    }

    public JPanel paintBackground(String backgroundFile){
        Image img = null;
        try {
            java.net.URL url = CustomWindow.class.getResource(backgroundFile);
            if (url != null) {
                img = javax.imageio.ImageIO.read(url);
            } else {
                System.err.println("Error with load: " + backgroundFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Image finalImg = img;
        JPanel newBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (finalImg != null) {
                    g.drawImage(finalImg, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        newBackground.setLayout(null);
        newBackground.setBounds(0, 0, width, height);
        return newBackground;
    }

}