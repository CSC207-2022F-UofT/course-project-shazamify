package user_interact_screen;

import user_interact_abr.friend_manager_abr.FriendManagerInputBoundary;
import user_interact_abr.friend_manager_abr.FriendManagerRequestModel;
import user_interact_abr.friend_manager_abr.FriendManagerResponseModel;

public class SendFriendRequestController implements FriendManagerInputBoundary {
    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel friendManagerRequestModel) {
        return null;
    }
}
