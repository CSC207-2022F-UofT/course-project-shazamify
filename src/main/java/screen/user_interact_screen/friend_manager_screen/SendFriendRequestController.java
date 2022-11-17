package screen.user_interact_screen.friend_manager_screen;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerInputBoundary;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;
import abr.user_interact_abr.manage_friend_request_abr.FriendManagerResponseModel;

import java.util.HashMap;

public class SendFriendRequestController implements FriendListObserver{
    FriendManagerInputBoundary inputBoundary;
    HashMap<String, String> tempFriendList;

    public SendFriendRequestController(FriendManagerInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
        TempFriendListObservable.addObserver(this);
    }

    FriendManagerResponseModel reactTo(String friendID){
        FriendManagerRequestModel requestModel = new FriendManagerRequestModel(TempFriendListObservable.currentUser,
                friendID, tempFriendList);
        return inputBoundary.reactTo(requestModel);
    }

    @Override
    public void updateTempFriendList(HashMap<String, String> tempFriendList) {
        this.tempFriendList = tempFriendList;
    }
}
