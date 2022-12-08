package framework.items;

import abr.playlist_abr.PlaylistDAOOutput;
import abr.playlist_abr.PlaylistModifyInputBoundary;
import abr.playlist_abr.PlaylistModifyUseCase;
import abr.song_abr.SongDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;
import interface_adaptors.playlist_ia.PlaylistModifyControl;
import interface_adaptors.queue_ia.QueueGetController;
import interface_adaptors.queue_ia.QueueGetPresenter;
import interface_adaptors.queue_ia.QueueUController;
import interface_adaptors.queue_ia.QueueViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class AddToPlaylistMenuItem extends JMenuItem {
    public AddToPlaylistMenuItem(String name, String playlistId, String songId){
        this.setText(name);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: URGENT
                //PlaylistModifyInputBoundary inputBoundary = new PlaylistModifyUseCase(new PlaylistDAOOutputImpl(), new SongDAOOutput());
                //PlaylistModifyControl playListModifier = new PlaylistModifyControl();
                //playListModifier.addToPlaylist(playlistId, songId);
            }
        });
    }
}
