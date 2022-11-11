package user_interaction;

import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.CommonUser;
import user.entities.User;
import user_interaction.user_interact_DS.FriendManagerFileDsGateway;
import user_interaction.user_interact_abr.friend_manager_abr.*;
import user_interaction.user_interact_screen.friend_manager_screen.SendFriendRequestView;
import user_interaction.user_interact_screen.friend_manager_screen.SendFriendRequestController;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Main {

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
        FriendManagerFileDsGateway dsGateway = new FriendManagerFileDsGateway();

        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController controller = new SendFriendRequestController(sendFriendRequest, dsGateway);

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
