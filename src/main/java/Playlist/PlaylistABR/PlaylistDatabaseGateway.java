package Playlist.PlaylistABR;

import Playlist.PlaylistEntities.Playlist;

public interface PlaylistDatabaseGateway {
    public int getNewID();
    public boolean storePlaylist(Playlist playlist);
}
