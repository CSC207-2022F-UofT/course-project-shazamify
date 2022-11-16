package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interaction.user_interact_DS.FriendManagerInMemoryDsGateway;
import user_interaction.user_interact_abr.manage_friend_request_abr.*;
import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;
import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import user_interaction.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFriendOrDenyFriendRequestTest {

    private static final FriendManagerDsGateway users = new FriendManagerInMemoryDsGateway(); //using fake user DB


    @Test
    void reactToDenyFriendRequest() {// Jae receives fr from Star, Jae denies the fr


        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();


        FriendManagerInputBoundary denyFriendRequest = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};

        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList);

        // Run the use case
        denyFriendRequest.reactTo(inputData);

        //Jae's friendList in friendList Repo should not contain Star
        assertNull(users.getFriendList("Jae").get("Star"));


    }

    @Test
    void reactToDeleteFriend() {// Jae and Star are friends, Jae deletes Star from friendList

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();


        FriendManagerInputBoundary deleteFriend = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "friend");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "friend");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList);

        // Run the use case
        deleteFriend.reactTo(inputData);


    }
}