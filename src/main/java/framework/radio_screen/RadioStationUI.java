package framework.radio_screen;

import interface_adaptors.radio_ia.RadioControl;

import javax.swing.*;
import java.awt.*;

/***
 * @author cynth
 * @since 2022-12-01
 *
 * A UI meant to display the profile of a Radio Station once selected.
 */


public class RadioStationUI extends JPanel {

    final JFrame frame = new JFrame("Radio Station");
    final String stationName;
    final String stationID;

    // final String thumbnailURL;
    // final boolean likeStatus;
    // RadioControl control;

    public RadioStationUI(String stationName, String stationID){
        // this.control = control;
        this.stationName = stationName;
        // this.thumbnailURL = thumbnailURL;
        // this.likeStatus = getLiked;
        this.stationID = stationID;
    }

    public void frameSetUp(){
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(this);
        frame.setVisible(true);

        playNowButtonSetUp();
        // likeStationButtonSetUp();
    }

    private void playNowButtonSetUp(){
        JButton playNow = new JButton("Play Now!");

        playNow.addActionListener(e -> playNowButtonClicked());
    }
    private void playNowButtonClicked(){
        // communicate with controller here
        RadioControl.displayRadioPlayer(this.stationName, this.stationID);
    }

//    private void likeStationButtonSetUp() {
//        JButton likeStation = new JButton("Like");
//        likeStation.addActionListener(e -> likeStationButtonClicked());
//    }

//    private void likeStationButtonClicked(){
//        try{
//
//            RadioControl.stationLike(this.stationName);
//
//            String message;
//            if (this.likeStatus){
//                message = stationName + " has been liked!";
//
//            }
//            else{
//                message = stationName + " has been unliked!";
//            }
//
//
//            JOptionPane.showMessageDialog(this, message);
//
//
//
//            frame.dispose();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
//    }


}
