package radio_tests;

import abr.radio_abr.RadioPlayer;
import org.junit.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/***
 * The purpose of this test is to ensure that the RadioPlayer shows and populates properly from a UI aspect.
 * It is also meant to test all the functionalities of the RadioPlayer, including its ability to actually play the radio.
 */

public class RadioPlayerTest {

    @Test
    public void PlayingRadio() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL testLink = new URL("https://n24a-e2.revma.ihrhls.com/zc4864?rj-ttl=5&rj-tok=AAABhOn5TGgAoU6eq8R1_-jYmQ");

        RadioPlayer.playStream(testLink);
    }

    @Test
    public void StopPlayingRadio(){
        // TODO: Implement
    }

}

