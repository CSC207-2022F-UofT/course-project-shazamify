package abr.song_abr;

import entities.Song;

import java.util.Optional;

public interface SongDAOInput {
    void save(Song s);

    void update(Song s);

    void delete(Song s);
}