package ds.user_interact_ds;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import entities.user_entities.User;

import java.util.HashMap;
import java.util.Map;

public class FriendManagerFileDsGateway implements FriendManagerDsGateway {

    /**
     * A map of username -> User object.
     */
    private Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser"); // <userID (userName), User>

    @Override
    public HashMap<String, String> getFriendList(String userID) {

        // if not null returns friendList, else return empty friendList
        if (UserFileReader.getUserMap("UserDatabase.ser").get(userID).getFriendList() != null){
            return UserFileReader.getUserMap("UserDatabase.ser").get(userID).getFriendList();
        } else {
            return new HashMap<>();
        }

    }

    /**
     * save the updated friendLists for user userID and friend friendID to user DB
     */
    @Override
    public void save(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // modify user and friend's friendList in userMap
        userMap.put(userID, getUserWithNewFriendList(userID, userFriendList));
        userMap.put(friendID, getUserWithNewFriendList(friendID, friendFriendList));
        //save to user_database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
    }

    /**
     * helper for save(), extract long method by creating method obj
     * @param userID user's ID
     * @param userFriendList the updated friendList for user
     * @return User obj with the updated friendList, every other attributes (name, password, avatar) remain the same
     */
    private User getUserWithNewFriendList(String userID, HashMap<String, String> userFriendList){
        User user = userMap.get(userID);
        user.setFriendList(userFriendList);
        return user;
    }

    // for testing only
    public static void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }
}
