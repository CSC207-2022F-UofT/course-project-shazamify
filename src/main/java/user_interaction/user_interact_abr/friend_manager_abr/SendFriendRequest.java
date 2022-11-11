package user_interaction.user_interact_abr.friend_manager_abr;

public class SendFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerOutputBoundary friendManagerPresenter;

    SendFriendRequestHelper sendFriendRequestHelper;


    public SendFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerOutputBoundary friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }


    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {
        sendFriendRequestHelper = new SendFriendRequestHelper(requestModel);
        sendFriendRequestHelper.handleFriendRequest();

        // save friendLists if updated
        if (sendFriendRequestHelper.getUpdated()){
            userDsGateway.save(sendFriendRequestHelper.getUserID(),
                    sendFriendRequestHelper.getFriendID(),
                    sendFriendRequestHelper.getTempUserFriendList(),
                    sendFriendRequestHelper.getTempFriendFriendList());
        }

        //update the view
        FriendManagerResponseModel responseModel = new FriendManagerResponseModel(sendFriendRequestHelper.getMsg(),
                sendFriendRequestHelper.getTempUserFriendList());

        return friendManagerPresenter.showMsgAndUpdatedFriendList(responseModel);

    }


}
