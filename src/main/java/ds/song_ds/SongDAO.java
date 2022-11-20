package ds.song_ds;

import entities.Song;

import java.util.Optional;

public interface SongDAO {
    Optional<Song> findById(String id);

//    TODO: findByName

    void save(Song s);

    void update(Song s);

    void delete(Song s);
}
