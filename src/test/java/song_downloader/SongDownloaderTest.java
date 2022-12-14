package song_downloader;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import entities.Song;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static abr.song_downloader_abr.SongDownloader.readJSON;
import static org.junit.Assert.assertEquals;

public class SongDownloaderTest {

    @Test
    public void jsonProvided_read_success() throws IOException {
        Path jsonPath = Paths.get("src/main/resources/songs/Despacito.mp3.info.json");

        String content = Files.readString(jsonPath);
        DocumentContext jsonContext = JsonPath.parse(content);

        Song s = readJSON(jsonContext);

        assertEquals("Despacito", s.getName());
        assertEquals("FXovf5dsRTw", s.getId());
        assertEquals(229, s.getDuration());
        assertEquals("Luis Fonsi", s.getArtist());
        assertEquals("2017", s.getYear());
        assertEquals("src/main/resources/songs/Despacito.mp3", s.getFilePath());
    }

}
