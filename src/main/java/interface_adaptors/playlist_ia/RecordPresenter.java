package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistCreateOutputBoundary;
import abr.playlist_abr.PlaylistCreateResponseModel;
import entities.playlist_entities.Playlist;

public class RecordPresenter implements PlaylistCreateOutputBoundary {

    public RecordViewModel present(PlaylistCreateResponseModel playlistCreateResponseModel) {
        return null;
    }
}
