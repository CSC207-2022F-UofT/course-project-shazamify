package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.friend_manager_abr.FriendManagerRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserInteraction;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFriendOrDenyFriendRequestTest {

    private static final FriendManagerDsGateway users = new InMemoryUserInteraction(); //using fake user DB


    @Test
    void reactToDenyFriendRequest() {// Jae receives fr from Star, Jae denies the fr


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //Star's friendList in friendList Repo should not contain Jae
                assertNull(users.getFriendFriendList().get(users.getUserID()));


                //Jae's friendList in friendList Repo should not contain Star
                assertNull(users.getUserFriendList().get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary denyFriendRequest = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList, starFriendList);

        // Run the use case
        denyFriendRequest.reactTo(inputData);


    }

    @Test
    void reactToDeleteFriend() {// Jae and Star are friends, Jae deletes Star from friendList

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //Star's friendList in friendList Repo should not contain Jae
                assertNull(users.getFriendFriendList().get(users.getUserID()));


                //Jae's friendList in friendList Repo should not contain Star
                assertNull(users.getUserFriendList().get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary deleteFriend = new DeleteFriendOrDenyFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "friend");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "friend");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList, starFriendList);

        // Run the use case
        deleteFriend.reactTo(inputData);


    }
}