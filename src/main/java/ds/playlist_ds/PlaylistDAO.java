package ds.playlist_ds;

import entities.playlist_entities.Playlist;

import java.util.Optional;

public interface PlaylistDAO {
    Optional<Playlist> findById(String id);

    Optional<Playlist> findByName(String name);

    void save(Playlist s);

    void update(Playlist s);

    void delete(Playlist s);
}
