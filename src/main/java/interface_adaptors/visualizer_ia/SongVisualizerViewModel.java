package interface_adaptors.visualizer_ia;

import entities.Amplitude;
import framework.visualizer.AmplitudeBar;
import interface_adaptors.AbstractViewModel;
import interface_adaptors.display_ia.SongPlayerAudio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongVisualizerViewModel extends AbstractViewModel<ArrayList<Amplitude>> {

    private static SongVisualizerViewModel instance;
    private static int currentindex = 0;
    private static ArrayList<AmplitudeBar> bars;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SongVisualizerViewModel getInstance() {
        if (instance == null) {instance = new SongVisualizerViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param amplitudes
     */
    public void updateView(ArrayList<Amplitude> amplitudes) {
        // Initialize view
        initView();
        // Render view
        render(amplitudes);
    }

    /**
     * Renders view
     */
    private void render(ArrayList<Amplitude> amplitudes) {

        int intervalSize = amplitudes.size() / SongPlayerAudio.NUM_INTERVALS;
        int barWidth = this.width / SongPlayerAudio.NUM_INTERVALS;
        int barHeight = 0;
        int index = 0;

        // Initialize bars array
        if ( bars != null ) { bars.clear(); }
        bars = new ArrayList<>();

        // Create content panel
        JPanel panel = new JPanel(null);
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(false);
        groupLayout.setAutoCreateContainerGaps(false);

        // Create bars
        for (int i = 0; i < amplitudes.size(); i += intervalSize) {
            barHeight = (int)(this.height * Math.abs(amplitudes.get(i).getAmplitude()));
            bars.add(createBar(index++, barWidth, barHeight));
        }

        // Add bars to horizontal group
        GroupLayout.Group horizontalGroup = groupLayout.createSequentialGroup();
        bars.forEach(bar -> horizontalGroup.addComponent(bar));
        groupLayout.setHorizontalGroup(horizontalGroup);

        // Add bars to vertical group
        GroupLayout.Group verticalGroup = groupLayout.createParallelGroup();
        bars.forEach(bar -> verticalGroup.addComponent(bar));
        groupLayout.setVerticalGroup(verticalGroup);

        // Add panel to view
        view.add(panel, BorderLayout.CENTER);
    }

    private AmplitudeBar createBar(int index, int width, int height) {
        return new AmplitudeBar(index, 1, this.height - height, width, height);
    }

    public void highlightBar(int index) {
        try {
            bars.get(index).highlight();
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("index " + index + " out of bound");
        }
    }

    public void unhighlightBar(int index) {
        try {
            bars.get(index).unhighlight();
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("index " + index + " out of bound");
        }
    }

    public void progressUpdate() {
        try {
            bars.get(currentindex).highlight();
            currentindex++;
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("index " + currentindex + " out of bound");
        }
        view.repaint();
    }

    public void progressUpdate(int index) {
        try {
            if ( index > currentindex ) {
                for (int i = currentindex; i <= index; i++) {
                    highlightBar(i);
                }
            }
            else {
                for (int i = index; i <= currentindex; i++) {
                    unhighlightBar(i);
                }
            }
            currentindex = index;
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println("index " + currentindex + " out of bound");
        }
        view.repaint();
    }

}
