package abr.playlist_abr;

import entities.playlist_entities.Playlist;

public interface PlaylistDatabaseGateway {
    public int getNewID();
    public boolean storePlaylist(Playlist playlist);
}
