package ds.song_ds;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.Song;

import java.util.Optional;

public class SongDAOImpl implements SongDAO{

    private MongoDatabase database;

    public SongDAOImpl(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    @Override
    public Optional<Song> findById(String id) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        Song s = coll.find(Filters.eq("_id", id)).first();

        return Optional.of(s);
    }

    @Override
    public void save(Song s) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        coll.insertOne(s);
    }

    @Override
    public void update(Song s) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        coll.findOneAndReplace(Filters.eq(s.getId()), s);
    }

    @Override
    public void delete(Song s) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        coll.deleteOne(Filters.eq(s.getId()));
    }
}
