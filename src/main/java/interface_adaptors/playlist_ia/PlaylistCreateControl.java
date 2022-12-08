package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistCreateInputBoundary;
import abr.playlist_abr.PlaylistCreateUseCase;
import abr.playlist_abr.PlaylistDAOInput;
import abr.playlist_abr.PlaylistResponseModel;
import ds.playlist_ds.PlaylistDAOInputImpl;


public class PlaylistCreateControl {
    private final PlaylistCreateInputBoundary playlistCreateInputBoundary;

    public PlaylistCreateControl() {
        PlaylistDAOInput dao = new PlaylistDAOInputImpl();
        this.playlistCreateInputBoundary = new PlaylistCreateUseCase(dao);
    }


    public PlaylistResponseModel create(String name){
        return playlistCreateInputBoundary.playlistCreate(name);

    }
}
