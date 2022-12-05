package user_interact_view_showcase;

import abr.user_interact_abr.manage_friend_request_abr.*;
import abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.SendFriendRequest;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import framework.user_interact_screen.friend_manager_screen.SendFriendRequestView;
import interface_adaptors.user_interact_ia.SendFriendRequestController;
import interface_adaptors.user_login_ia.UserStatusViewModel;

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
        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();
        userStatusViewModel.setUserName("Star");
        userStatusViewModel.updateFriendList(dsGateway.getFriendList("Star"));

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(dsGateway, presenter);
        SendFriendRequestController controller = new SendFriendRequestController(sendFriendRequest, userStatusViewModel);

        // Build the GUI, plugging in the parts
        SendFriendRequestView screen = new SendFriendRequestView(controller);

    }
}
