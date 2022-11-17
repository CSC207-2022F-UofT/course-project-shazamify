package playlist_abr;

import playlist_entities.Playlist;

public interface PlaylistDatabaseGateway {
    public int getNewID();
    public boolean storePlaylist(Playlist playlist);
}
