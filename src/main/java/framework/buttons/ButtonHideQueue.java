package framework.buttons;

import interface_adaptors.SearchResultsViewModel;
import interface_adaptors.playlist_ia.RecordViewModel;
import interface_adaptors.queue_ia.QueueViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHideQueue extends JButton {

    private ButtonRevealQueue revealbutton;
    private JPanel buttonspanel;

    public ButtonHideQueue(){
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/playerrevealqueueicon.png"))));
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
                QueueViewModel.getInstance().getView().setVisible(false);
                RecordViewModel.getInstance().getView().setVisible(false);
                SearchResultsViewModel.getInstance().getView().setVisible(true);
                //AlterVisibility();
            }
        });
    }
    public void Init(){}
    public void SetCompanion(ButtonRevealQueue companion){
        this.revealbutton = companion;
    }

    public void AlterVisibility(){
        revealbutton.setVisible(true);
        this.setVisible(false);
    }
}
