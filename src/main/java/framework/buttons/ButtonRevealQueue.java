package framework.buttons;

import abr.queue_abr.queue.QueueGetInputBoundary;
import abr.queue_abr.queue.QueueGetOutputBoundary;
import abr.queue_abr.queue.QueueGetUseCase;
import interface_adaptors.SearchResultsViewModel;
import interface_adaptors.playlist_ia.RecordViewModel;
import interface_adaptors.queue_ia.QueueGetController;
import interface_adaptors.queue_ia.QueueGetPresenter;
import interface_adaptors.queue_ia.QueueViewModel;
import interface_adaptors.song_player_ia.SongPlayerController;
import interface_adaptors.song_player_ia.SongPlayerViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonRevealQueue extends JButton {

    private ButtonHideQueue hidebutton;
    private JPanel buttonspanel;

    public ButtonRevealQueue(){
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/playerhidequeueicon.png"))));
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
                List<String> currentQueueOrder = getCurrentQueueOrder();
                QueueViewModel.getInstance().updateView(currentQueueOrder);
                RecordViewModel.getInstance().getView().setVisible(false);
                SearchResultsViewModel.getInstance().getView().setVisible(false);
                QueueViewModel.getInstance().getView().setVisible(true);
                //AlterVisibility();
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

    public List<String> getCurrentQueueOrder(){
        QueueGetOutputBoundary getOutputBoundary = new QueueGetPresenter();
        QueueGetInputBoundary getInputBoundary = new QueueGetUseCase(getOutputBoundary);
        QueueGetController getController = new QueueGetController(getInputBoundary);
        getController.retrieveList();

        return QueueViewModel.getInstance().getSong_ids();
    }
}
