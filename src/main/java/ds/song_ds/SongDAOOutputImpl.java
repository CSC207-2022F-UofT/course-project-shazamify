package ds.song_ds;

import abr.song_abr.SongDAOOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.Song;

import java.util.Optional;

public class SongDAOOutputImpl implements SongDAOOutput {
    private final MongoDatabase database;

    public SongDAOOutputImpl() {
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();
        MongoClient mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    public SongDAOOutputImpl(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    @Override
    public Optional<Song> findById(String id) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        Song s = coll.find(Filters.eq("_id", id)).first();

        return Optional.ofNullable(s);
    }

    @Override
    public Optional<Song> findByName(String name) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        Song s = coll.find(Filters.eq("name", name)).first();

        return Optional.ofNullable(s);
    }
}
