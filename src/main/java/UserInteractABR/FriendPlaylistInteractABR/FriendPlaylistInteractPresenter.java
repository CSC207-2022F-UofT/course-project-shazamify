package UserInteractABR.FriendPlaylistInteractABR;


public interface FriendPlaylistInteractPresenter {
    CheckFriendPlaylistResponseModel prepareSuccessView(CheckFriendPlaylistRequestModel user);

    CheckFriendPlaylistResponseModel prepareFailView(String error);
}
