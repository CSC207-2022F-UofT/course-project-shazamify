package ds.song_ds;

import abr.song_abr.SongDAOOutput;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import ds.DatabaseInitializer;
import entities.Song;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public FindIterable<Song> findByNameList(String name) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);

        FindIterable<Song> s = coll.find(Filters.regex("name", "(?i)^" + name));

        return s;
    }

    public List<String> FindByApproximate(String name) {
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);

        FindIterable<Song> s = coll.find();
        List<String> ls = new ArrayList<>();

        for (Song song: s){
            ls.add(song.getId());
        }
        return null;
    }
}
