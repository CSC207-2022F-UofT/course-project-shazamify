package interface_adaptors.display_ia;

import entities.Song;
import interface_adaptors.AbstractDisplayUseCase;
import interface_adaptors.song_player_ia.SongPlayerViewModel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplaySongPlayerUseCase extends AbstractDisplayUseCase {

    public static final int NUM_INTERVALS = 100;

    private static DisplaySongPlayerUseCase instance;

    private Clip clip;
    private AudioInputStream stream;
    private Timer timer;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static DisplaySongPlayerUseCase getInstance() {
        if (instance == null) {instance = new DisplaySongPlayerUseCase();}
        return instance;
    }

    /**
     * Executes use case
     * @param song
     */
    public void displaySongPlayer(Song song) {
        // Send to ViewModel
        SongPlayerViewModel.getInstance().updateView(song);
        // Clean-up
        try { clip.stop(); clip.close(); } catch (Exception e) {};
        try { stream.close(); } catch (Exception e) {};
        try { timer.stop(); } catch (Exception e) {};
        // Extract clip
        clip = extractClip(song);
        // Init timer
        initTimer(song);
    }

    /**
     * Extracts clip from the song
     * @param song
     * @return Clip clip
     */
    private Clip extractClip(Song song){
        Clip clip = null;
        try {
            AudioFormat format;
            DataLine.Info info;
//            TODO: resolve after MongoDB serialization
//            stream = AudioSystem.getAudioInputStream(song.getFile());
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return clip;
    }

    /**
     * Initializes timer object
     * @param song
     */
    private void initTimer(Song song) {
        int timerDelay = (int) (song.getDuration() * 1000) / DisplaySongPlayerUseCase.NUM_INTERVALS;
        // Create timer
        timer = new Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int progress = SongPlayerViewModel.getProgress();
                if ( progress == DisplaySongPlayerUseCase.NUM_INTERVALS ) {
                    timer.stop();
                }
                else {
                    SongPlayerViewModel.setProgress(progress+1);
                }
            }
        });
        timer.setRepeats(true);
    }

    /**
     * Plays the song
     */
    public void playSong() {
        try {
            clip.start();
            timer.start();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Stops playing the song
     */
    public void stopSong() {
        try {
            clip.stop();
            clip.setMicrosecondPosition(0);
            timer.stop();
            SongPlayerViewModel.setProgress(0);
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Pauses playing the song
     */
    public void pauseSong() {
        try {
            clip.stop();
            timer.stop();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Seeks start of the song
     */
    public void seekStartSong() {
        try {
            clip.stop();
            clip.setMicrosecondPosition(0);
            timer.stop();
            SongPlayerViewModel.setProgress(0);
            clip.start();
            timer.restart();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Seeks end of the song
     */
    public void seekEndSong() {
        try {
            System.out.println("SongPlayer - Seek End");
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
