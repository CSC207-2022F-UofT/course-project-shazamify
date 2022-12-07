package interface_adaptors;

import abr.user_interact_abr.manage_friend_request_abr.*;
import abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import abr.user_interact_abr.show_friend_list_abr.*;
import ds.user_interact_ds.FriendManagerInMemoryDsGateway;
import interface_adaptors.display_ia.DisplaySearchUseCase;
import interface_adaptors.playlist_ia.RecordViewModel;
import interface_adaptors.song_player_ia.SongPlayerViewModel;
import interface_adaptors.user_interact_ia.*;
import framework.buttons.*;
import framework.items.*;
import interface_adaptors.*;
import interface_adaptors.visualizer_ia.SongVisualizerViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class ShazamifyUI extends JFrame {

    private static final int FRAME_WIDTH   = 1500;
    private static final int NORTH_HEIGHT  = 60;
    private static final int CENTER_HEIGHT = 640;
    private static final int SOUTH_HEIGHT  = 200;
    private static final int COLLECTIONS_WIDTH = 300;

    public ShazamifyUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(FRAME_WIDTH, NORTH_HEIGHT + CENTER_HEIGHT + SOUTH_HEIGHT));
        this.setLocationRelativeTo(null);
        this.setContentPane(createContentPanel(FRAME_WIDTH, NORTH_HEIGHT + CENTER_HEIGHT + SOUTH_HEIGHT));
        this.setLocationByPlatform(true);
        //TODO: put in a nicer spot?
        try {
            ImageIcon logo = new ImageIcon(ImageIO.read(getClass().getResource("/Shazamify-Transparent.png")));
            this.setIconImage(logo.getImage());
        }catch(Exception e){}


        //MediaPlaylistController.listSongs();
        PlaylistCollectionController.displayPlaylists(null);
        DisplaySearchUseCase SearchController;
//        TODO: uncomment
//        SearchController.displaySearchBar();
    }

    private JPanel createContentPanel(int width, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMinimumSize(new Dimension(width, height));
        panel.add(createNorthPanel(FRAME_WIDTH, NORTH_HEIGHT),  BorderLayout.NORTH);
        panel.add(createCenterPanel(FRAME_WIDTH, CENTER_HEIGHT), BorderLayout.CENTER);
        panel.add(createSouthPanel(FRAME_WIDTH, SOUTH_HEIGHT),  BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createNorthPanel(int width, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(createCollectionsNavigationPanel(COLLECTIONS_WIDTH, NORTH_HEIGHT), BorderLayout.WEST);
        panel.add(createSearchPanel((int)((FRAME_WIDTH-COLLECTIONS_WIDTH)*0.75), NORTH_HEIGHT), BorderLayout.CENTER);
        panel.add(createUserProfilePanel((int)((FRAME_WIDTH-COLLECTIONS_WIDTH)*0.25), NORTH_HEIGHT), BorderLayout.EAST);
        /*
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension((int)((FRAME_WIDTH-COLLECTIONS_WIDTH)*0.25), NORTH_HEIGHT));
        p.setBackground(Color.RED);
        panel.add(p, BorderLayout.EAST);*/
        panel.setBackground(new Color(36, 36, 36));
        return panel;
    }

    private JPanel createCenterPanel(int width, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(createCollectionsPanel(COLLECTIONS_WIDTH, CENTER_HEIGHT), BorderLayout.WEST);
        panel.add(createHomePanel((FRAME_WIDTH-COLLECTIONS_WIDTH), CENTER_HEIGHT), BorderLayout.CENTER);
        panel.setBackground(new Color(50,50,50));
        return panel;
    }

    private JPanel createSouthPanel(int width, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(createSongVisualizationPanel(FRAME_WIDTH, (SOUTH_HEIGHT/2)), BorderLayout.NORTH);
        panel.add(createSongPlayerPanel(FRAME_WIDTH, (SOUTH_HEIGHT/2)), BorderLayout.CENTER);
        panel.setBackground(new Color(36, 36, 36));
        return panel;
    }

    private JPanel createCollectionsNavigationPanel(int width, int height){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(new Color(36,36,36));

        JPanel overheadButtonsPanel = new JPanel(new GridLayout(1, 0));
        overheadButtonsPanel.setMinimumSize(new Dimension(width, 80));
        overheadButtonsPanel.setOpaque(false);

        // Instantiate buttons
        ButtonPlaylistsCollection btnPlaylists = new ButtonPlaylistsCollection();
        //!!!!!!!!!!!!!!!!!select which button to display for testing:
        //initFriendListButton(overheadButtonsPanel);
        ButtonFriendsCollectionAlt btnFriends = new ButtonFriendsCollectionAlt();

        // Add buttons to the buttons panel
        overheadButtonsPanel.add(btnPlaylists);
        overheadButtonsPanel.add(btnFriends);

        panel.add(overheadButtonsPanel, BorderLayout.NORTH);

        return panel;
    }

    private void initFriendListButton(JPanel overheadButtonsPanel){
        FriendManagerDsGateway dsGateway = new FriendManagerInMemoryDsGateway();
        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();
//        TODO: uncomment
//        ShowFriendListController showFriendListController = new ShowFriendListController(orderFriendList);
//
//        FriendManagerInputBoundary acceptFriendRequest = new SendFriendRequest(dsGateway, presenter);
//        SendFriendRequestController acceptFriendRequestController = new SendFriendRequestController(acceptFriendRequest);
//
//        FriendManagerInputBoundary deleteOrDenyFriendRequest = new DeleteFriendOrDenyFriendRequest(dsGateway, presenter);
//        DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController = new DeleteFriendOrDenyFriendRequestController(deleteOrDenyFriendRequest);
//
//        ButtonFriendsCollection btnFriends = new ButtonFriendsCollection(showFriendListController, acceptFriendRequestController, deleteFriendOrDenyFriendRequestController);
//
//        overheadButtonsPanel.add(btnFriends);
    }

    private JPanel createCollectionsPanel(int width, int height){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        JPanel listsPanel = new JPanel();
        listsPanel.setBackground(new Color(36, 36, 36));
        listsPanel.add(PlaylistCollectionViewModel.getInstance().getView(width, height));
        panel.add(listsPanel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSongVisualizationPanel(int width, int height){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(SongVisualizerViewModel.getInstance().getView(width, height));
        return panel;
    }

    private JPanel createSongPlayerPanel(int width, int height){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(SongPlayerViewModel.getInstance().getView(width, height));
        return panel;
    }

    private JPanel createSearchPanel(int width, int height){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(SearchBarViewModel.getInstance().getView(width, height));
        return panel;
    }

    private JPanel createUserProfilePanel(int width, int height){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(width, height));
        //panel.add(UserProfileViewModel.getInstance().getView(width, height));
        //panel.setOpaque(false);
        panel.add(new ButtonViewAccount(), BorderLayout.EAST);
        panel.setOpaque(false);
        return panel;
    }

    private JPanel createHomePanel(int width, int height){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        JPanel listsPanel = new JPanel();
        listsPanel.setBackground(new Color(36, 36, 36));
        listsPanel.add(RecordViewModel.getInstance().getView(width, height));
        listsPanel.add(SearchResultsViewModel.getInstance().getView(width, height));
        panel.add(listsPanel, BorderLayout.CENTER);

        return panel;
    }

}
