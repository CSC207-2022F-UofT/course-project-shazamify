package user_interaction.user_interact_DS;

import user_interaction.user_interact_abr.friend_manager_abr.FriendManagerDsGateway;
import user.database.UserFileWriter;
import user.entities.CommonUser;
import user.entities.User;

import java.util.HashMap;
import java.util.Map;

public class FriendManagerInMemoryDsGateway implements FriendManagerDsGateway { // fake user DB for unit tests

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

    @Override
    public void save(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        // modify user and friend's friendList in userMap
        userMap.put(userID, new CommonUser(userID, "abababab"));
        userMap.put(friendID, new CommonUser(friendID, "abababab"));
        //save to database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
    }

}
