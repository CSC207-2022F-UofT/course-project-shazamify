package SongDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YTdlp {

    private final String ffmpegLoc;
    private final String outputLoc;
    private final String link;

    public YTdlp(String link) {
        this.ffmpegLoc = "C:\\ffmpeg\\bin\\ffmpeg.exe";
        this.outputLoc = "src\\main\\resources\\songs\\%(title)s_%(id)s.mp3";
        this.link = link;
        ProcessBuilder dl = new ProcessBuilder();
        dl.redirectErrorStream(true);
    }

    public YTdlp(String ffmpegLoc, String outputLoc, String link) {
        this.ffmpegLoc = ffmpegLoc;
        this.outputLoc = outputLoc;
        this.link = link;
        ProcessBuilder dl = new ProcessBuilder();
        dl.redirectErrorStream(true);
    }

    public void download() {
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
