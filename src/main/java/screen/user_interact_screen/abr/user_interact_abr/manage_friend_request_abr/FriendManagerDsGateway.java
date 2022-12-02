package screen.user_interact_screen.abr.user_interact_abr.manage_friend_request_abr;

import java.util.HashMap;

public interface FriendManagerDsGateway {

    HashMap<String, String> getFriendList(String userID);

    /**
     * save the updated friendList for both user and friend to user DB
     */
    void save(String user, String friend, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList);

}
