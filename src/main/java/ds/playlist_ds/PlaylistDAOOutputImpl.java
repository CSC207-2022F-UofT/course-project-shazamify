package ds.playlist_ds;

import abr.playlist_abr.PlaylistDAOOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.playlist_entities.Playlist;

import java.util.Optional;

public class PlaylistDAOOutputImpl implements PlaylistDAOOutput {
    private final MongoDatabase database;

    public PlaylistDAOOutputImpl() {
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();
        MongoClient mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    public PlaylistDAOOutputImpl(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    @Override
    public Optional<Playlist> findById(String id) {
        MongoCollection<Playlist> coll = database.getCollection("Playlists", Playlist.class);
        Playlist p = coll.find(Filters.eq("_id", id)).first();

        return Optional.ofNullable(p);
    }

    @Override
    public Optional<Playlist> findByName(String name) {
        MongoCollection<Playlist> coll = database.getCollection("Playlists", Playlist.class);
        Playlist p = coll.find(Filters.eq("name", name)).first();

        return Optional.ofNullable(p);
    }


}
