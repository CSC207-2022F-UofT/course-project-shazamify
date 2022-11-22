package framework;

import interface_adaptors.SongPlayerController;
import shazamify.controller.SongPlayerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlay extends JButton {

    public ButtonPlay() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/play.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongPlayerController.playSong();
            }
        });
    }

}
