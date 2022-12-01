package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistCreateInputBoundary;
import abr.playlist_abr.PlaylistCreateRequestModel;
import abr.playlist_abr.PlaylistCreateResponseModel;


public class PlaylistCreateControl {
    private final PlaylistCreateInputBoundary playlistCreateInputBoundary;

    public PlaylistCreateControl(PlaylistCreateInputBoundary playlistCreateInputBoundary) {
        this.playlistCreateInputBoundary = playlistCreateInputBoundary;
    }


    public PlaylistCreateResponseModel create(PlaylistCreateRequestModel playlistCreateRequestModel){
        return playlistCreateInputBoundary.playlistCreate(playlistCreateRequestModel);

    }
}
