package user_interact_abr.friend_manager_abr;

import user_interact_abr.UserInteractRequestModel;

import java.util.HashMap;
import java.util.Objects;

public class SendFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerPresenter friendManagerPresenter;

    public SendFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerPresenter friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }


    @Override
    public FriendManagerResponseModel reactTo(UserInteractRequestModel requestModel) {
        String userID = requestModel.getUserID();
        String friendID = requestModel.getFriendID();
        HashMap<String, String> tempUserFriendList = userDsGateway.getFriendList(userID);
        HashMap<String, String> tempFriendFriendList = userDsGateway.getFriendList(friendID);

        if (tempUserFriendList.containsKey(friendID)){
            String friendshipStatus = tempUserFriendList.get(friendID);

            //either userID is already friends with friendID, or there exists pending friend request between them
            if (Objects.equals(friendshipStatus, "friend")){
                return friendManagerPresenter.prepareFailView("You are already friends with " + friendID);
            } else if (Objects.equals(friendshipStatus, "pending_" + userID)) { // userID have sent friend request to friendID before
                return friendManagerPresenter.prepareFailView("Please do not send repeated friend request");
            } else { //case 1: friendshipStatus == "pending_" + friendID, friendID have sent friend request to userID before
                tempUserFriendList.put(friendID, "friend");
                tempFriendFriendList.put(userID, "friend"); // let them be friends, update friendship status
            }

        } else { // case 2: not a friend, create new friend request
            tempUserFriendList.put(friendID, "pending_" + userID);
            tempFriendFriendList.put(userID, "pending_" + userID);

        }

        //either case 1 or case 2, we update the friendLists in user database & view

        FriendManagerDsRequestModel userDsModel = new FriendManagerDsRequestModel(userID, friendID, tempUserFriendList, tempFriendFriendList);
        userDsGateway.save(userDsModel); // store friend request in both user & friend's friendLists

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel(userID, friendID);
        return friendManagerPresenter.prepareSuccessView(responseModel);
    }


}
