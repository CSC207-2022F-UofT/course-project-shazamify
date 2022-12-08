package abr.song_abr;

import com.mongodb.client.FindIterable;
import entities.Song;

import java.util.Optional;

public interface SongDAOOutput {
    Optional<Song> findById(String id);

    Optional<Song> findByName(String name);

    FindIterable<Song> findByNameList(String name);
}
