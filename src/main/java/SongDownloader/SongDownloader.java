package SongDownloader;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import ds.DatabaseInitializer;
import ds.song_ds.SongDAOInput;
import entities.Song;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SongDownloader {

    public static void main(String[] args) throws Exception {
//        Single video or playlist link
//        https://www.youtube.com/watch?v=gWo12TtN9Kk
        System.out.println("Enter youtube link: ");
        Scanner sc = new Scanner(System.in);
        String link = sc.nextLine();

        YTdlp p = new YTdlp();
        p.download(link);
        moveToDatabase();
    }

    public static void moveToDatabase() throws Exception {
//        download json and mp3 to directory using yt-dlp
//        iterate over json files in directory
//        create Song object if json file does not belong to playlist
//        store Song object and metadata in user_database

        SongDAOInput songDAOin = null;
        String uri = "mongodb://root:rootpassword@localhost:27017";
        DatabaseInitializer.init();

//        TODO: change path for laptop
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            Files.walk(Paths.get("C:\\Users\\allen\\Desktop\\csc207\\course-project-shazamify\\build\\songs"), FileVisitOption.FOLLOW_LINKS).filter(t ->
            {
                return t.toString().endsWith(".info.json");
            }).forEach(path -> {
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

    public static Song readJSON(DocumentContext dc) throws IOException {
        String id = dc.read("$['id']");
        String name = dc.read("$['title']");
        int duration = dc.read("$['duration']");

        return new Song(name, id, duration);
    }
}
