package interface_adaptors.user_interact_screen.friend_playlist_interact_screen;

import javax.swing.*;
import java.awt.*;

public class PlaylistView extends JPanel {

    CheckFriendPlaylistController controller;

    final JFrame frame = new JFrame("Playlist");

    public PlaylistView(CheckFriendPlaylistController controller, String userName){
        this.controller = controller;

        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        addPlaylist(userName);
        frame.add(this);
        frame.setVisible(true);
    }

    private void addPlaylist(String userName){
        JList playList = new JList<>(controller.returnFilteredPlaylist(userName).toArray());
        this.add(new JScrollPane(playList));
    }
}
