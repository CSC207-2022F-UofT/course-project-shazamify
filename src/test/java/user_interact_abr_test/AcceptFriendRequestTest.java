package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class AcceptFriendRequestTest {


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

    void AcceptRequest() { // 4 receives fr from 1, 4 accepts the fr

        //set up: 1 sent fr to 4;
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


        FriendManagerInputBoundary acceptFriendRequest = new AcceptFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data

        UserInteractRequestModel inputData = new UserInteractRequestModel(4, 1);

        // Run the use case
        acceptFriendRequest.reactTo(inputData);

    }
}