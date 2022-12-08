package interface_adaptors.playlist_ia;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import entities.Record;
import entities.Song;
import framework.items.RecordItem;
import interface_adaptors.AbstractViewModel;
import interface_adaptors.PlaylistDTOController;
import java.util.List;

public class RecordViewModel extends AbstractViewModel<String> {

    private static RecordViewModel instance;
    //private ArrayList<Song> songs;
    private String record_id;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static RecordViewModel getInstance() {
        if (instance == null) {instance = new RecordViewModel();}
        return instance;
    }

    /**
     * Updates view
     * @param record_id
     */
    public void updateView(String record_id) {
        // Update data
        this.record_id = record_id;
        // Initialize view
        initView();
        // Render playlist
        renderView();
    }

    /**
     * Renders view
     */
    private void renderView() {
        // Create shared panel
        JPanel sharedPanel = new JPanel(new BorderLayout());
        sharedPanel.setPreferredSize(new Dimension(width - 30, height));
        sharedPanel.setOpaque(false);
        // Create overhead display panel
        JPanel overheadDisplayPanel = new JPanel(new GridLayout(1, 0));

        //overheadDisplayPanel.add();
        int overheadDisplayHeight = 160;
        overheadDisplayPanel.setPreferredSize(new Dimension(width, overheadDisplayHeight));
        overheadDisplayPanel.setBackground(new Color(50, 50, 50));
        try {
            Image cover = ImageIO.read(PlaylistDTOController.getCover(record_id)).getScaledInstance(130,130,Image.SCALE_DEFAULT);
            overheadDisplayPanel.add(new JLabel(new ImageIcon(cover)));
        }catch(java.io.IOException e){}
        JPanel info = new JPanel(new GridLayout(0,1));
        info.setOpaque(false);
        JLabel nameLabel = new JLabel(PlaylistDTOController.getName(record_id));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Bold", Font.BOLD, 50));
        nameLabel.setOpaque(false);

        JLabel artistLabel = new JLabel(PlaylistDTOController.getArtist(record_id));
        artistLabel.setForeground(Color.WHITE);
        artistLabel.setFont(new Font("Bold", Font.BOLD, 30));
        artistLabel.setOpaque(false);

        info.add(nameLabel);
        info.add(artistLabel);
        overheadDisplayPanel.add(info);

        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setOpaque(false);
        // Populate list panel with items
        List<String> songs = PlaylistDTOController.getSongs(record_id);
        for (int i = 0; i < songs.size(); i++) {
            list.add(new RecordItem(i, songs.get(i), width - 30, 50, record_id));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width - 30, height));

        // Add overhead display and scroll panels to the shared panel
        sharedPanel.add(overheadDisplayPanel, BorderLayout.NORTH);
        sharedPanel.add(scrollPanel, BorderLayout.CENTER);
        // Add shared panel to view
        view.add(sharedPanel, BorderLayout.CENTER);
    }



}
