package user_interaction.user_interact_screen.friend_manager_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendFriendRequestView extends JPanel{

    SendFriendRequestController controller;

    final JFrame frame = new JFrame();

    JLabel userNameLabel = new JLabel("your username"), friendNameLabel = new JLabel("friend's username");
    JTextField userNameField= new JTextField(), friendNameField = new JTextField();

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

    private void sendFriendRequestButtonClicked() {
        try {
            JOptionPane.showMessageDialog(this, controller.reactTo(userNameField.getText(), friendNameField.getText()).getMsgToDisplay());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void screenCompSetup(){
        userNameLabel.setBounds(10,20,165,25);
        userNameField.setBounds(185,20,300,25);
        friendNameLabel.setBounds(10,65,165,25);
        friendNameField.setBounds(185,65,300,25);
        sendFriendRequest.setBounds(30,150,300,50);

        frame.add(sendFriendRequest);
        frame.add(userNameLabel);
        frame.add(friendNameLabel);
        frame.add(userNameField);
        frame.add(friendNameField);
    }

}
