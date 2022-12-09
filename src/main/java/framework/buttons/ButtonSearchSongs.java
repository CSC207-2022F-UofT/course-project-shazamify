package framework.buttons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ButtonSearchSongs extends JButton {

    private Icon iconclicked ;
    private Icon icon;

    public ButtonSearchSongs(){
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource( "/musictabicon.png")).getScaledInstance(120,50, Image.SCALE_DEFAULT));
            iconclicked = new ImageIcon(ImageIO.read(getClass().getResource( "/musictabiconclicked.png")).getScaledInstance(120,50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setIcon(iconclicked);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);

    }

    public void clicked(Boolean isClicked){
        this.setIcon((isClicked) ? iconclicked : icon);
    }

}
