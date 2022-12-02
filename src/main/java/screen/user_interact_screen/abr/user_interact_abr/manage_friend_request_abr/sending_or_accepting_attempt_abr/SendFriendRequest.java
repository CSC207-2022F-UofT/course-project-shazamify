package screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr;

import abr.user_interact_abr.manage_friend_request_abr.*;
import screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr.*;

public class SendFriendRequest implements FriendManagerInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendManagerOutputBoundary friendManagerPresenter;

    SendFriendRequestHelper sendFriendRequestHelper;


    public SendFriendRequest(FriendManagerDsGateway userDsGateway, FriendManagerOutputBoundary friendManagerPresenter){
        this.userDsGateway = userDsGateway;
        this.friendManagerPresenter = friendManagerPresenter;
    }


    /**
     * @param requestModel the input data containing user's ID (username), friend's ID and user's friendList
     * @return a FriendManagerResponseModel that contains a msg to display on screen and an updated user's friendList
     */
    @Override
    public FriendManagerResponseModel reactTo(FriendManagerRequestModel requestModel) {
        sendFriendRequestHelper = new SendFriendRequestHelper(requestModel, userDsGateway.getFriendList(requestModel.getFriendID()));
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
