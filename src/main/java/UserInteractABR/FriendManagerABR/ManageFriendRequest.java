package UserInteractABR.FriendManagerABR;

import UserInteractABR.UserInteractRequestModel;

import java.util.HashMap;

public class ManageFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerPresenter friendManagerPresenter;

    private HashMap<String, String> tempUserFriendList;
    private String userID;
    private String friendID;
    private String friendshipStatus;
    private boolean nowAdded;

    ManageFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerPresenter friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }


    @Override
    public FriendManagerResponseModel reactTo(UserInteractRequestModel requestModel) {
        userID = requestModel.getUserID();
        friendID = requestModel.getFriendID();
        tempUserFriendList = userDsGateway.getFriendList(userID);

        if (tempUserFriendList.containsKey(friendID)){
            friendshipStatus = tempUserFriendList.get(friendID);

            //either userID is already friends with friendID, or there exists pending friend request between them
            if (friendshipStatus == "friend"){
                return FriendManagerPresenter.prepareFailView("You are already friends with " + friendID);
            } else if (friendshipStatus == "pending_" + userID) { // userID have sent friend request to friendID before
                return FriendManagerPresenter.prepareFailView("Please do not send repeated friend request");
            } else { //case 1: friendshipStatus == "pending_" + friendID, friendID have sent friend request to userID before
                tempUserFriendList.put(friendID, "friend"); // let them be friend, update friendship status
            }

        } else { // case 2: not a friend, create new friend request
            tempUserFriendList.put(friendID, "pending_" + userID);

        }

        //either case 1 or case 2, we update the friendList in user database & view

        FriendManagerDsRequestModel userDsModel = new FriendManagerDsRequestModel(userID, friendID, tempUserFriendList);
        userDsGateway.save(userDsModel); // store friend request in both user & friend's friendLists

        FriendManagerResponseModel accountResponseModel = new FriendManagerResponseModel(userID);
        return FriendManagerPresenter.prepareSuccessView(FriendManagerResponseModel);
    }

}
