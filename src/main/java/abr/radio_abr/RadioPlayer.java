package abr.radio_abr;

import entities.radio_entities.RadioStation;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/***
 * @author cynth
 * @since 2022-12-01
 */
public class RadioPlayer {
    // This ABR has one purpose - to play the stream!

    private static boolean keepPlaying;

    /** Read sampled audio data from the specified URL and play it */
    public static void playStream(URL url)
            throws IOException, UnsupportedAudioFileException,
            LineUnavailableException
    {
        /*StationLibrary stationSelection = new StationLibrary();
        List<RadioStation> stationList = stationSelection.getStations();

        RadioStation station = null;

        for (RadioStation obj : stationList) {
            if (obj.getName() == stationName){
                station = obj;
                return;
            }
        }

        URL url = station.getStreamURL();*/

        AudioInputStream ain = null;  // We read audio data from here
        SourceDataLine line = null;   // And write it here.

        try {
            // Get an audio input stream from the URL
            ain= AudioSystem.getAudioInputStream(url);

            // Get information about the format of the stream
            AudioFormat format = ain.getFormat( );
            DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);

            // If the format is not supported directly (i.e. if it is not PCM
            // encoded), then try to transcode it to PCM.
            if (!AudioSystem.isLineSupported(info)) {
                // This is the PCM format we want to transcode to.
                // The parameters here are audio format details that you
                // shouldn't need to understand for casual use.
                AudioFormat pcm =
                        new AudioFormat(format.getSampleRate( ), 16,
                                format.getChannels( ), true, false);

                // Get a wrapper stream around the input stream that does the
                // transcoding for us.
                ain = AudioSystem.getAudioInputStream(pcm, ain);

                // Update the format and info variables for the transcoded data
                format = ain.getFormat( );
                info = new DataLine.Info(SourceDataLine.class, format);
            }

            // Open the line through which we'll play the streaming audio.
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);

            // Allocate a buffer for reading from the input stream and writing
            // to the line.  Make it large enough to hold 4k audio frames.
            // Note that the SourceDataLine also has its own internal buffer.
            int framesize = format.getFrameSize( );
            byte[  ] buffer = new byte[4 * 1024 * framesize]; // the buffer
            int numbytes = 0;                               // how many bytes

            // We haven't started the line yet.
            boolean started = false;

            keepPlaying = true;

            for(;;) {  // We'll exit the loop when we reach the end of stream
                // First, read some bytes from the input stream.

                if (keepPlaying) {
                    int bytesread=ain.read(buffer,numbytes,buffer.length-numbytes);
                    // If there were no more bytes to read, we're done.
                    if (bytesread == -1) break;
                    numbytes += bytesread;

                    // Now that we've got some audio data to write to the line,
                    // start the line, so it will play that data as we write it.
                    if (!started) {
                        line.start( );
                        started = true;
                    }

                    // We must write bytes to the line in an integer multiple of
                    // the framesize.  So figure out how many bytes we'll write.
                    int bytestowrite = (numbytes/framesize)*framesize;

                    // Now write the bytes. The line will buffer them and play
                    // them. This call will block until all bytes are written.
                    line.write(buffer, 0, bytestowrite);

                    // If we didn't have an integer multiple of the frame size,
                    // then copy the remaining bytes to the start of the buffer.
                    int remaining = numbytes - bytestowrite;
                    if (remaining > 0)
                        System.arraycopy(buffer,bytestowrite,buffer,0,remaining);
                    numbytes = remaining;
                }

            }

            // Now block until all buffered sound finishes playing.
            line.drain( );
        }
        finally { // Always relinquish the resources we use
            if (line != null) line.close( );
            if (ain != null) ain.close( );
        }
    }

    public static void stopStream(){
        keepPlaying = false;
    }

}
