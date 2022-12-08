package user_interact_view_showcase;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerPresenter;
import ds.user_database.UserFileReader;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import framework.user_interact_screen.friend_manager_screen.SendFriendRequestView;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_interact_ia.TempFriendListObservable;

import javax.swing.*;
import java.awt.*;

/**
 * not connected to user search yet
 */
public class SendFriendRequestViewShowcase {

    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Send Friend Request Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case
        FriendManagerDsGateway dsGateway = new FriendManagerFileDsGateway();

        FriendManagerOutputBoundary presenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController controller = new SendFriendRequestController(sendFriendRequest);

        // Build the GUI, plugging in the parts
        SendFriendRequestView screen = new SendFriendRequestView(controller);

        TempFriendListObservable.setFriendList(UserFileReader.getUserMap("UserDatabase.ser").get("Star").getFriendList());

    }
}
