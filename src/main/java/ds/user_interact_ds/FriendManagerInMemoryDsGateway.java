package ds.user_interact_ds;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import entities.user_entities.CommonUser;
import entities.user_entities.User;

import java.util.HashMap;
import java.util.Map;

/**
 * fake DsGateway for testing, serves the same purpose other than not saving the data to the real user DB
 */
public class FriendManagerInMemoryDsGateway implements FriendManagerDsGateway {

    private final Map<String, User> userMap = new HashMap<>(); // <userID (userName), User>

    @Override
    public HashMap<String, String> getFriendList(String userID) {

        // if not null returns friendList, else return empty friendList
        if (userMap.get(userID).getFriendList() != null){
            return userMap.get(userID).getFriendList();
        } else {
            return new HashMap<>();
        }
    }

    public FriendManagerInMemoryDsGateway(){
        userMapSetup();
    }

    public void userMapSetup(){
        // put in some users
        User newUser1 = new CommonUser("Star", "ababab");
        User newUser2 = new CommonUser("Jae", "ababab");
        User newUser3 = new CommonUser("Angela", "abababa");

        userMap.put("Star", newUser1);
        userMap.put("Jae", newUser2);
        userMap.put("Angela", newUser3);
    }

    @Override
    public void save(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        // modify user and friend's friendList in userMap
        userMap.put(userID, getUserWithNewFriendList(userID, userFriendList));
        userMap.put(friendID, getUserWithNewFriendList(friendID, friendFriendList));
    }

    private User getUserWithNewFriendList(String userID, HashMap<String, String> userFriendList){
        User user = userMap.get(userID);
        user.setFriendList(userFriendList);
        return user;
    }

}
