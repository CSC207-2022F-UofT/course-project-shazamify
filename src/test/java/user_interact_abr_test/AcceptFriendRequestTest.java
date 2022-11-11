package user_interact_abr_test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import user_interaction.user_interact_DS.FriendManagerInMemoryDsGateway;
import user_interaction.user_interact_abr.friend_manager_abr.*;

import java.util.HashMap;

class AcceptFriendRequestTest {

    private static final FriendManagerDsGateway users = new FriendManagerInMemoryDsGateway(); //using fake user DB


    @Test
    void AcceptRequest() { // Jae receives fr from Star, Jae accepts the fr


        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();

        FriendManagerInputBoundary acceptFriendRequest = new AcceptFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList, starFriendList);

        // Run the use case & check
        assertEquals("friend", acceptFriendRequest.reactTo(inputData).getFriendList().get("Star"));
        assertEquals("You are now friends with Star", acceptFriendRequest.reactTo(inputData).getMsgToDisplay());

    }

}