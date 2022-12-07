package interface_adaptors;

import entities.Song;
import framework.buttons.ButtonSearchAlbums;
import framework.buttons.ButtonSearchSongs;
import framework.buttons.ButtonSearchUsers;
import framework.items.SearchSongItem;
import framework.items.SearchUserItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchResultsViewModel {

    private static SearchResultsViewModel instance;

    private JPanel view;
    private int width;
    private int height;

    private ArrayList<String> songs;
    //private ArrayList<Album> albums;
    private ArrayList<String> users;

    private JPanel viewSongs;
    private JPanel viewUsers;
    private JPanel viewAlbums;
    private ButtonSearchSongs btnSearchSongs;
    private ButtonSearchAlbums btnSearchAlbums;
    private ButtonSearchUsers btnSearchUsers;

    private int BUTTONS_HEIGHT = 50;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static SearchResultsViewModel getInstance() {
        if (instance == null) {instance = new SearchResultsViewModel();}
        return instance;
    }

    public JPanel getView(int width, int height) {
        this.width = width;
        this.height = height;
        if (view == null) {
            view = new JPanel(new GridLayout(0, 1));
            view.setMaximumSize(new Dimension(width, height));
        }
        return view;
    }

    public JPanel getView() {
        return view;
    }

    public void initView() {
        getView().removeAll();
        view.updateUI();
    }

    /**
     * Updates view
     * potentially add Radio stations
     */
    public void updateViewUser(ArrayList<String> users) {
        // Update data
        this.users = users;
        // Initialize view
        initView();
        // Render playlist
        renderView();
    }


    /**
     * Renders view
     */
    private void renderView() {
        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(width, height));
        JPanel listsPanel = new JPanel();
        listsPanel.setBackground(new Color(36, 36, 36));
        listsPanel.add(renderSongsView());
        //listsPanel.add(renderAlbumsView());
        listsPanel.add(renderUsersView());
        content.add(renderButtonsView(), BorderLayout.NORTH);
        content.add(listsPanel, BorderLayout.CENTER);
        viewSongs.setVisible(true);
        //viewAlbums.setVisible(false);
        viewUsers.setVisible(false);
        // Add panel to view
        view.add(content);
    }

    /**
     * Renders view
     */
    private JPanel renderButtonsView() {

        JPanel panel = new JPanel(new GridLayout(1, 0));
        panel.setPreferredSize(new Dimension(width, BUTTONS_HEIGHT));
        panel.setOpaque(false);

        // Instantiate buttons
        btnSearchSongs = new ButtonSearchSongs();
        btnSearchAlbums = new ButtonSearchAlbums();
        btnSearchUsers = new ButtonSearchUsers();

        // Initialize buttons
        btnSearchSongs.clicked(true);
        btnSearchAlbums.clicked(false);
        btnSearchUsers.clicked(false);

        // Add listeners
        btnSearchSongs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(true);
                btnSearchAlbums.clicked(false);
                btnSearchUsers.clicked(false);
                viewSongs.setVisible(true);
                viewAlbums.setVisible(false);
                viewUsers.setVisible(false);
        }});
        btnSearchAlbums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(false);
                btnSearchAlbums.clicked(true);
                btnSearchUsers.clicked(false);
                viewSongs.setVisible(false);
                viewAlbums.setVisible(true);
                viewUsers.setVisible(false);
            }});
        btnSearchUsers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(false);
                btnSearchAlbums.clicked(false);
                btnSearchUsers.clicked(true);
                viewSongs.setVisible(false);
                viewAlbums.setVisible(false);
                viewUsers.setVisible(true);
            }});

        // Add buttons to the buttons panel
        panel.add(btnSearchSongs);
        //panel.add(btnSearchAlbums);
        panel.add(btnSearchUsers);

        return panel;
    }

    /**
     * Renders view
     */
    private JPanel renderSongsView() {
        // Create content panel
        viewSongs = new JPanel();
        viewSongs.setPreferredSize(new Dimension(width, height - BUTTONS_HEIGHT));
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        // Populate list panel with items
        for (int i = 0; i < songs.size(); i++) {
            list.add(new SearchSongItem(i, songs.get(i), width - 30, 50));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width - 30, height));
        // Add panel to view
        viewSongs.add(scrollPanel, BorderLayout.CENTER);
        return viewSongs;
    }

    /**
     * Renders view
     */
    private JPanel renderUsersView() {
        // Create content panel
        viewUsers = new JPanel();
        viewUsers.setPreferredSize(new Dimension(width, height - BUTTONS_HEIGHT));
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        // Populate list panel with items
        for (int i = 0; i < users.size(); i++) {
            list.add(new SearchUserItem(i, users.get(i), width - 30, 50));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width - 30, height));
        // Add panel to view
        viewUsers.add(scrollPanel, BorderLayout.CENTER);
        return viewUsers;
    }

    /**
     * Renders view
     */
    /*
    private JPanel renderAlbumsView() {
        // Create content panel
        viewAlbums = new JPanel();
        viewAlbums.setPreferredSize(new Dimension(width, height - BUTTONS_HEIGHT));
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        // Populate list panel with items
        for (int i = 0; i < albums.size(); i++) {
            list.add(new SearchAlbumItem(i, albums.get(i), width - 30, 50));
        }
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width - 30, height));
        // Add panel to view
        viewAlbums.add(scrollPanel, BorderLayout.CENTER);
        return viewAlbums;
    }
     */
}
