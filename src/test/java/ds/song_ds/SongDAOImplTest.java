package ds.song_ds;

import abr.song_abr.SongDAOInput;
import abr.song_abr.SongDAOOutput;
import com.mongodb.client.FindIterable;
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
        Song s = new Song("Song1", "1", 90, "Allen", "2022");

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAOInput songDAOin = null;
        SongDAOOutput songDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                songDAOin = new SongDAOInputImpl(mongoClient);
                songDAOout = new SongDAOOutputImpl(mongoClient);
                songDAOin.delete(s);
                songDAOin.save(s);
                LOGGER.info("Saved");
                Optional<Song> songResult = songDAOout.findById("1");

                assertTrue(songResult.isPresent());
                assertEquals(songResult.get().getName(), s.getName());
                assertEquals(songResult.get().getId(), s.getId());
                assertEquals(songResult.get().getDuration(), s.getDuration());
                assertEquals(songResult.get().getArtist(), s.getArtist());
                assertEquals(songResult.get().getYear(), s.getYear());
            } finally {
                songDAOin.delete(s);
                LOGGER.info("Deleted");
            }
        }

    }

    @Test
    public void songProvided_searchName_results() {
        LOGGER.info("Start test");
        Song s = new Song("Song1", "1", 90, "Allen", "2022");

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAOInput songDAOin = null;
        SongDAOOutput songDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                songDAOin = new SongDAOInputImpl(mongoClient);
                songDAOout = new SongDAOOutputImpl(mongoClient);
                songDAOin.delete(s);
                songDAOin.save(s);
                LOGGER.info("Saved");

                Optional<Song> songResult1 = songDAOout.findByName("Song1");
                assertTrue(songResult1.isPresent());

                FindIterable<Song> songResults2 = songDAOout.findByNameList("Son");
                for (Song s2 : songResults2) {
                    assertEquals("Song1", s2.getName());
                }


            } finally {
                songDAOin.delete(s);
                LOGGER.info("Deleted");
            }
        }
    }

    @Test
    public void idProvided_filePath_found() {
        LOGGER.info("Start test");
        Song s = new Song("Song1", "1", 90, "Allen", "2022");
        Song s2 = new Song("Despacito", "test", 90, "Allen", "2022");

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAOInput songDAOin = null;
        SongDAOOutput songDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                songDAOin = new SongDAOInputImpl(mongoClient);
                songDAOout = new SongDAOOutputImpl(mongoClient);
                songDAOin.delete(s);
                songDAOin.delete(s2);
                songDAOin.save(s);
                songDAOin.save(s2);
                LOGGER.info("Saved");

                Optional<Song> songResult1 = songDAOout.findByName("Song1");
                assertTrue(songResult1.isPresent());

                assertEquals("src/main/resources/songs/Song1.mp3", songResult1.get().getFilePath());

                Optional<Song> songResult2 = songDAOout.findById("test");
                assertTrue(songResult2.isPresent());
                assertEquals("src/main/resources/songs/Despacito.mp3", songResult2.get().getFilePath());


            } finally {
                songDAOin.delete(s);
                songDAOin.delete(s2);
                LOGGER.info("Deleted");
            }
        }
    }

    @Test
    public void despacitoTest() {
        LOGGER.info("Start test");

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        SongDAOOutput songDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            String id = "FXovf5dsRTw";
            songDAOout = new SongDAOOutputImpl(mongoClient);

            Optional<Song> songResult1 = songDAOout.findById(id);
            assertTrue(songResult1.isPresent());

            assertEquals("src/main/resources/songs/Despacito.mp3", songResult1.get().getFilePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
