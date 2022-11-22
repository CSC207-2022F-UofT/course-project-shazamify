package framework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ButtonSearchAlbums extends JButton {

    private Icon iconclicked ;
    private Icon icon;

    public ButtonSearchAlbums(){
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource( "/playlistsicon.png")));
            iconclicked = new ImageIcon(ImageIO.read(getClass().getResource( "/playlistsiconclicked.png")));
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
