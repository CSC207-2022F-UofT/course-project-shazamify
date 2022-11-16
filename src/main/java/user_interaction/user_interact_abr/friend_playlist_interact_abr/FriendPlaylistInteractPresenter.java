package user_interaction.user_interact_abr.friend_playlist_interact_abr;


import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;

public interface FriendPlaylistInteractPresenter {
    CheckFriendPlaylistResponseModel prepareSuccessView(FriendManagerRequestModel user);

    CheckFriendPlaylistResponseModel prepareFailView(String error);
}
