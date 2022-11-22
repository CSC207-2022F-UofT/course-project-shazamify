package framework;

import interface_adaptors.SongPlayerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPause extends JButton {

    public ButtonPause() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/pause.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongPlayerController.pauseSong();
            }
        });
    }

}
