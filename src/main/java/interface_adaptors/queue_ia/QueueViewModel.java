package interface_adaptors.queue_ia;

import entities.playlist_entities.Playlist;
import framework.items.PlaylistCollectionItem;
import framework.items.QueueCollectionItem;
import interface_adaptors.AbstractViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QueueViewModel extends AbstractViewModel<List<String>> {

    private static QueueViewModel instance;
    private List<String> song_ids;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static QueueViewModel getInstance() {
        if (instance == null) {instance = new QueueViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param song_ids
     */
    public void updateView(List<String> song_ids) {
        // Update data
        this.song_ids = song_ids;
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
        for (int i = 0; i < song_ids.size(); i++) {
            list.add(new QueueCollectionItem(i,  song_ids.get(i), song_ids.size(),  width, 60));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width, height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }

    public void setSong_ids(List<String> song_ids) {
        this.song_ids = song_ids;
    }

    public List<String> getSong_ids() {
        return this.song_ids;
    }
}
