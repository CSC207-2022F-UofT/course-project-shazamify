package ds.song_ds;

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

//        TODO: change from hardcoded
        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAO songDAO = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                songDAO = new SongDAOImpl(mongoClient);
                songDAO.delete(s);
                songDAO.save(s);
                LOGGER.info("Saved");
                Optional<Song> songResult = songDAO.findById("1");
                assertTrue(songResult.isPresent());
                assertEquals(songResult.get().getName(), s.getName());
                assertEquals(songResult.get().getId(), s.getId());
                assertEquals(songResult.get().getDuration(), s.getDuration());
            } finally {
                songDAO.delete(s);
                LOGGER.info("Deleted");
            }
        }

    }
}
