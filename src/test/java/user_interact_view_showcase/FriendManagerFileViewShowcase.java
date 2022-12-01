package user_interact_view_showcase;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerPresenter;
import abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import abr.user_interact_abr.show_friend_list_abr.OrderFriendList;
import abr.user_interact_abr.show_friend_list_abr.OrderFriendListInputBoundary;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import entities.user_entities.CommonUser;
import entities.user_entities.User;
import framework.user_interact_screen.friend_manager_screen.FriendListView;
import interface_adaptors.user_interact_ia.DeleteFriendOrDenyFriendRequestController;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.ShowFriendListController;
import interface_adaptors.user_interact_ia.TempFriendListObservable;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FriendManagerFileViewShowcase { // for presentation demo only
    public static void main(String[] args) {
        // put in some users, the methods used should only be called by user registration, it's only here for testing purposes
        //FriendManagerFileDsGateway.clearDatabase();
        //userDBSetup();

        // Build the main program window
        JFrame application = new JFrame("Send Friend Request Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        TempFriendListObservable.setCurrentUser("Star");

        // Create the parts to plug into the Use Case
        FriendManagerDsGateway dsGateway = new FriendManagerFileDsGateway();
        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        OrderFriendListInputBoundary orderFriendList = new OrderFriendList();
        ShowFriendListController showFriendListController = new ShowFriendListController(orderFriendList);

        FriendManagerInputBoundary acceptFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController acceptFriendRequestController = new SendFriendRequestController(acceptFriendRequest);

        FriendManagerInputBoundary deleteOrDenyFriendRequest = new DeleteFriendOrDenyFriendRequest(dsGateway, presenter);
        DeleteFriendOrDenyFriendRequestController deleteFriendOrDenyFriendRequestController = new DeleteFriendOrDenyFriendRequestController(deleteOrDenyFriendRequest);

        // setup users & friendLists in user DB, the methods used should only be called by user registration, it's only here for testing purposes

        //userFriendListSetup(dsGateway);
        TempFriendListObservable.setFriendList(UserFileReader.getUserMap("UserDatabase.ser").get("Star").getFriendList());

        // Build the GUI, plugging in the parts
        FriendListView screen = new FriendListView(showFriendListController, acceptFriendRequestController, deleteFriendOrDenyFriendRequestController);

    }

    private static void userDBSetup(){
        // add some users to user DB
        Map<String, User> userMap = new HashMap<>();
        User newUser1 = new CommonUser("Star", "ababab");
        User newUser2 = new CommonUser("Jae", "ababab");
        User newUser3 = new CommonUser("Angela", "abababa");
        User newUser4 = new CommonUser("Millie", "abababa");
        User newUser5 = new CommonUser("Mike", "abababa");
        userMap.put("Star", newUser1);
        userMap.put("Jae", newUser2);
        userMap.put("Angela", newUser3);
        userMap.put("Millie", newUser4);
        userMap.put("Mike", newUser5);
        UserFileWriter.writeUserMap(userMap,"UserDatabase.ser");
    }

    private static void userFriendListSetup(FriendManagerDsGateway dsGateway){
        // add some friends to Star's friendList
        HashMap<String, String> starFriendList = new HashMap<>();
        starFriendList.put("Jae", "pending_Jae");
        starFriendList.put("Millie", "pending_Millie");
        starFriendList.put("Mike", "pending_Mike");
        starFriendList.put("Angela", "friend");

        // add the friendLists of Star, Angela & Jae to the fake user DB
        HashMap<String, String> jaeFriendList = new HashMap<>();
        jaeFriendList.put("Star", "pending_Jae");

        HashMap<String, String> angelaFriendList = new HashMap<>();
        angelaFriendList.put("Star", "friend");

        HashMap<String, String> mikeFriendList = new HashMap<>();
        mikeFriendList.put("Star", "pending_Mike");

        HashMap<String, String> millieFriendList = new HashMap<>();
        millieFriendList.put("Star", "pending_Millie");

        dsGateway.save("Star", "Jae", starFriendList, jaeFriendList);
        dsGateway.save("Star", "Angela", starFriendList, angelaFriendList);
        dsGateway.save("Star", "Mike", starFriendList, mikeFriendList);
        dsGateway.save("Star", "Millie", starFriendList, millieFriendList);
    }



}
