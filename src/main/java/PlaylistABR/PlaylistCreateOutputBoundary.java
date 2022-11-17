package PlaylistABR;

import PlaylistEntities.Playlist;

public interface PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist);
}
