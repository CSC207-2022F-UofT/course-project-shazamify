package framework.buttons;

import framework.user_interact_screen.friend_manager_screen.FriendListView;
import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.ShowFriendListController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExpandFriends extends JButton {

    private Icon iconClicked ;
    private Icon icon;
    private ButtonPlaylistsCollection button;

    ShowFriendListController showFriendListController;
    SendFriendRequestController acceptFriendRequestController;
    DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController;

    public ButtonExpandFriends(ShowFriendListController showFriendListController,
                               SendFriendRequestController acceptFriendRequestController,
                               DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController){

        this.showFriendListController = showFriendListController;
        this.acceptFriendRequestController = acceptFriendRequestController;
        this.deleteFriendOrDenyFriendRequestController = deleteFriendOrDenyFriendRequestController;

        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource( "src/main/resources/friendsicon.png")));
            iconClicked = new ImageIcon(ImageIO.read(getClass().getResource( "src/main/resources/friendsiconclicked.png")));
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
                FriendListView screen = new FriendListView(showFriendListController, acceptFriendRequestController, deleteFriendOrDenyFriendRequestController);
            }
        });
    }

    public void setButtonPlaylistsCollection(ButtonPlaylistsCollection button) {
        this.button = button;
    }

    public void clicked(Boolean isClicked){
        this.setIcon((isClicked) ? iconClicked : icon);
    }

}
