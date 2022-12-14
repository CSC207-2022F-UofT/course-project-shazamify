package ds.playlist_ds;

import abr.playlist_abr.PlaylistDAOInput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import ds.DatabaseInitializer;
import ds.playlist_ds.PlaylistDAOInputImpl;
import entities.playlist_entities.Playlist;

import java.util.ArrayList;
import java.util.Arrays;

public class PlaylistPopulate {

    /**
     * Exploratory tool for populating app with playlists
     */
    public static void main(String[] args) {
        PlaylistDAOInput playlistDAOinput = new PlaylistDAOInputImpl();

        Playlist p1 = new Playlist("1");
        Playlist p2 = new Playlist("2");

        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();

        ArrayList<String> p1Songs = new ArrayList<String>(Arrays.asList("FXovf5dsRTw", "XfEMj-z3TtA"));
        ArrayList<String> p2Songs = new ArrayList<String>(Arrays.asList("Nq_BGGS-hus", "Hm901fX5IZM", "o-BbeLmOAYE"));

        p1.setSongs(p1Songs);
        p2.setSongs(p2Songs);

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase db = mongoClient.getDatabase("Shazamify");
            db.getCollection("playlists").drop();

            playlistDAOinput.save(p1);
            playlistDAOinput.save(p2);
        }
    }

}
