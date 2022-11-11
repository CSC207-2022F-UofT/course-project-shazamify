package user_interaction.user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class AcceptFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerOutputBoundary friendManagerPresenter;


    public AcceptFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerOutputBoundary friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }

    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {

        HashMap<String, String> tempUserFriendList = requestModel.getUserFriendList();
        HashMap<String, String> tempFriendFriendList = requestModel.getFriendFriendList();

        tempUserFriendList.put(requestModel.getFriendID(), "friend");
        tempFriendFriendList.put(requestModel.getUserID(), "friend"); // let them be friends, update friendship status

        //update the friendLists in user database & view

        userDsGateway.save(requestModel.getUserID(), requestModel.getFriendID(), tempUserFriendList, tempFriendFriendList);

        FriendManagerResponseModel responseModel = new FriendManagerResponseModel("You are now friends with " + requestModel.getFriendID(), tempUserFriendList);
        return friendManagerPresenter.showMsgAndUpdatedFriendList(responseModel);
    }
}
