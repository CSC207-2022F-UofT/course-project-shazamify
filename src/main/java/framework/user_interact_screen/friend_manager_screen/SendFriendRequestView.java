package framework.user_interact_screen.friend_manager_screen;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;
import interface_adaptors.user_interact_ia.SendFriendRequestController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * subject to change, TBA to the main UI, main UI not finished
 */
public class SendFriendRequestView extends JPanel{

    SendFriendRequestController controller;

    final JFrame frame = new JFrame();

    JLabel friendNameLabel = new JLabel("friend's username");
    JTextField friendNameField = new JTextField();

    final JButton sendFriendRequest = new JButton("Send friend request");

    public SendFriendRequestView(SendFriendRequestController controller){

        this.controller = controller;

        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        screenCompSetup();

        sendFriendRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendFriendRequestButtonClicked();
            }
        });

    }

    private void sendFriendRequestButtonClicked() { //TODO: take friendID input from SearchEngine instead
        try {
            FriendManagerResponseModel responseModel = controller.reactTo(friendNameField.getText());
            JOptionPane.showMessageDialog(this, responseModel.getMsgToDisplay());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void screenCompSetup(){
        friendNameLabel.setBounds(10,65,165,25);
        friendNameField.setBounds(185,65,300,25);
        sendFriendRequest.setBounds(100,150,300,50);

        frame.add(sendFriendRequest);
        frame.add(friendNameLabel);
        frame.add(friendNameField);
    }

}
