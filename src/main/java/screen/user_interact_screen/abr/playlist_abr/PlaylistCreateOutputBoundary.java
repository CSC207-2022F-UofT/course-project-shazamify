package screen.user_interact_screen.abr.playlist_abr;

import entities.playlist_entities.Playlist;

public interface PlaylistCreateOutputBoundary {
    public PlaylistCreateResponseModel createRMConverter(Playlist playlist);
}
