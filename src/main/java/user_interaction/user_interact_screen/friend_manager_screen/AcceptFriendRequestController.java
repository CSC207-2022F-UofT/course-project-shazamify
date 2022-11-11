package user_interaction.user_interact_screen.friend_manager_screen;

import user_interaction.user_interact_DS.FriendManagerFileDsGateway;
import user_interaction.user_interact_abr.friend_manager_abr.FriendManagerInputBoundary;
import user_interaction.user_interact_abr.friend_manager_abr.FriendManagerRequestModel;
import user_interaction.user_interact_abr.friend_manager_abr.FriendManagerResponseModel;

public class AcceptFriendRequestController {
    FriendManagerInputBoundary inputBoundary;

    FriendManagerFileDsGateway dsGateway;

    public AcceptFriendRequestController(FriendManagerInputBoundary inputBoundary, FriendManagerFileDsGateway dsGateway) {
        this.inputBoundary = inputBoundary;
        this.dsGateway = dsGateway;
    }

    FriendManagerResponseModel reactTo(String userID, String friendID){
        FriendManagerRequestModel requestModel = new FriendManagerRequestModel(userID, friendID, dsGateway.getFriendList(userID), dsGateway.getFriendList(friendID));
        return inputBoundary.reactTo(requestModel);
    }
}
