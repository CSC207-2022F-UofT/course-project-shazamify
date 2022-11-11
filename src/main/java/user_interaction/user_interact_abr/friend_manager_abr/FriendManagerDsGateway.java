package user_interaction.user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public interface FriendManagerDsGateway {

    HashMap<String, String> getFriendList(String userID);

    void save(String user, String friend, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList);

}
