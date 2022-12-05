package ds.playlist_ds;

import abr.playlist_abr.PlaylistDAOInput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.playlist_entities.Playlist;

public class PlaylistDAOInputImpl implements PlaylistDAOInput {
    private MongoDatabase database;

    public PlaylistDAOInputImpl() {
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();
        MongoClient mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    public PlaylistDAOInputImpl(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
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
