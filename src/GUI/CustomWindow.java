package GUI;

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

    /*public JLabel paintBackground(String backgroundFile){
        ImageIcon newBackgroundImage = new ImageIcon(backgroundFile);
        JLabel newBackground = new JLabel(newBackgroundImage);
        newBackground.setBounds(0, 0, getMonitorWidth(), getMonitorHeight());
        return newBackground;
    }*/

    public JPanel paintBackground(String backgroundFile){
        Image img = new ImageIcon(backgroundFile).getImage();

        JPanel newBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        newBackground.setLayout(null);
        newBackground.setBounds(0, 0, width, height);
        return newBackground;
    }



}
