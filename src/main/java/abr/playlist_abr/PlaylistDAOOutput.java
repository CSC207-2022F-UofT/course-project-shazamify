package abr.playlist_abr;

import entities.playlist_entities.Playlist;

import java.util.Optional;

/**
 * PlaylistDS Gateway
 */
public interface PlaylistDAOOutput {
    /**
     * find Playlist in database by ID
     * @param id: needed Playlist's ID
     * @return Playlist if exist
     */
    Optional<Playlist> findById(String id);

    /**
     * find Playlist in database by its name
     * @param name: needed Playlist's name
     * @return PLaylist if exist
     */
    Optional<Playlist> findByName(String name);
}
