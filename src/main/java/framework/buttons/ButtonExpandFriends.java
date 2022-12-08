package framework.buttons;

import framework.user_interact_screen.friend_manager_screen.FriendListView;
import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.ShowFriendListController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createMatteBorder;

public class ButtonExpandFriends extends JButton {

    private Icon iconClicked ;
    private Icon icon;
    private ButtonPlaylistsCollection button;

    ShowFriendListController showFriendListController;
    SendFriendRequestController acceptFriendRequestController;
    DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController;

    public ButtonExpandFriends(ShowFriendListController showFriendListController,
                               SendFriendRequestController acceptFriendRequestController,
                               DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController,
                               int width, int height){

        this.showFriendListController = showFriendListController;
        this.acceptFriendRequestController = acceptFriendRequestController;
        this.deleteFriendOrDenyFriendRequestController = deleteFriendOrDenyFriendRequestController;

        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);


        try {
            Image cover = ImageIO.read(getClass().getResource( "src/main/resources/expandfriendsicon.png")).getScaledInstance(50,50,Image.SCALE_DEFAULT);
            this.add(renderImage(new ImageIcon(cover)), BorderLayout.CENTER);
        }catch(java.io.IOException e){}

        Border blackline = createMatteBorder(0, 0, 1, 0, new Color(36,36,36));
        this.setBorder(blackline);

        this.setIcon(icon);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);

        this.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.clicked(false);
                FriendListView screen = new FriendListView(showFriendListController, acceptFriendRequestController, deleteFriendOrDenyFriendRequestController);
            }
        });
    }

    private JLabel renderImage(ImageIcon cover){
        JLabel coverlabel = new JLabel(cover);
        coverlabel.setOpaque(false);
        return coverlabel;
    }

}
