package abr.search_engine_abr;


import com.mongodb.client.*;
import ds.DatabaseInitializer;
import entities.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolang05
 * @date 2022/11/13/21:51
 */
public class SongLibrary {
    private static ArrayList<Song> songs;
    private final MongoDatabase database;

    public SongLibrary() {
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();
        MongoClient mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("Shazamify").withCodecRegistry(DatabaseInitializer.getCodecRegistry());
    }

    public List<Song> getSongs() {
        List<Song> songList = new ArrayList<>();
        MongoCollection<Song> coll = database.getCollection("songs", Song.class);
        FindIterable findIterable = coll.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            songList.add((Song) cursor.next());
        }
        return songList;
    }

}
