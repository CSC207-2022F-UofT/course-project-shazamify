package interface_adaptors;

import entities.playlist_entities.Playlist;
import framework.items.PlaylistCollectionItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlaylistCollectionViewModel extends AbstractViewModel<ArrayList<Playlist>> implements UserStatusObserver{

    private static PlaylistCollectionViewModel instance;
    private ArrayList<String> playlist_ids;
    private UserStatusViewModel userStatusViewModel;

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
     * @param playlists
     */
    public void updateView(ArrayList<String> playlist_ids) {
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
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width, height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }
    @Override
    private void userUpdate(){
        ArrayList<String> userplaylists = UserStatusViewModel.getInstance().getPlaylistIds;
        this.updateView(userplaylists);
    }

}
