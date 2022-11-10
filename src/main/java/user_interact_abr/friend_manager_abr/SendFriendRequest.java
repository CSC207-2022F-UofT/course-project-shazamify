package user_interact_abr.friend_manager_abr;

import user_interact_abr.UserInteractRequestModel;

import java.util.HashMap;
import java.util.Objects;

public class SendFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerPresenter friendManagerPresenter;

    FriendRequestManager friendRequestManager;


    public SendFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerPresenter friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }


    @Override
    public FriendManagerResponseModel reactTo(UserInteractRequestModel requestModel) {
        friendRequestManager = new FriendRequestManager(requestModel);

        if (friendRequestManager.handleFriendRequest() == 1){
            return friendManagerPresenter.prepareFailView("You are already friends with " + friendRequestManager.getFriendID());
        } else if (friendRequestManager.handleFriendRequest() == 2) {
            return friendManagerPresenter.prepareFailView("Please do not send repeated friend request");
        }

        // no early returns means actionNum == 0 / 3, in either case friendLists are updated
        // create DsRequestModel and save updated friendLists
        FriendManagerDsRequestModel userDsModel = new FriendManagerDsRequestModel(
                friendRequestManager.getUserID(),
                friendRequestManager.getFriendID(),
                friendRequestManager.getTempUserFriendList(),
                friendRequestManager.getTempFriendFriendList());
        userDsGateway.save(userDsModel);

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel(friendRequestManager.getUserID(), friendRequestManager.getFriendID());
        return friendManagerPresenter.prepareSuccessView(responseModel);

    }

    //refactoring long method reactTo() by creating method object
    class FriendRequestManager{

        int userID;
        int friendID;
        HashMap<Integer, String> tempUserFriendList;
        HashMap<Integer, String> tempFriendFriendList;

        String friendshipStatus;
        private int actionNum; // 0: friendshipStatus in friendList needs update (to add pending fr from userID)
                    // 1: friendID and userID are already friends
                    // 2: userID have sent fr to friendID before, still pending
                    // 3: friendshipStatus in friendList needs update (to become friends)

        FriendRequestManager(UserInteractRequestModel requestModel){
            this.userID = requestModel.getUserID();
            this.friendID = requestModel.getFriendID();
            this.tempUserFriendList = userDsGateway.getFriendList(userID);
            this.tempFriendFriendList = userDsGateway.getFriendList(friendID);
            this.friendshipStatus = tempUserFriendList.get(friendID);
        }

        int handleFriendRequest(){
            //check if there is pending / existed friendship between userID and friendID
            if (friendshipStatus != null){
                handleExistedFriendshipStatus();
            } else {
                handleNewFriendshipStatus();
            }
            return actionNum;
        }

        void changeFriendList(){
            if (actionNum == 0){
                //no friendshipStatus between userID and friendID, create new pending friend request
                tempUserFriendList.put(friendID, "pending_" + userID);
                tempFriendFriendList.put(userID, "pending_" + userID);
            } else { //actionNum == 3, both userID and friendID try to be friends, change friendList for both
                tempUserFriendList.put(friendID, "friend");
                tempFriendFriendList.put(userID, "friend");
            }

        }

        void handleExistedFriendshipStatus(){
            // decide actNum given friendshipStatus: pending friend request exists / already friends
            if (Objects.equals(friendshipStatus, "friend")) {
                actionNum = 1;
            } else if (Objects.equals(friendshipStatus, "pending_" + userID)) {
                actionNum = 2;
            } else {
                actionNum = 3;
                changeFriendList();
            }
        }

        void handleNewFriendshipStatus(){
            // not a friend (actionNum == 0), calls changeFriendList() to create new friend request
            changeFriendList();
        }


        HashMap<Integer, String> getTempFriendFriendList(){
            return tempFriendFriendList;
        }

        HashMap<Integer, String> getTempUserFriendList(){
            return tempUserFriendList;
        }

        int getFriendID(){
            return friendID;
        }

        int getUserID(){

            return userID;
        }

    }


}
