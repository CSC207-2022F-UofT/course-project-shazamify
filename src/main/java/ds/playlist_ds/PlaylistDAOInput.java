package ds.playlist_ds;

import entities.playlist_entities.Playlist;

public interface PlaylistDAOInput {
    void save(Playlist s);

    void update(Playlist s);

    void delete(Playlist s);
}
