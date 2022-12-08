package song_downloader;

import abr.song_downloader_abr.SongDownloader;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import entities.Song;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static abr.song_downloader_abr.SongDownloader.readJSON;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SongDownloaderTest {

    @Test
    public void linkProvided_download_success() {
//        TODO: uncomment
//        SongDownloader.download("https://www.youtube.com/watch?v=k85mRPqvMbE");
//
//        String audioPath = "src\\main\\resources\\songs\\Crazy Frog - Axel F (Official Video).mp3";
//        String jsonPath = "src\\main\\resources\\songs\\Crazy Frog - Axel F (Official Video).mp3.info.json";
//        File audioFile = new File(audioPath);
//        File jsonFile = new File(jsonPath);
//
//        assertTrue(audioFile.exists());
//        assertTrue(jsonFile.exists());
//
//        if (audioFile.exists()) {
//            audioFile.delete();
//        }
//
//        if (jsonFile.exists()) {
//            jsonFile.delete();
//        }

    }

    @Test
    public void jsonProvided_read_success() throws IOException {
        Path jsonPath = Paths.get("src\\main\\resources\\songs\\Baby Shark.mp3.info.json");

        String content = Files.readString(jsonPath);
        DocumentContext jsonContext = JsonPath.parse(content);

        Song s = readJSON(jsonContext);

        assertEquals("Baby Shark", s.getName());
        assertEquals("1-iKwZKc7Ok", s.getId());
        assertEquals(96, s.getDuration());
        assertEquals("Pinkfong Baby Shark - Kids' Songs & Stories", s.getArtist());
        assertEquals("2017", s.getYear());
    }

}
