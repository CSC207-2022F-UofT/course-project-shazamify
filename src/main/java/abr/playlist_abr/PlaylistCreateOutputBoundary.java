package abr.playlist_abr;

import entities.playlist_entities.Playlist;

public interface PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist);
}
