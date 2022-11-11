package user_interact_abr_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user_interact_abr.friend_manager_abr.FriendManagerRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserInteraction;

import java.util.HashMap;

class AcceptFriendRequestTest {

    private static final FriendManagerDsGateway users = new InMemoryUserInteraction(); //using fake user DB


    @Test
    void AcceptRequest() { // Jae receives fr from Star, Jae accepts the fr


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Jae

                Assertions.assertEquals("friend", users.getFriendFriendList().get(users.getUserID())); //

                //check if Jae's friendList in friendList Repo contains proper friendship status (befriended) with Star
                Assertions.assertEquals("friend", users.getUserFriendList().get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary acceptFriendRequest = new AcceptFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList, starFriendList);

        // Run the use case
        acceptFriendRequest.reactTo(inputData);

    }

}