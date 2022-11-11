package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteFriendOrDenyFriendRequestTest {

    private static final FriendManagerDsGateway userFriendListRepo = new InMemoryUserFriendList();

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
    void reactToDenyFriendRequest() {// Jae receives fr from Star, Jae denies the fr

        //set up: Star sent fr to Jae;
        setUserFriendListRepoHelper(userFriendListRepo, "Star", "Jae");

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //Star's friendList in friendList Repo should not contain Jae
                assertNull(userFriendListRepo.getFriendList("Star").get(users.getUserID()));


                //Jae's friendList in friendList Repo should not contain Star
                assertNull(userFriendListRepo.getFriendList("Jae").get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary denyFriendRequest = new DeleteFriendOrDenyFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Jae", "Star");

        // Run the use case
        denyFriendRequest.reactTo(inputData);


    }

    @Test
    void reactToDeleteFriend() {// Jae and Star are friends, Jae deletes Star from friendList

        //set up: Jae and Star are friends;
        setUserFriendListRepoHelper(userFriendListRepo, "Star", "Jae");
        setUserFriendListRepoHelper(userFriendListRepo, "Jae", "Star");

        FriendManagerPresenter friendManagerPresenter = new FriendManagerPresenter() {
            @Override
            public FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users) {
                //Star's friendList in friendList Repo should not contain Jae
                assertNull(userFriendListRepo.getFriendList("Star").get(users.getUserID()));


                //Jae's friendList in friendList Repo should not contain Star
                assertNull(userFriendListRepo.getFriendList("Jae").get(users.getFriendID()));
                return null;
            }

            @Override
            public FriendManagerResponseModel prepareFailView(String error) {
                return null;
            }
        };


        FriendManagerInputBoundary deleteFriend = new DeleteFriendOrDenyFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Jae", "Star");

        // Run the use case
        deleteFriend.reactTo(inputData);


    }
}