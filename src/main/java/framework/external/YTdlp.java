package framework.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YTdlp {

    /**
     * Location of ffmpeg.exe
     */
    private final String ffmpegLoc;
    /**
     * Location of output files
     */
    private final String outputLoc;

    /**
     * Default constructor for Allen's laptop
     */
    public YTdlp() {
        this.ffmpegLoc = "C:\\ffmpeg\\bin";
        this.outputLoc = "C:\\Users\\allen\\Desktop\\csc207\\course-project-shazamify\\src\\main\\resources\\songs\\%(title)s.mp3";
    }


    public YTdlp(String ffmpegLoc, String outputLoc) {
        this.ffmpegLoc = ffmpegLoc;
        this.outputLoc = outputLoc;
    }

    /**
     * Read out log of YTdlp
     * @param process The YTdlp process
     * @throws IOException
     */
    private static void flushInputStreamReader(Process process) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder s = new StringBuilder();

        while ((line = input.readLine()) != null) {
            s.append(line);
            System.out.println(line);
        }
    }

    /**
     * Run YTdlp with the necessary arguments for downloading the link
     * @param link YouTube link of song or playlist to be downloaded
     */
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
                "--write-thumbnail",
                "--embed-thumbnail",
//                "--convert-thumbnails PNG", doesn't work
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

}
