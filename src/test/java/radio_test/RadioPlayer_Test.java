package radio_test;

import abr.radio_abr.RadioPlayer;
import interface_adaptors.radio_ia.RadioControl;
import interface_adaptors.radio_ia.RadioPlayerViewModel;
import org.junit.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author cynth
 *
 * The purpose of these tests is to test the direct functionality of the Radioplayer.
 * Namely, that it can play streams properly and stop properly as well.
 */

public class RadioPlayer_Test {

    @Test
    public void playStreamDirect() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        RadioPlayer.playStream("cacf6613-10e5-483f-ba98-17c15bb823b9");
    }
}