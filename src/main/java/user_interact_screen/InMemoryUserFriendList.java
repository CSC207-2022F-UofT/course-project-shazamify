package user_interact_screen;

import user_interact_abr.friend_manager_abr.FriendManagerDsGateway;
import user_interact_abr.friend_manager_abr.FriendManagerDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserFriendList implements FriendManagerDsGateway {

    final private Map<String, HashMap<String, String>> users = new HashMap<>(); // userID + its request model

    @Override
    public HashMap<String, String> getFriendList(String userID) {
        return users.get(userID);
    }

    @Override
    public void save(FriendManagerDsRequestModel requestModel) {
        users.put(requestModel.getUserID(), requestModel.getUserFriendList()); //save user's friendList
        users.put(requestModel.getFriendID(), requestModel.getFriendFriendList()); //save friend's friendList
    }
}
