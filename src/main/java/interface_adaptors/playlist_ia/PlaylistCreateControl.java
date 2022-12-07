package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistCreateInputBoundary;
import abr.playlist_abr.PlaylistResponseModel;


public class PlaylistCreateControl {
    private final PlaylistCreateInputBoundary playlistCreateInputBoundary;

    public PlaylistCreateControl(PlaylistCreateInputBoundary playlistCreateInputBoundary) {
        this.playlistCreateInputBoundary = playlistCreateInputBoundary;
    }


    public PlaylistResponseModel create(){
        return playlistCreateInputBoundary.playlistCreate();

    }
}
