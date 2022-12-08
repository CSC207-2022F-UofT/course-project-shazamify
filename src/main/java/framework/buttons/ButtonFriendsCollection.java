package framework.buttons;

import interface_adaptors.user_interact_ia.FriendsCollectionViewModel;
import interface_adaptors.playlist_ia.PlaylistCollectionViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFriendsCollection extends JButton {

    private Icon iconclicked ;
    private Icon icon;
    private ButtonPlaylistsCollection button;

    public ButtonFriendsCollection(){
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource( "/friendsicon.png")));
            iconclicked = new ImageIcon(ImageIO.read(getClass().getResource( "/friendsiconclicked.png")));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setIcon(icon);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);

        this.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked(true);
                button.clicked(false);
                FriendsCollectionViewModel.getInstance().getView().setVisible(true);
                PlaylistCollectionViewModel.getInstance().getView().setVisible(false);
                //FriendsCollectionController.displayFriends(null);
            }
        });
    }

    public void setButtonPlaylistsCollection(ButtonPlaylistsCollection button) {
        this.button = button;
    }

    public void clicked(Boolean isClicked){
        this.setIcon((isClicked) ? iconclicked : icon);
    }

}
