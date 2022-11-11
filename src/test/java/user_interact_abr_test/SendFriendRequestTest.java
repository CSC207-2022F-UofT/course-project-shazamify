package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class SendFriendRequestTest {

    private static final FriendManagerDsGateway userFriendListRepo = new InMemoryUserFriendList();

    private void setUserFriendListRepoHelper(FriendManagerDsGateway userFriendListRepo, int userID, int friendID){
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
        //1 has no friend or pending friend request; 01 tries to send fr to 2

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if 1's friendList in friendList Repo contains proper friendship status (befriended) with 2
                assertEquals(userFriendListRepo.getFriendList(1).get(users.getFriendID()), "pending_" + users.getUserID());

                //check if 2's friendList in friendList Repo contains proper friendship status (befriended) with 1
                assertEquals(userFriendListRepo.getFriendList(2).get(users.getUserID()), "pending_" + users.getUserID());

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
        UserInteractRequestModel inputData = new UserInteractRequestModel(1, 2);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToNonEmptyFriendListAndNoRequestExistsBefore() {
        //1 has some friends or pending friend requests; no pending friend request between 1 and 3; 1 tries to send fr to 3

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if 1's friendList in friendList Repo contains proper friendship status (befriended) with 3
                assertEquals(userFriendListRepo.getFriendList(1).get(users.getFriendID()), "pending_" + users.getUserID());

                //check if 3's friendList in friendList Repo contains proper friendship status (befriended) with 1
                assertEquals(userFriendListRepo.getFriendList(3).get(users.getUserID()), "pending_" + users.getUserID());

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
        UserInteractRequestModel inputData = new UserInteractRequestModel(1, 3);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromSender() { //1 sent fr to 2 before; fr is still pending; 1 now tries to send again


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
        UserInteractRequestModel inputData = new UserInteractRequestModel(1, 2);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToExistedRequestFromReceiver() { //1 sent fr to 4 before; fr is still pending; 4 now tries to send fr to 1

        //set up: 1 sent fr to 4 before; fr is still pending;
        setUserFriendListRepoHelper(userFriendListRepo, 1, 4);


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //check if 1's friendList in friendList Repo contains proper friendship status (befriended) with 4

                assertEquals("friend", userFriendListRepo.getFriendList(1).get(users.getUserID()));

                //check if 4's friendList in friendList Repo contains proper friendship status (befriended) with 1
                assertEquals("friend", userFriendListRepo.getFriendList(4).get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel(4, 1);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }

    @Test
    void reactToAlreadyFriends() { //1 and 4 are already friends; 1 now tries to send fr to 4


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                assertEquals("You are already friends with " + 4, error);

                return null;
            }
        };

        FriendManagerInputBoundary sendFriendRequest = new SendFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel(1, 4);

        // Run the use case
        sendFriendRequest.reactTo(inputData);

    }
}