package interface_adaptors.visualizer_ia;

import entities.Amplitude;
import entities.Song;
import interface_adaptors.AbstractDisplayUseCase;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class SongVisualizerUseCase extends AbstractDisplayUseCase {

    private static SongVisualizerUseCase instance;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SongVisualizerUseCase getInstance() {
        if (instance == null) {instance = new SongVisualizerUseCase();}
        return instance;
    }

    /**
     * Executes use case
     * @param song
     */
    public void visualizeSong(Song song) {
        // Extract amplitudes from mp3 file
        ArrayList<Amplitude> amplitudes = (song.getAmplitudes() != null) ? song.getAmplitudes() : extractAmplitudes(song);
        // Send to ViewModel
        SongVisualizerViewModel.getInstance().updateView(amplitudes);
    }

    /**
     * Extracts amplitudes from song
     * @param song
     * @return amplitudes
     */
    private ArrayList<Amplitude> extractAmplitudes(Song song) {
        ArrayList<Amplitude> amplitudes = new ArrayList<>();
        try {
            // Derive audio input stream from input file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(song.getFile());
            AudioFormat baseFormat = audioInputStream.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_FLOAT, 44100, 32, 1, 4, 44100, false);
            AudioInputStream din = AudioSystem.getAudioInputStream(decodedFormat, audioInputStream);
            // Extract and set amplitudes
            byte[] array = new byte[4];
            int read = din.read(array);
            while (read != -1) {
                ByteBuffer bb = ByteBuffer.wrap(array);
                bb.order(ByteOrder.LITTLE_ENDIAN);
                float amplitude = bb.asFloatBuffer().get();
                amplitudes.add(new Amplitude(amplitude));
                read = din.read(array);
            }
            song.setAmplitudes(amplitudes);
            // Set duration
            long frames = audioInputStream.getFrameLength();
            double durationInSeconds = (frames + 0.0) / baseFormat.getFrameRate();
            song.setDurationInSeconds(durationInSeconds);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return amplitudes;
    }
}

