package playlist_abr;

import playlist_entities.Playlist;

public interface PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist);
}
