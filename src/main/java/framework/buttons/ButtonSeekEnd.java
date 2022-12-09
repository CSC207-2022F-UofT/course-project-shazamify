package framework.buttons;

import interface_adaptors.display_ia.SongPlayerAudio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSeekEnd extends JButton {

    public ButtonSeekEnd() {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/playerskipforwardicon.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongPlayerAudio.getInstance().seekEndSong();
            }
        });
    }

}
