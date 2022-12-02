package screen.user_interact_screen.abr.playlist_abr;

import entities.playlist_entities.Playlist;
import interface_adaptors.playlist_ia.RecordViewModel;

public interface PlaylistCreateOutputBoundary {
    public RecordViewModel present(PlaylistCreateResponseModel playlistCreateResponseModel);
}
