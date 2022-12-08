package framework.items;

import interface_adaptors.playlist_ia.PlaylistModifyControl;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddToPlaylistMenuItem extends JMenuItem {
    public AddToPlaylistMenuItem(String name, String playlistId, String songId){
        this.setText(name);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            //TODO: MODIFY HERE

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
    }
}
