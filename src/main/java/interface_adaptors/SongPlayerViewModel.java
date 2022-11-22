package interface_adaptors;

import entities.Song;
import framework.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SongPlayerViewModel extends AbstractViewModel<Song> {

    private static SongPlayerViewModel instance;
    private static Song song;
    private static JSlider slider;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SongPlayerViewModel getInstance() {
        if (instance == null) {instance = new SongPlayerViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param song
     */
    public void updateView(Song song) {
        // Update data
        this.song = song;
        // Initialize view
        initView();
        // Render slider
        renderSlider();
        // Render buttons
        renderButtons();
    }

    /**
     * Renders slider view
     */
    private void renderSlider() {
        // Create slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, DisplaySongPlayerUseCase.NUM_INTERVALS, 0);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                SongVisualizerViewModel.getInstance().progressUpdate(slider.getValue());
            }
        });
        // Create slider panel
        JPanel sliderPanel = new JPanel(new GridLayout(0, 1));
        sliderPanel.setMaximumSize(new Dimension(width, 10));
        sliderPanel.add(slider);
        // Add slider panel to the content panel
        view.add(sliderPanel, BorderLayout.NORTH);
    }

    /**
     * Renders buttons view
     */
    private void renderButtons() {
        try {
            // Create buttons panel
            JPanel buttonsPanel = new JPanel(new GridLayout(1, 0));
            buttonsPanel.setSize(width, 40);

            // Add buttons to the buttons panel
            buttonsPanel.add(new ButtonSeekStart());
            buttonsPanel.add(new ButtonPlay());
            buttonsPanel.add(new ButtonPause());
            buttonsPanel.add(new ButtonStop());
            buttonsPanel.add(new ButtonSeekEnd());

            // Add buttons panel to the content panel
            view.add(buttonsPanel, BorderLayout.CENTER);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static int getProgress() {
        return slider.getValue();
    }

    public static void setProgress(int interval) {
        slider.setValue(interval);
    }

}