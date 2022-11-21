package ds.song_ds;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.Song;

public class SongDAOInputImpl implements SongDAOInput{
    private final MongoDatabase database;

    public SongDAOInputImpl() {
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();
        MongoClient mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    public SongDAOInputImpl(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
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
