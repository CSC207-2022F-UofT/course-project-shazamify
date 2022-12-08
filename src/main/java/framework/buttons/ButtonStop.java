package framework.buttons;

import interface_adaptors.display_ia.SongPlayerAudio;
import interface_adaptors.song_player_ia.SongPlayerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStop extends JButton {

    public ButtonStop() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/stop.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongPlayerAudio.getInstance().stopSong();
            }
        });
    }

}
