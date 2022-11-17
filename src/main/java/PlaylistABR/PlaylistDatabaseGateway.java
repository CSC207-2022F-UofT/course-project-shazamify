package PlaylistABR;

import PlaylistEntities.Playlist;

public interface PlaylistDatabaseGateway {
    public int getNewID();
    public boolean storePlaylist(Playlist playlist);
}
