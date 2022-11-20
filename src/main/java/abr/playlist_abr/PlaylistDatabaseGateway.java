package abr.playlist_abr;

import entities.playlist_entities.Playlist;

public interface PlaylistDatabaseGateway {
    String getNewID();
    boolean storePlaylist(Playlist playlist);
}
