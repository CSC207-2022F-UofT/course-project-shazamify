package screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.deleting_attempt_abr;

import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;
import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.FriendManagerOutputBoundary;

import java.util.HashMap;

public class DeleteFriendOrDenyFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerOutputBoundary friendManagerPresenter;

    public DeleteFriendOrDenyFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerOutputBoundary friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }

    /**
     * @param requestModel the input data containing user's ID (username), friend's ID and user's friendList
     * @return a FriendManagerResponseModel that contains a msg to display on screen and an updated user's friendList
     */
    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {

        HashMap<String, String> tempUserFriendList = requestModel.getUserFriendList();
        HashMap<String, String> tempFriendFriendList = userDsGateway.getFriendList(requestModel.getFriendID());

        tempUserFriendList.remove(requestModel.getFriendID());
        tempFriendFriendList.remove(requestModel.getUserID()); //update friendship status to not a friend, no key-value pair in hashmap

        //update the friendLists in user user_database & view

        userDsGateway.save(requestModel.getUserID(), requestModel.getFriendID(), tempUserFriendList, tempFriendFriendList);

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel("Deleted/Denied successfully", tempUserFriendList);
        return friendManagerPresenter.showMsgAndUpdatedFriendList(responseModel);
    }
}
