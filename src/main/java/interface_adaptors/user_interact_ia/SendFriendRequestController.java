package interface_adaptors.user_interact_ia;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;
import interface_adaptors.user_login_ia.UserStatusObserver;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import java.util.HashMap;

public class SendFriendRequestController{
    FriendManagerInputBoundary inputBoundary;
    UserStatusViewModel userStatusViewModel;


    public SendFriendRequestController(FriendManagerInputBoundary inputBoundary, UserStatusViewModel userStatusViewModel) {
        this.inputBoundary = inputBoundary;
        this.userStatusViewModel = userStatusViewModel;
    }
    /**
     * @param friendID friend's user name
     * @return a FriendManagerResponseModel that contains a msg to display on screen and an updated user's friendList
     */
    public FriendManagerResponseModel reactTo(String friendID){
        FriendManagerRequestModel requestModel = new FriendManagerRequestModel(userStatusViewModel.getUserName(),
                friendID, userStatusViewModel.getFriendList());
        FriendManagerResponseModel responseModel = inputBoundary.reactTo(requestModel);
        userStatusViewModel.updateFriendList(responseModel.getFriendList());
        return responseModel;
    }

}
