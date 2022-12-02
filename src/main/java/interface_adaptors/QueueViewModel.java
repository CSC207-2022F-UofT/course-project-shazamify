package interface_adaptors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import entities.Record;
import entities.Song;
import framework.RecordItem;

public class QueueViewModel extends AbstractViewModel<Queue> {

    private static QueueViewModel instance;
    //private ArrayList<Song> songs;
    private Queue queue;

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
     * @param queue
     */
    public void updateView(Queue queue) {
        // Update data
        this.queue = queue;
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
            Image cover = ImageIO.read(record.getCover()).getScaledInstance(130,130,Image.SCALE_DEFAULT);
            overheadDisplayPanel.add(new JLabel(new ImageIcon(cover)));
        }catch(java.io.IOException e){}
        JPanel info = new JPanel(new GridLayout(0,1));
        info.setOpaque(false);
        JLabel nameLabel = new JLabel(record.getName());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Bold", Font.BOLD, 50));
        nameLabel.setOpaque(false);

        JLabel artistLabel = new JLabel(record.getArtist());
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
        ArrayList<Song> songs = record.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            list.add(new RecordItem(i, songs.get(i), width - 30, 50));
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
