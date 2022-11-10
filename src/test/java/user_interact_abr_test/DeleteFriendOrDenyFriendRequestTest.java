package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFriendOrDenyFriendRequestTest {


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

    void reactToDenyFriendRequest() {// 4 receives fr from 1, 4 denies the fr

        //set up: 1 sent fr to 4;
        setUserFriendListRepoHelper(userFriendListRepo, 1, 4);


        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {

                //1's friendList in friendList Repo should not contain 4
                assertNull(userFriendListRepo.getFriendList(1).get(users.getUserID()));


                //4's friendList in friendList Repo should not contain 1
                assertNull(userFriendListRepo.getFriendList(4).get(users.getFriendID()));

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary denyFriendRequest = new DeleteFriendOrDenyFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data

        UserInteractRequestModel inputData = new UserInteractRequestModel(4, 1);


        // Run the use case
        denyFriendRequest.reactTo(inputData);


    }

    @Test
    void reactToDeleteFriend() {// 4 and 1 are friends, 4 deletes 1 from friendList

        //set up: 4 and 1 are friends;

        setUserFriendListRepoHelper(userFriendListRepo, 1, 4);
        setUserFriendListRepoHelper(userFriendListRepo, 4, 1);

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {

                //1's friendList in friendList Repo should not contain 4
                assertNull(userFriendListRepo.getFriendList(1).get(users.getUserID()));


                //4's friendList in friendList Repo should not contain 1
                assertNull(userFriendListRepo.getFriendList(4).get(users.getFriendID()));

                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary deleteFriend = new DeleteFriendOrDenyFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data

        UserInteractRequestModel inputData = new UserInteractRequestModel(4, 1);


        // Run the use case
        deleteFriend.reactTo(inputData);


    }
}