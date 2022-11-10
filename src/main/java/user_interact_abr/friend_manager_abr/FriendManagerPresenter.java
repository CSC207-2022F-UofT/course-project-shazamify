package user_interact_abr.friend_manager_abr;


public interface FriendManagerPresenter {

    FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel users);

    FriendManagerResponseModel prepareFailView(String error);
}
