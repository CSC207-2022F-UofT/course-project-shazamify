package interface_adaptors;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerPresenter;
import abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import abr.user_interact_abr.show_friend_list_abr.OrderFriendList;
import abr.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import framework.buttons.ButtonExpandFriends;
import framework.items.FriendsCollectionItem;
import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.ShowFriendListController;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FriendsCollectionViewModel extends AbstractViewModel<HashMap<String, String>> implements UserStatusObserver {

    private static FriendsCollectionViewModel instance;
    private HashMap<String, String> friendUserNames;

    public static FriendsCollectionViewModel getInstance() {
        if (instance == null) {instance = new FriendsCollectionViewModel();}
        return instance;
    }

    public void updateView(HashMap<String, String> friendUserNames) {
        // Update data
        this.friendUserNames = friendUserNames;
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
        int i = 0;
        for (String userName : friendUserNames.keySet()) {
            if (friendUserNames.get(userName).equals("friend")) {
                list.add(new FriendsCollectionItem(i, userName, this.width, 60));
            }
            i++;
        }
        list.add(initExpandFriendListButton());
        // Create scroll panel
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(this.width, this.height));
        // Add panel to view
        view.add(scrollPanel, BorderLayout.CENTER);
    }
    private ButtonExpandFriends initExpandFriendListButton(){
        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();
        FriendManagerDsGateway dsGateway = new FriendManagerFileDsGateway();
        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();
        ShowFriendListController showFriendListController = new ShowFriendListController(orderFriendList, userStatusViewModel);

        FriendManagerInputBoundary acceptFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController acceptFriendRequestController = new SendFriendRequestController(acceptFriendRequest, userStatusViewModel);

        FriendManagerInputBoundary deleteOrDenyFriendRequest = new DeleteFriendOrDenyFriendRequest(dsGateway, presenter);
        DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController =
                new DeleteFriendOrDenyFriendRequestController(deleteOrDenyFriendRequest, userStatusViewModel);

        ButtonExpandFriends btnFriends = new ButtonExpandFriends(showFriendListController,
                acceptFriendRequestController, deleteFriendOrDenyFriendRequestController, this.width, 60);

        return btnFriends;
    }

    @Override
    public void userUpdated(){
        HashMap<String, String> userfriends = UserStatusViewModel.getInstance().getFriendList();
        this.updateView(userfriends);
    }
}