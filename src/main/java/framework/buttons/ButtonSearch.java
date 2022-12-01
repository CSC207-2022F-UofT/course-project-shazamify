package framework.buttons;

import interface_adaptors.SearchResultsViewModel;
import interface_adaptors.playlist_ia.RecordViewModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSearch extends JButton {

    public ButtonSearch(JTextField textField) {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/search.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchController.search(textField.getText());
                RecordViewModel.getInstance().getView().setVisible(false);
                SearchResultsViewModel.getInstance().getView().setVisible(true);
            }
        });
    }

}
