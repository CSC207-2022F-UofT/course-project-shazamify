package abr.song_downloader_abr;

import abr.song_abr.SongDAOInput;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import ds.DatabaseInitializer;
import ds.song_ds.SongDAOInputImpl;
import entities.Song;
import framework.external.Downloadable;
import framework.external.YTdlp;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SongDownloader {

    //    TODO: rename from main when finished project
    public static void main(String[] args) throws Exception {
//        Single video or playlist link
//        https://www.youtube.com/watch?v=gWo12TtN9Kk
//        System.out.println("Enter youtube link: ");
//        Scanner sc = new Scanner(System.in);
//        String link = sc.nextLine();

//        Downloadable p = new YTdlp();
//        p.download(link);
        moveToDatabase();
    }

    public static void download(String link) {
        Downloadable p = new YTdlp();
        p.download(link);
    }

    public static Song readJSON(DocumentContext dc) throws IOException {
        String id = dc.read("$['id']");
        String name = dc.read("$['title']");
        int duration = dc.read("$['duration']");
        String artist = dc.read("$['channel']");
        String year;
        try {
            year = Integer.toString(dc.read("$['release_year']"));
        } catch(PathNotFoundException e) {
            year = ((String) dc.read("$['upload_date']")).substring(0,4);
        }

        Song s = new Song(name, id, duration, artist, year);
        System.out.println("Important " + s.getFilePath());

        return s;
    }

    public static void moveToDatabase() throws Exception {
//        download json and mp3 to directory using yt-dlp
//        iterate over json files in directory
//        create Song object if json file does not belong to playlist
//        store Song object and metadata in user_database

        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase db = mongoClient.getDatabase("Shazamify");
            db.getCollection("songs").drop();

            SongDAOInput songDAOin = new SongDAOInputImpl(mongoClient);

            Files.walk(Paths.get("src\\main\\resources\\songs"), FileVisitOption.FOLLOW_LINKS).filter(t ->
                    t.toString().endsWith(".info.json")).forEach(path -> {
                try {
                    String content = Files.readString(path);
                    DocumentContext jsonContext = JsonPath.parse(content);
                    if (!((String) jsonContext.read("$['webpage_url']")).contains("playlist?list=")) {
                        Song s = readJSON(jsonContext);
                        System.out.println(s);
                        songDAOin.save(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
