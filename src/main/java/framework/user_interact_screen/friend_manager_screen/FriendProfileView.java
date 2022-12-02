package framework.user_interact_screen.friend_manager_screen;

import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A screen that shows the friend's profile, TBA since playList feature is not finished
 */
public class FriendProfileView extends JPanel { //TODO: add other components such as view playlist ,.etc
    final JFrame frame = new JFrame("Friend Profile");
    final DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController;
    final String friendName;
    final FriendListView friendListView;

    public FriendProfileView(FriendListView friendListView, DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController,
                             String name){
        this.deleteFriendOrDenyFriendRequestController = deleteFriendOrDenyFriendRequestController;
        this.friendName = name;
        this.friendListView = friendListView;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        DeleteButtonSetUp();
        frameSetUp();
    }

    private void frameSetUp(){
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(this);
        frame.setVisible(true);
    }
    private void denyOrDeleteFriendRequestButtonClicked(String name){
        try {
            JOptionPane.showMessageDialog(this, deleteFriendOrDenyFriendRequestController.reactTo(name).getMsgToDisplay());
            friendListView.updateButtons();
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void DeleteButtonSetUp(){
        JButton deleteFriend = new JButton("Delete friend");
        deleteFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                denyOrDeleteFriendRequestButtonClicked(friendName);
            }
        });
        this.add(deleteFriend);
    }
    private void viewPlaylistButtonClicked(String name){ //TODO: implement this
//        try {
//            JOptionPane.showMessageDialog(this, deleteFriendOrDenyFriendRequestController.reactTo(name).getMsgToDisplay());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }

    private void viewPlaylistButtonSetUp(){ //TODO: implement this
//        JButton deleteFriend = new JButton("Delete friend");
//        deleteFriend.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                denyOrDeleteFriendRequestButtonClicked(friendName);
//            }
//        });
//        frame.add(deleteFriend);
    }


}
