package ds.playlist_ds;

import entities.playlist_entities.Playlist;

import java.util.Optional;

public interface PlaylistDAOOutput {
    Optional<Playlist> findById(String id);

    Optional<Playlist> findByName(String name);
}
