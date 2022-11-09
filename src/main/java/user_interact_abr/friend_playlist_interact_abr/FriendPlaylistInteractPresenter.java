package user_interact_abr.friend_playlist_interact_abr;


import user_interact_abr.UserInteractRequestModel;

public interface FriendPlaylistInteractPresenter {
    CheckFriendPlaylistResponseModel prepareSuccessView(UserInteractRequestModel user);

    CheckFriendPlaylistResponseModel prepareFailView(String error);
}
