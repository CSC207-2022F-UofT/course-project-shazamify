package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interaction.user_interact_DS.FriendManagerInMemoryDsGateway;
import user_interaction.user_interact_abr.manage_friend_request_abr.*;
import user_interaction.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SendFriendRequestTest {

    private static final FriendManagerDsGateway users = new FriendManagerInMemoryDsGateway();


    @Test
    void reactToNoRequestExistsBefore() {
        //Star has no friend or pending friend request; Star tries to send fr to Jae

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", new HashMap<>());

        // Run the use case
        FriendManagerResponseModel responseModel = sendFriendRequest.reactTo(inputData);
        assertEquals("pending_Star", responseModel.getFriendList().get("Jae"));
        assertEquals("Friend request sent", responseModel.getMsgToDisplay());
    }

    @Test
    void reactToExistedRequestFromSender() { //Star sent fr to Jae before; fr is still pending; Star now tries to send again

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", starFriendList);


        // Run the use case
        FriendManagerResponseModel responseModel = sendFriendRequest.reactTo(inputData);
        assertEquals("pending_Star", responseModel.getFriendList().get("Jae"));
        assertEquals("Please do not send repeated friend request", responseModel.getMsgToDisplay());

    }

    @Test
    void reactToExistedRequestFromReceiver() { //Star sent fr to Jae before; fr is still pending; Jae now tries to send fr to Star

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList);


        // Run the use case
        FriendManagerResponseModel responseModel = sendFriendRequest.reactTo(inputData);
        assertEquals("friend", responseModel.getFriendList().get("Star"));
        assertEquals("You are now friends with Star", responseModel.getMsgToDisplay());

    }

    @Test
    void reactToAlreadyFriends() { //Star and Jae are already friends; Star now tries to send fr to Jae

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "friend");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", starFriendList);



        // Run the use case
        FriendManagerResponseModel responseModel = sendFriendRequest.reactTo(inputData);
        assertEquals("friend", responseModel.getFriendList().get("Jae"));
        assertEquals("You are already friends with Jae", responseModel.getMsgToDisplay());

    }
}