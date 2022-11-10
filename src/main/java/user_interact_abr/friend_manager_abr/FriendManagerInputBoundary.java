package user_interact_abr.friend_manager_abr;

import user_interact_abr.UserInteractRequestModel;

public interface FriendManagerInputBoundary {
    FriendManagerResponseModel reactTo(UserInteractRequestModel friendManagerRequestModel);
}
