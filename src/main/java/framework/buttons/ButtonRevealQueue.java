package framework.buttons;

import interface_adaptors.queue_ia.QueueViewModel;
import interface_adaptors.song_player_ia.SongPlayerController;
import interface_adaptors.song_player_ia.SongPlayerViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRevealQueue extends JButton {

    private ButtonHideQueue hidebutton;

    public ButtonRevealQueue(){
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/playerrevealqueue.png"))));
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
                QueueViewModel.getInstance().updateView();
                QueueViewModel.getInstance().getView().setVisible(true);
                AlterVisibility();
            }
        });
    }

    public void SetCompanion(ButtonHideQueue companion){
        this.hidebutton = companion;
    }

    public void AlterVisibility(){
        hidebutton.setVisible(true);
        this.setVisible(false);
    }
}
