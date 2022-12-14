package ds.playlist_ds;

import abr.playlist_abr.PlaylistDAOInput;
import abr.playlist_abr.PlaylistDAOOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import ds.DatabaseInitializer;
import ds.song_ds.SongDAOImplTest;
import entities.Song;
import entities.playlist_entities.Playlist;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlaylistDAOImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongDAOImplTest.class);

    @Test
    public void playlistProvided_save_success() {
        LOGGER.info("Start test");
        Song s1 = new Song("Song1", "1", 90, "Allen", "2022");
        Song s2 = new Song("Song2", "2", 45, "Cynthia", "2021");
        Playlist p = new Playlist("test_playlist");

        ArrayList<String> songIds = new ArrayList<>();
        songIds.add(s1.getId());
        songIds.add(s2.getId());

        p.setSongs(songIds);

        String uri = "mongodb://root:rootpassword@localhost:27017";

        DatabaseInitializer.init();

        PlaylistDAOInput playlistDAOin = null;
        PlaylistDAOOutput playlistDAOout = null;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            try {
                playlistDAOin = new PlaylistDAOInputImpl(mongoClient);
                playlistDAOout = new PlaylistDAOOutputImpl(mongoClient);
                playlistDAOin.delete(p);
                playlistDAOin.save(p);
                LOGGER.info("Saved");
                Optional<Playlist> playlistResult = playlistDAOout.findById("test_playlist");

                assertTrue(playlistResult.isPresent());

                ArrayList<String> actualIds = playlistResult.get().getSongs();
                assertEquals(s1.getId(), actualIds.get(0));
                assertEquals(s2.getId(), actualIds.get(1));

            } finally {
                assert playlistDAOin != null;
                playlistDAOin.delete(p);
                LOGGER.info("Deleted");
            }
        }
    }
}
