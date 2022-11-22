package abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;

import java.util.HashMap;

public class DeleteFriendOrDenyFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerOutputBoundary friendManagerPresenter;

    public DeleteFriendOrDenyFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerOutputBoundary friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }

    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {

        HashMap<String, String> tempUserFriendList = requestModel.getUserFriendList();
        HashMap<String, String> tempFriendFriendList = userDsGateway.getFriendList(requestModel.getFriendID());

        tempUserFriendList.remove(requestModel.getFriendID());
        tempFriendFriendList.remove(requestModel.getUserID()); //update friendship status to not a friend, no key-value pair in hashmap

        //update the friendLists in user user_database & view

        userDsGateway.save(requestModel.getUserID(), requestModel.getFriendID(), tempUserFriendList, tempFriendFriendList);

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel("You are no longer friends with " + requestModel.getFriendID(), tempUserFriendList);
        return friendManagerPresenter.showMsgAndUpdatedFriendList(responseModel);
    }
}
