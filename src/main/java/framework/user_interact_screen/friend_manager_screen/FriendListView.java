package framework.user_interact_screen.friend_manager_screen;

import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.ShowFriendListController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A screen that shows the friendList of current user
 */
public class FriendListView extends JPanel{
    ShowFriendListController showFriendListController;
    SendFriendRequestController acceptFriendRequestController;
    DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController;

    final JFrame frame = new JFrame("Friend List");

    public FriendListView(ShowFriendListController showFriendListController,
                          SendFriendRequestController acceptFriendRequestController,
                          DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController){

        this.showFriendListController = showFriendListController;
        this.acceptFriendRequestController = acceptFriendRequestController;
        this.deleteFriendOrDenyFriendRequestController = deleteFriendOrDenyFriendRequestController;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        frame.setSize(300, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        updateButtons();
        frame.add(this);
        frame.setVisible(true);
    }

    void updateButtons(){ //add buttons for every friend in orderedFriendList, depending on friendship status
        this.removeAll();
        for (String name : showFriendListController.returnOrderedUserFriendList()){
            if (name.contains("*")){ // if the user has a pending friend request sent by the name
                createPendingFriendProfileButtons(name);
            } else {createFriendProfileButtons(name);} //else they are already friends, have access to friend's profile
        }
        this.revalidate();
        this.repaint();
    }

    private void createFriendProfileButtons(String name){
        JButton checkFriendProfile = new JButton(name);
        checkFriendProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFriendProfileButtonClicked(name);
            }
        });
        this.add(checkFriendProfile);
    }

    private void checkFriendProfileButtonClicked(String name){
        DeleteFriendView deleteFriendView = new DeleteFriendView(this, deleteFriendOrDenyFriendRequestController, name);
    }

    private void createPendingFriendProfileButtons(String name){
        JButton checkFriendRequest = new JButton("Pending friend request from " + name.substring(0,name.length() - 1));
        checkFriendRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFriendRequestButtonClicked(name.substring(0,name.length() - 1));// get rid of the "*" at the end of the name
            }
        });
        this.add(checkFriendRequest);
    }

    private void checkFriendRequestButtonClicked(String name){
        AcceptOrDenyFriendRequestView friendRequestOptions = new AcceptOrDenyFriendRequestView(this,
                acceptFriendRequestController, deleteFriendOrDenyFriendRequestController, name);
    }


}
