package user_interact_abr.friend_playlist_interact_abr;


public interface FriendPlaylistInteractPresenter {
    CheckFriendPlaylistResponseModel prepareSuccessView(CheckFriendPlaylistRequestModel user);

    CheckFriendPlaylistResponseModel prepareFailView(String error);
}
