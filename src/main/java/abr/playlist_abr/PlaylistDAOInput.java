package abr.playlist_abr;

import entities.playlist_entities.Playlist;

/**
 * Playlist's database Gateway
 */

public interface PlaylistDAOInput {
    /**
     * save the playlist in the database
     * @param s: Playlist
     */
    void save(Playlist s);

    /**
     * update the playlist in the database
     * @param s: Playlist
     */
    void update(Playlist s);

    /**
     * delete the playlist in the database
     * @param s
     */
    void delete(Playlist s);
}
