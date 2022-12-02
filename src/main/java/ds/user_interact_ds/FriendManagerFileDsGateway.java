package ds.user_interact_ds;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;

import java.util.HashMap;

public class FriendManagerFileDsGateway implements FriendManagerDsGateway {

    @Override
    public HashMap<String, String> getFriendList(String userID) {

        // if not null returns friendList, else return empty friendList
        if (UserFileReader.getUserFriendList("UserDatabase.ser", userID) != null){
            return UserFileReader.getUserFriendList("UserDatabase.ser", userID);
        } else {
            return new HashMap<>();
        }

    }

    /**
     * save the updated friendLists for user userID and friend friendID to user DB
     */
    @Override
    public void save(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        //save to user_database
        UserFileWriter.setUserFriendList("UserDatabase.ser", userID, userFriendList);
        UserFileWriter.setUserFriendList("UserDatabase.ser", friendID, friendFriendList);
    }

    // for testing only
    public static void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }
}
