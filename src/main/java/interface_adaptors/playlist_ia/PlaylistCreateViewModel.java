package interface_adaptors.playlist_ia;

import framework.UserManagementInitializer;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_playlist_ia.UserPlayListController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlaylistCreateViewModel extends JFrame {
    TextField textField;
    public PlaylistCreateViewModel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Enter playlist name:"), BorderLayout.NORTH);
        panel.add(createButton(), BorderLayout.CENTER);
        TextField textField = new TextField();
        this.textField = textField;
        panel.add(textField);
    }

    public JButton createButton(){
        JButton createButton = new JButton("Create");
        createButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: URGENT
                PlaylistCreateControl playlistCreateControl = new PlaylistCreateControl();
                String plID = playlistCreateControl.create(textField.getText()).getID();
                // ASK DAVID HOW TO CONNECT CURRENT USER THIS PLAYLIST
                UserPlayListController userPlayListController = UserManagementInitializer.getUserPlaylistController();
                String userName = UserStatusViewModel.getInstance().getUserName();
                userPlayListController.addPlayListInUser(userName, plID);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return createButton;
    }
}
