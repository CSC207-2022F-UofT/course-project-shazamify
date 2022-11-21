package ds.playlist_ds;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.playlist_entities.Playlist;

import java.util.Optional;

public class PlaylistDAOImpl implements PlaylistDAO {

    private MongoDatabase database;

    public PlaylistDAOImpl(MongoClient mongoClient) {
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

    @Override
    public void save(Playlist p) {
        MongoCollection<Playlist> coll = database.getCollection("Playlists", Playlist.class);
        coll.insertOne(p);
    }

    @Override
    public void update(Playlist p) {
        MongoCollection<Playlist> coll = database.getCollection("Playlists", Playlist.class);
        coll.findOneAndReplace(Filters.eq(p.getId()), p);
    }

    @Override
    public void delete(Playlist p) {
        MongoCollection<Playlist> coll = database.getCollection("Playlists", Playlist.class);
        coll.deleteOne(Filters.eq(p.getId()));
    }
}
