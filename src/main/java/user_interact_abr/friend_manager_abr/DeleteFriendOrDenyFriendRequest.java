package user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class DeleteFriendOrDenyFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerPresenter friendManagerPresenter;

    public DeleteFriendOrDenyFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerPresenter friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }

    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {
        String userID = requestModel.getUserID();
        String friendID = requestModel.getFriendID();
        HashMap<String, String> tempUserFriendList = requestModel.getUserFriendList();
        HashMap<String, String> tempFriendFriendList = requestModel.getFriendFriendList();

        tempUserFriendList.remove(friendID);
        tempFriendFriendList.remove(userID); //update friendship status to not a friend, no key-value pair in hashmap

        //update the friendLists in user database & view

        FriendManagerDsRequestModel userDsModel = new FriendManagerDsRequestModel(userID, friendID, tempUserFriendList, tempFriendFriendList);
        userDsGateway.save(userDsModel); // store friend request in both user & friend's friendLists

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel(userID, friendID, tempUserFriendList, tempFriendFriendList);
        return friendManagerPresenter.prepareSuccessView(responseModel);
    }
}
