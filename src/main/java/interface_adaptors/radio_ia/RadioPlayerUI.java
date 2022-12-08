package interface_adaptors.radio_ia;

import framework.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/***
 * @author cynth
 *
 * The Radio Player UI displays that a stream is playing.
 */

public class RadioPlayerUI extends JPanel {
    private String stationName;
    private String stationID;

    final JFrame frame = new JFrame("Radio Player");

    public RadioPlayerUI(String stationName, String stationID){
        this.stationName = stationName;
        this.stationID = stationID;
    }

//    public void updateView(String stationName, String stationID) {
//        this.stationName = stationName;
//        this.stationID = stationID;
//        // initView();
//        renderButtons();
//        renderStream();
//    }

//    public JPanel getView(int width, int height) {
//        this.width = width;
//        this.height = height;
//        if (view == null) {
//            view = new JPanel(new GridLayout(0, 1));
//            view.setMaximumSize(new Dimension(width, height));
//        }
//        return view;
//    }
//
//    public JPanel getView() {
//        if (view == null) {
//            view = new JPanel(new GridLayout(0, 1));
//            view.setMaximumSize(new Dimension(width, height));
//        }
//        return view;
//    }
//
//    public void initView() {
//        getView().removeAll();
//        view.updateUI();
//    }

    public void frameSetUp(){
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(this);
        frame.setVisible(true);

        // layNowButtonSetUp();
        renderButtons();
        // likeStationButtonSetUp();
    }


    private void renderButtons() {
        try {
            // Create buttons panel
            JPanel buttonsPanel = new JPanel(new GridLayout(1, 0));
            buttonsPanel.setSize(40, 40);

            // Create label
            JLabel label = new JLabel(stationName);
            JLabel label1 = new JLabel("NOW PLAYING");
            JButton stopButton = new ButtonStop();

            stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RadioControl.stopStream();
                } // This is to call the controller to stop the stream.
            });

            // Add buttons and label to the buttons panel
            buttonsPanel.add(stopButton);
            buttonsPanel.add(label);
            buttonsPanel.add(label1);

            // Add buttons panel to the content panel
            frame.add(buttonsPanel, BorderLayout.CENTER);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

//    private void renderStream(){
//        try {
//            DisplayRadioPlayerUseCase.playStream(stationID); // This is to begin playing the stream.
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//    }

}
