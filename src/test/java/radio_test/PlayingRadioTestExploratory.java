package radio_test;

import abr.radio_abr.RadioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PlayingRadioTestExploratory {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        start();
    }

    public static void start() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String stationName = "1011 The Beat";
        String stationID = "7558a9d8-9aa3-45cb-b307-d9cc97870f2d";

        RadioPlayer.playStream(stationID);

    }
}
