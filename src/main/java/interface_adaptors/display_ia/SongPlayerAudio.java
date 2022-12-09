package interface_adaptors.display_ia;

import abr.queue_abr.queue.QueueFIB;
import abr.queue_abr.queue.QueueFOB;
import abr.queue_abr.queue.QueueFUC;
import interface_adaptors.AbstractDisplayUseCase;
import interface_adaptors.SongDTOController;
import interface_adaptors.queue_ia.QueueFirstController;
import interface_adaptors.queue_ia.QueueFirstPresenter;
import interface_adaptors.song_player_ia.SongPlayerViewModel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SongPlayerAudio extends AbstractDisplayUseCase {

    public static final int NUM_INTERVALS = 100;

    private static SongPlayerAudio instance;

    private Clip clip;
    private AudioInputStream stream;
    private Timer timer;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SongPlayerAudio getInstance() {
        if (instance == null) {instance = new SongPlayerAudio();}
        return instance;
    }

    /**
     * Executes use case
     * @param song_id
     */
    public void displaySongPlayer(String song_id) {
        // Send to ViewModel
        SongPlayerViewModel.getInstance().updateView(song_id);
        // Clean-up
        try { clip.stop(); clip.close(); } catch (Exception e) {};
        try { stream.close(); } catch (Exception e) {};
        try { timer.stop(); } catch (Exception e) {};
        // Extract clip
        clip = extractClip(song_id);
        // Init timer
        initTimer(song_id);
    }

    /**
     * Extracts clip from the song
     * @param song_id
     * @return Clip clip
     */
    private Clip extractClip(String song_id){
        Clip clip = null;
        System.out.println(SongDTOController.getArtist(song_id));
        System.out.println(SongDTOController.getName(song_id));
        System.out.println(SongDTOController.getDuration(song_id));
        System.out.println(SongDTOController.getYear(song_id));
        System.out.println("going into extract file path -- " + SongDTOController.getFilePath(song_id));
        //TODO: getFilePath returning nill
        try {
            AudioFormat format;
            DataLine.Info info;
            stream = AudioSystem.getAudioInputStream(new File(SongDTOController.getFilePath(song_id)));
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
     * @param song_id
     */
    private void initTimer(String song_id) {
        int timerDelay = (int) (SongDTOController.getDuration(song_id) * 1000) / SongPlayerAudio.NUM_INTERVALS;
        // Create timer
        timer = new Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int progress = SongPlayerViewModel.getProgress();
                if ( progress == SongPlayerAudio.NUM_INTERVALS ) {
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
            QueueFOB fob = new QueueFirstPresenter();
            QueueFIB fib = new QueueFUC(fob);
            QueueFirstController firstController = new QueueFirstController(fib);
            firstController.retrieveFirst();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
