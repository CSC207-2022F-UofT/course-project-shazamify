package user_interact_screen;

import user_interact_abr.friend_manager_abr.FriendManagerInputBoundary;
import user_interact_abr.UserInteractRequestModel;
import user_interact_abr.friend_manager_abr.FriendManagerResponseModel;

public class FriendRequestController implements FriendManagerInputBoundary {
    @Override
    public FriendManagerResponseModel reactTo(UserInteractRequestModel friendManagerRequestModel) {
        return null;
    }
}
