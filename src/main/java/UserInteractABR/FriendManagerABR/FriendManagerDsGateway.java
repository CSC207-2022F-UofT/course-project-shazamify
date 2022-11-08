package UserInteractABR.FriendManagerABR;

import java.util.HashMap;

public interface FriendManagerDsGateway {

    HashMap<String, String> getFriendList(String userID);

    void save(FriendManagerDsRequestModel requestModel);
}
