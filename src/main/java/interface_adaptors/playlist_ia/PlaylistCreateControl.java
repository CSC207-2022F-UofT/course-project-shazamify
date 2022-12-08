package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistCreateInputBoundary;
import abr.playlist_abr.PlaylistResponseModel;

/**
 *   Ping CreateUseCase to create a playlist
 */
public class PlaylistCreateControl {
    private final PlaylistCreateInputBoundary playlistCreateInputBoundary;

    public PlaylistCreateControl(PlaylistCreateInputBoundary playlistCreateInputBoundary) {
        this.playlistCreateInputBoundary = playlistCreateInputBoundary;
    }

    /**
     *
     * @return instruction to updateView
     */
    public PlaylistResponseModel create(){
        return playlistCreateInputBoundary.playlistCreate();

    }
}
