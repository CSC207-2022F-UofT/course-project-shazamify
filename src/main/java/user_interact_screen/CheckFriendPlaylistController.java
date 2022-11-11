package user_interact_screen;


import user_interact_abr.friend_playlist_interact_abr.CheckFriendPlaylistInputBoundary;
import user_interact_abr.friend_playlist_interact_abr.CheckFriendPlaylistResponseModel;
import user_interact_abr.friend_manager_abr.FriendManagerRequestModel;


public class CheckFriendPlaylistController implements CheckFriendPlaylistInputBoundary {


    @Override
    public CheckFriendPlaylistResponseModel reactTo(FriendManagerRequestModel checkFriendPlaylistRequestModel) {
        return null;
    }
}
