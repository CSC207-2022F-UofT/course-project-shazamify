package UserInteractABR.FriendManagerABR;


public interface FriendManagerPresenter {

    FriendManagerResponseModel prepareSuccessView(FriendManagerResponseModel user);

    FriendManagerResponseModel prepareFailView(String error);
}
