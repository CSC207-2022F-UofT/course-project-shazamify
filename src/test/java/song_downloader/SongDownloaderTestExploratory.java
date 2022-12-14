package song_downloader;

import abr.song_downloader_abr.SongDownloader;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class SongDownloaderTestExploratory {

    @Test
    public void linkProvided_download_success() {
        SongDownloader.download("https://www.youtube.com/watch?v=k85mRPqvMbE");

        String audioPath = "src\\main\\resources\\songs\\Crazy Frog - Axel F (Official Video).mp3";
        String jsonPath = "src\\main\\resources\\songs\\Crazy Frog - Axel F (Official Video).mp3.info.json";
        File audioFile = new File(audioPath);
        File jsonFile = new File(jsonPath);

        assertTrue(audioFile.exists());
        assertTrue(jsonFile.exists());

        if (audioFile.exists()) {
            audioFile.delete();
        }

        if (jsonFile.exists()) {
            jsonFile.delete();
        }

    }
}
