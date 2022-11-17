package Playlist.PlaylistABR;

import Playlist.PlaylistEntities.Playlist;

public interface PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist);
}
