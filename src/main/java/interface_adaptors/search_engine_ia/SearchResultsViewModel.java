package interface_adaptors.search_engine_ia;

import abr.user_interact_abr.manage_friend_request_abr.*;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import framework.buttons.*;
import framework.items.*;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchResultsViewModel {

    private static SearchResultsViewModel instance;

    private JPanel view;
    private int width;
    private int height;

    private List<String> songs;
    //private ArrayList<Album> albums;
    private List<String> users;
    private List<String> radios;

    private JPanel viewSongs;
    private JPanel viewUsers;
    private JPanel viewRadio;
    private JPanel viewAlbums;
    private ButtonSearchSongs btnSearchSongs;
    private ButtonSearchAlbums btnSearchAlbums;
    private ButtonSearchUsers btnSearchUsers;
    private ButtonSearchRadio btnSearchRadio;

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
    public void updateView(){
        // Initialize view
        initView();
        // Render playlist
        renderView();
    }

    /**
     * Updates view
     * potentially add Radio stations
     */
    public void updateViewUser(List<String> users) {
        // Update data
        this.users = users;
    }

    public void updateViewSongs(List<String> songs){
        this.songs = songs;
    }

    public void updateViewRadio(List<String> radio){
        this.radios = radio;
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
        listsPanel.add(renderRadioView());
        content.add(renderButtonsView(), BorderLayout.NORTH);
        content.add(listsPanel, BorderLayout.CENTER);
        viewSongs.setVisible(true);
        //viewAlbums.setVisible(false);
        viewUsers.setVisible(false);
        viewRadio.setVisible(false);
        // Add panel to view
        view.add(content);
    }

    /**
     * Renders view
     */
    private JPanel renderButtonsView() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(false);
        //JPanel panel = new JPanel(new GridLayout(1, 0));
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, BUTTONS_HEIGHT));
        //VSO
        panel.setBackground(Color.DARK_GRAY);

        // Instantiate buttons
        btnSearchSongs = new ButtonSearchSongs();
        btnSearchRadio = new ButtonSearchRadio();
        btnSearchUsers = new ButtonSearchUsers();

        // Initialize buttons
        btnSearchSongs.clicked(true);
        btnSearchRadio.clicked(false);
        btnSearchUsers.clicked(false);

        // Add listeners
        btnSearchSongs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(true);
                btnSearchRadio.clicked(false);
                btnSearchUsers.clicked(false);
                viewSongs.setVisible(true);
                //viewAlbums.setVisible(false);
                viewRadio.setVisible(false);
                viewUsers.setVisible(false);
        }});
//        btnSearchAlbums.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                btnSearchSongs.clicked(false);
//                btnSearchAlbums.clicked(true);
//                btnSearchUsers.clicked(false);
//                viewSongs.setVisible(false);
//                //viewAlbums.setVisible(true);
//                viewUsers.setVisible(false);
//            }});
        btnSearchRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(false);
                btnSearchRadio.clicked(true);
                btnSearchUsers.clicked(false);
                viewSongs.setVisible(false);
                //viewAlbums.setVisible(true);
                viewRadio.setVisible(true);
                viewUsers.setVisible(false);
            }});

        btnSearchUsers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchSongs.clicked(false);
                btnSearchRadio.clicked(false);
                btnSearchUsers.clicked(true);
                viewSongs.setVisible(false);
                //viewAlbums.setVisible(false);
                viewRadio.setVisible(false);
                viewUsers.setVisible(true);
            }});

        // Add buttons to the buttons panel
        buttonPanel.add(btnSearchSongs);
        //panel.add(btnSearchAlbums);
        buttonPanel.add(btnSearchUsers);
        buttonPanel.add(btnSearchRadio);
        panel.add(buttonPanel, BorderLayout.WEST);
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
        System.out.println(songs.size());
        for (int i = 0; i < songs.size(); i++) {
            list.add(new SearchSongItem(i, songs.get(i), width - 30, 50));
        }
        list.setBackground(Color.DARK_GRAY);
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
            list.add(addFriendRequestButton(users.get(i)));
        }
        list.setBackground(Color.DARK_GRAY);
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(width - 30, height));
        // Add panel to view
        viewUsers.add(scrollPanel, BorderLayout.CENTER);
        return viewUsers;
    }

    private JButton addFriendRequestButton(String userName){
        JButton requestButton = new JButton("send friend request");

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(new FriendManagerFileDsGateway(), new FriendManagerPresenter());
        SendFriendRequestController controller = new SendFriendRequestController(sendFriendRequest, UserStatusViewModel.getInstance());
        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestButtonClicked(userName, controller);
            }
        });
        return requestButton;
    }

    private void requestButtonClicked(String userName, SendFriendRequestController controller){
        try {
            JOptionPane.showMessageDialog(viewUsers,controller.reactTo(userName).getMsgToDisplay());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewUsers, e.getMessage());
        }
    }

    private JPanel renderRadioView() {
        // Create content panel
        viewRadio = new JPanel();
        viewRadio.setPreferredSize(new Dimension(width, height - BUTTONS_HEIGHT));
        // Create list panel
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        // Populate list panel with items
        for (int i = 0; i < radios.size(); i++) {
            list.add(new SearchUserItem(i, radios.get(i), width - 30, 50));
        }
        list.setBackground(Color.DARK_GRAY);
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
