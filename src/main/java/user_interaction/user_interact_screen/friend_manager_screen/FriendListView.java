package user_interaction.user_interact_screen.friend_manager_screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        FriendProfileView friendProfileView = new FriendProfileView(this, deleteFriendOrDenyFriendRequestController, name);
    }

    private void createPendingFriendProfileButtons(String name){
        JButton checkFriendRequest = new JButton(name);
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
