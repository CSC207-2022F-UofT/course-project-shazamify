package user_interact_view_showcase;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerPresenter;
import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.CommonUser;
import entities.user_entities.User;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import ds.user_interact_ds.FriendManagerInMemoryDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import framework.user_interact_screen.friend_manager_screen.SendFriendRequestView;
import interface_adaptors.user_interact_ia.SendFriendRequestController;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * TBC, not ready, don't run yet
 */
public class SendFriendRequestViewShowcase {

    public static void main(String[] args) {

        // put in some users
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        FriendManagerFileDsGateway.clearDatabase();

        User newUser1 = new CommonUser("Star", "ababab");
        User newUser2 = new CommonUser("Jae", "ababab");

        userMap.put("Star", newUser1);
        userMap.put("Jae", newUser2);

        UserFileWriter.writeUserMap(userMap,"UserDatabase.ser");

        // Build the main program window
        JFrame application = new JFrame("Send Friend Request Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case
        FriendManagerDsGateway dsGateway = new FriendManagerInMemoryDsGateway();

        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController controller = new SendFriendRequestController(sendFriendRequest);

        // Build the GUI, plugging in the parts
        SendFriendRequestView screen = new SendFriendRequestView(controller);

        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }
}
