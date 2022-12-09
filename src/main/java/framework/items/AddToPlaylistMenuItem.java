package framework.items;

import interface_adaptors.playlist_ia.PlaylistModifyControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToPlaylistMenuItem extends JMenuItem {
    public AddToPlaylistMenuItem(String name, String playlistId, String songId){
        this.setText(name);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: URGENT
                PlaylistModifyControl playListModifier = new PlaylistModifyControl();
                playListModifier.addToPlaylist(playlistId, songId);
            }
        });
    }
}
