package interface_adaptors.user_interact_ia;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;

import java.util.HashMap;

public class DeleteFriendOrDenyFriendRequestController implements FriendListObserver{
    FriendManagerInputBoundary inputBoundary;
    HashMap<String, String> tempFriendList;

    public DeleteFriendOrDenyFriendRequestController(FriendManagerInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
        TempFriendListObservable.addObserver(this);
    }

    public FriendManagerResponseModel reactTo(String friendID){
        FriendManagerRequestModel requestModel = new FriendManagerRequestModel(TempFriendListObservable.currentUser,
                friendID, tempFriendList);
        return inputBoundary.reactTo(requestModel);
    }

    @Override
    public void updateTempFriendList(HashMap<String, String> tempFriendList) {
        this.tempFriendList = tempFriendList;
    }
}
