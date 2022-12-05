package ds.song_ds;

import abr.song_abr.SongDAOInput;
import abr.song_abr.SongDAOOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import ds.DatabaseInitializer;
import entities.Song;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SongDAOImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongDAOImplTest.class);

    @Test
    public void songProvided_save_success() {
        LOGGER.info("Start test");
        Song s = new Song("Song1", "1", 90);

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAOInput songDAOin = null;
        SongDAOOutput songDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                songDAOin = new SongDAOInputImpl(mongoClient);
                songDAOin.delete(s);
                songDAOin.save(s);
                LOGGER.info("Saved");
                Optional<Song> songResult = songDAOout.findById("1");
                assertTrue(songResult.isPresent());
                assertEquals(songResult.get().getName(), s.getName());
                assertEquals(songResult.get().getId(), s.getId());
                assertEquals(songResult.get().getDuration(), s.getDuration());
            } finally {
                songDAOin.delete(s);
                LOGGER.info("Deleted");
            }
        }

    }
}
