package framework.user_interact_screen.friend_playlist_interact_screen;

import interface_adaptors.user_interact_ia.CheckFriendPlaylistController;

import javax.swing.*;
import java.awt.*;

/**
 * A screen that shows the friend's playlists, actionListener to view songs in a playlist TBA since playList feature is not finished
 */
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
