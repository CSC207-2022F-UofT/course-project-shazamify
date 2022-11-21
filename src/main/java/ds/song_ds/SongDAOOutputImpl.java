package ds.song_ds;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.Song;

import java.util.Optional;

public class SongDAOOutputImpl implements SongDAOOutput{
    private MongoDatabase database;

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
