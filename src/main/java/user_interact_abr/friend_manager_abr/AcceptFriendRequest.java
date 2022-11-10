package user_interact_abr.friend_manager_abr;

import user_interact_abr.UserInteractRequestModel;

import java.util.HashMap;

public class AcceptFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerPresenter friendManagerPresenter;


    public AcceptFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerPresenter friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }

    @Override
    public FriendManagerResponseModel reactTo(UserInteractRequestModel requestModel) {
        int userID = requestModel.getUserID();
        int friendID = requestModel.getFriendID();
        HashMap<Integer, String> tempUserFriendList = userDsGateway.getFriendList(userID);
        HashMap<Integer, String> tempFriendFriendList = userDsGateway.getFriendList(friendID);

        tempUserFriendList.put(friendID, "friend");
        tempFriendFriendList.put(userID, "friend"); // let them be friends, update friendship status

        //update the friendLists in user database & view

        FriendManagerDsRequestModel userDsModel = new FriendManagerDsRequestModel(userID, friendID, tempUserFriendList, tempFriendFriendList);
        userDsGateway.save(userDsModel); // store friend request in both user & friend's friendLists

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel(userID, friendID);
        return friendManagerPresenter.prepareSuccessView(responseModel);
    }
}
