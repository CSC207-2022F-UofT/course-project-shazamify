package SongDownloader;

import entities.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YTdlp {

    private final String ffmpegLoc;
    private final String outputLoc;

    public YTdlp() {
        this.ffmpegLoc = "C:\\Users\\alvinuy\\Downloads\\ffmpeg-20190911-944d76a-win64-static\\ffmpeg-20190911-944d76a-win64-static\\bin";
//        TODO change path for laptop
        this.outputLoc = "C:\\Users\\allen\\Desktop\\csc207\\course-project-shazamify\\build\\songs\\%(title)s.mp3";
    }

    public YTdlp(String ffmpegLoc, String outputLoc) {
        this.ffmpegLoc = ffmpegLoc;
        this.outputLoc = outputLoc;
    }

    public void download(String link) {
        ProcessBuilder dl = new ProcessBuilder();
        // to enable debug at java side
        dl.redirectErrorStream(true);
        dl.command("yt-dlp",
                "--verbose",
                "--extract-audio", "-i",
                "--audio-format", "mp3",
                "--audio-quality", "0",
                "--no-part", "--no-mtime",
                "--embed-thumbnail",
                "--write-info-json",
                "-o",
                outputLoc,
                link,
                "--ffmpeg-location", ffmpegLoc,
                "--postprocessor-args", "\"-id3v2_version 3\"");
        System.out.println(dl.command());

        try {
            Process p = dl.start();
            flushInputStreamReader(p);
            int exitCode = p.waitFor();
            System.out.println("Exit " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void flushInputStreamReader(Process process) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder s = new StringBuilder();

        while((line=input.readLine()) != null) {
            s.append(line);
            System.out.println(line);
        }
    }

}
