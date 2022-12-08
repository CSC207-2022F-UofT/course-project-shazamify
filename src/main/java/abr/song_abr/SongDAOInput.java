package abr.song_abr;

import entities.Song;

public interface SongDAOInput {
    void save(Song s);

    void update(Song s);

    void delete(Song s);
}
