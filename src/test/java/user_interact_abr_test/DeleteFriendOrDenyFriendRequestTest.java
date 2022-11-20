package user_interact_abr_test;

import abr.user_interact_abr.manage_friend_request_abr.*;
import org.junit.jupiter.api.Test;
import ds.user_interact_DS.FriendManagerInMemoryDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr.DeleteFriendOrDenyFriendRequest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFriendOrDenyFriendRequestTest {

    private static final FriendManagerDsGateway users = new FriendManagerInMemoryDsGateway(); //using fake user DB


    @Test
    void reactToDenyFriendRequest() {// Jae receives fr from Star, Jae denies the fr

        // set up pending friend relationship in ds
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        users.save("Jae", "Star", jaeFriendList, starFriendList);


        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();
        FriendManagerInputBoundary denyFriendRequest = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList);

        // Run the use case
        denyFriendRequest.reactTo(inputData);

        //Jae's friendList in friendList Repo should not contain Star and vice versa
        assertNull(users.getFriendList("Jae").get("Star"));
        assertNull(users.getFriendList("Star").get("Jae"));

    }

    @Test
    void reactToDeleteFriend() {// Jae and Star are friends, Jae deletes Star from friendList

        // set up friend relationship in ds
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "friend");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "friend");
        }};

        users.save("Jae", "Star", jaeFriendList, starFriendList);

        FriendManagerOutputBoundary friendManagerPresenter = new FriendManagerPresenter();
        FriendManagerInputBoundary deleteFriend = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList);

        // Run the use case
        deleteFriend.reactTo(inputData);

        //Jae's friendList in friendList Repo should not contain Star and vice versa
        assertNull(users.getFriendList("Jae").get("Star"));
        assertNull(users.getFriendList("Star").get("Jae"));

    }
}