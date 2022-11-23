package framework.user_interact_screen.friend_manager_screen;

import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A screen that shows the "accept friend request" and "deny friend request" button
 */
public class AcceptOrDenyFriendRequestView extends JPanel{
    final JFrame frame = new JFrame("option to accept or deny friend request");
    SendFriendRequestController acceptFriendRequestController;
    DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController;

    final JButton acceptFriendRequest = new JButton("Accept friend request");
    final JButton denyFriendRequest = new JButton("Deny friend request");

    final FriendListView friendListView;

    private final String friendName;

    public AcceptOrDenyFriendRequestView(FriendListView friendListView, SendFriendRequestController acceptFriendRequestController,
                                         DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController,
                                         String name){
        this.acceptFriendRequestController = acceptFriendRequestController;
        this.deleteFriendOrDenyFriendRequestController = deleteFriendOrDenyFriendRequestController;
        this.friendName = name;
        this.friendListView = friendListView;

        AcceptButtonsSetUp();
        DenyButtonsSetUp();
        frameSetUp();
    }

    private void AcceptButtonsSetUp(){

        acceptFriendRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptFriendRequestButtonClicked();
            }
        });
        this.add(acceptFriendRequest);
    }

    private void frameSetUp(){
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(this);
        frame.setVisible(true);
    }

    private void acceptFriendRequestButtonClicked(){
        try {
            JOptionPane.showMessageDialog(this, acceptFriendRequestController.reactTo(friendName).getMsgToDisplay());
            friendListView.updateButtons();
            frame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void DenyButtonsSetUp(){
        denyFriendRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                denyOrDeleteFriendRequestButtonClicked(friendName);
            }
        });
        this.add(denyFriendRequest);
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


}
