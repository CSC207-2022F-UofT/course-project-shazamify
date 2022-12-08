package framework.buttons;

import framework.SearchEngineInitializer;
import interface_adaptors.SearchResultsViewModel;
import interface_adaptors.playlist_ia.RecordViewModel;
import interface_adaptors.search_engine_ia.SearchEngineController;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSearch extends JButton {
    private JTextField textField;

    public ButtonSearch(JTextField textField) {
        this.textField = textField;
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/search.png"))));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchEngineController searchEngineController = SearchEngineInitializer.getSearchEngineController();
                searchEngineController.updateSearchRadioResult(textField.getText());
                searchEngineController.updateSearchUserResult(textField.getText());
                searchEngineController.updateSearchSongResult(textField.getText());
                searchEngineController.updateSearch();

                RecordViewModel.getInstance().getView().setVisible(false);
                SearchResultsViewModel.getInstance().getView().setVisible(true);
            }
        });
    }

}
