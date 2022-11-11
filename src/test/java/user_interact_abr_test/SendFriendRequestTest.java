package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.friend_manager_abr.FriendManagerRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserInteraction;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SendFriendRequestTest {

    private static final FriendManagerDsGateway users = new InMemoryUserInteraction();


    @Test
    void reactToEmptyFriendListAndNoRequestExistsBefore() {
        //Star has no friend or pending friend request; Star tries to send fr to Jae

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Jae
                assertEquals("pending_Star", users.getUserFriendList().get(users.getFriendID()));

                //check if Jae's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals("pending_Star", users.getFriendFriendList().get(users.getUserID()));

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", new HashMap<>(), new HashMap<>());

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToNonEmptyFriendListAndNoRequestExistsBefore() {
        //Star has some friends or pending friend requests; no pending friend request between Star and Jae; Star tries to send fr to Jae

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Jae
                assertEquals("pending_Star", users.getUserFriendList().get(users.getFriendID()));

                //check if Jae's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals("pending_Star", users.getFriendFriendList().get(users.getUserID()));

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Angela", "friend");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", new HashMap<>(), starFriendList);


        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromSender() { //Star sent fr to Jae before; fr is still pending; Star now tries to send again


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                assertEquals("Please do not send repeated friend request", error);

                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", jaeFriendList, starFriendList);


        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromReceiver() { //Star sent fr to Jae before; fr is still pending; Jae now tries to send fr to Star


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Jae

                assertEquals("friend", users.getFriendFriendList().get(users.getUserID()));

                //check if Jae's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals("friend", users.getUserFriendList().get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "pending_Star");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "pending_Star");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Jae", "Star", jaeFriendList, starFriendList);


        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToAlreadyFriends() { //Star and Jae are already friends; Star now tries to send fr to Jae


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                assertEquals("You are already friends with Jae", error);

                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(users, friendManagerPresenter);

        // input data
        HashMap<String, String> jaeFriendList = new HashMap<>() {{
            put("Star", "friend");
        }};
        HashMap<String, String> starFriendList = new HashMap<>() {{
            put("Jae", "friend");
        }};
        FriendManagerRequestModel inputData = new FriendManagerRequestModel("Star", "Jae", jaeFriendList, starFriendList);


        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }
}