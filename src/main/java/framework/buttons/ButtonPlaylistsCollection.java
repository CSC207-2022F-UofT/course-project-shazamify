package framework.buttons;

import interface_adaptors.FriendsCollectionViewModel;
import interface_adaptors.PlaylistCollectionViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlaylistsCollection extends JButton {

    private Icon iconclicked ;
    private Icon icon;
    private ButtonFriendsCollection button;

    public ButtonPlaylistsCollection(){
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

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked(true);
                button.clicked(false);
                FriendsCollectionViewModel.getInstance().getView().setVisible(false);
                PlaylistCollectionViewModel.getInstance().getView().setVisible(true);
                //PlaylistCollectionController.displayPlaylists(null);
            }
        });

    }

    public void setButtonFriendsCollection(ButtonFriendsCollection button) {
        this.button = button;
    }

    public void clicked(Boolean isClicked){
        this.setIcon((isClicked) ? iconclicked : icon);
    }

}
