package ds.playlist_ds;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.playlist_entities.Playlist;

import java.util.Optional;

public class PlaylistDAOOutputImpl implements PlaylistDAOOutput{
    private MongoDatabase database;

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
