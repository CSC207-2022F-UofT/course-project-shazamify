package interface_adaptors;

import abr.playlist_abr.PlaylistCreateOutputBoundary;
import abr.playlist_abr.PlaylistCreateResponseModel;
import entities.playlist_entities.Playlist;

public class RecordPresenter implements PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist){
        return null;
    }
}
