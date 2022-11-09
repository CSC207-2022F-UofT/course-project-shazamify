package user_interact_abr_test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class SendFriendRequestTest {

    private static FriendManagerDsGateway userFriendListRepo = new InMemoryUserFriendList();

    private void setUserFriendListRepoHelper(FriendManagerDsGateway userFriendListRepo, String userID, String friendID){
        //set up existing friend request for testing

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel(userID, friendID);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToEmptyFriendListAndNoRequestExistsBefore() {
        //Star has no friend or pending friend request; Star tries to send fr to Angela

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Angela
                assertEquals(userFriendListRepo.getFriendList("Star").get(users.getFriendID()), "pending_" + users.getUserID());

                //check if Angela's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals(userFriendListRepo.getFriendList("Angela").get(users.getUserID()), "pending_" + users.getUserID());

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Star", "Angela");

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToNonEmptyFriendListAndNoRequestExistsBefore() {
        //Star has some friends or pending friend requests; no pending friend request between Star and Millie; Star tries to send fr to Millie

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Angela
                assertEquals(userFriendListRepo.getFriendList("Star").get(users.getFriendID()), "pending_" + users.getUserID());

                //check if Angela's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals(userFriendListRepo.getFriendList("Millie").get(users.getUserID()), "pending_" + users.getUserID());

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Star", "Millie");

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromSender() { //Star sent fr to Angela before; fr is still pending; Star now tries to send again


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

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Star", "Angela");

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromReceiver() { //Star sent fr to Jae before; fr is still pending; Jae now tries to send fr to Star

        //set up: Star sent fr to Jae before; fr is still pending;
        setUserFriendListRepoHelper(userFriendListRepo, "Star", "Jae");


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if Star's friendList in friendList Repo contains proper friendship status (befriended) with Jae

                assertEquals("friend", userFriendListRepo.getFriendList("Star").get(users.getUserID()));

                //check if Jae's friendList in friendList Repo contains proper friendship status (befriended) with Star
                assertEquals("friend", userFriendListRepo.getFriendList("Jae").get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Jae", "Star");

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

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Star", "Jae");

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }
}