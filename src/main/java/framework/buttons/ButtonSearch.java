package framework.buttons;

import framework.SearchEngineInitializer;
import interface_adaptors.SearchResultsViewModel;
import interface_adaptors.playlist_ia.RecordViewModel;
import interface_adaptors.queue_ia.QueueViewModel;
import interface_adaptors.search_engine_ia.SearchEngineController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSearch extends JButton {
    private JTextField textField;

    public ButtonSearch(JTextField textField) {
        this.textField = textField;
        try {
            this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource( "/searchicon.png"))));
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
                SearchEngineController searchEngineController = SearchEngineInitializer.getSearchEngineController();
                searchEngineController.updateSearchRadioResult(textField.getText());
                searchEngineController.updateSearchUserResult(textField.getText());
                searchEngineController.updateSearchSongResult(textField.getText());
                //searchEngineController.updateSearch();
                System.out.println("then update..");
                //SearchResultsViewModel.getInstance().updateView();
                searchEngineController.updateSearch();
                RecordViewModel.getInstance().getView().setVisible(false);
                QueueViewModel.getInstance().getView().setVisible(false);
                SearchResultsViewModel.getInstance().getView().setVisible(true);
            }
        });
    }

}
