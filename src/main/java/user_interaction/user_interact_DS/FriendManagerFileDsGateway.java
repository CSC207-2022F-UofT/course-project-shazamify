package user_interaction.user_interact_DS;

import user_interaction.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.User;

import java.util.HashMap;
import java.util.Map;

public class FriendManagerFileDsGateway implements FriendManagerDsGateway {
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
    @Override
    public void save(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // modify user and friend's friendList in userMap
        userMap.put(userID, getUserWithNewFriendList(userID, userFriendList));
        userMap.put(friendID, getUserWithNewFriendList(friendID, friendFriendList));
        //save to database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
    }

    public static void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");}

    //extract long method by creating method obj
    private User getUserWithNewFriendList(String userID, HashMap<String, String> userFriendList){
        User user = userMap.get(userID);
        user.setFriendList(userFriendList);
        return user;
    }
}
