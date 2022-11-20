package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import screen.playlist_screen.RecordViewModel;

public interface PlaylistCreateOutputBoundary {
    public RecordViewModel playlistCreateViewModel(Playlist playlist);
}
