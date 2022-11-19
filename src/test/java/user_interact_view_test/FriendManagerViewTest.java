package user_interact_view_test;

import user_interaction.user_interact_DS.FriendManagerInMemoryDsGateway;
import user_interaction.user_interact_abr.manage_friend_request_abr.*;
import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import user_interaction.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import user_interaction.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;
import user_interaction.user_interact_abr.show_friend_list_abr.OrderFriendList;
import user_interaction.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;
import user_interaction.user_interact_screen.friend_manager_screen.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class FriendManagerViewTest { //tests FriendListView, AcceptOrDenyFriendRequestView & FriendProfileView

    public static void main(String[] args) {
        // Build the main program window
        JFrame application = new JFrame("Send Friend Request Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        //clean the observers that no longer needs update
        TempFriendListObservable.setCurrentUser("Star");

        // Create the parts to plug into the Use Case
        FriendManagerDsGateway dsGateway = new FriendManagerInMemoryDsGateway();
        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();
        ShowFriendListController showFriendListController = new ShowFriendListController(orderFriendList);

        FriendManagerInputBoundary acceptFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController acceptFriendRequestController = new SendFriendRequestController(acceptFriendRequest);

        FriendManagerInputBoundary deleteOrDenyFriendRequest = new DeleteFriendOrDenyFriendRequest(dsGateway, presenter);
        DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController = new DeleteFriendOrDenyFriendRequestController(deleteOrDenyFriendRequest);

        //setup users & friendLists in memory
        TempFriendListObservable.setFriendList(userSetUp());
        userDataBaseSetup(dsGateway);


        // Build the GUI, plugging in the parts
        FriendListView screen = new FriendListView(showFriendListController, acceptFriendRequestController, deleteFriendOrDenyFriendRequestController);

    }


    private static HashMap<String, String> userSetUp(){
        // add some friends to Star's friendList
        HashMap<String, String> starFriendList = new HashMap<>();
        starFriendList.put("Jae", "pending_Jae");
        starFriendList.put("Angela", "friend");
        return starFriendList;
    }

    private static void userDataBaseSetup(FriendManagerDsGateway dsGateway){
        // add the friendLists of Star, Angela & Jae to the fake database
        HashMap<String, String> jaeFriendList = new HashMap<>();
        jaeFriendList.put("Star", "pending_Jae");

        HashMap<String, String> angelaFriendList = new HashMap<>();
        angelaFriendList.put("Star", "friend");

        dsGateway.save("Star", "Jae", userSetUp(), jaeFriendList);
        dsGateway.save("Star", "Angela", userSetUp(), angelaFriendList);
    }
}