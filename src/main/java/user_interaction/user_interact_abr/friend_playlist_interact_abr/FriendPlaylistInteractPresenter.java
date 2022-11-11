package user_interaction.user_interact_abr.friend_playlist_interact_abr;


import user_interaction.user_interact_abr.friend_manager_abr.FriendManagerRequestModel;

public interface FriendPlaylistInteractPresenter {
    CheckFriendPlaylistResponseModel prepareSuccessView(FriendManagerRequestModel user);

    CheckFriendPlaylistResponseModel prepareFailView(String error);
}
