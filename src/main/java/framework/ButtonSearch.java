package framework;

import interface_adaptors.SearchResultsViewModel;
import screen.RecordViewModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSearch extends JButton {

    private JTextField textField;

    public ButtonSearch(JTextField textField ) {
        this.textField = textField;
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