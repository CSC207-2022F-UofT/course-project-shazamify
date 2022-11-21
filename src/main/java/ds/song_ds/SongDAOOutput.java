package ds.song_ds;

import entities.Song;

import java.util.Optional;

public interface SongDAOOutput {
    Optional<Song> findById(String id);

    Optional<Song> findByName(String name);
}
