package user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public interface FriendManagerDsGateway {

    HashMap<Integer, String> getFriendList(int userID);

    void save(FriendManagerDsRequestModel requestModel);
}
