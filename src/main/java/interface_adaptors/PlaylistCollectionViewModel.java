package interface_adaptors;

import entities.playlist_entities.Playlist;
import framework.buttons.ButtonCreatePlaylist;
import framework.items.PlaylistCollectionItem;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistCollectionViewModel extends AbstractViewModel<List<String>> implements UserStatusObserver {

    private static PlaylistCollectionViewModel instance;
    private List<String> playlist_ids;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static PlaylistCollectionViewModel getInstance() {
        if (instance == null) {instance = new PlaylistCollectionViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param playlist_ids
     */
    public void updateView(List<String> playlist_ids) {
        // Update data
        this.playlist_ids = playlist_ids;
        // Initialize view
        initView();
        // Render view
        renderView();
    }

    /**
     * Renders view
     */
    private void renderView() {
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.DARK_GRAY);
        // Populate list panel with items
        for (int i = 0; i < playlist_ids.size(); i++) {
            list.add(new PlaylistCollectionItem(i, playlist_ids.get(i), width, 60));
        }
        list.add(new ButtonCreatePlaylist(width, 60));
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width, height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }
    @Override
    public void userUpdated(){
        List<String> userplaylists = UserStatusViewModel.getInstance().getPlayListIds();
        this.updateView(userplaylists);
    }

}
