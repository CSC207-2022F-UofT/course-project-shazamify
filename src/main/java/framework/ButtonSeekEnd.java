package framework;

import interface_adaptors.SongPlayerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSeekEnd extends JButton {

    public ButtonSeekEnd() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/seekend.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongPlayerController.seekEndSong();
            }
        });
    }

}
