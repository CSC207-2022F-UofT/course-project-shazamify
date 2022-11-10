package user_interact_screen;

import user_interact_abr.friend_manager_abr.FriendManagerDsGateway;
import user_interact_abr.friend_manager_abr.FriendManagerDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserFriendList implements FriendManagerDsGateway {

    final private Map<Integer, HashMap<Integer, String>> userFriendLists = new HashMap<>(); // <userID, friendList<>>

    @Override
    public HashMap<Integer, String> getFriendList(int userID) {
        // if not null returns friendList, else return empty friendList
        if (userFriendLists.get(userID) != null){
            return userFriendLists.get(userID);
        } else {
            return new HashMap<>();
        }

    }

    @Override
    public void save(FriendManagerDsRequestModel requestModel) {
        userFriendLists.put(requestModel.getUserID(), requestModel.getUserFriendList()); //save user's friendList
        userFriendLists.put(requestModel.getFriendID(), requestModel.getFriendFriendList()); //save friend's friendList
    }

}