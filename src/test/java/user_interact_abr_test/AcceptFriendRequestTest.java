package user_interact_abr_test;

import org.junit.jupiter.api.Test;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.*;
import user_interact_screen.InMemoryUserFriendList;

import static org.junit.jupiter.api.Assertions.*;

class AcceptFriendRequestTest {

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
    void AcceptRequest() { // Jae receives fr from Star, Jae accepts the fr

        //set up: Star sent fr to Jae;
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


        FriendManagerInputBoundary acceptFriendRequest = new AcceptFriendRequest(userFriendListRepo, friendManagerPresenter);

        // input data
        UserInteractRequestModel inputData = new UserInteractRequestModel("Jae", "Star");

        // Run the use case
        acceptFriendRequest.reactTo(inputData);

    }
}